package model;

import java.util.ArrayList;

public class MethodInfoModell {
	
	private int access_flags;
	private int name_index;
	private String nameString;
	private int deskriptor_index;
	private String deskriptorString;
	private int attributeCount;
	private ArrayList<AttributInfoModell> attributListe;
	
	public MethodInfoModell(int acc_flags, int fieldNameIndex, int fieldDeskriptorIndex, int fieldAttributeCount) {
		
		this.access_flags = acc_flags;
		this.name_index = fieldNameIndex;
		this.deskriptor_index = fieldDeskriptorIndex;
		this.attributeCount = fieldAttributeCount;
	}
	
	public String toString() {
		return this.nameString;
	}

	public ArrayList<AttributInfoModell> getAttributListe() {
		return attributListe;
	}
	public void setAttributListe(ArrayList<AttributInfoModell> attributListe) {
		this.attributListe = attributListe;
	}
	public int getAccess_flags() {
		return access_flags;
	}
	public void setAccess_flags(int access_flags) {
		this.access_flags = access_flags;
	}
	public int getName_index() {
		return name_index;
	}
	public void setName_index(int name_index) {
		this.name_index = name_index;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getDeskriptor_index() {
		return deskriptor_index;
	}
	public void setDeskriptor_index(int deskriptor_index) {
		this.deskriptor_index = deskriptor_index;
	}
	public String getDeskriptorString() {
		return deskriptorString;
	}
	public void setDeskriptorString(String deskriptorString) {
		this.deskriptorString = deskriptorString;
	}
	public int getAttributeCount() {
		return attributeCount;
	}
	public void setAttributeCount(int attributeCount) {
		this.attributeCount = attributeCount;
	}
	
}
