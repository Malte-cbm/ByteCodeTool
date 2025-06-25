package model;

import java.io.RandomAccessFile;

public abstract class ConstantModelType {
	
	private final int tag;
	private final int length;
	private final String name;
	
	public ConstantModelType(int tag, int length, String name) {
		super();
		this.tag = tag;
		this.length = length;
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

	
	
	public int getLength() {
		return length;
	}

	public String getName() {
		return name;
	}
	
	
	public abstract void leseDaten( RandomAccessFile ra );
	
	
	
}