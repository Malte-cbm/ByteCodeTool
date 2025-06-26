package model;

import java.io.RandomAccessFile;

public abstract class ConstantModelType {
	
	private final int tag;
	private final int length;
	private final String name;
	private int tableIndex;
	
	public ConstantModelType(int tag, int length, String name) {
		super();
		this.tag = tag;
		this.length = length;
		this.name = name;
		//this.tableIndex = tableIndex;
	}
	
	public int getTableIndex() {
		return tableIndex;
	}

	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}
		
	public int getLength() {
		return length;
	}

	public String getName() {
		return name;
	}
	
	
	public abstract void leseDaten( RandomAccessFile ra );
	
	
	
}