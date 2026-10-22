/**
 * Reto 3VersiónB - Lista circular: Reproducción en bucle.
 */
class NodoCircular {
    String cancion;
    NodoCircular siguiente;

    NodoCircular(String cancion) { this.cancion = cancion; }
}

class ListaCircular {
    private NodoCircular actual; // cancion en reproduccion
    private NodoCircular cola;

    /**
     * Inserta una canción al final del círculo (entre la cola y la cabeza).
     */
    public void insertar(String cancion) {
        NodoCircular nuevo = new NodoCircular(cancion);
        if (cola == null) {
            // TODO 1: un solo nodo apunta a sí mismo
            nuevo.siguiente = nuevo;
            actual = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cola.siguiente; // el nuevo apunta a la cabeza (cola.siguiente)
            cola.siguiente = nuevo;           // y la cola apunta al nuevo
            cola = nuevo;                     // el nuevo es la cola
        }
    }

    /**
     * Avanza n canciones. No hace falta comprobar null
     * en una lista circular nunca se llega a un final.
     */
    public void rotar(int n) {
        for (int i = 0; i < n; i++) {
            if (actual != null) {          //solo protege el caso de lista vacía
                actual = actual.siguiente;
            }
        }
    }

    /**
     * Elimina la cancion en reproduccion y pasa a la siguiente
     */
    public void eliminarActual() {
        if (cola == null) return;
        if (actual == actual.siguiente) {
            //era el único nodo, la lista queda vacía
            actual = null;
            cola = null;
            return;
        }
        //busca el nodo anterior a actual recorriendo el circulo
        NodoCircular anterior = actual;
        while (anterior.siguiente != actual) {
            anterior = anterior.siguiente;
        }
        //salta actual corrige la cola si hacia falta y avanza
        anterior.siguiente = actual.siguiente;
        if (actual == cola) {
            cola = anterior;
        }
        actual = actual.siguiente;
    }

    /** Muestra una vuelta completa empezando en la canción en reproduccion */
    public void mostrarUnaVuelta() {
        if (actual == null) {
            System.out.println("(lista vacia)");
            return;
        }
        NodoCircular aux = actual;
        do {
            System.out.print(aux.cancion + " -> ");
            aux = aux.siguiente;
        } while (aux != actual);
        System.out.println("(vuelve a " + actual.cancion + ")");
    }
}

public class Reto3 {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.insertar("Livin' on a Prayer");
        lista.insertar("Dancing Queen");
        lista.insertar("Take On Me");
        lista.insertar("Mr. Brightside");

        System.out.println("Playlist inicial:");
        lista.mostrarUnaVuelta();

        lista.rotar(2);
        System.out.println("\nDespues de rotar 2:");
        lista.mostrarUnaVuelta();

        lista.eliminarActual();
        System.out.println("\nEliminar la que suena (intermedia):");
        lista.mostrarUnaVuelta();

        // Tras eliminar actual avanzo y ahora es justo la cola
        lista.eliminarActual();
        System.out.println("\nEliminar la cola:");
        lista.mostrarUnaVuelta();

        lista.eliminarActual();
        System.out.println("\nEliminar hasta quedar con un nodo:");
        lista.mostrarUnaVuelta();

        lista.eliminarActual();
        System.out.println("\nEliminar el unico nodo:");
        lista.mostrarUnaVuelta();
    }
}
