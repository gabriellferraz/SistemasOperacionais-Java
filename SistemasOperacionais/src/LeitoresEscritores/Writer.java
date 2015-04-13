/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 13/04/2015 
 */
package LeitoresEscritores;

public class Writer implements Runnable {
	
	private RWLock db;
	
	public Writer(RWLock db){
		this.db = db;
	}
	
	public void run(){
		while (true){
			//nap for awhile
			SleepUtilities.nap();
			
			db.acquireWriteLock();
			
			//you have access to write to the database
			SleepUtilities.nap();
			
			db.releaseWriteLock();
		}
	}
	
	public void acquireWriteLock(){
		db.acquireWriteLock();
	}
	
	public void releaseWriteLock(){
		db.releaseWriteLock();
	}
	
}
