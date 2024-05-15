package uniandes.dpoo.taller7.interfaz1;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import uniandes.dpoo.taller7.modelo.Tablero;

import javax.swing.JPanel;

public class panelC extends JPanel implements MouseListener {
	
	int tamanhoT;
	
	public panelC(Tablero tablero, int tamanhoT) {
		
		
		
		
		
	}
	
	public void crearTablero (Tablero tablero, int tamanhoT) {
		setLayout(new GridLayout(tamanhoT, tamanhoT));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
