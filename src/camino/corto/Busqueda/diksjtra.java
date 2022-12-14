package Busqueda;

import java.util.*;

public class Diksjtra {

    String[] nodos; // Letras de identificación de nodo
    int[][] grafo; // Matriz de distancias entre nodos
    String rutaMasCorta;// distancia más corta
    String RutaMasLarga;// distancia más Larga
    int longitudMasCorta = Integer.MAX_VALUE; // ruta más corta
    int longitudMasLarga = Integer.MAX_VALUE;/// Ruta mas Larga
    List<Nodo> listos = null; // nodos revisados Dijkstra

    // construye el grafo con la serie de identificadores de nodo en una cadena
    public Diksjtra(String[] serieNodos) {
        System.out.println(Arrays.toString(serieNodos));
        nodos = serieNodos;

        grafo = new int[nodos.length][nodos.length];

    }

    // asigna el tamaño de la arista entre dos nodos
    public void agregarRuta(String origen, String destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2] = distancia;
        grafo[n2][n1] = distancia;
    }

    public void imprimirGrafoMatriz() {

        System.out.println("MATRIZ GRAFO DISTANCIAS");
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // retorna la posición en el arreglo de un nodo específico
    private int posicionNodo(String nod) {
        int l = 0;
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i].equals(nod)) {
                return i;
            } else {
                l = i;
            }
        }
        return l;
    }

    // encuentra la ruta más corta desde un nodo origen a un nodo destino
    public String encontrarRutaMinimaDijkstra(String inicio, String fin) {
        // calcula la ruta más corta del inicio a los demás
        encontrarRutaMinimaDijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if (!listos.contains(tmp)) {
            return "Error, Camino no alcanzable";
        }
        tmp = listos.get(listos.indexOf(tmp));
        int distancia = tmp.distancia;

        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Nodo> pila = new Stack<Nodo>();
        while (tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = " ";
        // recorre la pila para armar la ruta en el orden correcto
        while (!pila.isEmpty()) {
            ruta += (pila.pop().id + " , ");
        }
        return "La distancia es: " + distancia + " Km y el camino a seguir es por " + ruta;
    }

    // encuentra la ruta más corta desde un nodo origen a un nodo destino
    public String encontrarRutaMaximaDijkstra(String inicio, String fin) {
        // calcula la ruta más corta del inicio a los demás
        encontrarRutaMaximaDijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if (!listos.contains(tmp)) {
            return "Error, Camino no alcanzable";
        }
        tmp = listos.get(listos.indexOf(tmp));
        int distancia = tmp.distancia;

        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Nodo> pila = new Stack<Nodo>();
        while (tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = " ";
        // recorre la pila para armar la ruta en el orden correcto
        while (!pila.isEmpty()) {
            ruta += (pila.pop().id + " Y ");
        }
        return "La distancia es: " + distancia + " Km y el camino a seguir es por " + ruta;
    }

    // encuentra la ruta más corta desde el nodo inicial a todos los demás
    public void encontrarRutaMinimaDijkstra(String inicio) {
        Queue<Nodo> cola = new PriorityQueue<Nodo>(); // cola de prioridad
        Nodo ni = new Nodo(inicio); // nodo inicial

        listos = new LinkedList<Nodo>();// lista de nodos ya revisados
        cola.add(ni); // Agregar nodo inicial a la cola de prioridad
        while (!cola.isEmpty()) { // mientras que la cola no esta vacia
            Nodo tmp = cola.poll(); // saca el primer elemento
            listos.add(tmp); // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);
            for (int j = 0; j < grafo[p].length; j++) { // revisa los nodos hijos del nodo tmp
                if (grafo[p][j] == 0) {
                    continue; // si no hay conexión no lo evalua
                }
                if (estaTerminado(j)) {
                    continue; // si ya fue agregado a la lista de terminados
                }
                Nodo nod = new Nodo(nodos[j], tmp.distancia + grafo[p][j], tmp);
                // si no está en la cola de prioridad, lo agrega
                if (!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for (Nodo x : cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if (x.id == nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod); // agrega el nodo con la nueva distancia
                        break; // no sigue revisando
                    }
                }

            }
        }
    }

    public void encontrarRutaMaximaDijkstra(String inicio) {
        Queue<Nodo> cola = new PriorityQueue<Nodo>(); // cola de prioridad
        Nodo ni = new Nodo(inicio); // nodo inicial

        listos = new LinkedList<Nodo>();// lista de nodos ya revisados
        cola.add(ni); // Agregar nodo inicial a la cola de prioridad
        while (!cola.isEmpty()) { // mientras que la cola no esta vacia
            Nodo tmp = cola.poll(); // saca el primer elemento
            listos.add(tmp); // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);
            for (int j = 0; j < grafo[p].length; j++) { // revisa los nodos hijos del nodo tmp
                if (grafo[p][j] == 0) {
                    continue; // si no hay conexión no lo evalua
                }
                if (estaTerminado(j)) {
                    continue; // si ya fue agregado a la lista de terminados
                }
                Nodo nod = new Nodo(nodos[j], tmp.distancia + grafo[p][j], tmp);
                // si no está en la cola de prioridad, lo agrega
                if (!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for (Nodo x : cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if (x.id == nod.id && x.distancia < nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod); // agrega el nodo con la nueva distancia
                        break; // no sigue revisando
                    }
                }

            }
        }
    }

    // verifica si un nodo ya está en lista de terminados
    public boolean estaTerminado(int j) {
        Nodo tmp = new Nodo(nodos[j]);
        return listos.contains(tmp);
    }


    // recorre recursivamente las rutas entre un nodo inicial y un nodo final
    // almacenando en una cola cada nodo visitado
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        // si el nodo inicial es igual al final se evalúa la ruta en revisión

        if (nodoI == nodoF) {

            int respuesta = evaluar(resultado);
            if (respuesta < longitudMasCorta) {
                longitudMasCorta = respuesta;
                rutaMasCorta = "";
                for (int x : resultado) {

                    rutaMasCorta += (nodos[x] + " ");
                }
            }
            return;
        }

        // Si el nodoInicial no es igual al final se crea una lista con todos los nodos
        // adyacentes al nodo inicial que no estén en la ruta en evaluación
        List<Integer> lista = new Vector<Integer>();
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[nodoI][i] != 0 && !resultado.contains(i)) {
                lista.add(i);
            }
        }
        // se recorren todas las rutas formadas con los nodos adyacentes al inicial
        for (int nodo : lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
    }

    // evaluar la longitud de una ruta
    public int evaluar(Stack<Integer> resultado) {
        int resp = 0;
        int[] r = new int[resultado.size()];
        int i = 0;
        for (int x : resultado) {
            r[i++] = x;
        }
        for (i = 1; i < r.length; i++) {
            resp += grafo[r[i]][r[i - 1]];
        }

        return resp;
    }

    /*
     * // Dados el número de nodos del grafo (n), el grafo (G) como matriz de
     * adyacencia y una
     * // matriz dist, guarda en dist la distancia mínima entre cada par de nodos,
     * de modo que
     * // dist[i][j] es la distancia mínima para ir del nodo i al j
     * void Floyd_Warshall (int n, vvi G, vvi dist){
     * dist = G;
     * for (int i = 0; i < n; ++i){
     * for (int j = 0; j < n; ++j){
     * if (i != j && dist[i][j] == 0) dist[i][j] = inf;
     * //las parejas de nodos sin arco están a distancia inf (p.e. 1e9)
     * }
     * }
     * 
     * for (int k = 0; k < n; ++k){ //por cada nodo intermedio k
     * for (int i = 0; i < n; ++i){
     * for (int j = 0; j < n; ++j){ //miramos todas las parejas de nodos
     * dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
     * //Si pasando por k mejoramos el resultado, lo actualizamos
     * }
     * }
     * }
     * 
     * }
 
     
     * // Dados el número de nodos del grafo (n), el número de arcos (m), un nodo
     * origen (s), un
     * // nodo destino (t) y el conjunto de aristas (edges) donde edge[i] = {nodo
     * donde empieza el
     * // arco, nodo donde termina, peso}, devuelve la mínima distancia para ir
     * desde s hasta t.
     * int Bellman_Ford (vvi& edges, int n, int m, int s, int t){
     * vi d(n, inf); // vector de distancias, inicialmente inf (un número grande
     * como 1e9)
     * 
     * d[s] = 0; // la distancia al nodo origen es 0
     * for (int i = 0; i < n-1; ++i){ // hacemos n-1 iteraciones
     * for (int j = 0; j < m; ++j){ // en cada una miramos todos los arcos
     * int v = edges[j][0];
     * int u = edges[j][1];
     * int w = edges[j][2];
     * 
     * d[u] = min(d[u], d[v] + w); // actualizamos distancia (si es necesario)
     * }
     * }
     * 
     * return d[t]; // devolvemos la distancia de s a t
     * }
     */
}
