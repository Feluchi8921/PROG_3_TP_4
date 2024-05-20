import java.util.ArrayList;
import java.util.Iterator;


public class CaminoMasCortoBackTracking {

    //Atributos
    private GrafoDirigido<Integer> grafo;
    private int origen;
    private int destino;
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> caminoMenor;

    public CaminoMasCortoBackTracking(GrafoDirigido<Integer> grafo, int origen, int destino) {
        this.grafo =grafo;
        this.origen =origen;
        this.destino =destino;
        this.visitados =new ArrayList<>();
        this.caminoMenor = new ArrayList<>();
    }

    //El método otroCaminoMayor tiene una complejidad temporal de O(V + E),
    // donde V es el número de vértices del grafo y E es el número de aristas.
    // Sin embargo, las mejoras implementadas podrían traducirse en una mejor eficiencia práctica,
    // especialmente en grafos con estructuras complejas o un gran número de vértices. Mas eficiente que DFS

    public ArrayList<Integer> otroCaminoMenor(int origen, int destino){
        this.visitados.clear();
        this.caminoMenor.clear();

        //Configurar estado inicial
        ArrayList<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        this.visitados.add(origen);

        this.otroCaminoMenorRecursivo(origen, destino, caminoParcial);
        return this.caminoMenor;
    }

    private void otroCaminoMenorRecursivo(int origen, int destino, ArrayList<Integer> caminoParcial){
        if(origen == destino){
            if(caminoParcial.size()<caminoMenor.size());
            caminoMenor.clear();
            caminoMenor.addAll(caminoParcial);
        }

        else{
            Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
            while(it_ady.hasNext()){
                Integer ady = it_ady.next();
                if(!visitados.contains(ady)){
                    caminoParcial.add(ady);
                    this.visitados.add(ady);
                    otroCaminoMenorRecursivo(ady, destino, caminoParcial);
                    caminoParcial.remove(ady);
                    this.visitados.remove(ady);
                }
            }
        }
    }
}