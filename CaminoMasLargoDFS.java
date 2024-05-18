import java.util.ArrayList;
import java.util.Iterator;


public class CaminoMasLargoDFS {

    //Atributos
    private GrafoDirigido<Integer> grafo;
    private int origen;
    private int destino;
    private ArrayList<Integer> visitados;

    public CaminoMasLargoDFS(GrafoDirigido<Integer> grafo, int origen, int destino){
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.visitados = new ArrayList<>();
    }

    //El método caminoMayor tiene una complejidad temporal de O(V + E),
    // donde V es el número de vértices del grafo y E es el número de aristas.
    // En el peor de los casos, la función visitará cada vértice y arista del grafo una vez.
    public ArrayList<Integer> caminoMayor(int origen, int destino){
        ArrayList<Integer> caminoMayor = new ArrayList<>();
        this.visitados.add(origen);
        if(origen == destino){
            caminoMayor.add(origen);
        }
        else{
            Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
            while(it_ady.hasNext()){
                Integer ady = it_ady.next();
                if(!this.visitados.contains(ady)){
                    ArrayList<Integer> camino = caminoMayor(ady, destino);
                    if(!camino.isEmpty() && (camino.size()>=caminoMayor.size())){
                        caminoMayor.clear();
                        caminoMayor.add(origen);
                        caminoMayor.addAll(camino);
                    }
                }
            }
        }
        this.visitados.remove(origen);
        return caminoMayor;
    }

}
