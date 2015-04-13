/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 13/04/2015 
 */
package LeitoresEscritores;

public interface RWLock {

	public abstract void acquireReadLock();
	public abstract void acquireWriteLock();
	public abstract void releaseReadLock();
	public abstract void releaseWriteLock();

}
