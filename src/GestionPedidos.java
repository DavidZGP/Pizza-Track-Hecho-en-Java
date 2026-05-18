import java.util.Scanner;

public class GestionPedidos {

    private PilaPizza pilaPrincipal;
    private PilaPizza pilaSecundaria;

    public GestionPedidos() {

        pilaPrincipal = new PilaPizza();  
        pilaSecundaria = new PilaPizza();
    }
    public void registrarPizza(Pizza pizza) {

        pilaPrincipal.push(pizza);

        pilaSecundaria.clear();

        System.out.println("Pizza registrada correctamente.");
    }

    public void deshacer() {

        if (pilaPrincipal.isEmpty()) {  
            //Verifica si hay pedidos para deshacer
            System.out.println("No hay pedidos para deshacer.");
            return;
        }

        Pizza pizza = pilaPrincipal.pop();  //Elimina el pedido actual de la pila principal

        pilaSecundaria.push(pizza);

        System.out.println("Pedido deshecho:");
        System.out.println(pizza);
    }

     public void rehacer() {

        if (pilaSecundaria.isEmpty()) {

            System.out.println("No hay pedidos para rehacer.");
            return;
        }

        Pizza pizza = pilaSecundaria.pop(); // Elimina el pedido de la pila secundaria para rehacerlo

        pilaPrincipal.push(pizza);  // Vuelve a agregar el pedido a la pila principal

        System.out.println("Pedido rehecho:");
        System.out.println(pizza);
    }

    public void mostrarPedidoActual() {

        if (pilaPrincipal.isEmpty()) {

            System.out.println("No hay pedidos activos.");
            return;
        }

        System.out.println("Pedido actual:");
        System.out.println(pilaPrincipal.peek());  // Muestra el pedido actual sin eliminarlo de la pila
    }

     public static void main(String[] args) {  

        Scanner sc = new Scanner(System.in);     // Crea un objeto Scanner para leer la entrada del usuario

        GestionPedidos sistema = new GestionPedidos();

        int opcion;

        do {

            System.out.println("\n===== PIZZA TRACK =====");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:

                    System.out.print("Nombre de la pizza: ");
                    String nombre = sc.nextLine();

                    String[] ingredientes = new String[3];

                    for (int i = 0; i < 3; i++) {  // Solicita al usuario que ingrese los ingredientes de la pizza

                        System.out.print("Ingrediente " + (i + 1) + ": ");  // Lee cada ingrediente y lo almacena en el arreglo de ingredientes
                        ingredientes[i] = sc.nextLine();
                    }

                    Pizza pizza = new Pizza(nombre, ingredientes);

                    sistema.registrarPizza(pizza);

                    break;

                case 2:

                    sistema.deshacer();

                    break;

                case 3:

                    sistema.rehacer();

                    break;

                case 4:

                    sistema.mostrarPedidoActual();

                    break;

                case 0:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static int leerEntero(Scanner sc) {  // Método auxiliar para leer un número entero y manejar entradas no válidas

        while (!sc.hasNextInt()) {

            System.out.print("Ingrese un numero valido: ");
            sc.next();
        }

        int numero = sc.nextInt();
        sc.nextLine();

        return numero;
    }
}
