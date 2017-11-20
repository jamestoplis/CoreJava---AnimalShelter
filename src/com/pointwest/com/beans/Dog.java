package com.pointwest.com.beans;

public class Dog extends Animal {

	public Dog(  ) {
		super();
		signatureSound = "Arf arf!";
		specie = "Dog";		
		referenceID = "D" + ++referenceIDIncrementor;
	}
	

}
