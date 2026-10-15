package modelo;

/**
 * Nodo de un árbol binario que almacena un objeto Estudiante.
 * Cada nodo guarda un dato y las referencias a sus hijos izquierdo y derecho.
 */
public class NodoEstudiante {

    // Información almacenada en el nodo
    private Estudiante dato;

    // Referencias a los hijos; valen null mientras no tengan hijo en esa posición
    private NodoEstudiante izquierdo;
    private NodoEstudiante derecho;

    /**
     * Constructor: crea un nodo con un estudiante.
     * Los hijos quedan en null (el nodo nace sin hijos, es decir, como hoja).
     */
    public NodoEstudiante(Estudiante dato) {
        this.dato = dato;
    }

    // Getter y setter del estudiante almacenado en el nodo
    public Estudiante getDato() { return dato; }
    public void setDato(Estudiante dato) { this.dato = dato; }

    // Getter y setter del hijo izquierdo (permite enlazar o consultar ese subárbol)
    public NodoEstudiante getIzquierdo() { return izquierdo; }
    public void setIzquierdo(NodoEstudiante izquierdo) { this.izquierdo = izquierdo; }

    // Getter y setter del hijo derecho (permite enlazar o consultar ese subárbol)
    public NodoEstudiante getDerecho() { return derecho; }
    public void setDerecho(NodoEstudiante derecho) { this.derecho = derecho; }
}
