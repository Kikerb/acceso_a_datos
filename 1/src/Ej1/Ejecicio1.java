package Ej1;

import java.io.File;

public class Ejecicio1 {
    
    public static void main(String[] args) {
    
        
        File fichero = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada");
        
        if (!fichero.exists()) {
        	fichero.mkdir();
            } else {
            System.out.println("El directorio 'cine_granada' ya existe.");
        }
       
       String[] array = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        
       for (int i=0; i < 7;i++) {
            File ficheroDias = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/" + array[i]);
            if (!ficheroDias.exists()) {
            	ficheroDias.mkdir();
                } else {
                System.out.println("Los directorios con los dias de la semana ya existen.");
            }
            
       }
       
    }

}
