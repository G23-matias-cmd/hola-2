//Galindo Salinas Matias Alejandro 
package ejercicio4;

import java.util.*;
import java.util.Scanner;


public class Supervisor extends Empleado{
    private static final float SUELDO_QUINCENAL = 8000f;
    private static final float INFONAVIT = 0.2f;
    private static final float SEGURO_GASTOS_MEDICOS = 0.1f;
    private static final float ISR = 0.16f;
    
    private void setPrestaciones(){
        setSueldoQuincenal(0,SUELDO_QUINCENAL * INFONAVIT);
        setSueldoQuincenal(1,SUELDO_QUINCENAL * SEGURO_GASTOS_MEDICOS);
        setSueldoQuincenal(2,SUELDO_QUINCENAL * ISR);
    }

    public Supervisor(int id, String nombre, String puesto){
        super(id, nombre, puesto);
        setPrestaciones();
    }

    public float calcularSueldo(){
        return SUELDO_QUINCENAL -
            // infonavit
            getSueldoQuincenal(0) -
            // seguro gastos medicos
            getSueldoQuincenal(1) -
            // isr
            getSueldoQuincenal(2);
    }

    public void leerDatos(Scanner entrada){
        System.out.println("El Supervisor no requiere datos adicionales.");
    }


    public void consultarEmpleado(){
        System.out.println("Id: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puesto: " + getPuesto());
        System.out.printf("Infonavit:  $0.2f\n" , getSueldoQuincenal(0));
        System.out.printf("Seguro Gastos M'edicos:  $0.2f\n" , getSueldoQuincenal(1));
        System.out.printf("ISR:  $0.2f\n" , getSueldoQuincenal(2));
    }

}