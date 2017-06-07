import java.net.*;

public class UDPServer {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try{
		@SuppressWarnings("resource")
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
			byte[] receiveData = new byte[1];
			byte[] sendData = new byte[1];
			
			while(true){
				
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);		
				
				String sentence = new String(receivePacket.getData());
				
				System.out.println("Received" +sentence);

				InetAddress IPAddress = receivePacket.getAddress();
				
				int port = receivePacket.getPort();
				
				String CapitalSentence = sentence.toUpperCase();
				
				sendData = CapitalSentence.getBytes();
			
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				
				serverSocket.send(sendPacket);
				
			}

		}
		catch(Exception e){
			
			

		}

	}

}
