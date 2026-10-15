package modelo;

public class NodoEstudiante {

    private Estudiante dato;
    private NodoEstudiante izquierdo;
    private NodoEstudiante derecho;

    public NodoEstudiante(Estudiante dato) {
        this.dato = dato;
    }

    public Estudiante getDato() { return dato; }
    public void setDato(Estudiante dato) { this.dato = dato; }

    public NodoEstudiante getIzquierdo() { return izquierdo; }
    public void setIzquierdo(NodoEstudiante izquierdo) { this.izquierdo = izquierdo; }

    public NodoEstudiante getDerecho() { return derecho; }
    public void setDerecho(NodoEstudiante derecho) { this.derecho = derecho; }
}
