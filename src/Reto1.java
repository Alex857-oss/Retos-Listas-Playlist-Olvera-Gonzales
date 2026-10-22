/**
 * Reto1 Versión B - Lista simple: Cola de canciones.
 * Se completan insertarInicio, contar e invertir.
 */
class Nodo {
    String cancion;
    Nodo siguiente;

    Nodo(String cancion) { this.cancion = cancion; }
}

class ListaSimple {
    private Nodo cabeza;

    /**
     * Inserta una canción al inicio de la lista.
     */
    public void insertarInicio(String cancion) {
        Nodo nuevo = new Nodo(cancion);
        // TODO 1: el nuevo apunta a la cabeza actual
        nuevo.siguiente = cabeza;
        // TODO 2: ahora el nuevo es la cabeza
        cabeza = nuevo;
    }

    /**
     * Cuenta cuantas canciones hay en la lista hasta llegar a null.
     */
    public int contar() {
        int total = 0;
        Nodo actual = cabeza;
        while (actual != null) {      // seguimos mientras exista nodo
            total++;                  // acumulamos y avanzamos
            actual = actual.siguiente;
        }
        return total;
    }

    /**
     * Invierte la lista sin crear nodos nuevos.
     */
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo proximo = actual.siguiente; // guarda la referencia antes de romper el enlace
            actual.siguiente = anterior;     // voltea el enlace hacia atras
            anterior = actual;               // avanza anterior
            actual = proximo;                // avanza actual
        }
        // TODO 8: al terminar, anterior quedo en el ultimo nodo original igual nueva cabeza
        cabeza = anterior;
    }

    /** Esta muestra la lista de la cabeza hasta null. */
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.cancion + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class Reto1 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        System.out.println("Lista vacia, total = " + lista.contar());
        lista.mostrar();

        lista.insertarInicio("Bohemian Rhapsody");
        lista.insertarInicio("Hotel California");
        lista.insertarInicio("Smells Like Teen Spirit");
        lista.insertarInicio("Imagine");
        lista.insertarInicio("Stairway to Heaven");

        System.out.println("\nDespues de insertar 5 canciones al inicio:");
        lista.mostrar();
        System.out.println("Total de canciones: " + lista.contar());

        lista.invertir();
        System.out.println("\nLista invertida:");
        lista.mostrar();

        ListaSimple una = new ListaSimple();
        una.insertarInicio("Solo una");
        una.invertir();
        System.out.println("\nInvertir con un solo nodo:");
        una.mostrar();
    }
}
