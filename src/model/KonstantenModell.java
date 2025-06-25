package model;

import java.util.HashMap;

public class KonstantenModell {
	
	private int tagInt;
	private String tagString;
	
	public static final HashMap<Integer, ConstantModelType> tagTabelle = new HashMap<>();
	
	static {
		
		tagTabelle.put(1, new ConstantUtf8(1, 3, "CONSTANT_Utf8"));	
		tagTabelle.put(3, new ConstantInteger(3, 5, "CONSTANT_Integer"));
		tagTabelle.put(4, new ConstantFloat(4, 5, "CONSTANT_Float"));
		tagTabelle.put(5, new ConstantLong(5, 9, "CONSTANT_Long"));
		tagTabelle.put(6, new ConstantDouble(6, 9, "CONSTANT_Double"));
		tagTabelle.put(7, new ConstantClass(7, 3, "CONSTANT_Class"));
		tagTabelle.put(8, new ConstantString(8, 3, "CONSTANT_String"));
		tagTabelle.put(9, new ConstantFieldRef(9, 5, "CONSTANT_Fieldref"));
		tagTabelle.put(10, new ConstantMethodRef(10, 5, "CONSTANT_Methodref"));
		tagTabelle.put(11, new ConstantInterfaceMethodRef(11, 5, "CONSTANT_InterfaceMethodref"));
		tagTabelle.put(12, new ConstantNameAndType(12, 5, "CONSTANT_NameAndType"));
		
		tagTabelle.put(15, new ConstantMethodHandle(15, 4, "CONSTANT_MethodHandle"));
		tagTabelle.put(16, new ConstantMethodType(16, 3, "CONSTANT_MethodType"));
		tagTabelle.put(17, new ConstantDynamic(17, 5, "CONSTANT_Dynamic"));
		tagTabelle.put(18, new ConstantInvokeDynamic(18, 5, "CONSTANT_InvokeDynamic"));
		tagTabelle.put(19, new ConstantModule(19, 3, "CONSTANT_Module"));
		tagTabelle.put(20, new ConstantPackage(20, 3, "CONSTANT_Package"));
		
	}
	
	public static ConstantModelType constTypeFromTag(int tag) {
		
		
		return tagTabelle.get(tag);
		
	}
			
}
