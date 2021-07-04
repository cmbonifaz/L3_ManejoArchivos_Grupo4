package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.TestEmpleado;

public class Archivo {

    Scanner datos = new Scanner(System.in);

    public void abrirArchivo(String nArchivo) {
        File nombre = new File(nArchivo);
        System.out.println("");
        if (nombre.exists()) {
            System.out.println("--- Archivo " + '"' + nArchivo + '"' + " ABIERTO exitosamente ---");
        } else {
            System.out.println("--- Archivo " + '"' + nArchivo + '"' + " CREADO exitosamente ---");
        }
    }

    public void escribirArchivo(String nArchivo, String nombre, int anio, int mes, int dia) {
        try {
            Empleado ob1 = new Empleado(nombre, anio, mes, dia);
            FileWriter archivo = new FileWriter(nArchivo, true);
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(ob1);
            salida.flush();
            archivo.close();
        } catch (IOException ex) {
            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void LecturaDeArchivo(String nArchivo) {
        String cadena;
        BufferedReader entrada;
        FileReader archivos;
        try {
            archivos = new FileReader(nArchivo);
            entrada = new BufferedReader(archivos);
            System.out.println("Contenido del archivo:");
            System.out.println("");
            cadena = entrada.readLine();
            while (cadena != null) {
                System.out.println(cadena);
                cadena = entrada.readLine();
            }
            archivos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
