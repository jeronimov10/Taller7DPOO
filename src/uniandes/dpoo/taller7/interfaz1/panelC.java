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
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import uniandes.dpoo.taller7.modelo.Tablero;


import uniandes.dpoo.taller7.interfaz1.panelS;






public class panelC extends JPanel implements MouseListener {
	
	private int tamanhoT;
	
	private float posX = 0;
	private float posY = 0;
	private float tamX;
	private float tamY;
	
	private Tablero tablero;
	private ImageIcon luz = new ImageIcon("data/luz.png");
	
	private int jugadas;
	private panelS panelS;
	private interfazPrincipale mainFrame;
	private RoundRectangle2D[][] casillasB;
	private RoundRectangle2D[][] contorno;
	
	
	
	
	
	public panelC(Tablero tablero, int tamanhoT, panelS panelS, interfazPrincipale mainFrame) {
		this.tablero = tablero;
		this.tamanhoT = tamanhoT;
		this.panelS = panelS;
		this.mainFrame = mainFrame;
		this.jugadas = 0;
		tablero = new Tablero(tamanhoT);
		tablero.desordenar(3);
		crearTablero(tablero);
		
		

	}
	

	public void crearTablero(Tablero tablero) {
		tamX = 500/tamanhoT;
		tamY = 500/tamanhoT;
		setLayout(new GridLayout(tamanhoT, tamanhoT));
		boolean[][] tab = tablero.darTablero();
		casillasB = new RoundRectangle2D[tamanhoT][tamanhoT];
		contorno = new RoundRectangle2D[tamanhoT][tamanhoT];
		Icon icono = new ImageIcon(luz.getImage().getScaledInstance((int)tamX-5, (int)tamY-5, Image.SCALE_DEFAULT));
		 for (int i = 0; i < tamanhoT; i++) {
		        for (int j = 0; j < tamanhoT; j++) {
		        	casillasB[i][j] = new RoundRectangle2D.Double(posX + (j * tamX), posY + (i * tamY), tamX, tamY, 15, 15);
		        	contorno[i][j] = new RoundRectangle2D.Double(posX + (j * tamX), posY + (i * tamY), tamX, tamY, 15, 15);
		        	//setBackground(Color.YELLOW);
		        	if(!tab[i][j]) {
		        		//setBackground(new Color(10,10,10));
		        	}
		        	JLabel iconoLuz = new JLabel();
		    		iconoLuz.setIcon(icono);
		        	add(iconoLuz);
		        }
		    }
		
		
		
	}
	

	
	public void cambiarTamanhoTablero(int tamanho) {
		removeAll();
		this.tamanhoT = tamanho;
		Tablero newTablero = new Tablero(tamanho);
		crearTablero(newTablero);
		revalidate();
		repaint();
	}

	

	public void actualizarTablero(Tablero nuevoTablero) {
	    this.tablero = nuevoTablero;
	    removeAll();
	    crearTablero(tablero);
	    revalidate();
	    repaint();
	    
	    
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		for (int i = 0; i < tamanhoT; i++) {
			for (int j = 0; j < tamanhoT; j++) {
				if (tablero.darTablero()[i][j]) {
					g2.setColor(Color.YELLOW);
				}else {
					g2.setColor(new Color(10,10,10));
				}
				g2.draw(casillasB[i][j]);
				g2.fill(casillasB[i][j]);
			}
		}
		g2.setColor(new Color(10,10,10));
		for (int ind = 0; ind < contorno.length; ind++) {
			for (int ind2 = 0; ind2 < contorno.length; ind2++) {
				g2.draw(contorno[ind][ind2]);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		tablero.jugar(casilla[0], casilla[1]);
		repaint();
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y){
		int ladoTablero = tablero.darTablero().length;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero;
		int anchoCasilla = anchoPanelTablero / ladoTablero;
		int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
		return new int[] { fila, columna };
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
	

}