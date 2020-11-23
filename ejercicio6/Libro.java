//Galindo Salinas Matias Alejandro 
package ejercicio6;

import java.util.Scanner;

public class Libro{
    private int intId;
    private String strTitulo;
    private String strAutor;
    private int intExistencia;
    private int intPrestados;

    public void setId(int id){
        intId = id;
    }

    public int getId(){
        return intId;
    }

    public void setTitulo(String titulo){
        strTitulo = titulo;
    }

    public String getTitulo(){
        return strTitulo;
    }

    public void setAutor(String autor){
        strAutor = autor;
    }

    public String getAutor(){
        return strAutor;
    }

    public void setExistencia(int existencia){
        intExistencia = existencia;
    }

    public int getExistencia(){
        return intExistencia;
    }

    public void setPrestados(int prestados){
        intPrestados = prestados;
    }

    public int getPrestados(){
        return intPrestados;
    }

    public String prestarLibro(){
        int existencia = getExistencia();
        if (existencia<=0){
            return "Error: No hay m'as libros para prestar.";
        }
        setExistencia(existencia-1);
        setPrestados(getPrestados()+1);
        return "Libro exitosamente prestado.";

    }

    public String devolverLibro(){
        int prestados = getPrestados();
        if (prestados<=0){
            return "Error: No hay m'as libros para devolver.";
        }
        setPrestados(prestados-1);
        setExistencia(getExistencia()+1);
        return "Libro exitosamente devuelto.";
    }

    public Libro(int id, String titulo, String autor, int existencia){
        setId(id);
        setTitulo(titulo);
        setAutor(autor);
        setExistencia(existencia);
        setPrestados(0);
    }

    public String toString(){
        return " " + getId() + " |          " + getExistencia() + " |         " + getPrestados() + " | " + getTitulo() + " | " + getAutor();
    }
}