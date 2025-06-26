package model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ConstantFloat extends ConstantModelType {
	
	private float wert;

	public float getWert() {
		return wert;
	}

	public void setWert(float wert) {
		this.wert = wert;
	}

	public ConstantFloat(int tag, int length, String name) {
		super(tag, length, name);
		
	}
	
	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Value: " + this.wert;
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] vierByteFloat = new byte[4];
		
		try {
			ra.read(vierByteFloat);
			
			this.wert = ByteBuffer.wrap(vierByteFloat).order(ByteOrder.BIG_ENDIAN).getFloat();
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
