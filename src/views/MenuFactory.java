package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFactory extends JMenuBar implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MenuFactory(HashMap<String, ArrayList<String>> aufbau){
		
		super();
		for (String i: aufbau.keySet()){
		    
		    JMenu reiter = baueReiter(i, aufbau.get(i));
		    this.add(reiter);
		}
	    }

		    

		 
	    private JMenu baueReiter(String name,  ArrayList<String> subpunkte){

		JMenu reiter = new JMenu(name);


		for(String i: subpunkte){
		    
		    JMenuItem subPunktItem = baueSubMenu(i);
		    reiter.add(subPunktItem);
		    
		}
		return reiter;
	    };


	    private JMenuItem baueSubMenu(String name){

		JMenuItem subPunktItem = new JMenuItem(name);
		subPunktItem.addActionListener(this);
		subPunktItem.setActionCommand(name);
		return subPunktItem;

	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
