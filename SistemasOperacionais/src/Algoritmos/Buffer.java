/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 06/04/2015 
 */
package Algoritmos;

public interface Buffer {

	public abstract void insert(Object item) throws InterruptedException;
	public abstract Object remove() throws InterruptedException;
}
