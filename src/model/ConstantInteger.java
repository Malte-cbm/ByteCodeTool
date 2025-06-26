package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantInteger extends ConstantModelType {
	
	private int wert;

	public int getValue() {
		return wert;
	}

	public void setValue(int value) {
		this.wert = value;
	}

	public ConstantInteger(int tag, int length, String name) {
		super(tag, length, name);
	}
	
	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Value: " + this.wert;
	}
	
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] vierByteInteger = new byte[4];
		
		try {
			ra.read(vierByteInteger);
		
			this.wert = (vierByteInteger[0] << 24) + (vierByteInteger[1] << 16) + (vierByteInteger[2] << 8) + (vierByteInteger[3] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
