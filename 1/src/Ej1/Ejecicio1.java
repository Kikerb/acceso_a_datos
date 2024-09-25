package Ej1;

import java.io.File;

public class Ejecicio1 {
	
	public static void main(String[] args) {
    
        
        File directorio = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada");
        	directorio.mkdir();
        String[] array = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
            
        for (int i=0; i < 7;i++) {
        	File ficheroDias = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/" + array[i]);
        	ficheroDias.mkdir();
        }        
        
    }

}
