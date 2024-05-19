package uniandes.dpoo.taller7.interfaz1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import uniandes.dpoo.taller7.modelo.Tablero;

import uniandes.dpoo.taller7.interfaz1.cambioEstado;






public class panelC extends JPanel implements MouseListener {
	
	int tamanhoT;
	
	private Tablero tablero;
	private ImageIcon luz = new ImageIcon("data/luz.png");
	private cambioEstado cambioEstadoI;
	
	
	
	
	
	
	
	
	public panelC(Tablero tablero, int tamanhoT) {
		this.tablero = tablero;
		this.cambioEstadoI = new cambioEstado(tablero);
		cambioEstadoI = new cambioEstado(tablero);
		crearTablero(cambioEstadoI);
		actualizarMouseListeners();
		

	}
	

	public void crearTablero(cambioEstado cambioEstadoI) {
	    int tamanhoT = tablero.darTablero().length;
	    setLayout(new GridLayout(tamanhoT, tamanhoT));
	    boolean[][] matrizTablero = tablero.darTablero();
	    
	    Random random = new Random();
	    
	    for (int i = 0; i < tamanhoT; i++) {
	        for (int j = 0; j < tamanhoT; j++) {
	            matrizTablero[i][j] = random.nextBoolean();
	        }
	    }
	    
	    for (int i = 0; i < tamanhoT; i++) {
	        for (int j = 0; j < tamanhoT; j++) {
	            Casilla c = new Casilla(i, j, matrizTablero[i][j], cambioEstadoI);
	            add(c);
	        }
	    }
	}
	
    private void actualizarMouseListeners() {
        for (Component componente : getComponents()) {
            if (componente instanceof Casilla) {
                Casilla casilla = (Casilla) componente;
                casilla.addMouseListener(this);
            }
        }
    }
	
	
	
	public void actualizarTablero(Tablero nuevoTablero) {
	    this.tablero = nuevoTablero;
	    removeAll();
	    crearTablero(cambioEstadoI);
	    revalidate();
	    repaint();
	    actualizarMouseListeners();
	    actualizarEstadoVi();
	}
	
	public void victoria(Tablero nuevotablero) {
		JOptionPane.showMessageDialog(this, "You won","Victoria", JOptionPane.INFORMATION_MESSAGE);
		int opcion = JOptionPane.showConfirmDialog(this, "Desea jugar otra vez?", "reiniciar", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			nuevotablero.reiniciar();
			actualizarTablero(nuevotablero);
		}
	}
	
	public void actualizarEstadoVi() {
		for (Component componente: getComponents()) {
			if (componente instanceof Casilla) {
				Casilla casilla = (Casilla) componente;
				casilla.actualizarEstadoV();
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof Casilla) { 
			Casilla c = (Casilla) e.getSource();
			int fila = c.getFila();
			int columna = c.getColumna();
			cambioEstadoI.cambiarEstadoCasillaAdyacente(fila, columna);
			actualizarTablero(tablero);
			
			if (cambioEstadoI.win()) {
				victoria(tablero);
			}

			

		}
		
	}
	


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private class Casilla extends JToggleButton {
		private int fila;
		private int columna;
		private boolean encendida;
		private ImageIcon Icono;
		private cambioEstado cambioEstadoI;
		
		
		
		
		public Casilla(int fila, int columna, boolean encendida, cambioEstado cambioEstadoI) {
			this.fila = fila;
			this.columna = columna;
			this.encendida = encendida;
			this.cambioEstadoI = cambioEstadoI;
			
			
			
			
			setPreferredSize(new Dimension(50,50));
			actualizarEstadoV();
			
	        addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                cambiarEstado();
	                cambioEstadoI.cambiarEstadoCasillaAdyacente(fila, columna); 
	                if (cambioEstadoI.win()) {
	                    JOptionPane.showMessageDialog(null, "¡Ganaste y recibiste 1 punto!");
	                }
	            }
	        });
			
	
		
			
			
			
			
}

		
		private void actualizarEstadoV() {
			if (encendida) {
				setBackground(Color.YELLOW);
				Icono = new ImageIcon("data/luz.png");
				
			} else {
				setBackground(new Color(10,10,10));
				Icono = new ImageIcon("data/luz.png");
			}
			setIcon(Icono);
		}
		
		private void cambiarEstado() {
			setSelected(!isSelected());

		}
			
			
		
		
		protected void pintar (Graphics g) {
			super.paint(g);
			if (!encendida) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		}
		public int getFila() {
			return fila;
			
		}
		
		public int getColumna() {
			return columna;
		}
	}
	
	

}
