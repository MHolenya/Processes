package proceso_hector;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultiHilo {

	public static void main(String[] args) {

		/* Creamos el metodo scanner para leer por terminal */
		Scanner sc = new Scanner(System.in);

		/*
		 * Creamos un arraylist para guardar los sitios que escribamos por la terminal
		 * para hacer ping
		 */
		ArrayList<String> as = new ArrayList<String>();

		/* Guardamos todos los Hilos que creamos posteriormente */
		ArrayList<Thread> at = new ArrayList<Thread>();
		String pag = null;

		/*
		 * Creamos un bucle para pedir por terminal 5 sitios para hacer ping y
		 * guardarlos en un array
		 */
		for (int i = 1; i < 6; i++) {

			/* Mostramos por pantalla un mensaje con el numero de pagina a introducir */
			System.out.println("Introduzca la pagina " + i);

			/* gaurdamos lo que escribamos en terminal en una variable pag */
			pag = sc.nextLine();

			/* añadimos las paginas a un array de String */
			as.add(pag);
		}
		/*
		 * Creamos un bucle para crear 5 Hilos automaticamente y guardarlos en un array
		 * de Threads
		 */
		for (int j = 0; j < 5; j++) {

			/* igualamos cont a j para que recoja su valor */
			int cont = j;

			/* Creamos el hilo */
			Thread t = new Thread() {

				/* metodo run */
				public void run() {

					/* instanciamos las variables de procesos */
					Process proceso_a = null;

					try {
						/* Instanciamos una variable proceso */
						ProcessBuilder builder_a = new ProcessBuilder();

						/* Heredamos de todos los hilos entrada\salida */
						builder_a.inheritIO();

						/* Comando para hacer ping en las paginas utilizadno el array de String */
						builder_a.command("ping", "-t", as.get(cont).toString());

						/* Iniciamos el proceso */
						proceso_a = builder_a.start();
						proceso_a.waitFor();

						/* Capturamos excepciones */
					} catch (Exception e) {

						/* Cerramos el proceso */
						System.out.println("Se va ha cerrar el proceso");
						proceso_a.destroy();
						System.err.println("Exception E/S" + e.toString());

					}
				}
			};

			/* Activamos el funcionamiento de los Threads */
			t.start();

			/* Añadimos los threads a el array */
			at.add(t);
		}

		/*
		 * Creamos un bucle con condicionales para pedir por teclado cual hilo quieres
		 * cerrar dependiendo del numero cerrara un hilo o otro al finalziar todos
		 * finaliza el proceso principal
		 */
		try {
			int opcion;
			do {
				opcion = Integer.parseInt(sc.nextLine());
				if (opcion == 0) {
					at.get(0).interrupt();
				} else if (opcion == 1) {
					at.get(1).interrupt();
				} else if (opcion == 2) {
					at.get(2).interrupt();
				} else if (opcion == 3) {
					at.get(3).interrupt();
				} else if (opcion == 4) {
					at.get(4).interrupt();
				} else {
					System.out.println("Valor no valido ");
				}
				/* mientras que opcion sea mayor o igual a 0 y menor de 5 */
			} while (opcion >= 0 && opcion < 5);
		} catch (NumberFormatException e) {
			System.err.println("Number Exception " + e.toString());
		}
	}
}
