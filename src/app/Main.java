package app;

import modelo.NodoEstudiante;
import negocio.RetoRecorridos;

public class Main {

    static void ejecutar(String titulo, int[] matriculas) {
        System.out.println("=== " + titulo + " ===");
        NodoEstudiante raiz = RetoRecorridos.construir(matriculas);
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder pos = new StringBuilder();
        System.out.println("-- traza PREORDEN");
        RetoRecorridos.preorden(raiz, "", pre);
        System.out.println("-- traza INORDEN");
        RetoRecorridos.inorden(raiz, "", in);
        System.out.println("-- traza POSORDEN");
        RetoRecorridos.posorden(raiz, "", pos);
        System.out.println("Preorden: " + pre.toString().trim());
        System.out.println("Inorden: " + in.toString().trim());
        System.out.println("Posorden: " + pos.toString().trim());
        System.out.println("Altura (extra): " + RetoRecorridos.altura(raiz));
        System.out.println();
    }

    public static void main(String[] args) {
        ejecutar("Reto SW-N3-A", new int[]{45, 25, 70, 10, 30, 60, 90, 27, 65});
        ejecutar("Caso limite: arbol vacio", new int[]{});
        ejecutar("Caso limite: un solo nodo", new int[]{50});
        ejecutar("Caso limite: cadena", new int[]{10, 20, 30, 40});
        ejecutar("Caso limite: repetido (30 dos veces)", new int[]{20, 30, 30, 10});
    }
}
