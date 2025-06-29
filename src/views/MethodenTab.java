package views;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ObserverFace;
import model.AttributInfoModell;
import model.ConstantUtf8;
import model.DatenContainer;
import model.FieldInfoModell;
import model.MethodInfoModell;

public class MethodenTab extends JPanel implements ObserverFace{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JList<MethodInfoModell> methods = new JList<MethodInfoModell>();
	private DefaultListModel<MethodInfoModell> listModelMethods = new DefaultListModel<MethodInfoModell>();

	private JList<AttributInfoModell> attribute = new JList<AttributInfoModell>();
	private DefaultListModel<AttributInfoModell> listModelAttributes = new DefaultListModel<AttributInfoModell>();
	
	private JScrollPane methodenListe;
	private JTextField methodenField;
	private JTextField deskriptorMethodenField;
	private JTextField accFlagsMethodenField;
	
	private JScrollPane methodenAttributListe;
	private JScrollPane byteCodeListeMethoden;
	
	public MethodenTab() {
		
		setLayout(new GridLayout(0, 1));
		
		this.methods.setModel(listModelMethods);
		this.methods.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				MethodInfoModell methodenWahl = methods.getSelectedValue();
				methodenField.setText(methodenWahl.getNameString()
);				deskriptorMethodenField.setText(methodenWahl.getDeskriptorString());
				accFlagsMethodenField.setText(String.valueOf(methodenWahl.getAccess_flags()));
				listModelAttributes = new DefaultListModel<AttributInfoModell>();
				
				//scrollpane attribute
				for (AttributInfoModell aModell: methodenWahl.getAttributListe()) {
					listModelAttributes.addElement(aModell);
				}
			}
		});
		this.methodenListe = new JScrollPane(methods);
		add(methodenListe);

		JPanel methodenDetails = new JPanel();
		methodenDetails.setLayout(new GridLayout(0, 2));
		
		JPanel methodenDaten = new JPanel();
		methodenDaten.setLayout(new GridLayout(0, 2));
		
		JLabel nameMethodenLabel = new JLabel("Name:");
		methodenDaten.add(nameMethodenLabel);
		this.methodenField = new JTextField(10);
		methodenDaten.add(methodenField);
		
		JLabel deskriptorMethodenLabel = new JLabel("Deskriptor");
		methodenDaten.add(deskriptorMethodenLabel);
		this.deskriptorMethodenField = new JTextField(10);
		methodenDaten.add(deskriptorMethodenField);
		
		JLabel accFlagsMethodenLabel = new JLabel("Access Flags:");
		methodenDaten.add(accFlagsMethodenLabel);
		this.accFlagsMethodenField = new JTextField(10);
		methodenDaten.add(accFlagsMethodenField);
		
		methodenDetails.add(methodenDaten);
		
		JPanel methodenAttribute = new JPanel();
		methodenAttribute.setLayout(new GridLayout(0, 1));

		JLabel attributMethodenLabel = new JLabel("Attribute:");
		methodenAttribute.add(attributMethodenLabel);
		this.methodenAttributListe = new JScrollPane();
		methodenAttribute.add(methodenAttributListe);
		
		methodenDetails.add(methodenAttribute);
		
		add(methodenDetails);
		
		this.byteCodeListeMethoden = new JScrollPane();
		add(byteCodeListeMethoden);
	}
	
	@Override
	public void update(DatenContainer datenContainer) {
		
		for ( MethodInfoModell model: datenContainer.getMethods()) {
			
			
			
			if( datenContainer.getConstant_pool().get(model.getName_index()-1) instanceof ConstantUtf8 obj) {
				
				model.setNameString(obj.getInhalt());
				if( datenContainer.getConstant_pool().get(model.getDeskriptor_index()-1) instanceof ConstantUtf8 ubj) {
					model.setDeskriptorString(ubj.getInhalt());
				}
			}
			
			this.listModelMethods.addElement(model);
		}
		
		
	}

}
