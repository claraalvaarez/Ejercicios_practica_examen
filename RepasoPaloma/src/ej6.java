//Ejercicio 6. Integración numérica de una función real en un intervalo
//             mediante el método de los rectángulos.

//        Por ejemplo, integrarRectangulos(x -> x * x; 0.0; 3.0; 3) =
//        1.0 * f(0.0) + 1.0 * f(1.0) + 1.0 * f(2.0) =
//        1.0 * 0.0 + 1.0 * 1.0 + 1.0 * 4.0 = 5.0
//        donde la anchura de cada rectángulo es (3.0 - 0.0) / 3 = 1.0

//  Prototipo del método:
//  public static double integrarRectangulos (java.util.function.DoubleUnaryOperator f, double a, double b, int n)

//  Nota: Se utiliza el tipo java.util.function.DoubleUnaryOperator para
//  representar la función a integrar.  Esta interfaz funcional modela una función
//  real de variable real (double → double) y opera directamente con tipos
//  primitivos.  Se ha elegido este tipo en lugar de alternativas genéricas como
//  Function<Double, Double> o UnaryOperator<Double> porque evita
//  conversiones automáticas entre double y Double (boxing y unboxing), lo que
//  mejora la eficiencia y reduce la creación innecesaria de objetos. Por tanto,
//  DoubleUnaryOperator es la opción más adecuada y habitual en Java para
//  cálculos numéricos sobre números reales.

//  Se pide:
//        1. Escribir una implementación recursiva del método.
//        2. Escribir una implementación con streams y expresiones
//           lambda.
//        3. Calcular la complejidad asintótica temporal del algoritmo.


public class ej6 {
}
