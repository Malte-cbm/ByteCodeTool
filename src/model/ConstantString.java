package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantString extends ConstantModelType {
	
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ConstantString(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
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
