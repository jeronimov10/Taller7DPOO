package uniandes.dpoo.taller7.interfaz1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
		crearTablero();
		Listeners();
		

	}
	

	public void crearTablero() {
		int tamanhoT = tablero.darTablero().length;
		setLayout(new GridLayout(tamanhoT, tamanhoT));
		boolean [][] matrizTablero = tablero.darTablero();
		
		Random random = new Random();
		
		for (int i = 0; i < tamanhoT; i++) { 
			 for (int j = 0; j < tamanhoT; j++) { 
				 matrizTablero[i][j] = random.nextBoolean();
			 }
		}
		
		
		for (int i = 0; i < tamanhoT; i++) { 
			 for (int j = 0; j < tamanhoT; j++) { 
				 Casilla c = new Casilla(i,j, matrizTablero[i][j]);
				 add(c);
			 }
		}
		
	}
	
	private void Listeners() {
		for (int i = 0; i < getComponentCount(); i++) {
			Casilla c = (Casilla) getComponent(i);
			c.addMouseListener(this);
		}
	}
	
	
	
	public void actualizarTablero(Tablero nuevoTablero) {
		this.tablero = nuevoTablero;
		removeAll();
		crearTablero();
		revalidate();
		repaint();
		
	}
	
	public void victoria(Tablero nuevotablero) {
		JOptionPane.showMessageDialog(this, "You won","Victoria", JOptionPane.INFORMATION_MESSAGE);
		int opcion = JOptionPane.showConfirmDialog(this, "Desea jugar otra vez?", "reiniciar", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			nuevotablero.reiniciar();
			actualizarTablero(nuevotablero);
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
	
	private class Casilla extends JPanel {
		private int fila;
		private int columna;
		private boolean encendida;
		private JLabel labelIcono;
		
		
		public Casilla(int fila, int columna, boolean encendida) {
			this.fila = fila;
			this.columna = columna;
			this.encendida = encendida;
			
			
			labelIcono = new JLabel();
			actualizarEstadoV();
			add(labelIcono);
			
			
			
			
}
		
		private void actualizarEstadoV() {
			if (encendida) {
				setBackground(Color.YELLOW);
				labelIcono.setIcon(luz);
				
			} else {
				setBackground(new Color(10,10,10));
				labelIcono.setIcon(luz);
			}
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
