import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Logger;

public class raffinal {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long starttime = System.nanoTime();
		System.out.println("Start: " +starttime);
		FinalDisk fd = new FinalDisk();
		fd.run();
		long stoptime = System.nanoTime();
		System.out.println("Stop: " +stoptime);
				
	}

	public void run(){
		

		(new Thread(new t1())).start();
        (new Thread(new t2())).start();

        
		
	}

	public class t1 implements Runnable{
		
		public void run(){
		
			
			System.out.println("Thread1");
			//for (double mb : new double[]{1e-6, 0.001, 1})
		     //   testFileSize(mb);
			//private static void testFileSize(double mb) throws IOException {
			double mb = 1.0;
			try{
				RandomAccessFile raf = new RandomAccessFile("C:/Users/Rima/Desktop/mb1.txt", "rw");

		         // write something in the file
		         long start = System.nanoTime();
		         raf.writeUTF("Hello World");

		         // set the file pointer at 0 position
		         raf.seek(0);

		         // print the line
		         System.out.println("" + raf.readLine());

		         // set the file pointer at 0 position
		         raf.seek(0);

		         // write something in the file
		         raf.writeUTF("This is an example \n Hello World");

		         raf.seek(0);
		         String h = raf.readLine();
		         long stop = System.nanoTime();

		         // print the line
		         System.out.println("" + h);
		         double total = stop - start;
		         double t = (1024/total); 
		         
		         System.out.println(t);
			}
			catch(Exception e){
				
				
			}
			
		}
		
	}
public class t2 implements Runnable{
		
		public void run(){
			
			System.out.println("Thread2");
			double mb = 1.0; //0.001KB
			try{
				RandomAccessFile raf = new RandomAccessFile("C:/Users/Rima/Desktop/mb1.txt", "rw");

		         // write something in the file
		         long start = System.nanoTime();
		         raf.writeUTF("djfgjdkng");

		         // set the file pointer at 0 position
		         raf.seek(0);

		         // print the line
		         System.out.println("" + raf.readLine());

		         // set the file pointer at 0 position
		         raf.seek(0);

		         // write something in the file
		         raf.writeUTF("sdfjfgjlgj");

		         raf.seek(0);
		         String h = raf.readLine();
		         long stop = System.nanoTime();

		         // print the line
		         System.out.println("" + h);
		         double total = stop - start;
		         double t = (1024/total); 
		         
		         System.out.println(t);
		         raf.close();
		         
		         System.out.println("Throughput: "+ 0.000976* 1000.0 / total);
				    
				    System.out.println("Latency: "+ total/1000000);
			}
			catch(Exception e){
				
				
			}

			
		}
		
	}
}
