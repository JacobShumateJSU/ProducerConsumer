package producerconsumer;
/**
 * Producer.java
 *
 * This is the producer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class Producer extends Thread
{
   public Producer(BoundedBuffer b) {
      buffer = b;
   }

   public void run()
   {

	   synchronized(buffer) 
       { 
      while (true)
      {
    	  

    	 int sleeptime = (int) ((Math.random() * (8000 - 4000)) + 4000);
         String threadName=Thread.currentThread().getName();
         System.out.println("Producer "+threadName+" sleeping for " + sleeptime/1000 + " seconds");

         
         try { sleep(sleeptime); }
         catch(InterruptedException e) {}

 
         
         int message = (int) ((Math.random() * (30000 - 5000)) + 5000);
         System.out.println(threadName+" produced " + message);
         
         buffer.enter(message);
         buffer.notify();
      }
      }
   }
   
   private  BoundedBuffer buffer;

}
