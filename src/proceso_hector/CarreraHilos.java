package proceso_hector;


public class CarreraHilos {

	public static void main(String[] args) {
		try {
			
			
		Thread t1 = new Thread(new Hilo_sumador("Hilo 1"));
		Thread t2 = new Thread(new Hilo_sumador("Hilo 2"));
		Thread t3 = new Thread(new Hilo_sumador("Hilo 3"));
		
		
		t1.setPriority(1);
		t2.setPriority(5);
		t3.setPriority(10);

		
		t1.start();
		t2.start();
		t3.start();
		
		
	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
