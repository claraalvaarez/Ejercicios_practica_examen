//Ejercicio 9. Implementación de tabla hash
//      Se pide:
//          1. Implementar un HashMap<K,V> simplificado con:
//              o direccionamiento abierto o
//              o encadenamiento
//          2. Diseñar función hash.
//          3. Gestionar colisiones.
//          4. Tests TDD para:
//              o inserción
//              o búsqueda
//              o borrado
//          5. Analizar:
//              o caso promedio vs peor caso
//          6. Comparar con:
//              o HashMap
//  Preguntas clave:
//        • ¿Por qué la complejidad media es O(1)?
//        • ¿Cuándo deja de serlo?


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ej9 {
    public interface HashMap<K, V>{
        void put(K clave, V valor);
        V get(K calve);
        V remove(K clave);
    }

    public class MiHashMap<K, V> implements HashMap<K, V>{
        public class Nodo<K, V>{
            K clave;
            V valor;
            Nodo(K clave, V valor){
                this.clave = clave;
                this.valor = valor;
            }
        }

        LinkedList<Nodo<K, V>>[] buckets;
        public MiHashMap(){
            buckets = new LinkedList[16];
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hash(K clave){
            return Math.abs(clave.hashCode()) % buckets.length;
        }

        @Override
        public void put(K clave, V valor) {
            LinkedList<Nodo<K, V>> b = buckets[hash(clave)];
            for(int i = 0; i < b.size(); i++){
                if(b.get(i).clave == clave){
                    b.get(i).valor = valor;
                    return;
                }
            }
            b.add(new Nodo<>( clave,  valor));
        }

        @Override
        public V get(K clave) {
            LinkedList<Nodo<K, V>> b = buckets[hash(clave)];
            for(int i = 0; i < b.size(); i++){
                if(b.get(i).clave == clave){
                    return b.get(i).valor;
                }
            }
            return null;
        }

        @Override
        public V remove(K clave) {
            LinkedList<Nodo<K, V>> b = buckets[hash(clave)];
            for(int i = 0; i < b.size(); i++){
                if(b.get(i).clave == clave){
                    return b.remove(i).valor;

                }
            }
            return null;
        }
    }


}
