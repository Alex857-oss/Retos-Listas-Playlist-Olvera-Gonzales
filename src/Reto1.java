/**
 * Reto 1 (Versión B) - Lista simple: Cola de canciones.
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
     * Inserta una canción al inicio de la lista. Es O(1): no hay que recorrer nada.
     */
    public void insertarInicio(String cancion) {
        Nodo nuevo = new Nodo(cancion);
        // TODO 1: el nuevo apunta a la cabeza actual (así no perdemos el resto de la lista)
        nuevo.siguiente = cabeza;
        // TODO 2: ahora el nuevo es la cabeza
        cabeza = nuevo;
    }

    /**
     * Cuenta cuántas canciones hay recorriendo la lista hasta llegar a null.
     */
    public int contar() {
        int total = 0;
        Nodo actual = cabeza;
        while (actual != null) {      // TODO 3: seguimos mientras exista nodo
            total++;                  // TODO 4: acumulamos...
            actual = actual.siguiente; // ...y avanzamos
        }
        return total;
    }

    /**
     * Invierte la lista SIN crear nodos nuevos: solo se voltean los enlaces.
     */
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo proximo = actual.siguiente; // guarda la referencia antes de romper el enlace
            actual.siguiente = anterior;     // TODO 5: voltea el enlace hacia atrás
            anterior = actual;               // TODO 6: avanza 'anterior'
            actual = proximo;                // TODO 7: avanza 'actual'
        }
        // TODO 8: al terminar, 'anterior' quedó en el último nodo original = nueva cabeza
        cabeza = anterior;
    }

    /** Muestra la lista de la cabeza hasta null. */
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

        // Datos propios (cámbienlos por los de su bina)
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

        // Caso borde: un solo nodo
        ListaSimple una = new ListaSimple();
        una.insertarInicio("Solo una");
        una.invertir();
        System.out.println("\nInvertir con un solo nodo:");
        una.mostrar();
    }
}
