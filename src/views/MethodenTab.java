package views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ObserverFace;
import model.DatenContainer;

public class MethodenTab extends JPanel implements ObserverFace{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JList<String> methoden = new JList<String>();
	
	public MethodenTab() {
		
		setLayout(new GridLayout(0, 1));
		
		JScrollPane methodenListe= new JScrollPane(methoden);
		add(methodenListe);

		JPanel methodenDetails = new JPanel();
		methodenDetails.setLayout(new GridLayout(0, 2));
		
		JPanel methodenDaten = new JPanel();
		methodenDaten.setLayout(new GridLayout(0, 2));
		
		JLabel nameMethodenLabel = new JLabel("Name:");
		methodenDaten.add(nameMethodenLabel);
		JTextField methodenField = new JTextField(10);
		methodenDaten.add(methodenField);
		
		JLabel deskriptorMethodenLabel = new JLabel("Deskriptor");
		methodenDaten.add(deskriptorMethodenLabel);
		JTextField deskriptorMethodenField = new JTextField(10);
		methodenDaten.add(deskriptorMethodenField);
		
		JLabel accFlagsMethodenLabel = new JLabel("Access Flags:");
		methodenDaten.add(accFlagsMethodenLabel);
		JTextField accFlagsMethodenField = new JTextField(10);
		methodenDaten.add(accFlagsMethodenField);
		
		methodenDetails.add(methodenDaten);
		
		JPanel methodenAttribute = new JPanel();
		methodenAttribute.setLayout(new GridLayout(0, 1));

		JLabel attributMethodenLabel = new JLabel("Attribute:");
		methodenAttribute.add(attributMethodenLabel);
		JScrollPane methodenAttributListe = new JScrollPane();
		methodenAttribute.add(methodenAttributListe);
		
		methodenDetails.add(methodenAttribute);
		
		add(methodenDetails);
		
		JScrollPane byteCodeListeMethoden = new JScrollPane();
		add(byteCodeListeMethoden);
	}
	
	@Override
	public void update(DatenContainer datenContainer) {
		
	}

}
