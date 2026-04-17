public class ListaDobleCircular {
    Nodo head = null;

    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            head = nuevo;
        } else {
            Nodo ultimo = head.anterior;
            nuevo.siguiente = head;
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            head.anterior = nuevo;
            head = nuevo;
        }
    }

    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            head = nuevo;
        } else {
            Nodo ultimo = head.anterior;
            nuevo.siguiente = head;
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            head.anterior = nuevo;
        }
    }

    public void eliminarInicio() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }
        if (head.siguiente == head) {
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            head = head.siguiente;
            head.anterior = ultimo;
            ultimo.siguiente = head;
        }
    }

    public void eliminarFinal() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }
        if (head.siguiente == head) {
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            Nodo penultimo = ultimo.anterior;
            penultimo.siguiente = head;
            head.anterior = penultimo;
        }
    }

    public boolean buscar(int valor) {
        if (head == null) return false;
        Nodo actual = head;
        do {
            if (actual.dato == valor) return true;
            actual = actual.siguiente;
        } while (actual != head);
        return false;
    }

    public void imprimir() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo actual = head;
        System.out.print("Lista: ");
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != head);
        System.out.println("(circular -> " + head.dato + ")");
    }
}