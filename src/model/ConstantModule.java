package model;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ConstantModule extends ConstantModelType {
	
	private int name_index;

	public int getName_index() {
		return name_index;
	}



	public ConstantModule(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Name Index: " + this.name_index;
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] zweiByteNameIndex= new byte[2];
		
		try {
			
			ra.read(zweiByteNameIndex);
			
			this.name_index = (zweiByteNameIndex[0] << 8) + (zweiByteNameIndex[1] << 0);
			
									
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
