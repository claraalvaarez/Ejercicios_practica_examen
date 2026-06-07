//Ejercicio 10. Frecuencia de elementos
//  Se pide:
//          1. Dada una lista, calcular frecuencia de cada elemento.
//          2. Implementación con:
//              o estructura propia
//              o HashMap
//          3. Ordenar por frecuencia.
//        Extensión:
//          • ¿Qué estructura usarías si necesitas mantener orden?


import java.util.*;

public class ej10 {
    public class FrecuenciaElementos {
        public static <T> Map<T, Integer> frecuencias(List<T> palabras){
            Map<T, Integer> frec = new HashMap<>();
            for(T p : palabras){
//                if(frec.get(p) != null){
//                    frec.put(p, frec.get(p) + 1);
//                } else {
//                    frec.put(p, 1);
//                }
                frec.put(p, frec.getOrDefault(p, 0) + 1);
            }
            return frec;
        }
        public static <T> List<Map.Entry<T, Integer>> ordenarPorFrecuencia(Map<T, Integer> frec){
            List<Map.Entry<T, Integer>> frecOrder = new ArrayList<>(frec.entrySet());
            frecOrder.sort((x, y) -> y.getValue() - x.getValue());
            return frecOrder;
        }
    }

    public class FrecuenciaPropia {
        public static class Par<T> {
            T valor;
            int contador;
            Par (T valor){
                this.valor = valor;
                this.contador = 1;
            }
            @Override
            public String toString() {
                return valor + "=" + contador;
            }

        }
        public static <T> List<Par<T>> frecuencias (List<T> elementos){
            List<Par<T>> frec = new ArrayList<>();
            for(T e : elementos){
                Par<T> encontrado = null;
                for(Par<T> par : frec){
                    if(par.valor.equals(e)){
                        encontrado = par;
                        break;
                    }
                }
                if(encontrado != null){
                    encontrado.contador++;
                } else{
                    frec.add(new Par<T> (e));
                }
            }

            frec.sort((x, y) -> y.contador - x.contador);
            return frec;
        }


    }


    public static void main(String[] args){
        List<String> palabras = new ArrayList<>();
        palabras.add("a");
        palabras.add("b");
        palabras.add("c");
        palabras.add("c");
        palabras.add("a");
        palabras.add("a");
        // Map<String, Integer> letras  = FrecuenciaPropia.frecuencias(palabras);
        System.out.println(FrecuenciaPropia.frecuencias(palabras));

//        List<Character> letras2 = List.of('p', 'a', 'p', 'a');
//        System.out.println(FrecuenciaElementos.frecuencias(letras2));
//        List<Integer> dados = List.of(6, 1, 6, 6, 2, 1);
//        System.out.println(FrecuenciaElementos.frecuencias(dados));
//        System.out.println(FrecuenciaElementos.ordenarPorFrecuencia(FrecuenciaElementos.frecuencias(dados)));
        Map<String, Integer> h = new HashMap<>();
        Map<String, Integer> l = new LinkedHashMap<>();
        Map<String, Integer> t = new TreeMap<>();
        for (Map<String, Integer> m : List.of(h, l, t)) {
            m.put("lunes", 1); m.put("martes", 2); m.put("viernes", 3); m.put("sabado", 4);
        }
        System.out.println(h);  // {martes=2, sabado=4, lunes=1, viernes=3} ← revuelto: manda el hash
        System.out.println(l);  // {lunes=1, martes=2, viernes=3, sabado=4} ← orden de INSERCIÓN
        System.out.println(t);  // {lunes=1, martes=2, sabado=4, viernes=3} ← claves ORDENADAS
    }
}
