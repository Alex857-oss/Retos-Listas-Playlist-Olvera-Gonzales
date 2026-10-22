/**
 * Reto2 Version B - Lista doble: Reproductor con anterior y siguiente
 */
class NodoDoble {
    String cancion;
    NodoDoble siguiente, anterior;

    NodoDoble(String cancion) { this.cancion = cancion; }
}

class ListaDoble {
    private NodoDoble cabeza, cola;

    /**
     * Esto una cancion al final
     */
    public void insertarFinal(String cancion) {
        NodoDoble nuevo = new NodoDoble(cancion);
        if (cola == null) {
            // 1: lista vacía el nuevo es cabeza y cola a la vez
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;   // la cola actual apunta al nuevo
            nuevo.anterior = cola;    // el nuevo apunta de regreso a la cola
            cola = nuevo;             // el nuevo es la nueva cola
        }
    }

    /**
     * Inserta nueva justo después de existente.
     */
    public boolean insertarDespuesDe(String existente, String nueva) {
        NodoDoble actual = cabeza;
        while (actual != null && !actual.cancion.equals(existente)) {
            actual = actual.siguiente;
        }
        if (actual == null) return false;

        NodoDoble nuevo = new NodoDoble(nueva);
        nuevo.anterior = actual;                 // nuevo mira hacia a actual
        nuevo.siguiente = actual.siguiente;      // nuevo mira hacia adelante al que seguia
        if (actual.siguiente != null) {
            actual.siguiente.anterior = nuevo;
        }
        actual.siguiente = nuevo;                // actual mira hacia adelante al nuevo

        // si 'actual' era la cola, la nueva cola es nuevo
        if (actual == cola) {
            cola = nuevo;
        }
        return true;
    }

    /** Aqui recorre de la cabeza hasta null. */
    public void mostrarAdelante() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.cancion + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    /** Este recorre desde la cola hasta null usando anterior */
    public void mostrarInverso() {
        NodoDoble actual = cola;
        while (actual != null) {
            System.out.print(actual.cancion + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}

public class Reto2 {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        lista.insertarFinal("Yesterday");
        lista.insertarFinal("Billie Jean");
        lista.insertarFinal("Africa");
        lista.insertarFinal("Wonderwall");

        System.out.println("Hacia adelante:");
        lista.mostrarAdelante();
        System.out.println("Hacia atras:");
        lista.mostrarInverso();

        System.out.println("\nInsertar 'Thriller' despues de 'Billie Jean' (intermedio): "
                + lista.insertarDespuesDe("Billie Jean", "Thriller"));
        System.out.println("Insertar 'Creep' despues de 'Wonderwall' (era la cola): "
                + lista.insertarDespuesDe("Wonderwall", "Creep"));
        System.out.println("Insertar despues de 'No existe': "
                + lista.insertarDespuesDe("No existe", "X"));

        System.out.println("\nHacia adelante:");
        lista.mostrarAdelante();
        System.out.println("Hacia atras:");
        lista.mostrarInverso();
    }
}
