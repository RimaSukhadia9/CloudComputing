import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class CPU1{



	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		//long start = System.nanoTime();
		//System.out.println("StartTime: " + start);
		CPU1 b = new CPU1();
		b.run();
		
	}
public void run(){
	
    (new Thread(new B())).start();
    (new Thread(new C())).start();
    (new Thread(new D())).start();
    (new Thread(new E())).start();
	
}
		
			

	
public class B implements Runnable{

public void run(){
	
System.out.println("ThreadB");
	long start = System.nanoTime();
	//System.out.println("StartTime: " + start);
//	double time1 = System.currentTimeMillis();
//	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//	String start = String.valueOf(new DecimalFormat("#.####################").format(ts1));
//			System.out.println(Integer.valueOf(start));

			int a = 0;
	for(int i=0; i<100000; i++){
		
		
		a= 4+5;
		
		a = 5+5;
		
		a = 8/9;
		a = 5*15999;
		a = 50000%10;
		 a= (9+10)/10000;
		 a+=9000;
		 a/=15000;
		 a-=100;
		 a/=1300;
		
		
		
	}

	long stop = System.nanoTime();
	//System.out.println("StopB: " +stop);
	//System.out.println(a);
//	double time2 = System.currentTimeMillis();
//	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
//	String stop = String.valueOf(new DecimalFormat("#.####################").format(ts2));
//			System.out.println(Integer.valueOf(stop));
//			
//			System.out.println(stop);
	double total = (double)(stop-start)/1000000000;
	
	double IOFlops = (100000*10)/total;
	//DecimalFormat f = new DecimalFormat("##.0000"); 
	
	System.out.println("IOPS: "+total);
	
	double b = 0;
	long start1 = System.nanoTime();

for(int i=0; i<100000; i++){
	
	
	b= 4.666 + 5.22;
	
	b = 5.9875+55556663.97878;
	
	b = 8/9;
	b = 5*159.99;
	b = 50000%10.2225;
	 b= (9+10)/10000;
	 b+=9000*5656;
	 b/=15000+12154.3454545*2554.566;
	 b-=100*18889.22226;
	 b/=1300.456458/ 9.5647;
	
	
	
}
long stop1 = System.nanoTime();
double total1 = (double)(stop1-start1)/1000000000;

double Flops = (100000*10)/total;
//DecimalFormat f = new DecimalFormat("##.0000"); 

System.out.println("FLOPS: "+total);

    //System.out.println("Latency: "+ total/1000000);
	//System.out.println(" " +total + " " + f.format(IOFlops));	

	


	
}
}
public class C implements Runnable{

public void run(){
	
	System.out.println("ThreadC");

	long start = System.nanoTime();
	//System.out.println(start);
//	double time1 = System.currentTimeMillis();
//	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//	String start = String.valueOf(new DecimalFormat("#.####################").format(ts1));
//			System.out.println(Integer.valueOf(start));

			int a = 0;
	for(int i=0; i<15000; i++){
		
		
		a= 4+5;
		
		a = 5+5;
		
		a = 8/9;
		a = 5*15999;
		a = 50000%10;
		 a= (9+10)/10000;
		 a+=9000;
		 a/=15000;
		 a-=100;
		 a/=1300;
		
		
		
		
		
	}
	long stop = System.nanoTime();
//	System.out.println("StopC: " +stop);
//	System.out.println(a);
////	double time2 = System.currentTimeMillis();
////	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
////	String stop = String.valueOf(new DecimalFormat("#.####################").format(ts2));
////			System.out.println(Integer.valueOf(stop));
////			
////			System.out.println(stop);
//	double total = (double)(stop-start)/1000000000;
//	
//	double IOFlops = (100000*10)/total;
//	DecimalFormat f = new DecimalFormat("##.0000"); 
//	
//	System.out.println(" " +total + " " + f.format(IOFlops));	

	


	
}
}
public class D implements Runnable{

public void run(){
	
	System.out.println("ThreadD");

	long start = System.nanoTime();
	//System.out.println(start);
//	double time1 = System.currentTimeMillis();
//	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//	String start = String.valueOf(new DecimalFormat("#.####################").format(ts1));
//			System.out.println(Integer.valueOf(start));

			int a = 0;
	for(int i=0; i<100000; i++){
		
		
		a= 4+5;
		
		a = 5+5;
		
		a = 8/9;
		a = 5*15999;
		 a = 50000%10;
		 a= (9+10)/10000;
		 a+=9000;
		 a/=15000;
		 a-=100;
		 a/=1300;
				 
				 
				 
		
		
		
		
		
	}
//	long stop = System.nanoTime();
//	System.out.println("StopD: " +stop);
//	System.out.println(a);
////	double time2 = System.currentTimeMillis();
////	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
////	String stop = String.valueOf(new DecimalFormat("#.####################").format(ts2));
////			System.out.println(Integer.valueOf(stop));
////			
////			System.out.println(stop);
//	double total = (double)(stop-start)/1000000000;
//	
//	double IOFlops = (100000*10)/total;
//	DecimalFormat f = new DecimalFormat("##.0000"); 
//	
//	System.out.println(" " +total + " " + f.format(IOFlops));	
//
//	


	
}
}
public class E implements Runnable{

public void run(){
	
	System.out.println("ThreadE");

	long start = System.nanoTime();
	//System.out.println(start);
//	double time1 = System.currentTimeMillis();
//	double ts1 = TimeUnit.MILLISECONDS.toSeconds((long) time1);
//	String start = String.valueOf(new DecimalFormat("#.####################").format(ts1));
//			System.out.println(Integer.valueOf(start));

			int a = 0;
	for(int i=0; i<100000; i++){
		
		
		a= 4+5;
		
		a = 5+5;
		
		a = 8/9;
		a = 5*15999;
		a = 50000%10;
		 a= (9+10)/10000;
		 a+=9000;
		 a/=15000;
		 a-=100;
		 a/=1300;
		
		
		
		
	}
//	long stop = System.nanoTime();
//	System.out.println("StopE: " +stop);
//	System.out.println(a);
////	double time2 = System.currentTimeMillis();
////	double ts2 = TimeUnit.MILLISECONDS.toSeconds((long) time2);
////	String stop = String.valueOf(new DecimalFormat("#.####################").format(ts2));
////			System.out.println(Integer.valueOf(stop));
////			
////			System.out.println(stop);
//	double total = (double)(stop-start)/1000000000;
//	
//	double IOFlops = (100000*10)/total;
//	DecimalFormat f = new DecimalFormat("##.0000"); 
//	
//	System.out.println(" " +total + " " + f.format(IOFlops));	
//
//	


	
}
}
}
