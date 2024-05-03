import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    //Atributos
    private Map<Integer, List<Arco<T>>> adyacencias;
    private int cantidadVertices;
    private int cantidadArcos;

    //Constructor
    public GrafoDirigido() {
        adyacencias = new HashMap<>();
        cantidadVertices = 0;
        cantidadArcos = 0;
    }

    @Override
    public void agregarVertice(int verticeId) {
        try{
            //Verifico si no existe
            if(contieneVertice(verticeId)==false){
                //lo agrego
        adyacencias.put(verticeId, new ArrayList<>());
        cantidadVertices++;
            }
        }
        catch(Exception e){
            System.out.println("No es posible agregar el vértice");
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        adyacencias.remove(verticeId);
        cantidadVertices--;
        // Eliminar arcos que llegan a verticeId
        for (List<Arco<T>> lista : adyacencias.values()) {
            lista.removeIf(arco -> arco.getVerticeDestino() == verticeId);
        }
        // Eliminar arcos que parten desde verticeId
        adyacencias.getOrDefault(verticeId, new ArrayList<>()).clear();
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        List<Arco<T>> adyacentes = adyacencias.getOrDefault(verticeId1, new ArrayList<>());
        adyacentes.add(new Arco<>(verticeId1, verticeId2, etiqueta));
        adyacencias.put(verticeId1, adyacentes);
        cantidadArcos++;
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        List<Arco<T>> adyacentes = adyacencias.getOrDefault(verticeId1, new ArrayList<>());
        adyacentes.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        cantidadArcos--;
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return adyacencias.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        List<Arco<T>> adyacentes = adyacencias.getOrDefault(verticeId1, new ArrayList<>());
        return adyacentes.stream().anyMatch(arco -> arco.getVerticeDestino() == verticeId2);
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        List<Arco<T>> adyacentes = adyacencias.getOrDefault(verticeId1, new ArrayList<>());
        return adyacentes.stream().filter(arco -> arco.getVerticeDestino() == verticeId2).findFirst().orElse(null);
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
        return adyacencias.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        List<Arco<T>> adyacentes = adyacencias.getOrDefault(verticeId, new ArrayList<>());
        return adyacentes.stream().map(Arco::getVerticeDestino).iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> todosLosArcos = new ArrayList<>();
        adyacencias.values().forEach(todosLosArcos::addAll);
        return todosLosArcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return adyacencias.getOrDefault(verticeId, new ArrayList<>()).iterator();
    }

}