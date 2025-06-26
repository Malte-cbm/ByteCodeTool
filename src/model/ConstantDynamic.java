package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantDynamic extends ConstantModelType {

	private int bootstrap_method_attr_index;
	private int name_and_type_index;

	
	public int getBootstrap_method_attr_index() {
		return bootstrap_method_attr_index;
	}

	public int getName_and_type_index() {
		return name_and_type_index;
	}

	
	public ConstantDynamic(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return this.getTableIndex()+1 + "  :  " + this.getName() + " Bootstrap Method Attribute: " + this.bootstrap_method_attr_index + " Name and Type Index: " + this.name_and_type_index;
	}
	
	@Override
	public void leseDaten(RandomAccessFile ra) {
		byte[] zweiByteBootstrapIndex= new byte[2];
		byte[] zweiByteNameIndex= new byte[2];
		
		try {
			
			ra.read(zweiByteBootstrapIndex);
			
			this.bootstrap_method_attr_index = (zweiByteBootstrapIndex[0] << 8) + (zweiByteBootstrapIndex[1] << 0);
			
			ra.read(zweiByteNameIndex);
			this.name_and_type_index = (zweiByteNameIndex[0] << 8) + (zweiByteNameIndex[1] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
