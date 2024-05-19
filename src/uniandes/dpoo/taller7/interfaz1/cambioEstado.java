package uniandes.dpoo.taller7.interfaz1;

import uniandes.dpoo.taller7.modelo.Tablero;

public class cambioEstado {
	
	private Tablero tablero;
	
	public cambioEstado(Tablero tablero) {
		this.tablero = tablero;
		
		
		
	}
	
	
	public void cambiarEstadoCasillaAdyacente(int fila, int columna) {
		cambiarEstadoCasilla(fila, columna);
		cambiarEstadoCasilla(fila - 1, columna);
		cambiarEstadoCasilla(fila + 1, columna);
		cambiarEstadoCasilla(fila, columna - 1);
		cambiarEstadoCasilla(fila, columna + 1);
		
	}
	
	private void cambiarEstadoCasilla(int fila, int columna) {
		if (fila >= 0 && fila < tablero.darTablero().length && columna>= 0 && columna < tablero.darTablero()[0].length) {
			tablero.darTablero()[fila][columna] = !tablero.darTablero()[fila][columna];
		}
	}
	
	public boolean win() {
		boolean[][] matrizTablero = tablero.darTablero();
		
		for (int i = 0; i< matrizTablero.length; i++) {
			for (int j = 0; j < matrizTablero[i].length; j++) {
				if (!matrizTablero[i][j]) {
					
					return false;
				}
			}
		}
		return true;
		
	}
	
	

}
