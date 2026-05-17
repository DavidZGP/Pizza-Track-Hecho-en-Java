public class PilaPizza {

    private NodoPizza tope;

    public PilaPizza() {
        tope = null;
    }    
     public void push(Pizza pizza) {

        NodoPizza nuevo = new NodoPizza(pizza);

        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Pizza pop() {

        if (isEmpty()) {
            return null;
        }

        Pizza pizza = tope.dato;

        tope = tope.siguiente;

        return pizza;
    }
