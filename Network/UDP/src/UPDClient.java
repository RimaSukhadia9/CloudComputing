import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class UPDClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		double time1 = System.currentTimeMillis();
    	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
    	String start = String.valueOf(new DecimalFormat("#.####################").format(ts1));
    			System.out.println(start);
    			
		String size = "B";
		switch(size){
		
		case "B":
			
			B1();
		
			
		case "KB":
			
			B2();
			
		case "KB64":
			
			B3();
		}
		 
		
		
	}


	
	
	public static void B1() throws Exception{
		
//		double time1 = System.currentTimeMillis();
//    	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//    	String start = String.valueOf(new DecimalFormat("#.####################").format(ts1));
//    			System.out.println(start);

		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket clientSocket = new DatagramSocket();
		
		InetAddress IPAddress = InetAddress.getByName("LocalHost");
		
		byte[] sendData = new byte[1];
		
		byte[] receiveData = new byte[1];

		String sentence = inFromUser.readLine();
		
		sendData = sentence.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1234);
		
		clientSocket.send(sendPacket);
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length, IPAddress, 9876);
		
		clientSocket.send(receivePacket);
		
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FromServer: " + modifiedSentence);
		
		double time2 = System.currentTimeMillis();
    	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
    	String stop = String.valueOf(new DecimalFormat("#.####################").format(ts2));
    			System.out.println(stop);
		
		clientSocket.close();
		

		
	}

public static void B2() throws Exception{
		
//		double time1 = System.currentTimeMillis();
//    	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//    	String bla = String.valueOf(new DecimalFormat("#.####################").format(ts1));
//    			System.out.println(bla);

		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket clientSocket = new DatagramSocket();
		
		InetAddress IPAddress = InetAddress.getByName("LocalHost");
		
		byte[] sendData = new byte[1024];
		
		byte[] receiveData = new byte[1024];

		String sentence = inFromUser.readLine();
		
		sendData = sentence.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1234);
		
		clientSocket.send(sendPacket);
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length, IPAddress, 9876);
		
		clientSocket.send(receivePacket);
		
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FromServer: " + modifiedSentence);
		
//		double time2 = System.currentTimeMillis();
//    	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
//    			System.out.println(String.valueOf(new DecimalFormat("#.####################").format(ts2)));

		
		clientSocket.close();
		

		
	}

public static void B3() throws Exception{
	
//	double time1 = System.currentTimeMillis();
//	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//			System.out.println(String.valueOf(new DecimalFormat("#.####################").format(ts1)));
//
	
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	
	DatagramSocket clientSocket = new DatagramSocket();
	
	InetAddress IPAddress = InetAddress.getByName("LocalHost");
	
	byte[] sendData = new byte[65536];
	
	byte[] receiveData = new byte[65536];

	String sentence = inFromUser.readLine();
	
	sendData = sentence.getBytes();
	
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1234);
	
	clientSocket.send(sendPacket);
	
	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length, IPAddress, 9876);
	
	clientSocket.send(receivePacket);
	
	String modifiedSentence = new String(receivePacket.getData());
	System.out.println("FromServer: " + modifiedSentence);
	
//	double time2 = System.currentTimeMillis();
//	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
//			System.out.println(String.valueOf(new DecimalFormat("#.####################").format(ts2)));

	
	clientSocket.close();
	

	
}
	
}
