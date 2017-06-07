package com.sharedmemory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortData implements Runnable {

	static List<File> files = new ArrayList<File>();
	Comparator<String> cmp;
	File file;
	long blocksize;
	static BufferedReader fbr;
	static String inputfile = "inputfile.txt";
	static{
		try {
			fbr = new BufferedReader(new FileReader(new File(inputfile)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public SortData(Comparator<String> cmp,long blocksize) {
		this.cmp=cmp;
		this.blocksize=blocksize;
		
	}

	@Override
	public void run() {
		
        try{
            List<String> tmplist =  new ArrayList<String>();
            String line = "";
            try {
                while(line != null) {
                    long currentblocksize = 0;// in bytes
                    synchronized(fbr){
                    while((currentblocksize < blocksize) 
                    &&(   (line = fbr.readLine()) != null) ){ // as long as you have 2MB
                        tmplist.add(line);
                        currentblocksize += line.length() *2 + 40; // java uses 16 bits per character + 40 bytes of overhead (estimated)
                    }
                    setFile(sortFiles(tmplist, cmp));
                    tmplist.clear();
                    }
                   
                    //System.out.println(currentblocksize);
                   
                }
                //System.out.println(files.size());
            } catch(EOFException oef) {
                if(tmplist.size()>0) {
                	 try {
                		 setFile(sortFiles(tmplist, cmp));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                 tmplist.clear();
                }
            }catch(IOException exception){}
        } finally {
            try {
            	 synchronized(fbr){
				fbr.close();
            	 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

	public File sortFiles(List<String> tmplist,Comparator<String> cmp) throws IOException{
			
		Collections.sort(tmplist,cmp);  // 
        File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
        newtmpfile.deleteOnExit();
        BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
       
        try {
            for(String r : tmplist) {
                fbw.write(r);
                fbw.newLine();
            }
        } finally {
            fbw.close();
        }
        return newtmpfile;
		

	}
	public static void setFile(File file) {
		files.add(file);
	}

	public static List<File> getFiles() {
		//System.out.println(files.size());
		return files;
	}

}
