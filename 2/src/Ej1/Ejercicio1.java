package Ej1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Ejercicio1 {
	
	public static void main(String[] args) throws IOException {	  
		StreamTokenizer lectortoken = new StreamTokenizer (new FileInputStream("C:/Users/AlumnoT/Desktop/acceso_a_datos/2/tema2_practica.txt"));
			try {
				while(lectortoken.nextToken()!= StreamTokenizer.TT_EOF) {
					if(lectortoken.ttype == StreamTokenizer.TT_NUMBER ) {
						System.out.print("Numero: ");
						System.out.println((int)lectortoken.nval);
					}
				}
			}catch (IOException error) {
				error.printStackTrace();
			}    
	}
}
