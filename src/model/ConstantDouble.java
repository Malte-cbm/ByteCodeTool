package model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ConstantDouble extends ConstantModelType {
	
	private double wert;

	public double getWert() {
		return wert;
	}

	public void setWert(double wert) {
		this.wert = wert;
	}

	public ConstantDouble(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Value: " + this.wert;
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] achtByteDouble = new byte[8];
		
		try {
			ra.read(achtByteDouble);
			
			this.wert = ByteBuffer.wrap(achtByteDouble).order(ByteOrder.BIG_ENDIAN).getDouble();
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
