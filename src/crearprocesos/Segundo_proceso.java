package crearprocesos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Segundo_proceso {

	

		public static int ejecutarClaseProceso(Class clase, int n1, int n2)
		throws IOException, InterruptedException{
			//definir donde esta el home de java 
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome
					+ File.separator + "bin"
					+ File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			//obtengo el nombre canonico de la casle que se va ha ejecutar
			String className = clase.getCanonicalName();
			
			ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(n1), String.valueOf(n2));
			Process process = builder.start();
			process.waitFor();
			return process.exitValue();
		}
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	int numero1, numero2;
	
	System.out.println("Dame un numero:");
	numero1 = teclado.nextInt();
	System.out.println("Dame otro numero");
	numero2 = teclado.nextInt();
	
	try {
		int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);
		if(estado_ejecucion==0) {
			System.out.println("Proceso ejecutado correctamente" );
			
		}else {
			System.out.println("Error ejecutando el proceso ");
		}
	}catch(IOException | InterruptedException ex) {
		System.err.println("Error:" + ex.toString());
		System.exit(-1);
	}
}

}
