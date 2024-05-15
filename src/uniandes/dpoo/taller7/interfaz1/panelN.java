package uniandes.dpoo.taller7.interfaz1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class panelN extends JPanel implements ActionListener {
	
	JRadioButton LMDP;
	JRadioButton LHDP;
	JRadioButton EP;
	
	
	public panelN() {
		setLayout(new GridLayout(1,8));
		setBackground(new Color(41,137,223));
		add(new JLabel(" "));
		add (new JLabel("Tamaño: "));
		JComboBox<String> tamanho = new JComboBox<String>();
		
		tamanho.addItem(" 5 x 5 ");
		tamanho.addItem(" 6 x 6 ");
		tamanho.addItem(" 7 x 7 ");
		tamanho.addItem(" 8 x 8 ");
		tamanho.addItem(" 9 x 9 ");
		tamanho.addItem(" 10 x 10 ");
		
		add (tamanho);
		
		add (new JLabel("Dificultade: "));
		
		LMDP = new JRadioButton("Facil");
		LHDP = new JRadioButton("Medio");
		EP = new JRadioButton("Dificil");
		
		LMDP.setBackground(new Color(41,137,223));
		LMDP.addActionListener(this);
		LMDP.setSelected(true);
		
		LHDP.setBackground(new Color(41,137,223));
		LHDP.addActionListener(this);
		
		EP.setBackground(new Color(41,137,223));
		EP.addActionListener(this);
		
		add (LMDP);
		add (LHDP);
		add (EP);
		
		add(new JLabel(""));
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == LMDP) {
			LMDP.setSelected(true);
			LHDP.setSelected(false);
			EP.setSelected(false);
			
		}
		else if (e.getSource() == LHDP) {
			LMDP.setSelected(false);
			LHDP.setSelected(true);
			EP.setSelected(false);
			
			
		}
		
		else if (e.getSource() == EP) {
			LMDP.setSelected(false);
			LHDP.setSelected(false);
			EP.setSelected(true);
			
			
		
		
		}
	}
	
	
	
	

}
