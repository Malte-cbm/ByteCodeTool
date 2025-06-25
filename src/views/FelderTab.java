package views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ObserverFace;
import model.DatenContainer;

public class FelderTab extends JPanel implements ObserverFace{


	private static final long serialVersionUID = 1L;
	
	private JList<String> felder = new JList<String>();
	
	private JTextField feldField;
	private JTextField deskriptorFelderField;
	private JTextField accFlagsFelderField;
	
	private JScrollPane feldAttributListe;
	private JScrollPane byteCodeListeFelder;
	
	

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
		this.feldField = new JTextField(10);
		feldDaten.add(feldField);
		
		JLabel deskriptorFelderLabel = new JLabel("Deskriptor");
		feldDaten.add(deskriptorFelderLabel);
		this.deskriptorFelderField = new JTextField(10);
		feldDaten.add(deskriptorFelderField);
		
		JLabel accFlagsFelderLabel = new JLabel("Access Flags:");
		feldDaten.add(accFlagsFelderLabel);
		this.accFlagsFelderField = new JTextField(10);
		feldDaten.add(accFlagsFelderField);
		
		feldDetails.add(feldDaten);
		
		JPanel feldAttribute = new JPanel();
		feldAttribute.setLayout(new GridLayout(0, 1));

		JLabel attributFelderLabel = new JLabel("Attribute:");
		feldAttribute.add(attributFelderLabel);
		this.feldAttributListe = new JScrollPane();
		feldAttribute.add(feldAttributListe);
		
		feldDetails.add(feldAttribute);
		
		add(feldDetails);
		
		this.byteCodeListeFelder = new JScrollPane();
		add(byteCodeListeFelder);
	}
	
	@Override
	public void update(DatenContainer datenContainer) {
		
		
		
	}

}
