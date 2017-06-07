import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SampleRW {
    public static void main(String [] args) throws Exception{
    	
    	double time = System.currentTimeMillis();
    	double ts = TimeUnit.MILLISECONDS.toSeconds((long) time);
    			System.out.println(String.valueOf(new DecimalFormat("#.##################").format(ts)));

        // The name of the file to open.
    	
    	@SuppressWarnings("resource")
		Scanner str = new Scanner(System.in);
        String fileName = str.nextLine();

    	
        // This will reference one line at a time
        String line = null;
        System.out.println(System.currentTimeMillis());
        
        


        try {
        	      	        
        	/*File file = new File(fileName);
        	
        	FileInputStream fin = new FileInputStream(file);
        	
        	System.out.println(fin);
        	*/
        	
        	
        	
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            //String strf = "foo.bar";
            //strf = str.next();
            

            while((line = bufferedReader.readLine()) != null) {
            	
            	//BufferedWriter bufferedWriter = new BufferedWriter(strf);
              System.out.println();
            }   
            
           
            
            //double time1 = System.currentTimeMillis();
        	//double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
        			//System.out.println(ts1*1000000);         
            
            // Always close files.
            bufferedReader.close();         
        }
        
        
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file " 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        double time1 = System.currentTimeMillis();
    	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
    			System.out.println(String.valueOf(new DecimalFormat("#.####################").format(ts1)));
        
    }
    
    public void run(){
    	
    	//int th=2;
		//if(th == 2){
    		
    		(new Thread(new many1())).start();
    		(new Thread(new many2())).start();
    		
    	//}
    	
    }
    
    public class many1 implements Runnable{
    	
    	public void run(){
    		
    		Scanner str = new Scanner(System.in);
            String fileName = str.nextLine();
			try {
      	        
            	//File file = new File(fileName);
            	
            	//FileInputStream fin = new FileInputStream(file);
            	
            	//System.out.println(fin);
            	
            	
            	
            	
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);

                String line;
				while((line = bufferedReader.readLine()) != null) {
                	
                  System.out.println(line);
                }   
                
               
                
                double time1 = System.currentTimeMillis();
            	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
            			System.out.println(ts1*1000000);         
                
                // Always close files.
                bufferedReader.close();         
            }
            
            
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" + 
                    fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file " 
                    + fileName + "'");                  
                // Or we could just do this: 
                // ex.printStackTrace();
            }
    		
    	}
    	
    }
    
public class many2 implements Runnable{
    	
    	public void run(){
    		
    		Scanner str = new Scanner(System.in);
            String fileName = str.nextLine();
			try {
      	        
            	//File file = new File(fileName);
            	
            	//FileInputStream fin = new FileInputStream(file);
            	
            	//System.out.println(fin);
            	
            	
            	
            	
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);

                String line;
				while((line = bufferedReader.readLine()) != null) {
                	
                  System.out.println(line);
                }   
                
               
                
                double time1 = System.currentTimeMillis();
            	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
            			System.out.println(ts1*1000000);         
                
                // Always close files.
                bufferedReader.close();         
            }
            
            
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" + 
                    fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file " 
                    + fileName + "'");                  
                // Or we could just do this: 
                // ex.printStackTrace();
            }
    		
    	}
    	
    }
    
    
}
/*
 *         try {
        	      	        
        	//File file = new File(fileName);
        	
        	//FileInputStream fin = new FileInputStream(file);
        	
        	//System.out.println(fin);
        	
        	
        	
        	
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	
              System.out.println(line);
            }   
            
           
            
            double time1 = System.currentTimeMillis();
        	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
        			System.out.println(ts1*1000000);         
            
            // Always close files.
            bufferedReader.close();         
        }
        
        
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file " 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
 */

