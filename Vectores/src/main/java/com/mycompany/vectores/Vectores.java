/*


 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 */
 /**
      * 📜 Descripción: Dado un vector de números enteros, encuentre la suma más pequeña y la suma más grande posibles al sumar (N-1) elementos del vector.
         🔹 Instrucciones:
         Leer un vector de N números enteros.
         Calcular la suma mínima excluyendo el número más grande.
         Calcular la suma máxima excluyendo el número más pequeño.
         Imprimir ambas sumas.
         * Ejemplo de entrada: [1, 3, 5, 7, 9]
         * Ejemplo de salida: 
           Suma mínima: 16  
           Suma máxima: 24  
      */
     
     /**
      * Reordenamiento de Números Pares e Impares
         📜 Descripción: Reordene un vector de enteros colocando primero los pares y luego los impares, manteniendo el orden relativo de aparición en cada grupo.
         🔹 Instrucciones:
         Leer un vector de N números enteros.
         Crear un nuevo vector donde los pares aparezcan primero y los impares después.
         No utilizar estructuras adicionales como listas o colecciones.
         * Ejemplo de entrada: [3, 1, 2, 4, 5, 6]
         * Ejemplo de salida: [2, 4, 6, 3, 1, 5]
      */
     
     /**
      * Encuentra los Dos Números que Suman un Valor
         📜 Descripción: Dado un vector de enteros y un número objetivo, encuentre dos elementos del vector cuya suma sea igual al número objetivo.
         🔹 Instrucciones:
         Leer un vector de N enteros y un número X.
         Identificar dos números dentro del vector cuya suma sea X.
         Imprimir ambos números o indicar si no existen.
         * Ejemplo de entrada:
         *  Vector: [2, 7, 11, 15]  
             X = 9
         * Ejemplo de salida: Par encontrado: (2, 7)
      */
     
     /**
      * Rotación Circular de un Vector
         📜 Descripción: Desplace circularmente los elementos de un vector k posiciones hacia la derecha.
         🔹 Instrucciones:
         Leer un vector de N enteros y un número k.
         Rotar el vector k posiciones hacia la derecha.
         * Ejemplo de entrada:
         Vector: [1, 2, 3, 4, 5]  
         k = 2
         * Ejemplo de salida: [4, 5, 1, 2, 3]
      */
     
     /**
      * Subsecuencia Más Larga de Números Consecutivos
         📜 Descripción: Encuentre la subsecuencia más larga de números consecutivos en un vector desordenado.
         🔹 Instrucciones:
         Leer un vector de N números enteros.
         Determinar la longitud de la mayor subsecuencia de números consecutivos (no necesariamente contiguos en el vector).
         * Ejemplo de entrada: [100, 4, 200, 1, 3, 2]
         * Ejemplo de salida: Mayor subsecuencia consecutiva: 4 (1, 2, 3, 4)
      */

package com.mycompany.vectores;

import java.util.HashSet; // para evitar duplicados

/**
 * Clase con ejemplos y operaciones sobre vectores
 */
public class Vectores {

    // Ejemplo de creación e impresión de vectores
    public void exampleArray() {
        int[] numeros = new int[5];
        numeros[0] = 5;
        numeros[1] = 1;
        numeros[2] = 2;
        numeros[3] = 3;
        numeros[4] = 4;

        System.out.print("Vector de enteros: ");
        for(int num: numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] palabras = { "Huber", "Aroldo", "Cap", "Perez" };
        System.out.print("Vector de palabras: ");
        for(String palabra: palabras) {
            System.out.print(palabra + " ");
        }
        System.out.println();
    }

    // Ejemplo de matriz bidimensional
    public void matrizExample() {
        int[][] matriz = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println("Matriz 3x3:");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 1. Calcular suma mínima y máxima de N-1 elementos
    public void sumaMinMax(int[] vector) {
        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : vector) {
            total += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int sumaMinima = total - max;
        int sumaMaxima = total - min;

        System.out.println("Suma minima: " + sumaMinima);
        System.out.println("Suma maxima: " + sumaMaxima);
    }

    // 2. Reordenar vector con pares primero, luego impares
    public void reordenarParesImpares(int[] vector) {
        int[] resultado = new int[vector.length];
        int index = 0;

        for (int num : vector) {
            if (num % 2 == 0) {
                resultado[index++] = num;
            }
        }

        for (int num : vector) {
            if (num % 2 != 0) {
                resultado[index++] = num;
            }
        }

        System.out.print("Vector reordenado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 3. Encontrar dos números que sumen un valor dado
    public void encontrarDosNumerosQueSumanX(int[] vector, int x) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] + vector[j] == x) {
                    System.out.println("Par encontrado: (" + vector[i] + ", " + vector[j] + ")");
                    return;
                }
            }
        }
        System.out.println("No existe un par que sume " + x);
    }

    // 4. Rotar el vector k posiciones a la derecha
    public void rotarVectorDerecha(int[] vector, int k) {
        int n = vector.length;
        k = k % n;
        int[] resultado = new int[n];

        for (int i = 0; i < n; i++) {
            resultado[(i + k) % n] = vector[i];
        }

        System.out.print("Vector rotado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 5. Encontrar la subsecuencia más larga de números consecutivos
    public void subsecuenciaConsecutiva(int[] vector) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : vector) {
            set.add(num);
        }

        int maxLongitud = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int actual = num;
                int longitud = 1;

                while (set.contains(actual + 1)) {
                    actual++;
                    longitud++;
                }

                maxLongitud = Math.max(maxLongitud, longitud);
            }
        }

        System.out.println("Mayor subsecuencia consecutiva: " + maxLongitud);
    }

    // Metodo principal para pruebas
    public static void main(String[] args) {
        Vectores v = new Vectores();

        System.out.println("--- Example Array ---");
        v.exampleArray();

        System.out.println("\n--- Matriz Example ---");
        v.matrizExample();

        System.out.println("\n--- Suma Min/Max ---");
        int[] vector1 = {1, 3, 5, 7, 9};
        v.sumaMinMax(vector1);

        System.out.println("\n--- Reordenar Pares e Impares ---");
        int[] vector2 = {3, 1, 2, 4, 5, 6};
        v.reordenarParesImpares(vector2);

        System.out.println("\n--- Encontrar Par que Suma X ---");
        int[] vector3 = {2, 7, 11, 15};
        v.encontrarDosNumerosQueSumanX(vector3, 9);

        System.out.println("\n--- Rotar Vector ---");
        int[] vector4 = {1, 2, 3, 4, 5};
        v.rotarVectorDerecha(vector4, 2);

        System.out.println("\n--- Subsecuencia Consecutiva ---");
        int[] vector5 = {100, 4, 200, 1, 3, 2};
        v.subsecuenciaConsecutiva(vector5);
    }
}
