import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Camino Mas Largo
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar aristas
        grafo.agregarArco(1, 2, 1);
        grafo.agregarArco(1, 3, 2);
        grafo.agregarArco(3, 2, 6);
        grafo.agregarArco(2, 4, 3);
        grafo.agregarArco(3, 5, 4);
        grafo.agregarArco(4, 5, 5);

        int origen = 1;
        int destino = 5;

        CaminoMasLargoBackTracking aux = new CaminoMasLargoBackTracking(grafo, origen, destino);
        List<Integer> caminoMasLargo = aux.otroCaminoMayor(origen, destino);

        System.out.println("\nCamino más largo de " + origen + " a " + destino + ":");
        System.out.println(caminoMasLargo);

        //Camino Menor
        CaminoMasCortoBackTracking caminoMenor = new CaminoMasCortoBackTracking(grafo, origen, destino);
        List<Integer> caminoMasCorto = caminoMenor.otroCaminoMenor(origen, destino);

        System.out.println("\nCamino más corto de " + origen + " a " + destino + ":");
        System.out.println(caminoMasCorto);


    }
}
