//Galindo Salinas Matias Alejandro 
package ejercicio5;

import java.util.Scanner;

public class Proveedor{
    private static final int TAMANO = 10;
    private int intId;
    private String strNombre;
    private String strArrProducto[] = new String[TAMANO];
    private int intArrCosto[] = new int[TAMANO];
    private int intArrExistencia[] = new int[TAMANO];


    public void setId(int id){
        intId = id;
    }

    public int getId(){
        return intId;
    }

    public void setNombre(String nombre){
        strNombre = nombre;
    }

    public String getNombre(){
        return strNombre;
    }

    public void anadirProducto(int intIndice, String nombre, int costo, int existencia){
        if (intIndice>=0 && intIndice<strArrProducto.length){
            strArrProducto[intIndice]=nombre;
            intArrCosto[intIndice]=costo;
            intArrExistencia[intIndice]=existencia;
        }
    }

    public int obtenerSumaTotalDeCostos(){
        int intSuma = 0;
        for(int i=0;i<strArrProducto.length;i++){
            intSuma += intArrCosto[i];
        }
        return intSuma;
    }

    public int obtenerCostoMayor(){
        int intCostoMayor = 0;
        for(int i=0;i<strArrProducto.length;i++){
            if (intArrCosto[i]>=intCostoMayor) {
                intCostoMayor = intArrCosto[i];
            }
        }
        return intCostoMayor;
    }

    public int obtenerCostoMenor(){
        int intCostoMenor = 0;
        for(int i=0;i<strArrProducto.length;i++){
            if (intArrCosto[i]<=intCostoMenor || intCostoMenor==0) {
                intCostoMenor = intArrCosto[i];
            }
        }
        return intCostoMenor;
    }

    public float obtenerCostoPromedio(){
        int intCostoPromedio = 0;
        int intTotalProductos = 0;
        for(int i=0;i<strArrProducto.length;i++){
            //si hay un producto registrado en esa entrada, cuenta para el promedio
            if (strArrProducto[i].length()>0){
                intTotalProductos ++;
                intCostoPromedio += intArrCosto[i];
            }
        }
        if (intTotalProductos>0){
            return intCostoPromedio*1.0f/intTotalProductos*1.0f;
        }
        return 0;
    }

    public int obtenerCostoExistencia(int intIndice){
        for(int i=0;i<strArrProducto.length;i++){
            if (i==intIndice){
                return intArrCosto[i] * intArrExistencia[i];
            }
        }
        return 0;
    }

    public Proveedor(int id, String nombre){
        setId(id);
        setNombre(nombre);
    }

    public void imprimir(){
        System.out.println("________________________________________________________");
        System.out.println("PROVEEDOR: " + strNombre);
        System.out.println("--------------------------------------------------------");
        System.out.println("PRODUCTO | COSTO | EXISTENCIA | COSTO TOTAL DEL PRODUCTO");
        for(int i=0;i<strArrProducto.length;i++){
            System.out.println(
                strArrProducto[i] + " | " + 
                intArrCosto[i] + " | " + 
                intArrExistencia[i] + " | " + 
                (intArrCosto[i] *  + intArrExistencia[i])
            );
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("SUMA TOTAL DE COSTOS: " + obtenerSumaTotalDeCostos());
        System.out.println("COSTO MAYOR: " + obtenerCostoMayor());
        System.out.println("COSTO MENOR: " + obtenerCostoMenor());
        System.out.println("COSTO PROMEDIO: " + obtenerCostoPromedio());
        System.out.println("--------------------------------------------------------");
    }
}