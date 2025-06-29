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
import model.ConstantClass;
import model.ConstantModelType;
import model.ConstantUtf8;
import model.DatenContainer;
import model.FieldInfoModell;

public class FelderTab extends JPanel implements ObserverFace{


	private static final long serialVersionUID = 1L;
	
	
	private JList<FieldInfoModell> felder = new JList<FieldInfoModell>();
	private DefaultListModel<FieldInfoModell> listModelFields = new DefaultListModel<FieldInfoModell>();

	private JList<AttributInfoModell> attribute = new JList<AttributInfoModell>();
	private DefaultListModel<AttributInfoModell> listModelAttributes = new DefaultListModel<AttributInfoModell>();
	
	private JTextField feldField;
	private JTextField deskriptorFelderField;
	private JTextField accFlagsFelderField;
	
	private JScrollPane felderListe;
	private JScrollPane feldAttributListe;
	private JScrollPane byteCodeListeFelder;
		

	public FelderTab() {
		
		setLayout(new GridLayout(0, 1));
		
		this.felder.setModel(listModelFields);
		this.felder.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				FieldInfoModell feldWahl = felder.getSelectedValue();
				feldField.setText(feldWahl.getFieldName());
				deskriptorFelderField.setText(feldWahl.getFieldDeskriptor());
				accFlagsFelderField.setText(String.valueOf(feldWahl.getAcc_flags()));
				listModelAttributes = new DefaultListModel<AttributInfoModell>();
				
				//scrollpane attribute
				for (AttributInfoModell aModell: feldWahl.getAttributListe()) {
					listModelAttributes.addElement(aModell);
				}
			}
		});
		this.felderListe= new JScrollPane(felder);
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
		this.attribute.setModel(listModelAttributes);
		this.feldAttributListe = new JScrollPane(attribute);
		feldAttribute.add(feldAttributListe);
		
		feldDetails.add(feldAttribute);
		
		add(feldDetails);
		
		this.byteCodeListeFelder = new JScrollPane();
		add(byteCodeListeFelder);
	}
	
	@Override
	public void update(DatenContainer datenContainer) {
		
		for ( FieldInfoModell model: datenContainer.getFields()) {
			
			
			
			if( datenContainer.getConstant_pool().get(model.getFieldNameIndex()-1) instanceof ConstantUtf8 obj) {
				
				model.setFieldName(obj.getInhalt());
				if( datenContainer.getConstant_pool().get(model.getFieldDeskriptorIndex()-1) instanceof ConstantUtf8 ubj) {
					model.setFieldDeskriptor(ubj.getInhalt());
				}
			}
			
			this.listModelFields.addElement(model);
		}
		
	}

}
