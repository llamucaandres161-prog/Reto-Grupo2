# Reto: recorridos recursivos de un árbol binario de búsqueda

**Universidad Técnica de Ambato - FISEI - Carrera de Software**
**Asignatura:** Estructura de Datos | **Paralelo:** SW-N3-A

## Descripción

Se insertan, uno por uno, las matrículas `45, 25, 70, 10, 30, 60, 90, 27, 65` en un árbol binario de búsqueda (ABB). Luego se implementan, **solo con recursión**, los recorridos preorden, inorden y posorden. Cada uno imprime una traza con sangría (2 espacios por nivel) que muestra la pila de llamadas.

Restricciones:
- Sin bucles ni ordenar listas para recorrer el árbol.
- Caso base: `nodo == null`.
- Una llamada recursiva por cada hijo.

## Estructura del proyecto

```
RetoRecorridos/
├── src/
│   ├── modelo/
│   │   ├── Estudiante.java         # datos del estudiante
│   │   └── NodoEstudiante.java     # nodo del árbol
│   ├── negocio/
│   │   └── RetoRecorridos.java     # insertar, preorden, inorden, posorden, altura
│   └── app/
│       └── Main.java               # ejecuta los casos de prueba
├── capturas/
│   └── arbolResultado.png          # árbol dibujado a mano (resultado del reto)
└── README.md
```

## 1. Árbol dibujado

![Árbol binario de búsqueda resultante](capturas/arbolResultado.png)

## 2. Predicciones

Las predicciones coinciden con lo que imprime el programa.

| Recorrido | Orden | Resultado |
|-----------|-------|-----------|
| Preorden  | nodo, izquierda, derecha | `45 25 10 30 27 70 60 65 90` |
| Inorden   | izquierda, nodo, derecha | `10 25 27 30 45 60 65 70 90` |
| Posorden  | izquierda, derecha, nodo | `10 27 30 25 65 60 90 70 45` |

El inorden sale ordenado de menor a mayor, como siempre en un ABB.

## 3. Código

Los tres recorridos son recursivos y solo cambia dónde va la línea `VISITA`:

- **Preorden:** va antes de las llamadas a los hijos.
- **Inorden:** va entre la llamada al hijo izquierdo y la del derecho.
- **Posorden:** va después de las dos llamadas.

Están en `src/negocio/RetoRecorridos.java` (métodos `public static`).

### Preorden
```java
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
```

### Inorden
```java
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
```

### Posorden
```java
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
```

## 4. Extra: altura

`altura` devuelve `-1` si el nodo es `null` y `1 + max(izq, der)` en los demás casos. Para el árbol principal da **3**.

```java
public static int altura(NodoEstudiante nodo) {
    if (nodo == null) return -1;          // árbol vacío
    return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
}
```

Una hoja devuelve `1 + max(-1, -1) = 0`, como pide el enunciado.

## 5. Casos límite

- **Árbol vacío:** no imprime nada y la altura es -1.
- **Un solo nodo (50):** todos los recorridos dan `50`.
- **Cadena (10, 20, 30, 40):** preorden e inorden dan `10 20 30 40` y posorden da `40 30 20 10`.
- **Repetido (20, 30, 30, 10):** el segundo 30 se ignora, así que preorden es `20 10 30`.

| Caso | Preorden | Inorden | Posorden | Altura |
|------|----------|---------|----------|--------|
| Reto SW-N3-A | `45 25 10 30 27 70 60 65 90` | `10 25 27 30 45 60 65 70 90` | `10 27 30 25 65 60 90 70 45` | 3 |
| Árbol vacío | (vacío) | (vacío) | (vacío) | -1 |
| Un solo nodo (50) | `50` | `50` | `50` | 0 |
| Cadena (10, 20, 30, 40) | `10 20 30 40` | `10 20 30 40` | `40 30 20 10` | 3 |
| Repetido (20, 30, 30, 10) | `20 10 30` | `10 20 30` | `10 30 20` | 1 |

## Cómo ejecutar

Desde la carpeta `RetoRecorridos/`:

```bash
javac -d out src/modelo/*.java src/negocio/*.java src/app/*.java
java -cp out app.Main
```

O ejecuta `app.Main` desde tu IDE (NetBeans, IntelliJ, Eclipse).

## Ejemplo de traza (inicio del preorden)

```
-- traza PREORDEN
entra 45
VISITA 45
  entra 25
  VISITA 25
    entra 10
    VISITA 10
      null -> regresa
      null -> regresa
    entra 30
    ...
```

## Integrantes

- ______________________________
- ______________________________
