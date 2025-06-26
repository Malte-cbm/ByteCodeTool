package views;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ObserverFace;
import model.DatenContainer;

public class UebersichtsTab extends JPanel implements ObserverFace{
	
	private static final long serialVersionUID = 1L;
	private JTextField magicField;
	private JTextField minorField;
	private JTextField majorField;
	
	private JTextField konstantenSummeField;
	private JTextField interfacesSummeField;
	private JTextField felderSummeField;
	private JTextField methodenSummeField;	
	private JTextField attributeSummeField;
	
	private JTextField flagsField;
	private JTextField thisClassField;
	private JTextField superClassField;
	private JTextField interfacesField;
	private JTextField attributField;
	

	
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
		this.magicField = new JTextField(10);
		gruppe1.add(magicField);
		
		JLabel minorLabel = new JLabel("Minor Version");
		gruppe1.add(minorLabel);
		this.minorField = new JTextField(10);
		gruppe1.add(minorField);
		
		JLabel majorLabel = new JLabel("Major Number");
		gruppe1.add(majorLabel);
		this.majorField = new JTextField(10);
		gruppe1.add(majorField);
		
		
		
		JLabel konstantenSummeLabel = new JLabel("Anzahl Konstanten");
		gruppe2.add(konstantenSummeLabel);
		this.konstantenSummeField = new JTextField(10);
		gruppe2.add(konstantenSummeField);
		
		JLabel interfacesSummeLabel = new JLabel("Anzahl Interfaces");
		gruppe2.add(interfacesSummeLabel);
		this.interfacesSummeField = new JTextField(10);
		gruppe2.add(interfacesSummeField);
		
		JLabel felderSummeLabel = new JLabel("Anzahl Felder");
		gruppe2.add(felderSummeLabel);
		this.felderSummeField = new JTextField(10);
		gruppe2.add(felderSummeField);
		
		JLabel methodenSummeLabel = new JLabel("Anzahl Methoden");
		gruppe2.add(methodenSummeLabel);
		this.methodenSummeField = new JTextField(10);
		gruppe2.add(methodenSummeField);
		
		JLabel attributeSummeLabel = new JLabel("Anzahl Attribute");
		gruppe2.add(attributeSummeLabel);
		this.attributeSummeField = new JTextField(10);
		gruppe2.add(attributeSummeField);
		
		gruppenDaten.add(gruppe1);
		gruppenDaten.add(gruppe2);
		
		add(gruppenDaten);
		
		JPanel javaDaten = new JPanel();
		javaDaten.setLayout(new GridLayout(0, 2));
		
		JLabel flagsLabel = new JLabel("Access Flags");
		javaDaten.add(flagsLabel);
		this.flagsField = new JTextField(10);
		javaDaten.add(flagsField);
		
		JLabel thisClassLabel = new JLabel("This Class");
		javaDaten.add(thisClassLabel);
		this.thisClassField = new JTextField(10);
		javaDaten.add(thisClassField);
		
		JLabel superClassLabel = new JLabel("Super Class");
		javaDaten.add(superClassLabel);
		this.superClassField = new JTextField(10);
		javaDaten.add(superClassField);
		
		add(javaDaten);
		
		JPanel interfaceDaten = new JPanel();
		interfaceDaten.setLayout(new GridLayout(0, 1));
		JLabel interfacesLabel = new JLabel("Implements:");
		interfaceDaten.add(interfacesLabel);
		this.interfacesField = new JTextField(10);
		interfaceDaten.add(interfacesField);
		
		add(interfaceDaten);
		
		JPanel attributDaten = new JPanel();
		attributDaten.setLayout(new GridLayout(0, 1));
		JLabel attributLabel = new JLabel("Attributes:");
		attributDaten.add(attributLabel);
		this.attributField = new JTextField(10);
		attributDaten.add(attributField);
		
		add(attributDaten);

	}
	
	@Override
	public void update(DatenContainer datenContainer) {
		
		magicField.setText(datenContainer.getMagic());
		minorField.setText(String.valueOf(datenContainer.getMinor_version()));
		majorField.setText(String.valueOf(datenContainer.getMajor_version()));
		konstantenSummeField.setText(String.valueOf(datenContainer.getConstant_pool_count()));
		flagsField.setText(String.valueOf(datenContainer.getAccess_flags()));
		thisClassField.setText(datenContainer.getConstant_pool().get(datenContainer.getThis_class()).getName());
		
	}

}
