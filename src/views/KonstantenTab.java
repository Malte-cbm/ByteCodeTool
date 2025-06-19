package views;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class KonstantenTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> konstanten = new JList<String>();
	
	public KonstantenTab() {
		
		setLayout(new GridLayout(0, 1));
		
		JPanel steuerElemente = new JPanel();
		steuerElemente.setLayout(new FlowLayout());
		
		JPanel steuerElementeSuche = new JPanel();
		steuerElementeSuche.setLayout(new GridLayout(0, 1));
		JLabel sucheLabel = new JLabel("Suche: ");
		steuerElementeSuche.add(sucheLabel);
		JTextField sucheField = new JTextField(10);
		steuerElementeSuche.add(sucheField);
		
		steuerElemente.add(steuerElementeSuche);
		
		JPanel steuerElementeFilter = new JPanel();
		steuerElementeFilter.setLayout(new GridLayout(0, 1));
		JLabel filterLabel = new JLabel("Object Filter: ");
		steuerElementeFilter.add(filterLabel);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		
		JComboBox<String> comboBoxFilter = new JComboBox<String>(model);
		steuerElementeFilter.add(comboBoxFilter);

		steuerElemente.add(steuerElementeFilter);		
		
		add(steuerElemente);
		
		JScrollPane konstantenPool = new JScrollPane(konstanten);
		add(konstantenPool);
	}

}
