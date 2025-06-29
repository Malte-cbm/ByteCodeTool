package model;

public class AttributInfoModell {

	private int attribute_name_index;
	private String attributeNameString;
	private int attributeLength;
	
	public int getAttribute_name_index() {
		return attribute_name_index;
	}
	public void setAttribute_name_index(int attribute_name_index) {
		this.attribute_name_index = attribute_name_index;
	}
	public String getAttributeNameString() {
		return attributeNameString;
	}
	public void setAttributeNameString(String attributeNameString) {
		this.attributeNameString = attributeNameString;
	}
	public int getAttributeLength() {
		return attributeLength;
	}
	public void setAttributeLength(int attributeLength) {
		this.attributeLength = attributeLength;
	}
	public String toString() {
		return this.attributeNameString;
	}
}
