package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantNameAndType extends ConstantModelType {
	
	private int name_index;
	private int deskriptor_index;
	
	public int getName_index() {
		return name_index;
	}

	public int getDeskriptor_index() {
		return deskriptor_index;
	}

	
	

	public ConstantNameAndType(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] zweiByteNameIndex = new byte[2];
		byte[] zweiByteDeskriptorIndex = new byte[2];
		try {
			
			ra.read(zweiByteNameIndex);
			
			this.name_index = (zweiByteNameIndex[0] << 8) + (zweiByteNameIndex[1] << 0);
			
			ra.read(zweiByteDeskriptorIndex);
			this.deskriptor_index = (zweiByteDeskriptorIndex[0] << 8) + (zweiByteDeskriptorIndex[1] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
