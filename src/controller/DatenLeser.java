package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DatenContainer;
import views.AnalyseTabs;

public class DatenLeser {
	
	private JTabbedPane klassenTabs;
	private ArrayList<DatenContainer> datenContainerListe;
	
	public DatenLeser ( JTabbedPane klassentabs ) {
		
		this.klassenTabs = klassentabs;
		this.datenContainerListe = new ArrayList<>();
	}
	
	public void leseKlasse(File klassenDatei, DatenContainer modell) throws FileNotFoundException {
		
		RandomAccessFile ra = new RandomAccessFile(klassenDatei, "r");
		
		modell.setMagic(leseMagicNo(ra));
		modell.notifySubscribers();
		
	}
	
	public int leseMinorVersion(RandomAccessFile ra) {
		
		try {
			byte[] zweiBytesMinorVersion = new byte[2];
			ra.read(zweiBytesMinorVersion);
			for (byte cell: zweiBytesMinorVersion)
				{;}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  4;
	}
	
	public String leseMagicNo(RandomAccessFile ra) {
		StringBuilder sb = new StringBuilder();
		
		try {
			byte[] vierBytesOfMagic = new byte[4];
			ra.read(vierBytesOfMagic);
			for (byte cell: vierBytesOfMagic)
				{sb.append(String.format("%02X", cell));}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}
	
	public void oeffneFile() {

    	
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setAcceptAllFileFilterUsed(false);
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Java class files", "class");
    	fileChooser.setFileFilter(filter);
    	int returnVal = fileChooser.showOpenDialog(null);
    	File fileWahl = fileChooser.getSelectedFile();
    	
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
    		
    		System.out.println("Die Wahl lautet: " + fileWahl.getPath());
    		
    		DatenContainer neueKlasse = new DatenContainer();
    		this.datenContainerListe.add(neueKlasse);
    		
    		String name = fileWahl.getName();
    		System.out.println(name);
    		
    		AnalyseTabs neueViewTabs = new AnalyseTabs(name, neueKlasse);
    		this.klassenTabs.addTab(neueViewTabs.getTitle(), null, neueViewTabs, null);
    		try {
				leseKlasse(fileWahl, neueKlasse);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	else if (returnVal == JFileChooser.CANCEL_OPTION) {
    		System.out.println("Keine Datei gewählt.");
    	}
    	else if (returnVal == JFileChooser.ERROR_OPTION) {
    		System.out.println("KP lol, Fehler!");
    	}
	}

}
