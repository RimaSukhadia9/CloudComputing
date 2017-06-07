package com.sharedmemory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class MergeData implements Runnable {
	static String outputfile = "outputfile.txt";
	static BufferedWriter fbw;
	PriorityQueue<BinaryFileBuffer> pq;

	static {
		try {
			fbw = new BufferedWriter(new FileWriter(outputfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MergeData(PriorityQueue<BinaryFileBuffer> pq) {
		this.pq = pq;
	}

	@Override
	public void run() {
		synchronized (fbw) {
			try {

				while (pq.size() > 0) {

					BinaryFileBuffer bfb = pq.poll();
					if (bfb != null) {

						String r = bfb.pop();
						
						fbw.write(r);
						// System.out.println(r);
						fbw.newLine();
						if (bfb.empty()) {
							bfb.fbr.close();
							//bfb.originalfile.delete();// we don't need you
														// anymore
						} else {
							
								pq.add(bfb);
							 // add it back
						}

					}
				}

			} catch (NullPointerException | IOException exception) {
				

			} finally {

				try {
					fbw.close();
					for (BinaryFileBuffer bfb : pq)
						bfb.close();
				} catch (IOException e) {
					System.out.println("something is wrong here ");// TODO Auto-generated
					e.printStackTrace();
				}

			}
		}

	}

}
