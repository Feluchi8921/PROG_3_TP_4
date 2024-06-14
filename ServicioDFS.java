import java.util.*;

public class ServicioDFS {

    //Atributos
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, String> colores;
    private String no_visitado;
    private String visitado;
    private String encontrado;
    private boolean tieneCiclo;

    public ServicioDFS(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
        this.no_visitado = "blanco";
        this.visitado = "amarillo";
        this.encontrado = "negro";
        this.tieneCiclo = false;
    }

    public List<Integer> DFS(GrafoDirigido<Integer> grafo) {

        //Necesito un iterador para recorrer los vertices. Primera iteracion
        Iterator<Integer> iterator1 = grafo.obtenerVertices();

        //Mientras haya un proximo
        while (iterator1.hasNext()) {
            //Guardo el valor del vertice
            int v = iterator1.next();
            //Marco todos en blanco
            colores.put(v, this.no_visitado);
        }

        //Segunda iteracion
        Iterator<Integer> iterator2 = grafo.obtenerVertices();
        //Lista para guardar los vertices vistados
        List<Integer> ordenVisitados = new ArrayList<>();
        //Mientras haya siguiente
        while(iterator2.hasNext()){
            //Guardo el valor del siguiente
            int v = iterator2.next();
            //Si ya esta marcado como no visitado
            if(colores.get(v)==this.no_visitado){
                //lo agrego
                ordenVisitados.add(v);
                //llamo al metodo privado y le paso el vertice con la lista de visitados
                dfsVisitar(v, ordenVisitados);
            }
        }
        //Retorno la lista que contiene el orden de los vertices visitados
        return ordenVisitados;
    }

    private  void dfsVisitar(int vertice, List<Integer> ordenVisitados){

        //Marco el vertice como visitado
        colores.put(vertice, this.visitado);

        //Recorro los adyacentes al vertice
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        //Si no es nulo
        if(adyacentes != null){
            //Mientras haya adyacente
            while(adyacentes.hasNext()){
                //Guardo el valor
                int ady = adyacentes.next();

                //Si un adyacente esta sin visitar, lo marco como visitado
                if(colores.get(ady) == this.no_visitado){
                    //Lo agrego a la lista
                    ordenVisitados.add(ady);
                    //llamo recursivamente
                    dfsVisitar(ady, ordenVisitados);
                }

                //Agrego esta linea para detectar si hay un ciclo
                else{
                    if(colores.get(ady) == this.visitado){
                        this.tieneCiclo = true;
                        isTieneCiclo(this.tieneCiclo);
                    }
                }
            }
        }
        colores.put(vertice, this.encontrado);
    }

    public boolean isTieneCiclo(boolean tieneCiclo){
        return tieneCiclo;
    }
}


