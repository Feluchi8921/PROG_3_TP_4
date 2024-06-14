import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

/*
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

        // Crear un ejemplo de grafo
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>(); // Grafo dirigido

        // Agregar vértices al grafo
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        // Agregar aristas al grafo
        grafo.agregarArco(1, 2,1);
        grafo.agregarArco(1, 3, 2);
        grafo.agregarArco(2, 4, 3);
        grafo.agregarArco(3, 2, 4);
        grafo.agregarArco(3, 4,5 );

        // Instanciar la clase VerticesDeOrigenAdestino
        VerticesDeOrigenAdestino verticesDeOrigenAdestino = new VerticesDeOrigenAdestino(grafo, 1, 4);

        // Obtener la lista de vertices que forman un camino del origen al destino
        ArrayList<Integer> vertices = verticesDeOrigenAdestino.otroVertice(1, 4);

        // Imprimir la lista de vertices
        System.out.println("Caminos desde el vertice 1 al vertice 4:");
        for (Integer vertice : vertices) {
            System.out.print(vertice + " ");
        }
    }
*/
        // Crear un grafo dirigido
        GrafoDirigido<Integer> grafoConPares = new GrafoDirigido<>();

        // Agregar vértices al grafo
        grafoConPares.agregarVertice(1);
        grafoConPares.agregarVertice(2);
        grafoConPares.agregarVertice(3);
        grafoConPares.agregarVertice(4);
        grafoConPares.agregarVertice(5);

        // Agregar aristas al grafo
        grafoConPares.agregarArco(1, 2, 1);
        grafoConPares.agregarArco(1, 3, 1);
        grafoConPares.agregarArco(2, 4, 1);
        grafoConPares.agregarArco(2, 5, 1);
        grafoConPares.agregarArco(3, 4, 1);
        grafoConPares.agregarArco(4, 5, 1);

        // Instanciar la clase CaminoMasCortoConMayorCantPares
        CaminoMasCortoConMayorCantPares caminoMasCortoConMayorCantPares = new CaminoMasCortoConMayorCantPares(grafoConPares, 1, 5);

        // Encontrar el camino de menor longitud con mayor cantidad de pares
        List<Integer> caminoEncontrado = caminoMasCortoConMayorCantPares.otroCaminoMenor(1, 5);

        // Imprimir el camino encontrado
        System.out.println("Camino de menor longitud con mayor cantidad de pares:");
        for (Integer vertice : caminoEncontrado) {
            System.out.print(vertice + " ");
        }
        System.out.println();

        // Imprimir la cantidad máxima de pares encontrados
        System.out.println("Cantidad máxima de pares encontrados: " + caminoMasCortoConMayorCantPares.getCantMayorPares());
    }
}



