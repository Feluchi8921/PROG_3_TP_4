import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private Grafo<Integer> grafo;
    private Queue<Integer> fila;
    private HashMap<Integer, Boolean> visitados;

    public BFS(Grafo<Integer> grafo) {
        this.grafo = grafo;
        this.fila = new LinkedList<>();
        this.visitados = new HashMap<>();
    }

    public List<Integer> bfsForest() {
        this.fila.clear(); // Limpiar la cola antes de iniciar
        Iterator<Integer> iter1 = grafo.obtenerVertices(); // Obtener iterador de vértices
        while(iter1.hasNext()) { // Recorrer vértices
            int v = iter1.next(); // Obtener vértice actual
            visitados.put(v, false); // Marcar como no visitado
        }

        ArrayList<Integer> ordenVisitados = new ArrayList<>(); // Lista para orden de visita
        Iterator<Integer> iter2 = grafo.obtenerVertices(); // Nuevo iterador de vértices
        while(iter2.hasNext()) { // Recorrer vértices
            int v = iter2.next(); // Obtener vértice actual
            if(visitados.get(v)==false) { // Si no visitado
                bfsForest(v, ordenVisitados); // Explorar desde este vértice
            }
        }

        return ordenVisitados; // Devolver orden de visita
    }

    private void bfsForest(int vertice, ArrayList<Integer> ordenVisitados) {
        visitados.put(vertice, true); // Marcar como visitado
        this.fila.add(vertice); // Agregar a la cola
        ordenVisitados.add(vertice); // Agregar al orden de visita

        while (!this.fila.isEmpty()) { // Mientras la cola no esté vacía
            int x = this.fila.poll(); // Extraer primer vértice de la cola
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(x); // Obtener adyacentes
            if(adyacentes!=null) { // Si hay adyacentes
                while (adyacentes.hasNext()) { // Recorrer adyacentes
                    int a = adyacentes.next(); // Obtener adyacente actual
                    if(visitados.get(a)==false) { // Si no visitado
                        visitados.put(a, true); // Marcar como visitado
                        this.fila.add(a); // Agregar a la cola
                        ordenVisitados.add(a); // Agregar al orden de visita
                    }
                }
            }
        }
    }

}
