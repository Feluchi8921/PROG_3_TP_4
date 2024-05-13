import java.util.Iterator;
//Clase implementada por los profes para bajar la complejidad
public class IteradorArcos <T> implements Iterator<Integer> {
    private Iterator<Arco<T>> iterador;
    public IteradorArcos(Iterator<Arco<T>> iterador){
        this.iterador=iterador;
    }
    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Integer next() {
        Arco<T> arco = iterador.next();
        return arco.getVerticeDestino();
    }
}
