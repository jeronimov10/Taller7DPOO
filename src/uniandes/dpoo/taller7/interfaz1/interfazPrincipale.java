package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;


public class interfazPrincipale extends JFrame {
	
	private panelN panelN;
	private panelC panelC;
	private Tablero tablero;
	private panelE panelE;
	private panelS panelS;
	String Njugador = "jugador";
	private int tamanhoTablero = 5;
	private int dificultad = 1;
	private Top10 top10;
	private JComboBox<String> tamanho;

	
	
	public interfazPrincipale() {
		
		setSize(665, 585);
		setResizable(true);
		
		setTitle("LIGHTS OUT");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		
		panelN = new panelN(this);
		add(panelN,BorderLayout.NORTH);
		tablero = new Tablero(5);
		panelC = new panelC(tablero, tamanhoTablero);
		add(panelC, BorderLayout.CENTER);
		panelE = new panelE(this);
		add (panelE, BorderLayout.EAST);
		panelS = new panelS(Njugador);
		add(panelS, BorderLayout.SOUTH);
		
		top10 = new Top10();
		NombreInicial();
		
	
		
	}
	
	
	
	public static void main(String[] args) {
		interfazPrincipale interfacePrincipale = new interfazPrincipale();
		
		interfacePrincipale.setLocationRelativeTo(null);
		interfacePrincipale.setVisible(true);
		
		
	}
	
	private void NombreInicial() {
		
		DialogoCambiarJugador nombre = new DialogoCambiarJugador(this);
		nombre.setVisible(true);
		
		if (nombre.Aceptado()) {
			Njugador = nombre.getNombreJugador();
			
			
		} else {
			Njugador = "Jugador";
		}
		
		
		
		
	}
	
	public void reiniciarJuego() {
		tablero = new Tablero(tamanhoTablero);
		tablero.desordenar(dificultad * 10);
		panelC.actualizarTablero(tablero);
	}
	public void cambiarTamanhoTablero(int nuevoTamanho) {
		this.tamanhoTablero = nuevoTamanho;
		tablero = new Tablero(tamanhoTablero);
		
		panelC.actualizarTablero(tablero);
		
		revalidate();
		repaint();
		
		
		revalidate();
		repaint();
	}
	
	public void cambiardificultad(int nuevaDificultad) {
		this.dificultad = nuevaDificultad;
		tablero.desordenar(dificultad * 10);
		
	}
	
	public void actualizarNombreJugador(String NuevoNombre) {
		Njugador = NuevoNombre;
		panelS.actualizarNombreJugador(NuevoNombre);
		
		if (tablero.tableroIluminado()) {
			int puntaje = tablero.calcularPuntaje();
			top10.agregarRegistro(NuevoNombre, puntaje);
		}
		tablero.reiniciar();
	}
	
	public Top10 getTop10() {
		
		return top10;
	}


}
