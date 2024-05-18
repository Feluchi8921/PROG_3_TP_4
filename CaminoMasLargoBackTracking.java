import java.util.ArrayList;
import java.util.Iterator;


public class CaminoMasLargoBackTracking {

    //Atributos
    private GrafoDirigido<Integer> grafo;
    private int origen;
    private int destino;
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> caminoMayor;

    public CaminoMasLargoBackTracking(GrafoDirigido<Integer> grafo, int origen, int destino) {
        this.grafo =grafo;
        this.origen =origen;
        this.destino =destino;
        this.visitados =new ArrayList<>();
        this.caminoMayor = new ArrayList<>();
    }

    //El método otroCaminoMayor tiene una complejidad temporal de O(V + E),
    // donde V es el número de vértices del grafo y E es el número de aristas.
    // Sin embargo, las mejoras implementadas podrían traducirse en una mejor eficiencia práctica,
    // especialmente en grafos con estructuras complejas o un gran número de vértices. Mas eficiente que DFS

    public ArrayList<Integer> otroCaminoMayor(int origen, int destino){
        this.visitados.clear();
        this.caminoMayor.clear();

        //Configurar estado inicial
        ArrayList<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        this.visitados.add(origen);

        this.otroCaminoMayorRecursivo(origen, destino, caminoParcial);
        return this.caminoMayor;
    }

    private void otroCaminoMayorRecursivo(int origen, int destino, ArrayList<Integer> caminoParcial){
        if(origen == destino){
            if(caminoParcial.size()>=caminoMayor.size());
            caminoMayor.clear();
            caminoMayor.addAll(caminoParcial);
        }

        else{
            Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
            while(it_ady.hasNext()){
                Integer ady = it_ady.next();
                if(!visitados.contains(ady)){
                    caminoParcial.add(ady);
                    this.visitados.add(ady);
                    otroCaminoMayorRecursivo(ady, destino, caminoParcial);
                    caminoParcial.remove(ady);
                    this.visitados.remove(ady);
                }
            }
        }
    }
}