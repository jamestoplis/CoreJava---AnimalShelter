package com.pointwest.com.controller;

import java.util.HashMap;

import com.pointwest.com.beans.Animal;
import com.pointwest.com.beans.Cat;
import com.pointwest.com.beans.Dog;
import com.pointwest.com.beans.Parrot;

public class AnimalShelterController {
	private HashMap<String, Animal> animalMap;

	public void setAnimalMap(HashMap<String, Animal> animalMap) {
		this.animalMap = animalMap;
	}
	
	public HashMap<String, Animal> getAnimalMap() {
		return animalMap;
	}
	
	public int getMapSize(String animalType) {
		int size = 0;
		for (Animal animal : animalMap.values()) {
			if (animal.getSpecie().equalsIgnoreCase(animalType)) {
				size++;
			}
		}

		return size;
	}

	// ADD ANIMAL
	public Animal addAnimal(String animalType) {
		Animal newAnimal = null;
		switch (animalType) {
		case "Dog":
			newAnimal = new Dog();
			break;
		case "Cat":
			newAnimal = new Cat();
			break;
		case "Parrot":
			newAnimal = new Parrot();
			break;
		}

		animalMap.put(newAnimal.getReferenceID(), newAnimal);
		return newAnimal;
	}

	public void addAnimalName(Animal animal, String name) {
		animal.setName(name);
	}

	public void addAnimalAge(Animal animal, int age) {
		animal.setAge(age);
	}

	public void addAnimalGender(Animal animal, String gender) {
		animal.setGender(gender);
	}

	// REMOVE ANIMAL
	public String removeAnimal(String animalType, String refNumber) {

		Animal removeAnimal = animalMap.remove(refNumber);

		return removeAnimal.getName();
	}

	// VIEW ANIMAL
	public String viewAnimals(String animalType) {
		String animalGreetings = "";

		for (Animal animal : animalMap.values()) {
			if (animal.getSpecie().equalsIgnoreCase(animalType)) {
				animalGreetings += animal.greet();
			}
		}
		return animalGreetings;

	}

	public String viewAnimals() {
		String animalGreetings = "";

		for (Animal animal : animalMap.values()) {
			animalGreetings += animal.greet();

		}
		return animalGreetings;
	}

	// FEED ANIMAL
	public String feedAnimal(String animalType, String refNumber) {

		Animal removeAnimal = animalMap.get(refNumber);
		return String.format("You have fed %s the %s. You are so kind", removeAnimal.getName(), animalType);
	}


}
