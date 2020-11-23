//Galindo Salinas Matias Alejandro 
import java.util.*;
import java.util.Scanner;
import ejercicio6.Libro;

public class Ejercicio6{

    private Libro[] arrLibros = new Libro[5];

    private void imprimirMenu(){
        System.out.println("----- Seleccione una opci'on: -----");
        System.out.println("1. - Enlistar Libros");
        System.out.println("2. - Prestar Libro");
        System.out.println("3. - Devolver Libro");
        System.out.println("S. - Salir");
    }

    private void listarLibros(){
        System.out.println("------------------ LIBROS ------------------");
        System.out.println("ID | EXISTENCIA | PRESTADOS | TITULO | AUTOR");
        for(int i=0;i<arrLibros.length;i++){
            System.out.println(arrLibros[i]);
        }
        System.out.println("--------------------------------------------");
    }

    private Libro leerLibro(Scanner entrada){
        int intId;
        System.out.println("Id de Libro: ");
        try {
            intId = Integer.parseInt(entrada.next());
            for(int i=0;i<arrLibros.length;i++){
                if (arrLibros[i].getId()==intId){
                    return arrLibros[i];
                }
            }
            //si no encontr'o el id del Libro, el usuario introdujo un id incorrecto
            System.out.println("Error: Id incorrecto.");
            return leerLibro(entrada);
        }catch (Exception exception) {
            System.out.println("Error: Id incorrecto.");
            return leerLibro(entrada);
        }
    }
 
    private void prestarLibro(Scanner entrada){
        Libro libro = leerLibro(entrada);
        System.out.println(libro.prestarLibro());
    }

    private void devolverLibro(Scanner entrada){
        Libro libro = leerLibro(entrada);
        System.out.println(libro.devolverLibro());
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
                listarLibros();
                break;
            case '2':
                prestarLibro(entrada);
                break;
            case '3':
                devolverLibro(entrada);
                break;
            // si el usuario se equivoca
            default:
                System.out.println(" Error: Opci'on no reconocida.");
                break;
        }
        return leerOpcion(entrada);
    }

    public Ejercicio6(){
        arrLibros[0] = new Libro(1, "La Biblia", "Jes'us", 4);
        arrLibros[1] = new Libro(2, "Fisica I", "Resnick", 9);
        arrLibros[2] = new Libro(3, "Geometria I", "Spivack", 6);
        arrLibros[3] = new Libro(4, "El capital", "Karl Marx", 8);
        arrLibros[4] = new Libro(5, "La 'Iliada", "Homero", 3);
    }

    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        Ejercicio6 ejercicio6 = new Ejercicio6();
        char opcion = ' ';
        while (opcion!='s')
            opcion = ejercicio6.leerOpcion(entrada);
    } 
}