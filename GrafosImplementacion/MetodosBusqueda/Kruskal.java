package GrafosImplementacion.MetodosBusqueda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import GrafosImplementacion.GenerarGrafos.GrafoNDP;
import GrafosImplementacion.NodosYmatrices.AristaPonderada;

public class Kruskal {

	private GrafoNDP grafo;
	private int cantNodos;
	private int cantAristas;
	
	private ArrayList<AristaPonderada> aristas;
	private ArrayList<AristaPonderada> arbol;
	private int[] padres;
	
	private int minimoCosto;

	public GrafoNDP getGrafo() {
		return grafo;
	}

	public int getCantNodos() {
		return cantNodos;
	}
	
	public int getCantAristas() {
		return cantAristas;
	}

	public int getMinimoCosto() {
		return minimoCosto;
	}
	
	public Kruskal(GrafoNDP grafo) {
		this.grafo = grafo;
		this.cantNodos = this.grafo.getGrafo().getOrdenMatriz();
		this.cantAristas = this.grafo.getCantAristas();
		
		this.aristas = new ArrayList<AristaPonderada>();
		this.arbol = new ArrayList<AristaPonderada>();
		this.padres = new int[this.cantNodos];
		this.inicializarPadres();
		this.minimoCosto = 0;
	}
	
	public void ejecutar() throws IOException {
		
		int indice;
		
		// armo la lista de aristas
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i + 1; j < this.cantNodos; j++) {
				indice = this.grafo.getGrafo().getIndice(i, j);
				
				if (this.grafo.getGrafo().hayArista(indice)) {
					this.aristas.add(new AristaPonderada(i, j ,this.grafo.getPesoArista(indice)));
				}
			}
		}
		
		// ordeno la lista de aristas de menor a mayor por costo
		Collections.sort(this.aristas);
		
		int nodo1;
		int nodo2;
		int peso;
		
		// recorro la lista de aristas
		for (AristaPonderada arista : this.aristas) {
			// leo los datos de la arista
			nodo1 = arista.getNodo1();
			nodo2 = arista.getNodo2();
			peso = arista.getPeso();
			
			// si los nodos de la arista no tienen el mismo padre
			if (find(nodo1) != find(nodo2)) {
				// les pongo el mismo padre;
				union(nodo1, nodo2);
				// agrego la arista al arbol abarcador mínimo
				this.arbol.add(arista);
				// acumulo el peso de la arista al costo mínimo
				this.minimoCosto += peso;
			}
		}
		
		// escribo la solucion en consola
		this.escribirSolucionEnConsola();
		
	}
	
	public void inicializarPadres() {
		for (int i = 0; i < padres.length; i++) {
			this.padres[i] = i;
		}
	}
	
	public int find(int nodo) {
		return this.padres[nodo] == nodo ? nodo : find(this.padres[nodo]);
	}
	
	public void union(int nodo1, int nodo2) {
		this.padres[find(nodo1)] = this.padres[find(nodo2)];
	}
	
	public void escribirSolucionEnConsola() {
		System.out.println("KRUSKAL:");
		System.out.println("Costo del Árbol Abarcador Mínimo: " + this.minimoCosto);
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Lista de Ramas:");
		for (AristaPonderada rama : arbol) {
			System.out.println(rama.getNodo1() + " " + rama.getNodo2());
		}
	}

}
