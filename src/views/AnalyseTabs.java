package views;

import javax.swing.JTabbedPane;

import model.DatenContainer;

public class AnalyseTabs extends JTabbedPane {
	

	private String title;
	private UebersichtsTab uebersichts_tab;
	private KonstantenTab konstanten_tab;
	private FelderTab felder_tab;
	private MethodenTab methoden_tab;
	
	private static final long serialVersionUID = 1L;

	public AnalyseTabs() {
		
		this.title = "Neuer Tab"; 
		JTabbedPane komplettesPane = this;
	
		this.uebersichts_tab = new UebersichtsTab();
		komplettesPane.addTab("Übersicht", null, uebersichts_tab, null);
	
		this.konstanten_tab = new KonstantenTab();
		komplettesPane.addTab("Konstanten", null, konstanten_tab, null);
	
		this.felder_tab = new FelderTab();
		komplettesPane.addTab("Felder", null, felder_tab, null);
	
		this.methoden_tab = new MethodenTab();
		komplettesPane.addTab("Methoden", null, methoden_tab, null);
		
		
	}
	
	public String getTitle() {
		return title;
	}

	public AnalyseTabs(String dateiname, DatenContainer datenContainer) {
		this();
		this.title = dateiname;
		enterObserverMode(datenContainer);
	}
	
	public void enterObserverMode(DatenContainer datenContainer) {
		datenContainer.subscribe(this.uebersichts_tab);
		datenContainer.subscribe(this.konstanten_tab);
		datenContainer.subscribe(this.felder_tab);
		datenContainer.subscribe(this.methoden_tab);
	}


}
