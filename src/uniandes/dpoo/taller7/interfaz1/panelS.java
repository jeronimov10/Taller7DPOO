package uniandes.dpoo.taller7.interfaz1;



import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelS extends JPanel {
	
	private JLabel jugadas;
	private JTextField valorJugadas;
	private JLabel jugador;
	private JTextField nombreJugador;
	
	
	
	public panelS(String njugador) {
		
		setLayout(new GridLayout(1, 4));
		
		jugadas = new JLabel("Jugadas: ");
		valorJugadas = new JTextField("0");
		valorJugadas.setEditable(false);
	
		jugador = new JLabel("Jugador: ");
		nombreJugador = new JTextField(njugador);
		nombreJugador.setEditable(false);
		
		
		
		
		add(jugadas);
		add(valorJugadas);
		add(jugador);
		add(nombreJugador);
		
	
	}
	
	
	public void actualizarNombreJugador(String nuevoNombre) {
		
		nombreJugador.setText(nuevoNombre);
	}
	

	
	

}
