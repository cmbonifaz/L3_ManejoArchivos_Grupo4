package test;

import dominio.Archivo;
import dominio.Empleado;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestEmpleado {

    static Scanner datos = new Scanner(System.in);
    static FileWriter archivo;

    public static void main(String[] args) {
        int op = 0;
        String nArchivo = null;
        while (op != 5) {
            op = 0;
            System.out.println("");
            System.out.println("Menu de opciones del archivo ");
            System.out.println("1.- Abrir/crear archivo");
            System.out.println("2.- Insertar datos");
            System.out.println("3.- Leer datos");
            System.out.println("4.- Cerrar archivo");
            System.out.println("5.- Salir");
            System.out.println("Ingrese el numero de la opcion que desea: ");
            while (op < 1 || op > 5) {
                op = datos.nextInt();
            }
            switch (op) {
                case 1 -> {
                    if (nArchivo == null) {
                        Archivo abrir = new Archivo();
                        System.out.println("");
                        System.out.println("--- Abriendo/creando archivo ---");
                        System.out.println("");
                        datos.nextLine();
                        System.out.println("Por favor ingrese el nombre del archivo con su extension (.txt), por ejemlo <<prueba.txt>>: ");
                        nArchivo = datos.nextLine();
                        abrir.abrirArchivo(nArchivo);
                        try {
                            archivo = new FileWriter(nArchivo, true);
                        } catch (IOException ex) {
                            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.out.println("");
                        System.out.println("--- Ya tiene un archivo ABIERTO con nombre: " + '"' + nArchivo + '"' + " ---");
                    }
                }

                case 2 -> {
                    if (nArchivo != null) {
                        int contador = 0,
                                nro = 0;
                        System.out.println("--- Inserte los datos ---");
                        System.out.println("");
                        System.out.println("Cuantos empleados desea ingresar?: ");
                        while (nro < 1) {
                            nro = datos.nextInt();
                        }
                        while (contador < nro) {
                            System.out.println("--------------------------");
                            System.out.println("Empleado No " + (contador + 1));
                            llenarDatos(nArchivo);
                            contador++;
                        }
                    } else {
                        System.out.println("");
                        System.out.println("--- Nota: Por favor cree o abra un archivo para insertar datos ---");
                    }
                }
                case 3 -> {
                    if (nArchivo != null) {
                        Archivo lec = new Archivo();
                        System.out.println("");
                        System.out.println("--- Leyendo los datos ---");
                        System.out.println("");
                        lec.LecturaDeArchivo(nArchivo);

                    } else {
                        System.out.println("");
                        System.out.println("--- Nota: No existe ningun archivo abierto para leer los datos ---");
                    }
                }

                case 4 -> {
                    if (nArchivo != null) {
                        try {
                            archivo.close();
                        } catch (IOException ex) {
                            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("");
                        System.out.println("-- Archivo Cerrado ---");
                        nArchivo = null;
                    } else {
                        System.out.println("");
                        System.out.println("--- Nota: No existe ningun archivo abierto ---");
                    }
                }
                case 5 -> {
                    System.out.println("");
                    System.out.println("--- Saliendo del programa ---");
                    System.out.println("");
                }
                default -> {
                }
            }
        }
    }

    public static void llenarDatos(String nArchivo) {
        Archivo escribir = new Archivo();
        Calendar fecha = new GregorianCalendar();
        int anio = 2022,
                mes = 0,
                dia = 0;
        String nombre = null;
        Empleado ob1 = new Empleado(nombre, anio, mes, dia);
        datos.nextLine();
        
        System.out.println("Nombre del empleado: ");
        nombre = datos.nextLine();
        ob1.setNombre(nombre);

        System.out.println("Anio de nacimiento: ");
        while (anio > fecha.get(Calendar.YEAR)) {
            anio = datos.nextInt();
        }
        ob1.setAnio(anio);

        System.out.println("Mes de nacimiento(numero): ");
        while (mes < 1 || mes > 12) {
            mes = datos.nextInt();
        }
        ob1.setMes(mes - 1);

        System.out.println("Dia de nacimiento: ");
        while (dia < 1 || dia > 31) {
            dia = datos.nextInt();
        }
        ob1.setDia(dia);
        System.out.println(ob1);
        escribir.escribirArchivo(nArchivo, ob1.getNombre(), ob1.getAnio(), ob1.getMes(), ob1.getDia());
    }
}
