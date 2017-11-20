package com.pointwest.com.beans;

public class Parrot extends Animal {

	public Parrot() {
		super();
		signatureSound = "Caw Caw";
		specie = "Parrot";
		referenceID = "P" + ++referenceIDIncrementor;
	}

}
