////Ejercicio 2. Cálculo de la parte entera del logaritmo mediante programación
////             funcional
////    Dado un número entero positivo 𝑛 y una base entera 𝑏 > 1, calcular la parte entera del
////    logaritmo en base b de n, es decir:
////            ⌊log𝑏(𝑛)⌋
////    Por ejemplo:
////            • logEntero(8, 2) = 3
////            • logEntero(15, 2) = 3
////            • logEntero(9, 3) = 2
////    Se pide:
////          1. Elaborar tests utilizando TDD que cubran:
////                  - valores exactos (potencias de la base)
////                  - valores no exactos
////                  - casos límite (por ejemplo, 𝑛 = 1)
////                  - entradas no válidas.
////          2. Implementar el método utilizando programación funcional con streams de Java
////             y expresiones lambda, evitando el uso de bucles explícitos.
////          3. Justificar la estrategia utilizada para modelar el problema con streams (por
////             ejemplo, generación de una secuencia de potencias o de divisiones sucesivas).
////          4. Analizar la complejidad asintótica temporal del algoritmo.
////          5. Comparar esta solución con la versión recursiva del ejercicio anterior en términos
////             de:
////                  - claridad del código;
////                  - eficiencia;
////                  - uso de memoria.
////
////    Prototipo del método:
////    public static int logEntero(int n, int base)


import java.util.stream.Stream;

public class ej2 {
    public static int logEntero(int n, int base){

        return (int) Stream.iterate(1, x * base)
                .takeWhile(x -> x <= n)
                .count() - 1;
    }

}
