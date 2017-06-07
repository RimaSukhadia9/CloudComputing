import java.io.IOException;

import java.io.*;
import java.nio.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
import java.net.*;
import java.nio.*;
import java.lang.*;

public class DiskSpeed {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//Scanner str = new Scanner(System.in);
		//String fname = str.nextLine();
		


		String s = "I was here!\n";
		
		byte data[] = s.getBytes();
		
		ByteBuffer out = ByteBuffer.wrap(data);
		
		ByteBuffer copy = ByteBuffer.allocate(12);
		
		Path path = FileSystems.getDefault().getPath("logs", "access.log");
	     //BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
	     OpenOption fname2 = new OpenOption() {
		}; 
		
		try(FileChannel fc = (FileChannel.open(path, fname2))){
			
			int nread;
						
			do{
				
				nread = fc.read(copy);
				
			}while(nread != -1 && copy.hasRemaining());
		
			fc.position(0);
			
			while(out.hasRemaining()){
				
				fc.write(out);
				
			out.rewind();
				
			}
			
			long length = fc.size();
			
			fc.position(length-1);
			
			copy.flip();
			
			while(copy.hasRemaining()){
				
				fc.write(copy);
				
			}
			
			while(out.hasRemaining()){
				
				fc.write(out);
				
			}
			
		}
			
			catch(IOException ie){
				
				System.out.println("I/O Exception" + ie);
				
			}
			
		}
		
	}


