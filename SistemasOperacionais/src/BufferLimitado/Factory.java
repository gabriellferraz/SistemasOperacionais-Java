/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 06/04/2015 
 */
package BufferLimitado;

public class Factory {

	public static void main(String[] args) {
		Buffer buffer = new BoundedBuffer();
		
		Thread producer = new Thread(new Producer(buffer));
		Thread consumer = new Thread(new Consumer(buffer));
		
		producer.start();
		consumer.start();

	}

}
