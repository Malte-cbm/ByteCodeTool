package views;

import javax.swing.JTabbedPane;

public class AnalyseTabs extends JTabbedPane {
	

	private String title;
	
	private static final long serialVersionUID = 1L;

	public AnalyseTabs() {
		
		this.title = "Neuer Tab"; 
		JTabbedPane komplettesPane = this;
	
		UebersichtsTab uebersichts_tab = new UebersichtsTab();
		komplettesPane.addTab("Übersicht", null, uebersichts_tab, null);
	
		KonstantenTab konstanten_tab = new KonstantenTab();
		komplettesPane.addTab("Konstanten", null, konstanten_tab, null);
	
		FelderTab felder_tab = new FelderTab();
		komplettesPane.addTab("Felder", null, felder_tab, null);
	
		MethodenTab methoden_tab = new MethodenTab();
		komplettesPane.addTab("Methoden", null, methoden_tab, null);
		
	}
	
	public String getTitle() {
		return title;
	}

	public AnalyseTabs(String dateiname) {
		this();
		this.title = dateiname;
	}

}
