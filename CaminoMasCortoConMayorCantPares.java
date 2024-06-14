import java.util.ArrayList;
import java.util.Iterator;

public class CaminoMasCortoConMayorCantPares {

        //Atributos
        private GrafoDirigido<Integer> grafo;
        private int origen;
        private int destino;
        private ArrayList<Integer> visitados;
        private ArrayList<Integer> caminoMenor;
        private int cantMayorPares;

        public CaminoMasCortoConMayorCantPares(GrafoDirigido<Integer> grafo, int origen, int destino) {
            this.grafo =grafo;
            this.origen =origen;
            this.destino =destino;
            this.visitados =new ArrayList<>();
            this.caminoMenor = new ArrayList<>();
            this.cantMayorPares=0;
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
            int cantParesParcial = 0;
            caminoParcial.add(origen);
            this.visitados.add(origen);

            this.otroCaminoMenorRecursivo(origen, destino, caminoParcial, cantParesParcial);
            return this.caminoMenor;
        }

        private void otroCaminoMenorRecursivo(int origen, int destino, ArrayList<Integer> caminoParcial, int cantParesParcial) {
            if (origen == destino) {
                if (caminoMenor.isEmpty() || caminoParcial.size() < caminoMenor.size() ||
                        (caminoParcial.size() == caminoMenor.size() && cantParesParcial > cantMayorPares)) ;
                caminoMenor.clear();
                caminoMenor.addAll(caminoParcial);
                cantMayorPares = cantParesParcial;

            } else {
                Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
                while (it_ady.hasNext()) {
                    Integer ady = it_ady.next();
                    if (!visitados.contains(ady)) {
                        caminoParcial.add(ady);
                        this.visitados.add(ady);
                        if (ady % 2 == 0) {
                            cantParesParcial++;
                        }
                        otroCaminoMenorRecursivo(ady, destino, caminoParcial, cantParesParcial);
                        caminoParcial.remove(ady);
                        this.visitados.remove(ady);
                        if (ady % 2 == 0) {
                            cantParesParcial--;
                        }
                    }
                }
            }
        }
        public int getCantMayorPares(){
            return this.cantMayorPares;
        }
    }

