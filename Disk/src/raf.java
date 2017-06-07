

import java.io.*;

public class raf {

   public static void main(String[] args) {
      try {
         // create a new RandomAccessFile with filename test
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
      } catch (IOException ex) {
         ex.printStackTrace();
      }

   }
}
