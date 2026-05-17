public class Pizza {

    private String nombre;
    private String[] ingredientes;

    public Pizza(String nombre, String[] ingredientes) {
         this.nombre = nombre;

        this.ingredientes = new String[3];

        for (int i = 0; i < 3; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

     @Override
    public String toString() {

        String texto = "Pizza: " + nombre + "\n";
        texto += "Ingredientes: ";

        for (int i = 0; i < ingredientes.length; i++) {

            texto += ingredientes[i];

            if (i < ingredientes.length - 1) {
                texto += ", ";
            }
        }

        return texto;
    }
}