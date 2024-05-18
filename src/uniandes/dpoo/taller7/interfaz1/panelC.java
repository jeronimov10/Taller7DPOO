package uniandes.dpoo.taller7.interfaz1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;


import javax.swing.JPanel;




public class panelC extends JPanel implements MouseListener {
	
	int tamanhoT;
	
	private Tablero tablero;
	private ImageIcon luz = new ImageIcon("data/luz.png");
	private Icon iconLuz;
	
	
	
	
	
	
	public panelC(Tablero tablero, int tamanhoT) {
		this.tablero = tablero;
		crearTablero();
		

	}
	
	public void crearTablero() {
		int tamanhoT = tablero.darTablero().length;
		setLayout(new GridLayout(tamanhoT, tamanhoT));
		boolean [][] matrizTablero = tablero.darTablero();
		
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
	
	
	
	public void actualizarTablero() {
		removeAll();
		crearTablero();
		revalidate();
		repaint();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof Casilla) { 
			Casilla c = (Casilla) e.getSource();
			tablero.jugar(c.getFila(), c.getColumna());
			actualizarTablero();
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
		
		public Casilla(int fila, int columna, boolean encendida) {
			this.fila = fila;
			this.columna = columna;
			this.encendida = encendida;
			setOpaque(false);
			setBackground(encendida ? Color.yellow : Color.BLACK);
			if (encendida) {
				add(new JLabel(new ImageIcon("data/luz.png")));
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
