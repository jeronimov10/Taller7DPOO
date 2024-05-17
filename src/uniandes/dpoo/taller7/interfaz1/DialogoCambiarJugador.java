package uniandes.dpoo.taller7.interfaz1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class DialogoCambiarJugador extends JDialog implements ActionListener {
	
	private JTextField Nombre;
	private JButton Aceptar;
	private JButton Cancelar;
	private String nombreJugador;
	private boolean aceptado;
	
	
	
	
	
	
	

	public DialogoCambiarJugador(JFrame frame) {
		
		super(frame, "Cambiar Jugador", true);
		
		setLayout(new BorderLayout());
		
		JLabel ENombre = new JLabel("Ingrese el nombre del jugador: ");
		Nombre = new JTextField(15);
		
		
		JPanel panelEntrada = new JPanel();
		panelEntrada.add(ENombre);
		panelEntrada.add(Nombre);
		add(panelEntrada, BorderLayout.CENTER);
		
		Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(this);

		Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(this);
		
		JPanel botones = new JPanel();
		botones.add(Aceptar);
		botones.add(Cancelar);
		add(botones, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(frame);
		
		
		
		
	}
	
	public String getNombreJugador() {
		return nombreJugador;
		
	}
	
	public boolean Aceptado() {
		return aceptado;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== Aceptar) {
			nombreJugador = Nombre.getText().trim();
			aceptado = true;
			setVisible(false);
			
			
		} else if (e.getSource()== Cancelar) {
			aceptado = false;
			setVisible(false);
		}
		
	}

}
