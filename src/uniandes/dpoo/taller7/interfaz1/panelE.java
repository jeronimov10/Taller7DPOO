package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class panelE extends JPanel implements ActionListener {
	
	private JButton Nuevo;
	private JButton Reinciar;
	private JButton Top10;
	private JButton ChangeJugador;
	private interfazPrincipale mainFrame;
	private JComboBox<String> tamanho;
	
	
	
	
	
	public panelE(interfazPrincipale mainFrame) {
		this.mainFrame = mainFrame;
		this.tamanho = tamanho;
		
		
		setLayout(new GridLayout(9, 1));
		Nuevo = new JButton("Nuevo");
		Nuevo.setBackground(new Color(41,137,223));
		Nuevo.addActionListener(this);
		
		Reinciar = new JButton("Reinciar");
		Reinciar.setBackground(new Color(41,137,223));
		Reinciar.addActionListener(this);
		
		Top10 = new JButton("Top 10");
		Top10.setBackground(new Color(41,137,223));
		Top10.addActionListener(this);
		
		ChangeJugador = new JButton("Cambiar Jugador");
		ChangeJugador.setBackground(new Color(41,137,223));
		ChangeJugador.addActionListener(this);
		
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
		
		if (e.getSource() == ChangeJugador) {
			DialogoCambiarJugador d = new DialogoCambiarJugador(mainFrame);
			d.setVisible(true);
			
			if(d.Aceptado()) {
				String nuevoNombre = d.getNombreJugador();
				mainFrame.actualizarNombreJugador(nuevoNombre);
			}
		} else if (e.getSource()== Top10) {
				abrirTop10();
			
			
			
		} else if (e.getSource() == Reinciar) {
			mainFrame.reiniciarJuego();
		}
			
		
		
		
	}
	
	private void abrirTop10() {
		
		JDialog top10D = new JDialog(mainFrame, "Top 10 puntajes", true);
		top10D.setSize(300, 400);
		top10D.setLayout(new BorderLayout());
		
		Collection<RegistroTop10> top10 = mainFrame.getTop10().darRegistros();
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		for (RegistroTop10 registro : top10) {
			
			listModel.addElement(registro.toString());
			
		}
		
		JList<String> top10List = new JList<String>(listModel);
		
		JScrollPane scrollPane = new JScrollPane(top10List);
		
		top10D.add(scrollPane, BorderLayout.CENTER);
		
		top10D.setLocationRelativeTo(mainFrame);
		top10D.setVisible(true);
		
		
	}
	
	

}
