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

    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }

        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void clear() {
        tope = null;
    }
}
