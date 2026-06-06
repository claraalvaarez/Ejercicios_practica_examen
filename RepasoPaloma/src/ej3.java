//////Ejercicio 3. Tokenización de una cadena (recursiva)
//////      Dada una cadena de texto y un carácter o subcadena separadora, obtener
//////      una lista con los tokens resultantes de dividir la cadena utilizando dicho
//////      separador.
//////      Por ejemplo:
//////        • tokenizar("uno,dos,tres", ",") = ["uno", "dos", "tres"]
//////        • tokenizar("a--b--c", "--") = ["a", "b", "c"]
//////      Se pide:
//////        1. Elaborar tests utilizando TDD que cubran:
//////              - cadena vacía;
//////              - cadena sin separador;
//////              - cadena con múltiples separadores;
//////              - separadores consecutivos;
//////              - separador al inicio o al final de la cadena.
//////        2. Implementar el método utilizando recursividad, descomponiendo el
//////           problema a partir de la primera aparición del separador.
//////        3. Para localizar el separador, utilizar exclusivamente un método que
//////           permita obtener la posición de la primera aparición de un carácter o
//////           subcadena dentro de otra cadena.
//////        4. Diseñar la solución de forma que no se utilicen métodos de alto nivel
//////           como split.
//////        5. Calcular la complejidad asintótica temporal del algoritmo.
//////    Prototipo del método:
//////        public static List<String> tokenizar(String texto, String separador)
////
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ej3 {
    public static List<String> tokenizar(String texto, String separador){

    }
    // Tests
    @Test
    public void cadenaVaciaTest(){
        assertEquals(" ", tokenizar(" ",","));
    }
    public void cadenaSinSeparadorTest(){
        assertEquals("a" ,"b", tokenizar("a,b",","));
    }
    public void cadenaMultiplesSeparadoresTest(){
        assertEquals(" ", tokenizar("a,b,c",","));
    }

}
