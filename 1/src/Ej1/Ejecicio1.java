package Ej1;

import java.io.File;

public class Ejecicio1 {
    
    public static void main(String[] args) {
    
        
        File fichero = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada");
        
        if (!fichero.exists()) {
            fichero.mkdir();
                System.out.println("El directorio 'cine_granada' se ha creado con ruta absoluta: " + fichero.getAbsolutePath());
            } else {
            System.out.println("El directorio 'cine_granada' ya existe.");
        }
        
       
       String[] array = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};  
       for (int i=0; i < 7;i++) {
            File ficheroDias = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/" + array[i]);
            
            if (!ficheroDias.exists()) {
            	ficheroDias.mkdir();
            		System.out.println(array[i] + " ha sido creado con ruta absoluta: " + ficheroDias.getAbsolutePath());	
                } else {
                System.out.println(array[i] + " ya existe.");
            }
            
       }
       System.out.println("---------------------Archivos creados hasta ahora---------------------");
       System.out.println("");
       for (int j =0; j <7;j++) {
           File ruta_antigua = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/" + array[j]);
           File ruta_nueva= new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/" + array[j]);
           ruta_antigua.renameTo(ruta_nueva);
           System.out.println(ruta_nueva.getPath());
           System.out.println("");
       }
       
       
    }

}
