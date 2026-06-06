//Ejercicio 8. Cola y cola doble
//  Se pide:
//        1. Implementar una cola FIFO.
//        2. Extender a cola doble (deque).
//        3. Resolver el problema:
//              o invertir una cola usando solo operaciones de cola/pila.
//        4. Comparar con:
//              o LinkedList
//              o ArrayDeque
//  Reflexión:
//        • ¿por qué ArrayDeque suele ser preferible a LinkedList?

import java.util.*;

public class Ej8 {
   public static class Cola<T>{
      private static class Nodo<T>{
         T valor;
         Nodo<T> siguiente;
         Nodo(T valor){
            this.valor = valor;
            this.siguiente = null;
         }
      }

      private Nodo<T> head;  // Por aqui saco.
      private Nodo<T> tail; // Por aqui meto. Sacar por detras es muy caro -> O(N). Hay que recorrer toda la lista para apuntar al anterior
      private int tamano;

      public void add(T valor){
         Nodo<T> nuevo = new Nodo<>(valor);
         if(head == null) { // Si la cola esta vacia el nuevo nodo tiene que ser head y tail.
            head = nuevo;
            tail = nuevo;
         } else {
            tail.siguiente = nuevo;
            tail = nuevo;
         }
         tamano++;
      }

      public T remove(){
         if(head == null) return null;
//         throw new java.util.NoSuchElementException("Cola vacía");
         T valor = head.valor;
         head = head.siguiente;
         if(head == null) tail = null; // Si la cola se queda vacia despues de quitar el primer elemento, tail es null.
         tamano--;
         return valor;

      }

      public T peek(){
         if(head == null) return null;
//         throw new java.util.NoSuchElementException("Cola vacía");
         return head.valor;
      }

      public int size(){
         return tamano;
      }

      public boolean empty(){
         return head == null;
      }


   }



   public static class ColaDoble<T>{
      private static class Nodo<T>{
         T valor;
         Nodo<T> siguiente;
         Nodo<T> anterior;
         Nodo(T valor){
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
         }
      }

      private Nodo<T> head;  // Por aqui saco.
      private Nodo<T> tail; // Por aqui meto. Sacar por detras es muy caro -> O(N). Hay que recorrer toda la lista para apuntar al anterior
      private int tamano;

      public void addLast(T valor){
         Nodo<T> nuevo = new Nodo<>(valor);
         if(head == null) { // Si la cola esta vacia el nuevo nodo tiene que ser head y tail.
            head = nuevo;
            tail = nuevo;
         } else {
            nuevo.anterior = tail;
            tail.siguiente = nuevo;
            tail = nuevo;
         }
         tamano++;
      }
      public void addFirst(T valor){
         Nodo<T> nuevo = new Nodo<>(valor);
         if(head == null) { // Si la cola esta vacia el nuevo nodo tiene que ser head y tail.
            head = nuevo;
            tail = nuevo;
         } else {
            nuevo.siguiente = head;
            head.anterior = nuevo;
            head = nuevo;
         }
         tamano++;
      }

      public T removeFirst(){
         if(head == null) return null;
//         throw new java.util.NoSuchElementException("Cola vacía");
         T valor = head.valor;
         head = head.siguiente;

         if(head == null) tail = null;// Si la cola se queda vacia despues de quitar el primer elemento, tail es null.
         else head.anterior = null;
         tamano--;
         return valor;
      }
      public T removeLast(){
         if(head == null) return null;
//         throw new java.util.NoSuchElementException("Cola vacía");
         T valor = tail.valor;
         tail = tail.anterior;

         if(tail == null) head = null;// Si la cola se queda vacia despues de quitar el primer elemento, tail es null.
         else tail.siguiente = null;
         tamano--;
         return valor;
      }

      public T peekFirst(){
         if(empty()) return null;
//         throw new java.util.NoSuchElementException("Cola vacía");
         return head.valor;
      }
      public T peekLast(){
         if(empty()) return null;
//         throw new java.util.NoSuchElementException("Cola vacía");
         return tail.valor;
      }

      public int size(){
         return tamano;
      }

      public boolean empty(){
         return head == null;
      }


   }

   public static <T> void invertirCola(Cola<T> cola){
//    Stack<T> pila = new Stack<>();
      Deque<T> pila = new ArrayDeque<>();
      // Paso 1: Pasar de la cola a la pila. cola → pila
      while(!cola.empty()){
         pila.push(cola.remove());
      }
      // Paso 2: Pasar de la pila a la cola. pila → cola
      while (!pila.isEmpty()){
         cola.add(pila.pop());
      }

   }


   public static void main(String[] args){
      Cola<Integer> c = new Cola<>();
      c.add(2);
      c.add(9);
      System.out.println(c.remove());
      c.add(5);
      System.out.println(c.peek());
      System.out.println(c.remove());
      System.out.println(c.remove());
      System.out.println(c.empty());
      c.add(7);
      System.out.println(c.peek());

      Cola<Integer> q = new Cola<>();
      q.add(1); q.add(2); q.add(3);
      invertirCola(q);
      System.out.println(q.remove());   // 3
      System.out.println(q.remove());   // 2
      System.out.println(q.remove());   // 1


   }

}

