package GrafosImplementacion.MetodosBusqueda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import GrafosImplementacion.GenerarGrafos.GrafoNDNP;
import GrafosImplementacion.NodosYmatrices.Arista;

public class DFS {

	private GrafoNDNP grafo;
	private int cantNodos;
	private int cantAristas;

	private int nodoInicial;
	private ArrayList<Arista> arbol;
	private boolean[] nodoTerminado;
	
	public GrafoNDNP getGrafo() {
		return grafo;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public int getNodoInicial() {
		return nodoInicial;
	}

	public DFS(GrafoNDNP grafo, int nodoInicial) {
		this.grafo = grafo;
		this.cantNodos = grafo.getCantNodos();
		this.cantAristas = grafo.getCantAristas();

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoTerminado = new boolean[this.cantNodos];
	}

	public void ejecutar() throws IOException {
		// pila que almacena los nodos visitados
		Stack<Integer> pila = new Stack<Integer>();
		// apilo el nodo inicial
		pila.push(this.nodoInicial);
		
		int nodo, indice;
		boolean adyacente = false;
		
		// mientras la pila no está vacía
		while(!pila.isEmpty()) {
			// pispeo el nodo de la cima de la pila
			nodo = pila.peek();
			
			// genero todos los números de nodo
			for (int i = 0; i < this.cantNodos; i++) {
				// si el nodo generado no es el nodo actual y no fue terminado
				if (nodo != i && !this.nodoTerminado[i]) {
					// genero el índice para la matriz simétrica
					if (nodo < i) {
						indice = this.grafo.getGrafo().getIndice(nodo, i);
					} else {
						indice = this.grafo.getGrafo().getIndice(i, nodo);
					}
					
					// si existe una arista que una estos nodos
					if (this.grafo.getGrafo().hayArista(indice)) {
						// agrego la arista al árbol
						this.arbol.add(new Arista(nodo, i));
						// marco el nodo actual como terminado
						this.nodoTerminado[nodo] = true;
						// apilo el otro nodo de la arista para seguir recorriendo a partir de él
						pila.push(i);
						// indico que se encontró un nodo adyacente
						adyacente = true;
						// rompo el ciclo para seguir recorriendo a partir del nuevo nodo apilado
						break;
					}
				}
			}
			
			// si no se encontró algún nodo adyacente
			if (!adyacente) {
				// desapilo el nodo de la cima de la pila y lo marco como terminado
				nodo = pila.pop();
				this.nodoTerminado[nodo] = true;
			} else {
				// reestablezco el valor de la bandera
				adyacente = false;
			}
		}
		
		// escribo la solucion en consola
		this.escribirSolucionEnConsola();

	}

	public void escribirSolucionEnConsola() {
		System.out.println("DFS: Búsqueda en Profundidad:");
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Raíz del Árbol): " + this.nodoInicial);
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol) {
			System.out.println(rama.getNodo1() + " " + rama.getNodo2());
		}
	}

}
