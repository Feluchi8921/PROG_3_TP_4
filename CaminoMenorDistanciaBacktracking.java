import java.util.ArrayList;
import java.util.Iterator;

public class CaminoMenorDistanciaBacktracking {
    //Atributos
    private Grafo grafo;
    private ArrayList<String> caminoMenor;
    private int sumaMenor;
    private ArrayList<String> visitados;

    //Constructor
    public CaminoMenorDistanciaBacktracking(Grafo g){
        this.grafo = g;
        this.caminoMenor = new ArrayList<>();
        this.sumaMenor = 0;
        this.visitados = new ArrayList<>();
    }

    //Back
    public ArrayList<String> back (int origen, int destino){
        ArrayList<String> caminoParcial = new ArrayList<>();
        int sumaParcial = 0;
        bacKRecursivo(caminoParcial, sumaParcial, origen, destino);
        return caminoMenor;
    }

    private void bacKRecursivo(ArrayList<String> caminoParcial, int sumaParcial, int origen, int destino){
        if(origen==destino && sumaParcial<sumaMenor){
            caminoMenor.clear();
            caminoMenor.addAll(caminoParcial);
            sumaMenor=sumaParcial;
        }
        else{
            Iterator<String> it1 = grafo.obtenerAdyacentes(origen);
            while(it1.hasNext()){
                String v = it1.next();
                if(v!= null){
                    caminoParcial.add(v);
                    visitados.add(v);
                    /*No tengo implementado el metodo obtenerEtiqueta en grafos
                    int etiquetaArco = grafo.obtenerEtiquetaArco(origen, v);
                    sumaParcial+=etiquetaArco;
                    backRecursivo(caminoParcial, sumaParcial, v, destino);
                    caminoParcial.remove(v);
                    visitados.remove(v);
                    sumaParcial-=etiquetaArco;
                     */
                }
            }
        }
    }
}
