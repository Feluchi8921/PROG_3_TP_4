import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class VerticesDeOrigenAdestino {

    //Atributos
    private GrafoDirigido<Integer> grafo;
    private int origen;
    private int destino;
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> vertices;

    public VerticesDeOrigenAdestino(GrafoDirigido<Integer> grafo, int origen, int destino) {
        this.grafo =grafo;
        this.origen =origen;
        this.destino =destino;
        this.visitados =new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    public ArrayList<Integer> otroVertice(int origen, int destino){
        // Configurar estado inicial
        ArrayList<Integer> verticesParciales = new ArrayList<>();
        verticesParciales.add(origen);
        this.visitados.add(origen);

        this.otroVertice(origen, destino, verticesParciales);
        return this.vertices;
    }


    private void otroVertice(int origen, int destino, ArrayList<Integer> verticesParciales){
        if(origen == destino){
            // Solo guarda una copia de los vértices parciales al destino
            vertices.addAll(new ArrayList<>(verticesParciales));
        } else {
            List<Integer> noDisponibles = new ArrayList<>(); // Conjunto para almacenar vértices no disponibles temporalmente
            Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
            while(it_ady.hasNext()){
                Integer ady = it_ady.next();
                if(!visitados.contains(ady) && !noDisponibles.contains(ady)){
                    verticesParciales.add(ady);
                    noDisponibles.add(ady); // Marcar el vértice como no disponible temporalmente
                    otroVertice(ady, destino, verticesParciales);
                    verticesParciales.remove(ady);
                    noDisponibles.remove(ady); // Eliminar el vértice al retroceder
                }
            }
        }
    }

}