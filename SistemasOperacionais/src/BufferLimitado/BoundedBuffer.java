/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 06/04/2015  
 */

package BufferLimitado;

import java.util.concurrent.Semaphore;

public class BoundedBuffer implements Buffer{

	private static final int BUFFER_SIZE = 5;
	private Object[] buffer;
	private int in, out;
	private Semaphore mutex;
	private Semaphore empty;
	private Semaphore full;
	
	public BoundedBuffer() {
		//buffer is initially empty
		in = 0;
		out = 0;
		buffer = new Object[BUFFER_SIZE];
		
		mutex = new Semaphore(1);
		empty = new Semaphore(BUFFER_SIZE);
		full = new Semaphore(0);
	}
	
	public void insert (Object item) throws InterruptedException{
		empty.acquire();
		mutex.acquire();
		
		//add an item to the buffer
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;
		
		mutex.release();
		full.release();
	}
	
	public Object remove() throws InterruptedException{
		full.acquire();
		mutex.acquire();
		
		//remove an item from the buffer
		Object item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;
		
		mutex.release();
		empty.release();
		
		return item;
	}
}