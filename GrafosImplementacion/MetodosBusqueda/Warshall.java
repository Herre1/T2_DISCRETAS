package GrafosImplementacion.MetodosBusqueda;

import java.io.IOException;


import GrafosImplementacion.GenerarGrafos.GrafoDP;

public class Warshall {

	private static final int INFINITO = -1;
	private GrafoDP grafo;
	private int cantNodos;
	
	private boolean[][] caminos;

	public GrafoDP getGrafo() {
		return grafo;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public boolean[][] getCaminos() {
		return caminos;
	}

	public Warshall(GrafoDP grafo) {
		this.grafo = grafo;
		this.cantNodos = grafo.getCantNodos();
		this.caminos = new boolean[this.cantNodos][this.cantNodos];	
	}
	
	public void ejecutar() throws IOException {
		// armo la matriz booleana para evaluar si hay caminos
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				if (this.grafo.getGrafo()[i][j] != INFINITO && this.grafo.getGrafo()[i][j] != 0) {
					this.caminos[i][j] = true;
				} else {
					this.caminos[i][j] = false;
				}
			}
		}
		
		boolean anterior, ik, kj, actual;
		
		// para cada iteración k del algoritmo
		for (int k = 0; k < this.cantNodos; k++) {
			// para cada fila de la matriz
			for (int i = 0; i < this.cantNodos; i++) {
				// para cada columna de la matriz
				for (int j = 0; j < this.cantNodos; j++) {
					
					// si el pivot ij no está en la diagonal principal ni en la fila k o columna k
					if (i != j && k != i && k != j) {
						// existe camino en la iteración anterior
						anterior = this.caminos[i][j];
						
						// existe camino usando como intermediario al nodo k
						ik = this.caminos[i][k];
						kj = this.caminos[k][j];
						actual = (ik && kj);
								
						// existe algún camino
						this.caminos[i][j] = (anterior || actual);
					}
				}
			}
		}
		
		// muestro solución en consola
		this.escribirSolucionEnConsola();
				
			
	}

	private void escribirSolucionEnConsola() {
		System.out.println("WARSHALL: Caminos entre todos los nodos ");
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				System.out.println("Nodo Inicial: " + i + " Nodo Final: " + j + " Existe camino: " + this.caminos[i][j]);
			}
		}	
	}
	

}
