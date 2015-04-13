/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 13/04/2015 
 */
package LeitoresEscritores;

import java.util.concurrent.Semaphore;

public class Reader implements Runnable {
	
	private RWLock db;
	private Semaphore mutex;
	private int readercount;
	
	public Reader(RWLock db){
		this.db = db;
	}
	
	public void run(){
		while (true){
			//nap for awhile
			SleepUtilities.nap();
			
			db.acquireWriteLock();
			
			//you have access to read to the database
			SleepUtilities.nap();
			
			db.releaseWriteLock();
		}
	}
	
	public void acquireWriteLock() throws InterruptedException{
		
		mutex.acquire(); //acesso exclusivo ao readercount
		readercount++;
		if (readercount == 1) //para o primeiro leitor
			db.acquireWriteLock(); //sincroniza com escritores
		mutex.release(); //libera outros leitores
		
	}
	
	public void releaseWriteLock() throws InterruptedException{
		
		mutex.acquire(); //acesso exclusivo ao readercount
		readercount--;
		if (readercount == 0) //se último leitor
			db.releaseWriteLock(); //libera um escritor
		mutex.release();
		
	}

}
