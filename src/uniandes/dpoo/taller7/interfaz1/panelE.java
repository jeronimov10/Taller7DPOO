package uniandes.dpoo.taller7.interfaz1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelE extends JPanel implements ActionListener {
	
	JButton Nuevo;
	JButton Reinciar;
	JButton Top10;
	JButton ChangeJugador;
	
	
	
	public panelE() {
		
		setLayout(new GridLayout(9, 1));
		Nuevo = new JButton("Nuevo");
		Nuevo.setBackground(new Color(41,137,223));
		Reinciar = new JButton("Reinciar");
		Reinciar.setBackground(new Color(41,137,223));
		Top10 = new JButton("Top 10");
		Top10.setBackground(new Color(41,137,223));
		ChangeJugador = new JButton("Cambiar Jugador");
		ChangeJugador.setBackground(new Color(41,137,223));
		
		add (new JLabel(" "));
		add (Nuevo);
		add (new JLabel(" "));
		add (Reinciar);
		add (new JLabel(" "));
		add (Top10);
		add (new JLabel(" "));
		add (ChangeJugador);
		add (new JLabel(" "));
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stu
		
	}
	
	

}
