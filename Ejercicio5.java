//Galindo Salinas Matias Alejandro 
import java.util.*;
import java.util.Scanner;
import ejercicio5.Proveedor;

public class Ejercicio5{

    private Proveedor[] arrProveedores = new Proveedor[3];

    private void imprimirMenu(){
        System.out.println("----- Seleccione una opci'on: -----");
        System.out.println("1. - Enlistar Proveedores");
        System.out.println("2. - Consultar Proveedor");
        System.out.println("S. - Salir");
    }

    private void listarProveedores(){
        System.out.println("----- Proveedores -----");
        for(int i=0;i<arrProveedores.length;i++){
            System.out.println(arrProveedores[i].getId() + ".- " + arrProveedores[i].getNombre());
        }
        System.out.println("----------------------------");
    }

    private Proveedor leerProveedor(Scanner entrada){
        int intId;
        System.out.println("Id de Proveedor: ");
        try {
            intId = Integer.parseInt(entrada.next());
            for(int i=0;i<arrProveedores.length;i++){
                if (arrProveedores[i].getId()==intId){
                    return arrProveedores[i];
                }
            }
            //si no encontr'o el id del proveedor, el usuario introdujo un id incorrecto
            System.out.println("Error: Id incorrecto.");
            return leerProveedor(entrada);
        }catch (Exception exception) {
            System.out.println("Error: Id incorrecto.");
            return leerProveedor(entrada);
        }
    }

    private void consultarProveedor(Scanner entrada){
        Proveedor proveedor = leerProveedor(entrada);
        proveedor.imprimir();
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
                listarProveedores();
                break;
            case '2':
                consultarProveedor(entrada);
                break;
            // si el usuario se equivoca
            default:
                System.out.println(" Error: Opci'on no reconocida.");
                break;
        }
        return leerOpcion(entrada);
    }

    public Ejercicio5(){
        Proveedor proveedor;
        proveedor = new Proveedor(1,"Bimbo");
        proveedor.anadirProducto(0, "Gansito", 10, 20);
        proveedor.anadirProducto(1, "Ping:uinos", 12, 10);
        proveedor.anadirProducto(2, "Plat'ivolos", 15, 8);
        proveedor.anadirProducto(3, "Submarino", 14, 4);
        proveedor.anadirProducto(4, "Polvorones", 13, 6);
        proveedor.anadirProducto(5, "Nito", 9, 5);
        proveedor.anadirProducto(6, "Donas", 18, 4);
        proveedor.anadirProducto(7, "Colchones", 22, 2);
        proveedor.anadirProducto(8, "Conchas", 26, 4);
        proveedor.anadirProducto(9, "Roles Glaseados", 30, 4);
        arrProveedores[0]=proveedor;

        proveedor = new Proveedor(2,"Sabritas");
        proveedor.anadirProducto(0, "Papas", 15, 9);
        proveedor.anadirProducto(1, "Papas Adobadas", 16, 11);
        proveedor.anadirProducto(2, "Papas con Lim'on", 16, 4);
        proveedor.anadirProducto(3, "Fritos Salados", 12, 6);
        proveedor.anadirProducto(4, "Fritos Chipotle", 13, 8);
        proveedor.anadirProducto(5, "Chetos", 13, 3);
        proveedor.anadirProducto(6, "Chetos Bolita", 13, 2);
        proveedor.anadirProducto(7, "Doritos", 12, 8);
        proveedor.anadirProducto(8, "Churrumais", 11, 10);
        proveedor.anadirProducto(9, "Sabritones", 11, 10);
        arrProveedores[1]=proveedor;

        proveedor = new Proveedor(3,"Coca Cola");
        proveedor.anadirProducto(0, "Coca Cola 125ml", 12, 30);
        proveedor.anadirProducto(1, "Coca Cola 255ml", 16, 30);
        proveedor.anadirProducto(2, "Coca Cola medio litro", 18, 20);
        proveedor.anadirProducto(3, "Coca Cola un litro", 25, 25);
        proveedor.anadirProducto(4, "Coca Cola Lata", 18, 40);
        proveedor.anadirProducto(5, "Fanta 125ml", 12, 20);
        proveedor.anadirProducto(6, "Fanta Lata", 18, 20);
        proveedor.anadirProducto(7, "Fresca 125ml", 12, 15);
        proveedor.anadirProducto(8, "Fresca Lata", 18, 15);
        proveedor.anadirProducto(9, "Leche Santa Clara 1 litro", 22, 50);
        arrProveedores[2]=proveedor;

    }

    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        Ejercicio5 ejercicio5 = new Ejercicio5();
        char opcion = ' ';
        while (opcion!='s')
            opcion = ejercicio5.leerOpcion(entrada);
    } 
}