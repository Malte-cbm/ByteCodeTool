package model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ConstantLong extends ConstantModelType {
	
	private long wert;

	public long getWert() {
		return wert;
	}

	public void setWert(long wert) {
		this.wert = wert;
	}

	public ConstantLong(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] achtByteLong = new byte[8];
		
		try {
			ra.read(achtByteLong);
			
			this.wert = ByteBuffer.wrap(achtByteLong).order(ByteOrder.BIG_ENDIAN).getLong();
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
