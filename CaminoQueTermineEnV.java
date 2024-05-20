import java.util.ArrayList;
import java.util.Iterator;

public class CaminoQueTermineEnV {

    // Atributos
    private GrafoDirigido<Integer> grafo;
    private int destino;
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> encontrados;

    public CaminoQueTermineEnV(GrafoDirigido<Integer> grafo, int destino) {
        this.grafo = grafo;
        this.destino = destino;
        this.visitados = new ArrayList<>();
        this.encontrados = new ArrayList<>();
    }

    public ArrayList<Integer> verticesHastaV(int origen) {
        this.visitados.clear();
        this.encontrados.clear();

        // Configurar estado inicial
        ArrayList<Integer> verticesParcial = new ArrayList<>();
        verticesParcial.add(origen);
        this.visitados.add(origen);

        this.verticesHastaVRecursivo(origen, verticesParcial);
        return this.encontrados;
    }

    private void verticesHastaVRecursivo(int origen, ArrayList<Integer> verticesParcial) {
        if (origen == this.destino) {
            encontrados.clear();
            encontrados.addAll(verticesParcial);
        } else {
            Iterator<Integer> it_ady = grafo.obtenerAdyacentes(origen);
            while (it_ady.hasNext()) {
                Integer ady = it_ady.next();
                if (!visitados.contains(ady)) {
                    verticesParcial.add(ady);
                    this.visitados.add(ady);
                    verticesHastaVRecursivo(ady, verticesParcial);
                    verticesParcial.remove(ady);
                    // No es necesario eliminar ady de visitados aquí,
                    // ya que se reinicia visitados en cada llamada a verticesHastaV.
                }
            }
        }
    }
}


