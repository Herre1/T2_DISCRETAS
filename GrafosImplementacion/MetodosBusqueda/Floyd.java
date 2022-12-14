package GrafosImplementacion.MetodosBusqueda;


import java.io.IOException;

import GrafosImplementacion.GenerarGrafos.GrafoDP;

public class Floyd {

	private static final int INFINITO = -1;
	private GrafoDP grafo;
	private int cantNodos;
	
	private int[][] costosMinimos;


	
	 public GrafoDP getGrafo() {
		return grafo;
	}



	public int getCantNodos() {
		return cantNodos;
	}

	public int[][] getCostosMinimos() {
		return costosMinimos;
	}

	public Floyd(GrafoDP grafo) {
		this.grafo = grafo;
		this.cantNodos = grafo.getCantNodos();
		this.costosMinimos = new int[this.cantNodos][this.cantNodos];	
	}
	
	public void ejecutar() throws IOException {
		// clono la matriz de adyacencia para calcular los costos mínimos
		this.costosMinimos = this.grafo.getGrafo().clone();
		
		int anterior, ik, kj, actual, minimo;
		
		// para cada iteración k del algoritmo
		for (int k = 0; k < this.cantNodos; k++) {
			// para cada fila de la matriz
			for (int i = 0; i < this.cantNodos; i++) {
				// para cada columna de la matriz
				for (int j = 0; j < this.cantNodos; j++) {
					
					// si el pivot ij no está en la diagonal principal ni en la fila k o columna k
					if (i != j && k != i && k != j) {
						// costo de la iteración anterior
						anterior = this.costosMinimos[i][j];
						
						// costo de usar como intermediario al nodo k
						ik = this.costosMinimos[i][k];
						kj = this.costosMinimos[k][j];
						if (ik == INFINITO || kj == INFINITO) {
							actual = INFINITO;
						} else {
							actual = ik + kj;
						}
						
						// selecciono el costo mínimo
						if (actual != INFINITO && (actual < anterior || anterior == INFINITO)) {
							minimo = actual;
						} else {
							minimo = anterior;
						}
						this.costosMinimos[i][j] = minimo;
					}
				}
			}
		}
		
		// muestro solución en consola
		this.escribirSolucionEnConsola();
				

			
	}

	private void escribirSolucionEnConsola() {
		int costo;
		System.out.println("FLOYD: Costos mínimos entre todos los nodos ");
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				costo = this.costosMinimos[i][j];
				if (costo == INFINITO) {
					System.out.println("Nodo Inicial: " + i + " Nodo Final: " + j + " Costo del Camino Más Corto: INFINITO");
				} else {
					System.out.println("Nodo Inicial: " + i + " Nodo Final: " + j + " Costo del Camino Más Corto: " + costo);
				}
			}
		}	
	}
	
	
}
