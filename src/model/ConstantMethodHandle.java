package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantMethodHandle extends ConstantModelType {
	
	private int reference_kind;
	private int reference_index;
	
	public int getReference_kind() {
		return reference_kind;
	}

	public int getReference_index() {
		return reference_index;
	}

	

	public ConstantMethodHandle(int tag, int length, String name) {
		super(tag, length, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void leseDaten(RandomAccessFile ra) {
		// TODO Auto-generated method stub
		
		byte[] einByteKind= new byte[1];
		byte[] zweiByteIndex= new byte[2];
		
		try {
			
			ra.read(einByteKind);
			
			this.reference_kind = (einByteKind[0] << 0);
			
			ra.read(zweiByteIndex);
			this.reference_index = (zweiByteIndex[0] << 8) + (zweiByteIndex[1] << 0);
						
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
