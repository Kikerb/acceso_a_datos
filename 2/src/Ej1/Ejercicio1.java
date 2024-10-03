package Ej1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Ejercicio1 {
	
	public static void main(String[] args) throws IOException {	  
		 StreamTokenizer lectortoken = new StreamTokenizer (new FileInputStream("C:/Users/AlumnoT/Desktop/acceso_a_datos/2/tema2_practica.txt"));
	        boolean seguir = false;
	                
	        try {
	            
	            while(lectortoken.nextToken()!= StreamTokenizer.TT_EOF) {
	                if(lectortoken.ttype =='>') {
	                    seguir = true;
	                }
	                
	                if (seguir == true) {
	                    if(lectortoken.ttype == StreamTokenizer.TT_WORD ) {
	                        String nombre = lectortoken.sval;
	                        lectortoken.nextToken();
	                        String apellido = lectortoken.sval;
	                        System.out.println("Nombre: " + nombre + " " + apellido + " ");
	                        seguir = false;
	                    }
	                }
	                
	                if(lectortoken.ttype == StreamTokenizer.TT_NUMBER) {
	                    System.out.println("Numero: " + (int)lectortoken.nval);
	                    System.out.println("");
	                    
	                }
	            }
	                    
	                
	        }catch (IOException error) {
	            error.printStackTrace();
	        }
	}
}
