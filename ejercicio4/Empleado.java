//Galindo Salinas Matias Alejandro 
package ejercicio4;

import java.util.Scanner;
import java.util.*;

public class Empleado{
    private int intId;
    private String strNombre;
    private String strPuesto;
    private float flSueldoQuincenal[] = new float[4];
    private float flHorasExtrasDiurnas;
    private float flHorasExtrasNocturnas;

    private static final float SUELDO_QUINCENAL = 5000;
    private static final float COSTO_HORA_EXTRA_DIURNA = 50;
    private static final float COSTO_HORA_EXTRA_NOCTURNA = 60;    

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

    public void setPuesto(String puesto){
        strPuesto = puesto;
    }

    public String getPuesto(){
        return strPuesto;
    }

    public void setHorasExtrasDiurnas(float horasExtrasDiurnas){
        flHorasExtrasDiurnas = horasExtrasDiurnas;
        setSueldoQuincenal(0, horasExtrasDiurnas * COSTO_HORA_EXTRA_DIURNA);
    }

    public float getHorasExtrasDiurnas(){
        return flHorasExtrasDiurnas;
    }

    public float getHorasExtrasNocturnas(){
        return flHorasExtrasNocturnas;
    }

    public void setHorasExtrasNocturnas(float horasExtrasNocturnas){
        flHorasExtrasNocturnas = horasExtrasNocturnas;
        setSueldoQuincenal(1, horasExtrasNocturnas * COSTO_HORA_EXTRA_NOCTURNA);
    }

    public void setSueldoQuincenal(int intIndice, float flImporte){
        if (intIndice>=0 && intIndice<flSueldoQuincenal.length){
            flSueldoQuincenal[intIndice]=flImporte;
        }
    }

    public float getSueldoQuincenal(int intIndice){
        if (intIndice>=0 && intIndice<flSueldoQuincenal.length){
            return flSueldoQuincenal[intIndice];
        }
        return 0;
    }

    public Empleado(int id, String nombre, String puesto){
        setId(id);
        setNombre(nombre);
        setPuesto(puesto);
    }

    public float calcularSueldo(){
        return SUELDO_QUINCENAL +
            // horas extra diurnas
            flSueldoQuincenal[0] +
            // horas extra nocturnas
            flSueldoQuincenal[1] ;
    }

    public void imprimir(){
        System.out.printf("%d - %s - %s - $%.2f\n", intId, strPuesto, strNombre, calcularSueldo());
    }

    private float  leerFloat(String strEtiqueta, Scanner entrada){
        float flCantidad;
        System.out.println(strEtiqueta);
        try {
            return Float.parseFloat(entrada.next());
        }catch (Exception exception) {
            System.out.println("Error: cantidad incorrecta.");
            return leerFloat(strEtiqueta, entrada);
        }
    }

    public void leerDatos(Scanner entrada){
        setHorasExtrasDiurnas(leerFloat("No. Horas Extras Diurnas: ",  entrada));
        setHorasExtrasNocturnas(leerFloat("No. Horas Extras Nocturnas: ",  entrada));
    }

    public void consultarEmpleado(){
        System.out.println("Id: " + intId);
        System.out.println("Nombre: " + strNombre);
        System.out.println("Puesto: " + strPuesto);
        System.out.printf("No. Horas Extra Diurnas: %.2f = $%.2f\n" ,  flHorasExtrasDiurnas, getSueldoQuincenal(0));
        System.out.printf("No. Horas Extra Nocturnas: %.2f = $%.2f\n" ,  flHorasExtrasNocturnas, getSueldoQuincenal(1));
    }

}