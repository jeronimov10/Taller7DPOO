package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import uniandes.dpoo.taller7.modelo.Tablero;

import javax.swing.JFrame;

public class interfazPrincipale extends JFrame {
	
	private panelN panelN;
	private panelC panelC;
	private Tablero tablero;
	private panelE panelE;
	private panelS panelS;
	String Njugador;
	
	
	int tamanhoT = 5;
	
	
	public interfazPrincipale() {
		
		setSize(665, 585);
		setResizable(true);
		
		setTitle("LIGHTS OUT");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panelN = new panelN();
		add(panelN,BorderLayout.NORTH);
		tablero = new Tablero(5);
		panelC = new panelC(tablero, tamanhoT);
		add(panelC, BorderLayout.CENTER);
		panelE = new panelE();
		add (panelE, BorderLayout.EAST);
		panelS = new panelS(Njugador);
		add(panelS, BorderLayout.SOUTH);
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		interfazPrincipale interfacePrincipale = new interfazPrincipale();
		
		interfacePrincipale.setLocationRelativeTo(null);
		interfacePrincipale.setVisible(true);
		
		
	}
	
	
	
	
	
	

}
