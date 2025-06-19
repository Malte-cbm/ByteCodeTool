package views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FelderTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JList<String> felder = new JList<String>();

	public FelderTab() {
		
		setLayout(new GridLayout(0, 1));
		
		JScrollPane felderListe= new JScrollPane(felder);
		add(felderListe);
		
		JPanel feldDetails = new JPanel();
		feldDetails.setLayout(new GridLayout(0, 2));
		
		JPanel feldDaten = new JPanel();
		feldDaten.setLayout(new GridLayout(0, 2));
		
		JLabel nameFeldLabel = new JLabel("Name:");
		feldDaten.add(nameFeldLabel);
		JTextField feldField = new JTextField(10);
		feldDaten.add(feldField);
		
		JLabel deskriptorLabel = new JLabel("Deskriptor");
		feldDaten.add(deskriptorLabel);
		JTextField deskriptorField = new JTextField(10);
		feldDaten.add(deskriptorField);
		
		JLabel accFlagsLabel = new JLabel("Access Flags:");
		feldDaten.add(accFlagsLabel);
		JTextField accFlagsField = new JTextField(10);
		feldDaten.add(accFlagsField);
		
		feldDetails.add(feldDaten);
		
		JPanel feldAttribute = new JPanel();
		feldAttribute.setLayout(new GridLayout(0, 1));

		JLabel attributLabel = new JLabel("Attribute:");
		feldAttribute.add(attributLabel);
		JScrollPane feldAttributListe = new JScrollPane();
		feldAttribute.add(feldAttributListe);
		
		feldDetails.add(feldAttribute);
		
		add(feldDetails);
		
		JScrollPane byteCodeListe = new JScrollPane();
		add(byteCodeListe);
	}

}
