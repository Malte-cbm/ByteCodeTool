package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ConstantUtf8 extends ConstantModelType {

	private int laenge;
	private String inhalt;
	
	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public ConstantUtf8(int tag, int length, String name) {
		super(tag, length, name);
		
	}
	
	public void leseDaten(RandomAccessFile ra) {
		
		byte[] zweiByteUtf8Laenge = new byte[2];
		try {
			ra.read(zweiByteUtf8Laenge);
		
			this.laenge = (zweiByteUtf8Laenge[0] << 8) + (zweiByteUtf8Laenge[1] << 0);

			//Pointer zurücksetzen, String auslesen

			ra.seek( ra.getFilePointer()-2);
			this.inhalt = ra.readUTF();
			
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}
	

}
