package model;

import java.util.ArrayList;
import java.util.LinkedList;

import controller.ObserverFace;

public class DatenContainer {
	
	private LinkedList<ObserverFace> subscribers;
	
	private int magic;
	private int minor_version;
	private int major_version;
	
	private int constant_pool_count;
	private ArrayList<String> constant_pool;
	
	private String access_flags;
	private String this_class;
	private String super_class;
	
	private int interfaces_count;
	private ArrayList<String> interfaces;
	
	private int fields_count;
	private ArrayList<String> fields;
	
	private int methods_count;
	private ArrayList<String> methods;
	
	private int attributes_count;
	private ArrayList<String> attributes;
	
	
	public DatenContainer() {
		this.subscribers = new LinkedList<>();
	}
	
	
	
	
	
	//Methoden, die analog zum Publisher sind
	public void subscribe( ObserverFace subscriber) {
		subscribers.add(subscriber);
	}
	public void unsubscribe( ObserverFace subscriber) {
		subscribers.remove(subscriber);
	}	
	
	public void notifySubscribers() {
		for( ObserverFace s  : subscribers ) {
			s.update(this);
		}
	}




	//getter & setter
	public int getMagic() {
		return magic;
	}





	public void setMagic(int magic) {
		this.magic = magic;
	}





	public int getMinor_version() {
		return minor_version;
	}





	public void setMinor_version(int minor_version) {
		this.minor_version = minor_version;
	}





	public int getMajor_version() {
		return major_version;
	}





	public void setMajor_version(int major_version) {
		this.major_version = major_version;
	}





	public int getConstant_pool_count() {
		return constant_pool_count;
	}





	public void setConstant_pool_count(int constant_pool_count) {
		this.constant_pool_count = constant_pool_count;
	}





	public ArrayList<String> getConstant_pool() {
		return constant_pool;
	}





	public void setConstant_pool(ArrayList<String> constant_pool) {
		this.constant_pool = constant_pool;
	}





	public String getAccess_flags() {
		return access_flags;
	}





	public void setAccess_flags(String access_flags) {
		this.access_flags = access_flags;
	}





	public String getThis_class() {
		return this_class;
	}





	public void setThis_class(String this_class) {
		this.this_class = this_class;
	}





	public String getSuper_class() {
		return super_class;
	}





	public void setSuper_class(String super_class) {
		this.super_class = super_class;
	}





	public int getInterfaces_count() {
		return interfaces_count;
	}





	public void setInterfaces_count(int interfaces_count) {
		this.interfaces_count = interfaces_count;
	}





	public ArrayList<String> getInterfaces() {
		return interfaces;
	}





	public void setInterfaces(ArrayList<String> interfaces) {
		this.interfaces = interfaces;
	}





	public int getFields_count() {
		return fields_count;
	}





	public void setFields_count(int fields_count) {
		this.fields_count = fields_count;
	}





	public ArrayList<String> getFields() {
		return fields;
	}





	public void setFields(ArrayList<String> fields) {
		this.fields = fields;
	}





	public int getMethods_count() {
		return methods_count;
	}





	public void setMethods_count(int methods_count) {
		this.methods_count = methods_count;
	}





	public ArrayList<String> getMethods() {
		return methods;
	}





	public void setMethods(ArrayList<String> methods) {
		this.methods = methods;
	}





	public int getAttributes_count() {
		return attributes_count;
	}





	public void setAttributes_count(int attributes_count) {
		this.attributes_count = attributes_count;
	}





	public ArrayList<String> getAttributes() {
		return attributes;
	}





	public void setAttributes(ArrayList<String> attributes) {
		this.attributes = attributes;
	}

}
