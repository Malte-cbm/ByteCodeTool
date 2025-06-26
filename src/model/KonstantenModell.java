package model;

import java.util.HashMap;

public class KonstantenModell {
	
	private int tagInt;
	private String tagString;
	
	public static ConstantModelType constTypeFromTag(int tag) {
		
		switch(tag) {
		case 1: 	return  new ConstantUtf8(1, 3, "CONSTANT_Utf8");
		case 3: 	return  new ConstantInteger(3, 5, "CONSTANT_Integer");
		case 4: 	return  new ConstantFloat(4, 5, "CONSTANT_Float");
		case 5: 	return  new ConstantLong(5, 9, "CONSTANT_Long");
		case 6: 	return  new ConstantDouble(6, 9, "CONSTANT_Double");
		case 7: 	return  new ConstantClass(7, 3, "CONSTANT_Class");
		case 8: 	return  new ConstantString(8, 3, "CONSTANT_String");
		case 9: 	return  new ConstantFieldRef(9, 5, "CONSTANT_Fieldref");
		case 10: 	return  new ConstantMethodRef(10, 5, "CONSTANT_Methodref");
		case 11: 	return  new ConstantInterfaceMethodRef(11, 5, "CONSTANT_InterfaceMethodref");
		case 12: 	return  new ConstantNameAndType(12, 5, "CONSTANT_NameAndType");
		case 15: 	return  new ConstantMethodHandle(15, 4, "CONSTANT_MethodHandle");
		case 16: 	return  new ConstantMethodType(16, 3, "CONSTANT_MethodType");
		case 17: 	return  new ConstantDynamic(17, 5, "CONSTANT_Dynamic");
		case 18: 	return  new ConstantInvokeDynamic(18, 5, "CONSTANT_InvokeDynamic");	
		case 19: 	return  new ConstantModule(19, 3, "CONSTANT_Module");
		case 20: 	return  new ConstantPackage(20, 3, "CONSTANT_Package");
		}
		return null;
		
	}
			
}
