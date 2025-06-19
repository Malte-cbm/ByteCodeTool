package views;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ByteCodeToolMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ByteCodeToolMainWindow() {
		
		Sprachen language = new Sprachen();
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu(language.MENUBAR_ITEM_EDIT);
		jmb.add(jm);
		
		jmb.add(new JMenu(language.MENUBAR_ITEM_FILE));
		jmb.add(new JMenu(language.MENUBAR_ITEM_SOURCE));
		
		this.setJMenuBar(jmb);
		
		JScrollPane contentPane = new JScrollPane();
		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1060, 900);
		setTitle("SuperDuperHaxx0rWerkzeug");
		
		JTabbedPane klassenTabs = new JTabbedPane(JTabbedPane.TOP);
		
		AnalyseTabs klasse1_tab_1 = new AnalyseTabs("Banane");
		
		klassenTabs.addTab(klasse1_tab_1.getTitle(), null, klasse1_tab_1, null);
		
		contentPane.setViewportView(klassenTabs);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteCodeToolMainWindow mainframe = new ByteCodeToolMainWindow();
		
		mainframe.setVisible(true);
	}
}
