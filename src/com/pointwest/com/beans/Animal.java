package com.pointwest.com.beans;

public abstract class Animal {
	protected String name, gender, signatureSound, specie;
	protected static int referenceIDIncrementor = 1000;
	protected int age;
	protected String referenceID;
	
	
	public String greet() {
		return String.format( "%s: %s! Hi I'm %s the %s %s. I'm %d years old.\n", referenceID, signatureSound, name, gender, specie, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getReferenceID() {
		return referenceID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecie() {
		return specie;
	}
}
