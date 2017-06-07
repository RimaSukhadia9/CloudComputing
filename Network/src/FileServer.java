import java.net.*;
import java.io.*;

public class FileServer {
	
	public static ServerSocket serversocket;
	
	private static Socket clientSocket = null;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		long start = System.nanoTime();
		System.out.println(start);
		
		try{
			
			serversocket = new ServerSocket(7777);
			
			System.out.println("Server Started");
			
		}
		
		catch(Exception e){
			
			System.err.println("Port is already in use");
			
			System.exit(1);
			
		}
		
		while(true){
			
			try{
				
				clientSocket = serversocket.accept();
				
				System.out.println("Accepted Connection: " +clientSocket);
			
				Thread t = new Thread(new ClientConnection(clientSocket));
				
				t.start();
				
			}
			
			catch(Exception e){
				
				System.err.println("Error in connection attempt");
				
			}
			
		}
		
	}

}
