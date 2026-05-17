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

            System.out.println("No hay pedidos para deshacer.");
            return;
        }

        Pizza pizza = pilaPrincipal.pop();

        pilaSecundaria.push(pizza);

        System.out.println("Pedido deshecho:");
        System.out.println(pizza);
    }
