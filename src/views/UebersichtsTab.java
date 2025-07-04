package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import controller.ObserverFace;
import model.ConstantClass;
import model.ConstantModelType;
import model.ConstantUtf8;
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
	private JScrollPane interfacesField;
	private JList<ConstantModelType> interfaces = new JList<ConstantModelType>();
	private JScrollPane attributField;
	private JList<ConstantModelType> attributes = new JList<ConstantModelType>();
	
	private DefaultListModel<ConstantModelType> listModelInterfaces;
	private DefaultListModel<ConstantModelType> listModelAttributes;

	
	

	
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
		this.listModelInterfaces = new DefaultListModel<>();
		this.interfaces.setModel(listModelInterfaces);
		this.interfacesField = new JScrollPane(interfaces);

		interfaceDaten.add(interfacesField);
		
		add(interfaceDaten);
		
		JPanel attributDaten = new JPanel();
		attributDaten.setLayout(new GridLayout(0, 1));
		JLabel attributLabel = new JLabel("Attributes:");
		attributDaten.add(attributLabel);
		
		this.listModelAttributes = new DefaultListModel<>();
		this.attributes.setModel(listModelAttributes);
		this.attributField = new JScrollPane(attributes);
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
		
		int thisClassIndexImConstArray = datenContainer.getThis_class()-1;
		
			if( datenContainer.getConstant_pool().get(thisClassIndexImConstArray) instanceof ConstantClass obj) {
				if (datenContainer.getConstant_pool().get(obj.getIndex()-1) instanceof ConstantUtf8 ubj) {
					thisClassField.setText(ubj.getInhalt());
				}
			}
		
		
		int superClassIndexImConstArray = datenContainer.getSuper_class()-1;
		if (superClassIndexImConstArray == 0) {
			superClassField.setText("Object");
		}
		else if( datenContainer.getConstant_pool().get(superClassIndexImConstArray) instanceof ConstantClass obj) {
			
			if (datenContainer.getConstant_pool().get(obj.getIndex()-1) instanceof ConstantUtf8 ubj) {
				superClassField.setText(ubj.getInhalt());
			}
		}
		
		for (int i: datenContainer.getInterfaces()) {
			this.listModelInterfaces.addElement(datenContainer.getConstant_pool().get(i));}
		
		/*for (int i: datenContainer.getAttributes()) {
			this.listModelAttributes.addElement(datenContainer.getConstant_pool().get(i));}
		*/
		interfacesSummeField.setText(String.valueOf(datenContainer.getInterfaces_count()));
		felderSummeField.setText(String.valueOf(datenContainer.getFields_count()));
		methodenSummeField.setText(String.valueOf(datenContainer.getMethods_count()));
		attributeSummeField.setText(String.valueOf(datenContainer.getAttributes_count()));
	}

}
