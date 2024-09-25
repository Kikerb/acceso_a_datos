package Ej1;

import java.io.File;

public class Ejecicio1 {
	
	public static void main(String[] args) {
    
        
        File directorio = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada");
        
        if (!directorio.exists()) {
            boolean creado = directorio.mkdir();
            if (creado) {
                System.out.println("El directorio 'cine_granada' ha sido creado exitosamente.");
            	} else {
                System.out.println("No se pudo crear el directorio 'cine_granada'.");
            }
        	} else {
            System.out.println("El directorio 'cine_granada' ya existe.");
        }
    }

}
