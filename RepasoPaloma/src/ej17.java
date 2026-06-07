//  Ejercicio 17. Camino mínimo (intro)
//      Se pide:
//          1. Implementar una versión simplificada de Dijkstra.
//          2. Usar:
//              o cola de prioridad
//          3. Analizar complejidad.

import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Ejercicio17Dijkstra {

    private static class Arista {
        String destino;
        int peso;

        Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    private Map<String, List<Arista>> adyacencia = new HashMap<>();

    public void addArista(String a, String b, int peso) {
        adyacencia.putIfAbsent(a, new ArrayList<>());
        adyacencia.putIfAbsent(b, new ArrayList<>());
        adyacencia.get(a).add(new Arista(b, peso));
        adyacencia.get(b).add(new Arista(a, peso));
    }


    private List<String> reconstruirCamino(String inicio, String fin, Map<String, String> predecesor) {
        if (!predecesor.containsKey(fin) && !inicio.equals(fin)) {
            return Collections.emptyList();
        }
        LinkedList<String> camino = new LinkedList<>();
        String paso = fin;
        while (paso != null) {
            camino.addFirst(paso);
            paso = predecesor.get(paso);
        }
        return camino;
    }

    private static class Entrada {
        String nodo;
        int distancia;

        Entrada(String nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }
    }

    public List<String> caminoMinimoPQ(String inicio, String fin) {
        // Si alguno no esta en el grafo, no hay camino
        if (!adyacencia.containsKey(inicio) || !adyacencia.containsKey(fin)) {
            return Collections.emptyList();
        }

        Map<String, Integer> distancia = new HashMap<>();
        Map<String, String> predecesor = new HashMap<>();
        Set<String> visitado = new HashSet<>();

         // Inicializar todo a infinito (MAX_VALUE) menos el inicio que lo pongo a 0
        for (String nodo : adyacencia.keySet()) {
            distancia.put(nodo, Integer.MAX_VALUE);
        }
        distancia.put(inicio, 0);

        // Creo la cola de prioridad que me devulve la entrada con menos distancia
        PriorityQueue<Entrada> cola = new PriorityQueue<>(Comparator.comparingInt((Entrada e) -> e.distancia));
        cola.add(new Entrada(inicio, 0));

        while (!cola.isEmpty()) {
            // Elijo el de menor distancia
            Entrada e = cola.poll();
            String actual = e.nodo;

            // si lo ya he visitado no hago nada
            if (visitado.contains(actual)) continue;
            visitado.add(actual);

            if (actual.equals(fin)) break;

            for (Arista arista : adyacencia.get(actual)) {
                int nuevaDistancia = distancia.get(actual) + arista.peso;
                if (nuevaDistancia < distancia.get(arista.destino)) {
                    distancia.put(arista.destino, nuevaDistancia);
                    predecesor.put(arista.destino, actual);
                    cola.add(new Entrada(arista.destino, nuevaDistancia));
                }
            }
        }

        return reconstruirCamino(inicio, fin, predecesor);
    }

    public static void main(String[] args) {
        Ejercicio17Dijkstra g = new Ejercicio17Dijkstra();
        g.addArista("Ana", "Bea", 4);
        g.addArista("Ana", "Carlos", 1);
        g.addArista("Carlos", "Bea", 2);
        g.addArista("Bea", "Dani", 5);
        g.addArista("Carlos", "Eva", 10);
        g.addArista("Dani", "Eva", 1);

        System.out.println(g.caminoMinimo("Ana", "Eva"));
        System.out.println(g.caminoMinimo("Ana", "Dani"));
        System.out.println(g.caminoMinimo("Ana", "Ana"));
        System.out.println(g.caminoMinimo("Ana", "Zoe"));
        System.out.println(g.caminoMinimoPQ("Ana", "Eva"));
    }
}