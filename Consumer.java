package producerconsumer;
/**
 * Consumer.java
 *
 * This is the consumer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class Consumer extends Thread
{
   public Consumer(BoundedBuffer b)
   {
      buffer = b;
   }
   
   public void run()
   {
 
	   int sum=0;
       int rem=0;
      
 synchronized(buffer) 
  { 
     while (true)
      {
 
    	 int sleeptime = (int) ((Math.random() * (8000 - 4000)) + 4000);
         String threadName=Thread.currentThread().getName();
         System.out.println("Consumer "+threadName+" sleeping for " + sleeptime/1000 + " seconds");

         try { sleep(sleeptime); }
         catch(InterruptedException e) {}

   
         
         System.out.println(threadName+" wants to consume.");

         Object bu = buffer.remove();
    
         if(bu!=null) {
        	 int message = (int) bu;
        	 int num = message;
        
         
        	 while (num > 0) {
        		 rem = num % 10;
        		 sum = sum+rem;
        		 num = num /10;
        	 }
        	 System.out.println(threadName+" consumed "+message+" Sum of its digits is:"+sum);
        	 sum=0;
         }
         else {

        	 while(bu==null) {
        		 try {
        			 System.out.println("WAITING.....");
        			 buffer.wait();
        			 System.out.println("WAITING.....");
        		 } catch (InterruptedException e) {
        			 System.out.println("COULD NOT WAIT");
        			 e.printStackTrace();
        		 }
        	 }
        	 System.out.println("I'm awake!");
        	 //}
        	
         }
      }
     }
  }
   
   private  BoundedBuffer buffer;


}


