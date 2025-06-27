package model;

public class FieldInfoModell {
	
	private int acc_flags;
	private int fieldNameIndex;
	private int fieldDeskriptorIndex;
	private int fieldAttributeCount;
	
	private String fieldName;
	private String fieldDeskriptor;
	
	
	public int getAcc_flags() {
		return acc_flags;
	}
	public void setAcc_flags(int acc_flags) {
		this.acc_flags = acc_flags;
	}
	public int getFieldNameIndex() {
		return fieldNameIndex;
	}
	public void setFieldNameIndex(int fieldNameIndex) {
		this.fieldNameIndex = fieldNameIndex;
	}
	public int getFieldDeskriptorIndex() {
		return fieldDeskriptorIndex;
	}
	public void setFieldDeskriptorIndex(int fieldDeskriptorIndex) {
		this.fieldDeskriptorIndex = fieldDeskriptorIndex;
	}
	public int getFieldAttributeCount() {
		return fieldAttributeCount;
	}
	public void setFieldAttributeCount(int fieldAttributeCount) {
		this.fieldAttributeCount = fieldAttributeCount;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldDeskriptor() {
		return fieldDeskriptor;
	}
	public void setFieldDeskriptor(String fieldDeskriptor) {
		this.fieldDeskriptor = fieldDeskriptor;
	}
}
