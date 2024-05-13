import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    // Atributos
    private HashMap<Integer, List<Arco<T>>> vertices;
    private int cantidadVertices;
    private int cantidadArcos;

    // Constructor
    public GrafoDirigido() {
        vertices = new HashMap<>();
        cantidadVertices = 0;
        cantidadArcos = 0;
    }

    @Override
    public void agregarVertice(int verticeId) {
        // Si no está el vértice lo agrego, sino se repetiría
        if (!this.contieneVertice(verticeId)) {
            vertices.put(verticeId, new ArrayList<Arco<T>>());
            cantidadVertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (this.contieneVertice(verticeId)) {
            // Eliminar arcos salientes del vértice
            List<Arco<T>> arcos = vertices.get(verticeId);
            for (Arco<T> arco : arcos) {
                vertices.get(arco.getVerticeDestino()).remove(arco);
                cantidadArcos--;
            }

            // Eliminar el vértice
            vertices.remove(verticeId);
            cantidadVertices--;
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        // Verificar si existen los vértices dados
        if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
            vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
            cantidadArcos++;
        } else {
            throw new IllegalArgumentException("Los vértices no existen en el grafo");
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
            List<Arco<T>> arcos = vertices.get(verticeId1);
            for (int i = 0; i < arcos.size(); i++) {
                Arco<T> arco = arcos.get(i);
                if (arco.getVerticeDestino() == verticeId2) {
                    arcos.remove(i);
                    cantidadArcos--;
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Los vértices o el arco no existen en el grafo");
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // Primero verificar que los vértices estén
        if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
            List<Arco<T>> arcos = vertices.get(verticeId1);
            if (!arcos.isEmpty()) {
                for (Arco<T> a : arcos) {
                    if (a.getVerticeDestino() == verticeId2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
            List<Arco<T>> arcos = vertices.get(verticeId1);
            if (!arcos.isEmpty()) {
                for (Arco<T> a : arcos) {
                    if (a.getVerticeDestino() == verticeId2) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return cantidadVertices;
    }

    @Override
    public int cantidadArcos() {
        return cantidadArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    // Hecho en clase
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if(vertices.containsKey(verticeId)){
            return new IteradorArcos<T>(vertices.get(verticeId).iterator());
        }
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        Set<Map.Entry<Integer, List<Arco<T>>>> lista = vertices.entrySet();
        if(!lista.isEmpty()) {
            ArrayList<Arco<T>> aux = new ArrayList<>();
            for (Map.Entry<Integer, List<Arco<T>>> l : lista)
                aux.addAll(l.getValue());
            return aux.iterator();
        }
        return null;
    }

    //Hecho en clase
    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if(vertices.containsKey(verticeId)){
            return vertices.get(verticeId).iterator();
        }
        return null;
    }

}