package com.sharedmemory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortLargeFile {
	static double diff;
	static long d, s, roundTrip;
	static int totalThreads;
	static List<Thread> listThreads = new ArrayList<>();
	static PropertiesController propertiesController=new PropertiesController();
	
	public static void main(String[] args) {
		totalThreads = Integer.parseInt(propertiesController.getProperty("numberofthreads"));
		String inputfile = "inputfile.txt";
		String outputfile = "outputfile.txt";
		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String r1, String r2) {
				return r1.compareTo(r2);
			}
		};
		try {
			s = System.nanoTime();
			List<File> l = sortInBatch(new File(inputfile), comparator);
			listThreads.clear();
			mergeSortedFiles(l, new File(outputfile), comparator);
			d = System.nanoTime();
			roundTrip = (d - s);
			diff = roundTrip / 1e6;
			System.out.println(diff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<File> sortInBatch(File file, Comparator<String> cmp) throws IOException {
		List<File> files = new ArrayList<File>();
		long blocksize = estimateBestSizeOfBlocks(file);// in bytes
		for (int i = 0; i < totalThreads; i++) {
			listThreads.add(new Thread(new SortData(cmp, blocksize)));
		}
		try {
			for (int i = 0; i < listThreads.size(); i++) {
				listThreads.get(i).start();
			}
			for (int i = 0; i < listThreads.size(); i++) {
				listThreads.get(i).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		files.addAll(SortData.getFiles());
		System.out.println("Total Files"+files.size());
		return files;
	}

	public static long estimateBestSizeOfBlocks(File filetobesorted) {
		long sizeoffile = filetobesorted.length();
		// we don't want to open up much more than 1024 temporary files, better
		// run
		// out of memory first. (Even 1024 is stretching it.)
		final int MAXTEMPFILES = 1024;
		long blocksize = sizeoffile / MAXTEMPFILES;
		// on the other hand, we don't want to create many temporary files
		// for naught. If blocksize is smaller than half the free memory, grow
		// it.
		long freemem = Runtime.getRuntime().freeMemory();
		if (blocksize < freemem / 2)
			blocksize = freemem / 2;
		else {
			if (blocksize >= freemem)
				System.err.println("We expect to run out of memory. ");
		}
		
		return blocksize;
	}

	/*
	 * public static File sortAndSave(List<String> tmplist, Comparator<String>
	 * cmp) throws IOException {
	 * 
	 * }
	 */

	public static void mergeSortedFiles(List<File> files, File outputfile, final Comparator<String> cmp)
			throws IOException {
		PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<BinaryFileBuffer>(11,
				new Comparator<BinaryFileBuffer>() {
					public int compare(BinaryFileBuffer i, BinaryFileBuffer j) {
						return cmp.compare(i.peek(), j.peek());
					}
				});
		try {
			for (File f : files) {
				BinaryFileBuffer bfb = new BinaryFileBuffer(f);
				pq.add(bfb);

			}
			System.out.println("size of pq   "+pq.size());

		} catch (NullPointerException exception) {

		}
		for (int i = 0; i < totalThreads; i++) {
			listThreads.add(new Thread(new MergeData(pq)));
		}

		try {
			for (int i = 0; i < listThreads.size(); i++) {
				listThreads.get(i).start();
			}
			for (int i = 0; i < listThreads.size(); i++) {
				listThreads.get(i).join();
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
