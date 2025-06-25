package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantInterfaceMethodRef extends ConstantModelType {
	
	private int class_index;
	private int name_and_type_index;
	
	public int getClass_index() {
		return class_index;
	}


	public int getName_and_type_index() {
		return name_and_type_index;
	}



	public ConstantInterfaceMethodRef(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] zweiByteClassIndex = new byte[2];
		byte[] zweiByteNameIndex = new byte[2];
		try {
			
			ra.read(zweiByteClassIndex);
			
			this.class_index = (zweiByteClassIndex[0] << 8) + (zweiByteClassIndex[1] << 0);
			ra.read(zweiByteNameIndex);
			this.name_and_type_index = (zweiByteNameIndex[0] << 8) + (zweiByteNameIndex[1] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
