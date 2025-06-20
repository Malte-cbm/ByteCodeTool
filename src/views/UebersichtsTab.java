package views;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ObserverFace;
import model.DatenContainer;

public class UebersichtsTab extends JPanel implements ObserverFace{
	
	private static final long serialVersionUID = 1L;

	
	public UebersichtsTab() {
		setLayout(new GridLayout(0, 1));
		
		JPanel gruppenDaten = new JPanel();
		gruppenDaten.setLayout(new GridLayout(0 , 2));
		
		JPanel gruppe1 = new JPanel();
		gruppe1.setLayout(new GridLayout(0, 2));
		
		JPanel gruppe2 = new JPanel();
		gruppe2.setLayout(new GridLayout(0, 2));

		JLabel magicLabel = new JLabel("Magic Number");
		gruppe1.add(magicLabel);
		JTextField magicField = new JTextField(10);
		gruppe1.add(magicField);
		
		JLabel minorLabel = new JLabel("Minor Version");
		gruppe1.add(minorLabel);
		JTextField minorField = new JTextField(10);
		gruppe1.add(minorField);
		
		JLabel majorLabel = new JLabel("Major Number");
		gruppe1.add(majorLabel);
		JTextField majorField = new JTextField(10);
		gruppe1.add(majorField);
		
		
		
		JLabel konstantenSummeLabel = new JLabel("Anzahl Konstanten");
		gruppe2.add(konstantenSummeLabel);
		JTextField konstantenSummeField = new JTextField(10);
		gruppe2.add(konstantenSummeField);
		
		JLabel interfacesSummeLabel = new JLabel("Anzahl Interfaces");
		gruppe2.add(interfacesSummeLabel);
		JTextField interfacesSummeField = new JTextField(10);
		gruppe2.add(interfacesSummeField);
		
		JLabel felderSummeLabel = new JLabel("Anzahl Felder");
		gruppe2.add(felderSummeLabel);
		JTextField felderSummeField = new JTextField(10);
		gruppe2.add(felderSummeField);
		
		JLabel methodenSummeLabel = new JLabel("Anzahl Methoden");
		gruppe2.add(methodenSummeLabel);
		JTextField methodenSummeField = new JTextField(10);
		gruppe2.add(methodenSummeField);
		
		JLabel attributeSummeLabel = new JLabel("Anzahl Attribute");
		gruppe2.add(attributeSummeLabel);
		JTextField attributeSummeField = new JTextField(10);
		gruppe2.add(attributeSummeField);
		
		gruppenDaten.add(gruppe1);
		gruppenDaten.add(gruppe2);
		
		add(gruppenDaten);
		
		JPanel javaDaten = new JPanel();
		javaDaten.setLayout(new GridLayout(0, 2));
		
		JLabel flagsLabel = new JLabel("Access Flags");
		javaDaten.add(flagsLabel);
		JTextField flagsField = new JTextField(10);
		javaDaten.add(flagsField);
		
		JLabel thisClassLabel = new JLabel("This Class");
		javaDaten.add(thisClassLabel);
		JTextField thisClassField = new JTextField(10);
		javaDaten.add(thisClassField);
		
		JLabel superClassLabel = new JLabel("Super Class");
		javaDaten.add(superClassLabel);
		JTextField superClassField = new JTextField(10);
		javaDaten.add(superClassField);
		
		add(javaDaten);
		
		JPanel interfaceDaten = new JPanel();
		interfaceDaten.setLayout(new GridLayout(0, 1));
		JLabel interfacesLabel = new JLabel("Implements:");
		interfaceDaten.add(interfacesLabel);
		JTextField interfacesField = new JTextField(10);
		interfaceDaten.add(interfacesField);
		
		add(interfaceDaten);
		
		JPanel attributDaten = new JPanel();
		attributDaten.setLayout(new GridLayout(0, 1));
		JLabel attributLabel = new JLabel("Attributes:");
		attributDaten.add(attributLabel);
		JTextField attributField = new JTextField(10);
		attributDaten.add(attributField);
		
		add(attributDaten);

	}
	
	@Override
	public void update(DatenContainer datenContainer) {
		
	}

}
