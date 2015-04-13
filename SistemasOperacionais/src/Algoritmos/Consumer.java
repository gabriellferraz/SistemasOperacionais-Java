/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 06/04/2015  
 */
package Algoritmos;

import java.util.Date;

public class Consumer implements Runnable{

	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;

	}

	public void run() {
		Date message;
		
		while (true){
			SleepUtilities.nap();
			try {
				message = (Date)buffer.remove();
				System.out.println("Consumiu " + message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}

}
