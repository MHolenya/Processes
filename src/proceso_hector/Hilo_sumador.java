package proceso_hector;

public class Hilo_sumador implements Runnable {
	String nombre;
	public Hilo_sumador( String nombre) {
		this.nombre= nombre;
	}

	int suma = 0;

	@Override
	public void run() {
		
		while (suma < 100) {
			int numeroA = (int) (Math.random() * 5 + 1);
			suma += numeroA;

			try {
				
				Thread.sleep(1000);
				System.out.println(nombre + " : " + suma);
			
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("EL" + nombre + " ha finalizado");
		
	}

}
