import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DFS {

    //Atributos
    private Grafo<Integer> grafo;
    private HashMap<Integer, String> colores;
    private String visitado;
    private String sinVisitar;
    private String adyVisitados;
    public DFS(Grafo<Integer> grafo){
        this.grafo = grafo;
        this.visitado = "amarillo";
        this.sinVisitar = "blanco";
        this.adyVisitados = "negro";
    }

    public List<Integer> dfsForest() {

        //Recorro todos los vertices
        Iterator<Integer> iter1 = grafo.obtenerVertices();
        //Le asigno color blanco, sin visitar
        while(iter1.hasNext()) {
            int v = iter1.next();
            colores.put(v, this.sinVisitar);
        }

        //Si el vertice esta sin visitar lo marco como visitado
        Iterator<Integer> iter2 = grafo.obtenerVertices();
        List<Integer> ordenVisitados = new ArrayList<>();
        while(iter2.hasNext()) {
            int v = iter2.next();
            if(colores.get(v)==this.sinVisitar) {
                ordenVisitados.add(v);
                dfsVisitar(v, ordenVisitados);
            }
        }

        //Retorno una lista dque contiene el orden en el que fueron visitados los vertices
        return ordenVisitados;
    }

    private void dfsVisitar(int vertice, List<Integer> ordenVisitados) {

        //Marco el vertice como visitado
        colores.put(vertice, this.visitado);

        //Recorro los adyacentes al vertice
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        if(adyacentes!=null) {
            while(adyacentes.hasNext()) {
                int a = adyacentes.next();

                //Si un adyacente esta sin visitar, lo marco como visitado
                if(colores.get(a)==this.sinVisitar) {
                    ordenVisitados.add(a);
                    dfsVisitar(a, ordenVisitados);
                }
            }
        }
        colores.put(vertice, this.adyVisitados);
    }
}
