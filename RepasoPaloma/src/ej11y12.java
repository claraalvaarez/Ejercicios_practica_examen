// Ejercicio 11. Montículo binario (heap)
//  Se pide:
//      1. Implementar un min-heap:
//          o inserción
//          o extracción del mínimo
//      2. Representación mediante array.
//      3. Tests TDD.
//      4. Complejidad de:
//          o insert
//          o extractMin

//Ejercicio 12. Cola de prioridad
//  Se pide:
//      1. Implementar una cola de prioridad usando:
//          o tu heap
//      2. Resolver:
//          o obtener los k elementos más pequeños de una lista
//      3. Comparar con:
//          o PriorityQueue
//  Reflexión:
//        • ¿por qué PriorityQueue no está ordenada internamente?

import java.util.PriorityQueue;

public class ej11y12 {
    public static class MinHeap {
        private int[] datos;
        private int tamano;
        MinHeap(int capacidad){
            this.datos = new int[ capacidad + 1]; // Le sumo 1 porque la posicion 0 se queda vacia
            this.tamano = 0;
        }

        public boolean empty(){
            return tamano == 0;
        }

        public int size(){
            return tamano;
        }

        public int peek(){
            if (empty()) throw new java.util.NoSuchElementException("Heap vacio");
            return datos[1];
        }

        // El padre del elemento de la posicion k esta en k/2.
        // Los hijos del elemento en posicion k estan en 2k y 2k+1
        public void insertar(int valor){
            tamano++;
            datos[tamano] = valor;
            int actual = tamano;
            while(actual > 1 && datos[actual] < datos[actual/2]){
                intercambiar(actual, actual/2);
                actual = actual/2;
            }

        }
        private void intercambiar(int i, int j){
            int temp = datos[j];
            datos[j] = datos[i];
            datos[i] = temp;
        }

        public int extraerMin(){
            if (empty()) throw new java.util.NoSuchElementException("Heap vacio");
            int min = datos[1];

            datos[1] = datos[tamano];
            tamano--;
            int actual = 1;
            while(2*actual <= tamano) { // Mientras tenga el menos hijo izq
                int posicionHijo = 2 * actual; // Candidato hijo izquierdo
                if(posicionHijo + 1 <= tamano && datos[posicionHijo + 1] < datos[posicionHijo]) {
                    posicionHijo = posicionHijo + 1; // El derecho existe y es menor que el de la izq
                }
                if(datos[actual] <= datos[posicionHijo]) break; // El padre es menor que el hijo. Esta en su posicion
                intercambiar(actual, posicionHijo);
                actual = posicionHijo;
            }



            return min;

        }

        @Override
        public String toString() { // Para imprimirlo bonito
            StringBuilder sb = new StringBuilder("[-");
            for (int i = 1; i <= tamano; i++) {
                sb.append(", ").append(datos[i]);
            }
            return sb.append("]").toString();
        }

    }





    public static void main(String[] args) {
//        MinHeap heap = new MinHeap(10);
//        for (int v : new int[]{9, 4, 7, 1, 6, 3}) heap.insertar(v);
//        System.out.println(heap);
//        System.out.println(heap.extraerMin());
//        System.out.println(heap);
//
//        System.out.println(heap.extraerMin());
//        System.out.println(heap.extraerMin());
//        System.out.println(heap.peek());
//        System.out.println(heap.size());

        PriorityQueue<Integer> enteros = new PriorityQueue<>();
        for (int v : new int[]{9, 4, 7, 1, 6, 3}) enteros.add(v);
        System.out.println(enteros);
        System.out.println(enteros.poll());
        System.out.println(enteros.peek());
    }

}
