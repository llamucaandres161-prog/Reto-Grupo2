package modelo;

/**
 * Representa a un estudiante con su matrícula, cédula, nombre y nota.
 * Es una clase del paquete modelo: solo guarda datos, no tiene lógica de negocio.
 */
public class Estudiante {

    // Atributos privados (encapsulamiento): solo se acceden mediante los getters
    private int matricula;   // número de matrícula del estudiante
    private String cedula;   // cédula de identidad
    private String nombre;   // nombre completo
    private double nota;     // calificación obtenida

    /**
     * Constructor: crea un estudiante con todos sus datos.
     */
    public Estudiante(int matricula, String cedula, String nombre, double nota) {
        this.matricula = matricula;
        this.cedula = cedula;
        this.nombre = nombre;
        this.nota = nota;
    }

    // Getters: permiten consultar los datos sin poder modificarlos desde fuera
    public int getMatricula() { return matricula; }
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public double getNota() { return nota; }

    /**
     * Devuelve el estudiante como texto con el formato "matrícula - nombre".
     * Se usa, por ejemplo, al imprimirlo con System.out.println(estudiante).
     */
    @Override
    public String toString() {
        return matricula + " - " + nombre;
    }
}