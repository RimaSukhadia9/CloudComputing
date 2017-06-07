import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;
public class UDisk {
	public static void main(String... args) throws IOException {
	    for (double mb : new double[]{1e-6, 0.001, 1})
	        testFileSize(mb);
	}

	private static void testFileSize(double mb) throws IOException {
	    File file = File.createTempFile("test", ".txt");
	    file.deleteOnExit();
	    char[] chars = new char[1024];
	    Arrays.fill(chars, 'A');
	    String longLine = new String(chars);
	    long start1 = System.nanoTime();
	    System.out.println(longLine);
	   
	    PrintWriter pw = new PrintWriter(new FileWriter(file));
	    for (int i = 0; i < mb * 1024; i++)
	        pw.println(longLine);
	    pw.close();
	    long time1 = System.nanoTime() - start1;
	    System.out.printf("Took %.3f seconds to write to a %d MB, file rate: %.2f MB/s%n",
	            time1 / 1e9, file.length() >> 20, file.length() * 1000.0 / time1);

	    long start2 = System.nanoTime();
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    for (String line; (line = br.readLine()) != null; ) {
	    }
	    br.close();
	    long time3 = System.nanoTime() - start2;
	    long time2 = System.nanoTime();
	    System.out.printf("Took %.3f seconds to read to a %d MB file, rate: %.2f MB/s%n",
	            time2 / 1e9, file.length() >> 20, file.length() * 1000.0 / time3);
	    file.delete();
	    
	    double total = time2 - time1;
	    System.out.println("Throughput: "+ 0.000976* 1000.0 / time3);
	    
	    System.out.println("Latency: "+ total/1000000);

	    
	}
	
}
