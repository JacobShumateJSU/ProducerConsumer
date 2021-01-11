package producerconsumer;
/**
 * Server.java
 *
 * This creates the buffer and the producer and consumer threads.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

public class Server
{

	public static void main(String args[]) {
		BoundedBuffer server1 = new BoundedBuffer();
		BoundedBuffer server2 = new BoundedBuffer();

			
			Producer John = new Producer(server1);
			John.setName("John");
			Producer Liz = new Producer(server2);
			Liz.setName("Liz");
			Consumer Mary = new Consumer(server1);
			Mary.setName("Mary");
			Consumer Bert = new Consumer(server2);
			Bert.setName("Bert");
			John.start();
			Liz.start();
			Mary.start();
			Bert.start();
	}//main
}//class
