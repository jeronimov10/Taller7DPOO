package uniandes.dpoo.taller7.interfaz1;



import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelS extends JPanel {
	
	private JLabel jugadas;
	private JLabel valorJugadas;
	private JLabel jugador;
	private JLabel nombreJugador;
	
	
	
	public panelS(String njugador) {
		
		setLayout(new GridLayout(1, 4));
		
		jugadas = new JLabel("Jugadas: ");
		valorJugadas = new JLabel("0");
		
		jugador = new JLabel("Jugador: ");
		nombreJugador = new JLabel(njugador);
		
		add(jugadas);
		add(valorJugadas);
		add(jugador);
		add(nombreJugador);
		
	
	}
	

	
	

}
