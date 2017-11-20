package com.pointwest.com.beans;

public class Cat extends Animal {

	public Cat() {
		super();
		signatureSound = "Meow";
		specie = "Cat";
		referenceID = "C" + ++referenceIDIncrementor;
	}

}
