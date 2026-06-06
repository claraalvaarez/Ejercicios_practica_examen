//Ejercicio 7. Implementación de pila (Stack)
//  Se pide:
//        1. Implementar una pila genérica Stack<T> sin usar colecciones de Java (array
//           dinámico o lista enlazada).
//        2. Escribir tests TDD para:
//              o push
//              o pop
//              o peek
//              o control de pila vacía
//        3. Analizar complejidad de cada operación.
//        4. Repetir usando:
//              o ArrayDeque
//              o Stack
//  Comparar diseño y eficiencia.

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ej7 {

    // Implementacion de pila generica con lista enlazada
    private static class Nodo<T>{
        T valor;
        Nodo<T> siguiente;
        Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public class PilaEnlazada<T>{
        private Nodo<T> head;
        private int tamano;

        public PilaEnlazada(){
            this.head = null;
            this.tamano = 0;
        }

        public void push(T valor){
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.siguiente = head;
            head = nuevo;
            tamano++;
        }

        public T pop(){
            if (head == null) {
                throw new EmptyStackException();
            }
            // if(head == null) return null;
            T valor = head.valor;
            head = head.siguiente;
            tamano--;
            return valor;
        }

        public T peek(){
            if (head == null) {
                throw new EmptyStackException();
            }
            // if(head == null) return null;
            return head.valor;
        }

        public boolean empty(){
//            if(head == null) return true;   Forma menos elegante
//            return false;
            return head == null;
        }

        public int size(){
            return tamano;
        }


    }

        @Test
        public void pushYPeekTest(){
            PilaEnlazada<Integer> pila = new PilaEnlazada<>();
            pila.push(5);
            assertEquals(5, (int) pila.peek());
            assertEquals(1, pila.size());
            assertFalse(pila.empty());
        }
        // Hacer test LIFO: Meter 3 elementos, ver que los saca en orden y comprobar que se queda vacio





}
