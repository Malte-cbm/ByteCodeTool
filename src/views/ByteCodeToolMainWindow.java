package views;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import controller.DatenLeser;
import model.DatenContainer;

import javax.swing.JScrollPane;

public class ByteCodeToolMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTabbedPane klassenTabs;
	private DatenLeser hauptController;
	
	public ByteCodeToolMainWindow() {
		
		HashMap<String, ArrayList<String>> aufbau = new HashMap<>();
		ArrayList<String> dateiPunkte = new ArrayList<>();
		dateiPunkte.add("Öffnen");
		dateiPunkte.add("Beenden");
		aufbau.put("Datei", dateiPunkte);

		this.klassenTabs = new JTabbedPane(JTabbedPane.TOP);
		
		this.hauptController = new DatenLeser(klassenTabs);
		
		MenuFactory mfBar = new MenuFactory(aufbau, this.hauptController);
		
		this.setJMenuBar(mfBar);
		
		JScrollPane contentPane = new JScrollPane();
		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1060, 900);
		setTitle("SuperDuperHaxx0rWerkzeug");
		
		DatenContainer jaja = new DatenContainer();

		AnalyseTabs klasse1_tab_1 = new AnalyseTabs("Banane", jaja);
		
		klassenTabs.addTab(klasse1_tab_1.getTitle(), null, klasse1_tab_1, null);
		
		
		contentPane.setViewportView(klassenTabs);
		
		
	}
	public static void main(String[] args) {
		ByteCodeToolMainWindow mainframe = new ByteCodeToolMainWindow();
		
		
		
		mainframe.setVisible(true);
	}
}
