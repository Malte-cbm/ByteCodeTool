package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.AttributInfoModell;
import model.ConstantModelType;
import model.ConstantUtf8;
import model.DatenContainer;
import model.FieldInfoModell;
import model.KonstantenModell;
import model.MethodInfoModell;
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
		modell.setMinor_version(leseMinorVersion(ra));
		modell.setMajor_version(leseMajorVersion(ra));
		modell.setConstant_pool_count(leseConstant_Pool_Count(ra));
		modell.setConstant_pool(leseConstant_Pool_Array(ra, modell.getConstant_pool_count()));
		modell.setAccess_flags(leseAccFlags(ra));
		modell.setThis_class(leseThisClass(ra));
		modell.setSuper_class(leseSuperClass(ra));
		modell.setInterfaces_count(leseInterfaces_Count(ra));
		modell.setInterfaces(leseInterface_Array(ra, modell.getInterfaces_count()));
		modell.setFields_count(leseField_Count(ra));
		modell.setFields(leseField_Array(ra, modell.getFields_count(), modell));
		modell.setMethods_count(leseMethods_Count(ra));
		modell.setMethods(leseMethod_Array(ra, modell.getMethods_count(), modell));
		modell.notifySubscribers();

		
	}
	
	public AttributInfoModell leseAttributInformationen(RandomAccessFile ra, DatenContainer dc) {
		AttributInfoModell neuesAttribut = new AttributInfoModell();
		
		try {
			int name = 0;
			int length = 0;
			
			byte[] zweiBytesNameIndex = new byte[2];
			ra.read(zweiBytesNameIndex);
			name = (zweiBytesNameIndex[0] << 8) + (zweiBytesNameIndex[1] << 0);
			neuesAttribut.setAttribute_name_index(name);
			if (dc.getConstant_pool().get(name) instanceof ConstantUtf8 str) {
				neuesAttribut.setAttributeNameString(str.getInhalt());
				System.out.println(str.getInhalt());
			}
			
			byte[] vierBytesLaenge = new byte[4];
			ra.read(vierBytesLaenge);
			length = (vierBytesLaenge[0] << 24) + (vierBytesLaenge[1] << 16) + (vierBytesLaenge[2] << 8) + (vierBytesLaenge[3] << 0);
			neuesAttribut.setAttributeLength(length);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return neuesAttribut;
	}
	
	public int leseAttributes_Count(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesAttributesCount = new byte[2];
			ra.read(zweiBytesAttributesCount);
			wert = (zweiBytesAttributesCount[0] << 8) + (zweiBytesAttributesCount[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
	}
	
	public ArrayList<MethodInfoModell> leseMethod_Array(RandomAccessFile ra, int fieldsNo, DatenContainer dc) {
		
		ArrayList<MethodInfoModell> fertigeListe = new ArrayList<>();
		
		try {
			
			int flags = 0;
			int name = 0;
			int deskriptor = 0;
			int attributeAnz = 0;
			
			for(int i = 0; i < fieldsNo; i++) {
				
				byte[] zweiByteFlagsIndex= new byte[2];
				byte[] zweiByteNameIndex= new byte[2];
				byte[] zweiByteDeskriptorIndex= new byte[2];
				byte[] zweiByteAttributeAnzahl= new byte[2];
				
			
				ra.read(zweiByteFlagsIndex);
				
				flags = (zweiByteFlagsIndex[0] << 8) + (zweiByteFlagsIndex[1] << 0);
				
				ra.read(zweiByteNameIndex);
				name = (zweiByteNameIndex[0] << 8) + (zweiByteNameIndex[1] << 0);
				
				ra.read(zweiByteDeskriptorIndex);
				deskriptor = (zweiByteDeskriptorIndex[0] << 8) + (zweiByteDeskriptorIndex[1] << 0);
				
				ra.read(zweiByteAttributeAnzahl);
				attributeAnz = (zweiByteAttributeAnzahl[0] << 8) + (zweiByteAttributeAnzahl[1] << 0);
				
				MethodInfoModell neueMethode = new MethodInfoModell(flags, name, deskriptor, attributeAnz);
				
				System.out.println("Methode bei: Flags: " + flags + " Name: " + name + " Deskriptor: " + deskriptor + " NoAttributes: " + attributeAnz);
				
				ArrayList<AttributInfoModell> attributListe = new ArrayList<AttributInfoModell>();
				for(int j = 0; j< attributeAnz; j++) {
					AttributInfoModell neuesAttribut = leseAttributInformationen(ra, dc);
					
					attributListe.add(neuesAttribut);
					//Pointer vorschieben, da die AttributInformationen selber nicht implementiert werden
					
					ra.seek( ra.getFilePointer() + neuesAttribut.getAttributeLength());
					
				}
				neueMethode.setAttributListe(attributListe);
				fertigeListe.add(neueMethode);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fertigeListe;
	}
	
	public int leseMethods_Count(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesMethodsCount = new byte[2];
			ra.read(zweiBytesMethodsCount);
			wert = (zweiBytesMethodsCount[0] << 8) + (zweiBytesMethodsCount[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
	}
	
	public ArrayList<FieldInfoModell> leseField_Array(RandomAccessFile ra, int fieldsNo, DatenContainer dc) {
		
		ArrayList<FieldInfoModell> fertigeListe = new ArrayList<>();
		
		try {
			
			int flags = 0;
			int name = 0;
			int deskriptor = 0;
			int attributeAnz = 0;
			
			for(int i = 0; i < fieldsNo; i++) {
				
				byte[] zweiByteFlagsIndex= new byte[2];
				byte[] zweiByteNameIndex= new byte[2];
				byte[] zweiByteDeskriptorIndex= new byte[2];
				byte[] zweiByteAttributeAnzahl= new byte[2];
				
			
				ra.read(zweiByteFlagsIndex);
				
				flags = (zweiByteFlagsIndex[0] << 8) + (zweiByteFlagsIndex[1] << 0);
				
				ra.read(zweiByteNameIndex);
				name = (zweiByteNameIndex[0] << 8) + (zweiByteNameIndex[1] << 0);
				
				ra.read(zweiByteDeskriptorIndex);
				deskriptor = (zweiByteDeskriptorIndex[0] << 8) + (zweiByteDeskriptorIndex[1] << 0);
				
				ra.read(zweiByteAttributeAnzahl);
				attributeAnz = (zweiByteAttributeAnzahl[0] << 8) + (zweiByteAttributeAnzahl[1] << 0);
				
				FieldInfoModell neuesField = new FieldInfoModell(flags, name, deskriptor, attributeAnz);
				
				System.out.println("Field bei: Flags: " + flags + " Name: " + name + " Deskriptor: " + deskriptor + " NoAttributes: " + attributeAnz);
				
				ArrayList<AttributInfoModell> attributListe = new ArrayList<AttributInfoModell>();
				for(int j = 0; j< attributeAnz; j++) {
					AttributInfoModell neuesAttribut = leseAttributInformationen(ra, dc);
					
					attributListe.add(neuesAttribut);
					//Pointer vorschieben, da die AttributInformationen selber nicht implementiert werden
					
					ra.seek( ra.getFilePointer() + neuesAttribut.getAttributeLength());
					
				}
				neuesField.setAttributListe(attributListe);
				fertigeListe.add(neuesField);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fertigeListe;
	}
	
	public int leseField_Count(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesFieldCount = new byte[2];
			ra.read(zweiBytesFieldCount);
			wert = (zweiBytesFieldCount[0] << 8) + (zweiBytesFieldCount[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
	}
	
	public ArrayList<Integer> leseInterface_Array(RandomAccessFile ra, int interfaceNo) {
		
		ArrayList<Integer> fertigeListe = new ArrayList<>();
		
		try {
			
			int wert = 0;
			
			for(int i = 0; i < interfaceNo; i++) {
				
				byte[] zweiByteInterfaceIndex= new byte[2];
			
				ra.read(zweiByteInterfaceIndex);
				
				wert = (zweiByteInterfaceIndex[0] << 8) + (zweiByteInterfaceIndex[1] << 0);
				
				fertigeListe.add(wert);
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i: fertigeListe) {
			System.out.println("Interface bei: " + i);
		}
		
		return fertigeListe;
	}
	
	public int leseInterfaces_Count(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesInterfacesCount = new byte[2];
			ra.read(zweiBytesInterfacesCount);
			wert = (zweiBytesInterfacesCount[0] << 8) + (zweiBytesInterfacesCount[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
	}
	
	public int leseSuperClass (RandomAccessFile ra) {
		
		int wert = 0;
		try {
			byte[] zweiBytesSuperClass = new byte[2];
			ra.read(zweiBytesSuperClass);
			wert = (zweiBytesSuperClass[0] << 8) + (zweiBytesSuperClass[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
		
	}
	
	public int leseThisClass (RandomAccessFile ra) {
		
		int wert = 0;
		try {
			byte[] zweiBytesThisClass = new byte[2];
			ra.read(zweiBytesThisClass);
			wert = (zweiBytesThisClass[0] << 8) + (zweiBytesThisClass[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
		
	}
	
	public int leseAccFlags (RandomAccessFile ra) {
		
		int wert = 0;
		try {
			byte[] zweiBytesAccFlags = new byte[2];
			ra.read(zweiBytesAccFlags);
			wert = (zweiBytesAccFlags[0] << 8) + (zweiBytesAccFlags[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
		
	}
	public ArrayList<ConstantModelType> leseConstant_Pool_Array(RandomAccessFile ra, int constNo) {
		
		ArrayList<ConstantModelType> fertigeListe = new ArrayList<>();
		
		try {
			
				
			for(int i = 0; i < constNo-1; i++) {
				
				byte[] einByteConstTag= new byte[1];
			
				ra.read(einByteConstTag);
				
				int x = einByteConstTag[0]<<0;
				
				System.out.println("Tag: " + x + " Konstante NO: " + i);
				ConstantModelType cmt = KonstantenModell.constTypeFromTag(einByteConstTag[0]<<0);
				
				cmt.setTableIndex(i);
				cmt.leseDaten(ra);
				fertigeListe.add(cmt);
				if (x==5 | x==6) {
					cmt = KonstantenModell.constTypeFromTag(einByteConstTag[0]<<0);
					
					i += 1;
					cmt.setTableIndex(i);
					fertigeListe.add(cmt);
					}
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fertigeListe;
	}
	public int leseConstant_Pool_Count(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesConstPool = new byte[2];
			ra.read(zweiBytesConstPool);
			wert = (zweiBytesConstPool[0] << 8) + (zweiBytesConstPool[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
	}
	
	public int leseMajorVersion(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesMajorVersion = new byte[2];
			ra.read(zweiBytesMajorVersion);
			wert = (zweiBytesMajorVersion[0] << 8) + (zweiBytesMajorVersion[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
	}
	
	public int leseMinorVersion(RandomAccessFile ra) {
		int wert = 0;
		try {
			byte[] zweiBytesMinorVersion = new byte[2];
			ra.read(zweiBytesMinorVersion);
			wert = (zweiBytesMinorVersion[0] << 8) + (zweiBytesMinorVersion[1] << 0);
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wert;
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
    		//this.klassenTabs.removeTabAt(0);
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
