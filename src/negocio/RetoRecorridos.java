package negocio;

import modelo.Estudiante;
import modelo.NodoEstudiante;

public class RetoRecorridos {

    // Inserta una matricula en el ABB (ignora repetidos).
    public static NodoEstudiante insertar(NodoEstudiante nodo, int matricula) {
        if (nodo == null) { // caso base: lugar libre
            return new NodoEstudiante(new Estudiante(matricula,
                    String.format("18%08d", matricula),
                    "Estudiante " + matricula, 8));
        }
        int actual = nodo.getDato().getMatricula();
        if (matricula < actual) { // caso recursivo: izquierda
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), matricula));
        } else if (matricula > actual) { // caso recursivo: derecha
            nodo.setDerecho(insertar(nodo.getDerecho(), matricula));
        }
        return nodo;
    }

    // PREORDEN = visita el nodo, luego izquierda, luego derecha
    public static void preorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + m);
        System.out.println(sangria + "VISITA " + m);
        salida.append(m).append(' ');
        preorden(nodo.getIzquierdo(), sangria + "  ", salida);
        preorden(nodo.getDerecho(), sangria + "  ", salida);
    }

    // INORDEN = izquierda, luego visita el nodo, luego derecha
    public static void inorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + m);
        inorden(nodo.getIzquierdo(), sangria + "  ", salida);
        System.out.println(sangria + "VISITA " + m);
        salida.append(m).append(' ');
        inorden(nodo.getDerecho(), sangria + "  ", salida);
    }

    // POSORDEN = izquierda, luego derecha, luego visita el nodo
    public static void posorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + m);
        posorden(nodo.getIzquierdo(), sangria + "  ", salida);
        posorden(nodo.getDerecho(), sangria + "  ", salida);
        System.out.println(sangria + "VISITA " + m);
        salida.append(m).append(' ');
    }

    // EXTRA: altura en aristas (hoja = 0, arbol vacio = -1)
    public static int altura(NodoEstudiante nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

    public static NodoEstudiante construir(int[] matriculas) {
        NodoEstudiante raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }
        return raiz;
    }
}
