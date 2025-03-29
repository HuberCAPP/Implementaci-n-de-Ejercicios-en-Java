/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicios;

import java.util.Arrays;
/**
 *
 * @author huber
 */
public class Ejercicios {
    // Método para resolver la ecuación cuadrática
    public static void solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            System.out.println("El coeficiente 'a' no puede ser 0 en una ecuación cuadrática.");
            return;
        }
        
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Las soluciones reales son: " + root1 + " y " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("La solucion real es: " + root);
        } else {
            System.out.println("No hay soluciones reales.");
        }
    }

    // Método para verificar si un número es palíndromo
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        
        return originalNumber == reversedNumber;
    }
    // Método para verificar si una palabra es palíndromo
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase().replaceAll("\\s+", ""); // Convertir a minúsculas y eliminar espacios
        int length = word.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Método para verificar si un número es vampiro
    public static boolean isVampireNumber(int number) {
        String numStr = String.valueOf(number);
        int numLength = numStr.length();
        
        if (numLength % 2 != 0) return false; // Debe tener un número par de dígitos
        
        int halfLength = numLength / 2;
        
        for (int i = (int) Math.pow(10, halfLength - 1); i < (int) Math.pow(10, halfLength); i++) {
            for (int j = i; j < (int) Math.pow(10, halfLength); j++) {
                if (i * j == number) {
                    String productStr = String.valueOf(i) + String.valueOf(j);
                    char[] sortedProduct = productStr.toCharArray();
                    char[] sortedNumber = numStr.toCharArray();
                    Arrays.sort(sortedProduct);
                    Arrays.sort(sortedNumber);
                    
                    if (Arrays.equals(sortedProduct, sortedNumber)) {
                        System.out.println(number + " es un numero vampiro con colmillos " + i + " y " + j);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // Método para encontrar el primer número vampiro en un rango
    public static void findFirstVampireNumber(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isVampireNumber(i)) {
                return;
            }
        }
        System.out.println("No se encontraron numeros vampiro en el rango.");
    }

    public static void main(String[] args) {
        // Prueba del método de la ecuación cuadrática
        solveQuadratic(1, -3, 2); // Debería imprimir 2 y 1
        solveQuadratic(1, 2, 1); // Debería imprimir -1
        solveQuadratic(1, 1, 1); // No tiene soluciones reales

       // Prueba del método de palíndromo numérico
        int num1 = 111;
        int num2 = 123;
        System.out.println(num1 + " es palindromo? " + isPalindrome(num1));
        System.out.println(num2 + " es palindromo? " + isPalindrome(num2));
        
        
         // Prueba del método de palíndromo de palabra
        String word1 = "reconocer";  //se utiliza para almacenar 
        String word2 = "hola";
        System.out.println(word1 + " es palindromo? " + isPalindrome(word1));
        System.out.println(word2 + " es palindromo? " + isPalindrome(word2));
        
         // Prueba del método de número vampiro
        findFirstVampireNumber(1000, 2000);
    }
}
