package modelo;

public class Estudiante {

    private int matricula;
    private String cedula;
    private String nombre;
    private double nota;

    public Estudiante(int matricula, String cedula, String nombre, double nota) {
        this.matricula = matricula;
        this.cedula = cedula;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getMatricula() { return matricula; }
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public double getNota() { return nota; }

    @Override
    public String toString() {
        return matricula + " - " + nombre;
    }
}
