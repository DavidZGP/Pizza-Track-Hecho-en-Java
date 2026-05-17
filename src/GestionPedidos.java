import java.util.Scanner;

public class GestionPedidos {

    private PilaPizza pilaPrincipal;
    private PilaPizza pilaSecundaria;

    public GestionPedidos() {

        pilaPrincipal = new PilaPizza();
        pilaSecundaria = new PilaPizza();
    }