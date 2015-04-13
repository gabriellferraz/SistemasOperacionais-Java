/**
 * Autores: Gabriel Ferraz e Rodolfo Bicalho
 * Data: 06/04/2015  
 */
package Algoritmos;

import java.util.Date;

public class Producer implements Runnable
{
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Date message;
		
		while (true){
			SleepUtilities.nap();
			message = new Date();
			try {
				buffer.insert(message);
				System.out.println("Produziu " + message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
