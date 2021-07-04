package dominio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado {

    Calendar fecha = new GregorianCalendar();
    int diaA = fecha.get(Calendar.DAY_OF_MONTH);
    int mesA = fecha.get(Calendar.MONTH);
    int anioA = fecha.get(Calendar.YEAR);
    private String nombre;
    private int anio;
    private int mes;
    private int dia;

    public Empleado(String nombre, int anio, int mes, int dia) {
        this.nombre = nombre;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        int resultado = anioA - anio;
        this.anio = resultado;
    }

    public int getAnio() {
        return this.anio;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        int resultado = mesA - mes;
        if (resultado < 0) {
            resultado += 11;
            this.anio--;
        } else if (resultado > 0) {
            resultado--;
        }
        this.mes = resultado;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        int dias = 31;
        if (mesA == 4 || mesA == 6 || mesA == 9 || mesA == 11) {
            dias = 30;
        } else if (mesA == 2) {
            dias = 28;
        }
        int resultado = diaA - dia;
        if (resultado < 0) {
            resultado += dias;
        }
        this.dia = resultado;
    }

    @Override
    public String toString() {
        return "Edad del empleado " + this.nombre + " es " + this.anio + " Anios, " + this.mes + " Meses, " + this.dia + " Dias";
    }
}
