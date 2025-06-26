package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantMethodType extends ConstantModelType {
	
	private int deskriptor_index;

	public int getDeskriptor_index() {
		return deskriptor_index;
	}

	public ConstantMethodType(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Deskriptor Index: " + this.deskriptor_index;
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] zweiByteDeskriptorIndex= new byte[2];
		
		try {
					
			ra.read(zweiByteDeskriptorIndex);
			this.deskriptor_index = (zweiByteDeskriptorIndex[0] << 8) + (zweiByteDeskriptorIndex[1] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
