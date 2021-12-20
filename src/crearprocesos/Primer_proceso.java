package crearprocesos;

import java.io.IOException;

public class Primer_proceso {

	public static void main(String[] args) {
		//ruta del ejecutable de google crome 
		String RUTA_PROCESO = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		//Creamos el proceso de google 
		ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
		//Lanzamos el proceso
		
		try {
			Process process = pb.start();
			//obtenemos su estado de ejecucion
			int retorno = process.waitFor();
			System.out.println("La ejecucion de  " + RUTA_PROCESO + "\ndevuelve" + retorno);
			
		
		
		
		} catch (IOException ex) {
			System.err.println("Error" + ex.toString());
			
			
			
		}catch(InterruptedException ex) {
			System.err.println("el proceso finalizo de forma incorrecta");
			System.exit(-1);
		}
	}

}
