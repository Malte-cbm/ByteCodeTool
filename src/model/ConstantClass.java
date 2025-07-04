package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantClass extends ConstantModelType {
	
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ConstantClass(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Index: " + this.index;
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		byte[] zweiByteIndex = new byte[2];
		
		try {
			ra.read(zweiByteIndex);
			
			this.index = (zweiByteIndex[0] << 8) + (zweiByteIndex[1] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
