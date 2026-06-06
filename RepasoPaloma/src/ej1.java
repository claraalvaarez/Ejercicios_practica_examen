import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ej1 {
    // Ejercicio 1. Cálculo de la parte entera del logaritmo
//    Dado un número entero positivo 𝑛 y una base entera 𝑏 > 1, calcular la parte entera del
//    logaritmo en base b de n, es decir:
//            ⌊log𝑏(𝑛)⌋
//    Por ejemplo:
//            • logEntero(8, 2) = 3
//            • logEntero(15, 2) = 3
//            • logEntero(9, 3) = 2
//    Se pide:
//          1. Elaborar tests para comprobar los siguientes casos:
//                  - valores exactos (potencias de la base)
//                  - valores no exactos
//                  - casos límite (por ejemplo, 𝑛 = 1)
//          2. Implementar el método utilizando recursividad, basándose en la idea de
//             reducción del problema mediante divisiones sucesivas.
//          3. Añadir tests adicionales que permitan validar el comportamiento del método ante
//             entradas no válidas (por ejemplo, base menor o igual que 1, o valores negativos).
//          4. Analizar la complejidad asintótica temporal del algoritmo.
//          5. Explicar brevemente por qué este problema es adecuado para una solución
//             recursiva.
//    Prototipo del método:
//    public static int logEntero(int n, int base)
    public static int logEntero(int n, int base) {
        // Caso base:
        // -> Si b > n : return 0
        // -> Si b <= n : return 1 + logEntero(n/b, b)
        if(n < base){
            return 0;
        } else {
            return 1 + logEntero(n/base, base);
        }
    }
    // Test
    @Test
    public void valorNoExactoTest(){
        assertEquals(3, ej1.logEntero(15,2));
    }
    public void valorEnteroTest(){
        assertEquals(2, ej1.logEntero(8,2));
    }
    public void casoLimiteTest(){
        assertEquals(0, ej1.logEntero(1,9));
    }
    @Test(expected = IllegalArgumentException.class)
    public void nNegativoTest(){
        assertEquals(-8,1);
    }
}
// La complejidad temporal del ejercicio es O(log n)
// Porque el problema se resume en cada paso. Cada division del numero n entre b es un subproblema
// que se va haciendo mas pequeño a medida que avanza. Se finaliza en el caso base.
