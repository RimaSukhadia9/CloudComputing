//import java.io.*;
//import java.net.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//public class FileClient {
//
//    private static Socket sock;
//    private static String fileName;
//    private static BufferedReader stdin;
//    private static PrintStream os;
//	private static DataInputStream dis;
//
//    public static void main(String[] args) throws IOException {
//    	
//    	FileClient fc1 = new FileClient();
//    	fc1.run();
//    	
//            }
//    
//    public void run(){
//    	
//    	(new Thread(new A())).start();
//    	
//    	(new Thread(new B())).start();
//
//    }
//    
//    public class A implements Runnable{
//    	
//    	public void run(){
//    		
//    		try {
//                sock = new Socket("192.168.1.131", 7777);
//                stdin = new BufferedReader(new InputStreamReader(System.in));
//            } catch (Exception e) {
//                System.err.println("Cannot connect to the server, try again later.");
//                System.exit(1);
//            }
//
//            
//
//            try {
//            	os = new PrintStream(sock.getOutputStream());
//                  switch (Integer.parseInt(selectAction())) {
//                case 1:
//                    os.println("1");
//                    sendFile();
//                    break;
//                case 2:
//                    os.println("2");
//                    System.err.print("Enter file name: ");
//                    fileName = stdin.readLine();
//                    os.println(fileName);
//                    receiveFile(fileName);
//                    break;
//            }
//            } catch (Exception e) {
//                System.err.println("not valid input");
//            }
//
//
//            try {
//				sock.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            
//        	long stop = System.nanoTime();
//    		System.out.println(stop);
//        }
//
//        public  String selectAction() throws IOException {
//            System.out.println("1. Send file.");
//            System.out.println("2. Recieve file.");
//            System.out.print("\nMake selection: ");
//
//            return stdin.readLine();
//        }
//
//        public void sendFile() {
//            try {
//                System.err.print("Enter file name: ");
//                fileName = stdin.readLine();
//
//                File myFile = new File(fileName);
//                byte[] mybytearray = new byte[(int) myFile.length()];
//
//                FileInputStream fis = new FileInputStream(myFile);
//                BufferedInputStream bis = new BufferedInputStream(fis);
//                //bis.read(mybytearray, 0, mybytearray.length);
//
//                dis = new DataInputStream(bis);
//                dis.readFully(mybytearray, 0, mybytearray.length);
//
//                OutputStream os = sock.getOutputStream();
//
//                //Sending file name and file size to the server
//                DataOutputStream dos = new DataOutputStream(os);
//                
//                long start = System.nanoTime();
//                System.out.println(start);
//                
//                dos.writeUTF(myFile.getName());
//                dos.writeLong(mybytearray.length);
//                dos.write(mybytearray, 0, mybytearray.length);
//                dos.flush();
//                System.out.println("File "+fileName+" sent to Server.");
//            } catch (Exception e) {
//                System.err.println("File does not exist!");
//            }
//        }
//
//        public void receiveFile(String fileName) {
//            try {
//                int bytesRead;
//                InputStream in = sock.getInputStream();
//
//                DataInputStream clientData = new DataInputStream(in);
//
//                fileName = clientData.readUTF();
//                OutputStream output = new FileOutputStream(("received_from_server_" + fileName));
//                long size = clientData.readLong();
//                byte[] buffer = new byte[65536];
//                while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
//                    output.write(buffer, 0, bytesRead);
//                    size -= bytesRead;
//                }
//                long stop = System.nanoTime();
//                System.out.println(stop);
//                output.close();
//                in.close();
//
//                System.out.println("File "+fileName+" received from Server.");
//            } catch (IOException ex) {
//                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//    		
//    	}
//    	
//    }
//    
//    public class B implements Runnable{
//    	
//    	public void run(){
//    		
//    		try {
//                sock = new Socket("192.168.1.131", 7777);
//                stdin = new BufferedReader(new InputStreamReader(System.in));
//            } catch (Exception e) {
//                System.err.println("Cannot connect to the server, try again later.");
//                System.exit(1);
//            }
//
//            
//
//            try {
//            	os = new PrintStream(sock.getOutputStream());
//                  switch (Integer.parseInt(selectAction())) {
//                case 1:
//                    os.println("1");
//                    sendFile();
//                    break;
//                case 2:
//                    os.println("2");
//                    System.err.print("Enter file name: ");
//                    fileName = stdin.readLine();
//                    os.println(fileName);
//                    receiveFile(fileName);
//                    break;
//            }
//            } catch (Exception e) {
//                System.err.println("not valid input");
//            }
//
//
//            try {
//				sock.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            
//        	long stop = System.nanoTime();
//    		System.out.println(stop);
//        }
//
//        public String selectAction() throws IOException {
//            System.out.println("1. Send file.");
//            System.out.println("2. Recieve file.");
//            System.out.print("\nMake selection: ");
//
//            return stdin.readLine();
//        }
//
//        public void sendFile() {
//            try {
//                System.err.print("Enter file name: ");
//                fileName = stdin.readLine();
//
//                File myFile = new File(fileName);
//                byte[] mybytearray = new byte[(int) myFile.length()];
//
//                FileInputStream fis = new FileInputStream(myFile);
//                BufferedInputStream bis = new BufferedInputStream(fis);
//                //bis.read(mybytearray, 0, mybytearray.length);
//
//                dis = new DataInputStream(bis);
//                dis.readFully(mybytearray, 0, mybytearray.length);
//
//                OutputStream os = sock.getOutputStream();
//
//                //Sending file name and file size to the server
//                DataOutputStream dos = new DataOutputStream(os);
//                long start = System.nanoTime();
//                System.out.println(start);
//                dos.writeUTF(myFile.getName());
//                dos.writeLong(mybytearray.length);
//                dos.write(mybytearray, 0, mybytearray.length);
//                dos.flush();
//                System.out.println("File "+fileName+" sent to Server.");
//            } catch (Exception e) {
//                System.err.println("File does not exist!");
//            }
//        }
//
//        public void receiveFile(String fileName) {
//            try {
//                int bytesRead;
//                InputStream in = sock.getInputStream();
//
//                DataInputStream clientData = new DataInputStream(in);
//
//                fileName = clientData.readUTF();
//                OutputStream output = new FileOutputStream(("received_from_server_" + fileName));
//                long size = clientData.readLong();
//                byte[] buffer = new byte[65536];
//                while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
//                    output.write(buffer, 0, bytesRead);
//                    size -= bytesRead;
//                }
//                long stop = System.nanoTime();
//                System.out.println(stop);
//                output.close();
//                in.close();
//
//                System.out.println("File "+fileName+" received from Server.");
//            } catch (IOException ex) {
//                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//    		
//    	}
//    	
//    }
//}