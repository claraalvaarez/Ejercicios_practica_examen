//Ejercicio 5. Particionado de una lista
//  Dada una lista de números enteros, dividirla en dos listas:
//        • una con los elementos que cumplen una condición
//        • otra con los que no
//  Por ejemplo:
//      particionar([1,2,3,4,5], x -> x % 2 == 0)= ([2,4], [1,3,5])
//      Se pide:
//        1. Escribir una implementación recursiva del método.
//        2. Escribir una implementación utilizando streams y expresiones
//           lambda.
//        3. Diseñar tests utilizando TDD, incluyendo:
//              o lista vacía
//              o todos cumplen la condición
//              o ninguno cumple
//        4. Analizar la complejidad asintótica temporal del algoritmo.
//        5. Comparar ambas implementaciones en términos de:
//              o legibilidad
//              o eficiencia
//              o uso de memoria
//  Prototipo del método:
//      public static <T> Map<Boolean, List<T>> particionar(List<T> lista, Predicate<T> condicion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ej5 {
    public static <T> Map<Boolean, List<T>> particionar(List<T> lista, Predicate<T> condicion){
        Map<Boolean, List<T>> resultado = new HashMap<>();
        resultado.put(true, new ArrayList<>());
        resultado.put(false, new ArrayList<>());
        particionarAux(lista, condicion, resultado);
        return resultado;

    }
    public static <T> void particionarAux(List<T> lista, Predicate<T> condicion, Map<Boolean, List<T>> resultado){
        if(lista.isEmpty()) return;
        if(condicion.test(lista.get(0))){
            resultado.get(true).add(lista.get(0));
        }else {
            resultado.get(false).add(lista.get(0));
        }
        particionarAux(lista.subList(1, lista.size()), condicion, resultado);

    }
}
