//Galindo Salinas Matias Alejandro 
import java.util.*;
import java.util.Scanner;
import ejercicio4.Empleado;
import ejercicio4.Supervisor;



public class Ejercicio4{

    private Empleado[] arrEmpleados = new Empleado[3];

    private void imprimirMenu(){
        System.out.println("----- Seleccione una opci'on: -----");
        System.out.println("1. - Enlistar Empleados");
        System.out.println("2. - Introducir Datos de Empleado");
        System.out.println("3. - Consultar Empleado");
        System.out.println("S. - Salir");
    }

    private void listarEmpleados(){
        System.out.println("----- Listar Empleados -----");
        for(int i=0;i<arrEmpleados.length;i++){
            arrEmpleados[i].imprimir();
        }
        System.out.println("----------------------------");
    }

    private Empleado leerEmpleado(Scanner entrada){
        int intId;
        System.out.println("Id de Empleado: ");
        try {
            intId = Integer.parseInt(entrada.next());
            for(int i=0;i<arrEmpleados.length;i++){
                if (arrEmpleados[i].getId()==intId){
                    return arrEmpleados[i];
                }
            }
            //si no encontr'o el id del empleado, el usuario introdujo un id incorrecto
            System.out.println("Error: Id incorrecto.");
            return leerEmpleado(entrada);
        }catch (Exception exception) {
            System.out.println("Error: Id incorrecto.");
            return leerEmpleado(entrada);
        }
    }

    private String leerPuesto(Empleado empleado, Scanner entrada){
        String strPuesto;
        System.out.println("Puesto del Empleado: ");
        strPuesto = entrada.next();
        if (empleado.getPuesto().equalsIgnoreCase(strPuesto)){
            return empleado.getPuesto();
        }
        return "";
    }


    private void introducirDatos(Scanner entrada){
        Empleado empleado = leerEmpleado(entrada);
        String strPuesto = leerPuesto(empleado, entrada);
        if ("".equals(strPuesto)){
            System.out.println("Error: El puesto y el Id no coinciden.");
            return;
        }
        empleado.leerDatos(entrada);
        System.out.println("Los datos han sido exitosamente le'idos.");
    }

    
    private void consultarEmpleado(Scanner entrada){
        Empleado empleado = leerEmpleado(entrada);
        empleado.consultarEmpleado();
    }

    public char leerOpcion(Scanner entrada){
        char chOpcion = ' ';
        imprimirMenu();
        chOpcion = entrada.next().charAt(0);
        switch (chOpcion){
            //salir del programa
            case 's':
            case 'S':
                return 's';
            case '1':
                listarEmpleados();
                break;
            case '2':
                introducirDatos(entrada);
                break;
            case '3':
                consultarEmpleado(entrada);
                break;
            // si el usuario se equivoca
            default:
                System.out.println(" Error: Opci'on no reconocida.");
                break;
        }
        return leerOpcion(entrada);
    }

    public Ejercicio4(){
        arrEmpleados[0]= new Supervisor(1,"Matias Alejandro Galindo Salinas", "Supervisor");
        arrEmpleados[1]= new Empleado(2,"Juan P'erez L'opez", "Empleado");
        arrEmpleados[2]= new Empleado(3,"Alfredo S'anchez M'endez", "Empleado");
    }

    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        Ejercicio4 ejercicio4 = new Ejercicio4();
        char opcion = ' ';
        while (opcion!='s')
            opcion = ejercicio4.leerOpcion(entrada);
    } 
}