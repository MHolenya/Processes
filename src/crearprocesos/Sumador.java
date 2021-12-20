package crearprocesos;

	import java.io.*;

	public class Sumador {
		
		/**
		 * Este m�todo suma todos los n�meros que hay en un intervalo
		 * @param numero1 Inicio del intervalo
		 * @param numero2 Fin del intervalo
		 * @return Suma de todos los n�meros que hay en el intervalo definido
		 */
		
		public static int sumar(int numero1, int numero2) {
			int suma = 0;
			for (int i = numero1; i<= numero2; i++) {
				suma += i;
			}
			return suma;
		}
	
	
		public static void main(String[] args) {
			//Obtenemos los par�metros pasados al crear el proceso
			int numero1 = Integer.valueOf(args[0]);
			int numero2 = Integer.valueOf(args[1]);
			
			int suma = sumar(numero1, numero2);
		}
		
	}