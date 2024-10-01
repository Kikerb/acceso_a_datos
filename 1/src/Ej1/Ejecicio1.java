package Ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejecicio1 {
    
	public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada");
            if(!fichero.exists()) {
                fichero.mkdir();
                System.out.println("Se ha creado el directorio con ruta absoluta: " + fichero.getAbsolutePath());
                String[] array = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
                for (int i=0; i < 7;i++) {
                    File ficheroDias = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/" + array[i]);
                    if(!ficheroDias.exists()) {
                        ficheroDias.mkdir();
                        System.out.println(array[i] + " ha sido creado con ruta absoluta: " + ficheroDias.getAbsolutePath());
                    
                }else {
                    System.out.println(array[i] + " ya existe");
                }
            }
            System.out.println("");
            System.out.println("----------ARCHIVOS CREADOS HASTA AHORA----------------");
            System.out.println("");
            for (int j =0; j <7;j++) {
                File ruta_antigua = new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/" + array[j]);
                File ruta_nueva= new File("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/" + array[j]);
                ruta_antigua.renameTo(ruta_nueva);
                System.out.println(ruta_antigua.getAbsolutePath() + " se ha movido a " + ruta_nueva.getAbsolutePath());
                System.out.println(ruta_nueva.getPath());
                System.out.println("");
                
                File archivo = new File ("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/" + array[j] + "/sesiones.txt" );
                archivo.createNewFile();

            }
            
                        
            }else {
                System.out.println("El directorio 'cine_granada' ya existe");
            }  
            
            FileOutputStream escritura = new FileOutputStream ("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/Lunes/sesiones.txt");
            String cadena = "Spiderman (2002): 18:00 - 20:07";
            byte[] arrayBytes = cadena.getBytes();
            escritura.write(arrayBytes);
            escritura.close();
            
            FileInputStream lectura = new FileInputStream ("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/Lunes/sesiones.txt");
            int letra = lectura.read();
            while (letra != -1) {
            	System.out.print((char)letra);
            	letra = lectura.read();
            }
            lectura.close();
            
            System.out.println("");
            			
            FileWriter escribir = new FileWriter("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/Martes/sesiones.txt");
            escribir.write("Iron Man (2008): 17:00 - 19:06");
            escribir.close();
            
            FileReader leer = new FileReader("C:/Users/AlumnoT/Desktop/acceso_a_datos/1/cine_granada/Martes/sesiones.txt");
            int letra2 = leer.read();
            while (letra2 != -1) {
            	System.out.print((char)letra2);
            	letra2 = leer.read();
            }
            leer.close();
            
    }

}
