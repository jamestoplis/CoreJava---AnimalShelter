package com.pointwest.com.ui;

import java.util.HashMap;
import java.util.Scanner;

import com.pointwest.com.beans.Animal;
import com.pointwest.com.controller.AnimalShelterController;

public class AnimalShelterUI {
	AnimalShelterController asc;
	Scanner in = new Scanner(System.in);

	public void setManager(AnimalShelterController asc) {
		this.asc = asc;
	}

	public void setAnimalMap(HashMap<String, Animal> animalMap) {
		asc.setAnimalMap(animalMap);
	}

	public void closeScanner() {
		in.close();
	}

	public void run(int maxShelterSize) {
		String choice = displayHomePage();
		int size = asc.getMapSize(choice);

		boolean backToHome = false;
		while (!backToHome) {
			if (size == 0) {

				backToHome = displayMainMenuEmpty(choice);

			} else if (size > 0 && size < maxShelterSize) {

				backToHome = displayMainMenu(choice);

			} else {
				//If current shelter is full, check if all shelters are full as well, then exit
				if (  asc.getAnimalMap().size() >=  maxShelterSize * 3) {
					backToHome = true;

				} else {
					backToHome = displayMainMenuFull(choice);
				}
			}
			size = asc.getMapSize(choice);
		}
	}

	// HOME PAGE
	public String displayHomePage() {
		System.out.println("\nJC'S ANIMAL SHELTER");
		System.out.println("\nPlease select a shelter to visit\n");
		System.out.println("[1] Dog Shelter");
		System.out.println("[2] Cat Shelter");
		System.out.println("[3] Parrot Shelter");

		String choice = in.nextLine();

		switch (choice) {
		case "1":
			choice = "Dog";
			break;
		case "2":
			choice = "Cat";
			break;
		case "3":
			choice = "Parrot";
			break;
		}

		return choice;
	}

	// MAIN MENU NORMAL
	public boolean displayMainMenu(String animalType) {
		System.out.println("\nJC'S ANIMAL SHELTER");
		System.out.printf("\nWelcome to the %s Shelter!\n", animalType);
		System.out.println("Please select an option...\n");
		System.out.println("[1] Add a " + animalType);
		System.out.println("[2] Remove a " + animalType);
		System.out.println("[3] Feed a " + animalType);
		System.out.println("[4] View All " + animalType + "s");
		System.out.println("[5] Go Back to Home Page");

		String choice = in.nextLine();
		boolean backToHome = false;
		switch (choice) {
		case "1":
			displayAddAnimalMenu(animalType);
			break;
		case "2":
			displayRemoveAnimalMenu(animalType);
			break;
		case "3":
			displayFeedAnimalMenu(animalType);
			break;
		case "4":
			displayViewAnimalsMenu(animalType);
			break;
		case "5":
			backToHome = true;
			System.out.println("Going back to home page...");
			break;
		}

		return backToHome;
	}

	// DISPLAY WHEN SHELTER IS EMPTY
	public boolean displayMainMenuEmpty(String animalType) {
		System.out.println("\nJC'S ANIMAL SHELTER");
		System.out.printf("\nThe %s shelter is empty! Please add a %s\n", animalType, animalType);
		System.out.println("[1] Add an Animal");
		System.out.println("[2] Go Back to Home Page");

		String choice = in.nextLine();
		boolean backToHome = false;
		switch (choice) {
		case "1":
			displayAddAnimalMenu(animalType);
			break;
		case "2":
			backToHome = true;
			System.out.println("Going back to home page...");
			break;
		}

		return backToHome;

	}

	// DISPLAY WHEN SHELTER IS FULL
	public boolean displayMainMenuFull(String animalType) {
		System.out.println("\nJC'S ANIMAL SHELTER");
		System.out.printf("\nThe %s shelter is currently full. We are no longer able to accept any new %ss.\n",
				animalType, animalType);
		System.out.println("[1] Remove a " + animalType);
		System.out.println("[2] View All " + animalType + "s");
		System.out.println("[3] Go Back to Home Page");
		String choice = in.nextLine();

		boolean backToHome = false;
		switch (choice) {
		case "1":
			displayRemoveAnimalMenu(animalType);
			break;
		case "2":
			displayViewAnimalsMenu(animalType);
			break;
		case "3":
			backToHome = true;
			System.out.println("Going back to home page...");
			break;
		}

		return backToHome;
	}

	// ADD ANIMAL
	public void displayAddAnimalMenu(String animalType) {

		Animal newAnimal = asc.addAnimal(animalType);

		displayAddAnimalName(newAnimal);
		displayAddAnimalAge(newAnimal);
		displayAddAnimalGender(newAnimal);
		System.out.println(animalType + " " + newAnimal.getName() + " has been added");

	}

	public void displayAddAnimalName(Animal animal) {
		System.out.println("Please enter the animal's name:");
		asc.addAnimalName(animal, in.nextLine());
	}

	public void displayAddAnimalAge(Animal animal) {
		System.out.println("Please enter the animal's age:");
		asc.addAnimalAge(animal, Integer.parseInt(in.nextLine()));
	}

	public void displayAddAnimalGender(Animal animal) {
		System.out.println("Please enter animal's gender: ");
		asc.addAnimalGender(animal, in.nextLine());
	}

	// REMOVE ANIMAL
	public void displayRemoveAnimalMenu(String animalType) {
		System.out.println("Enter reference ID of the animal you want to remove. You monster");
		String id = in.nextLine().toUpperCase();
		String name = asc.removeAnimal(animalType, id);

		if ("NULL".equalsIgnoreCase(name)) {
			System.out.printf("%s #%d was not found. Thank goodness.", animalType, id);
		} else {
			System.out.println("Removed " + name + " from the shelter. Jerk.");
		}
	}

	// VIEW ANIMALS
	public void displayViewAnimalsMenu(String animalType) {
		System.out.printf("\nMeet our wonderful %s friends!\n", animalType);
		System.out.println(asc.viewAnimals(animalType));
	}

	// FEED ANIMAL
	public void displayFeedAnimalMenu(String animalType) {
		System.out.println("Enter reference ID of the animal you want to feed. You cutie");
		String id = in.nextLine().toUpperCase();

		System.out.println(asc.feedAnimal(animalType, id));
	}

	// EXIT PROGRAM
	public void displayExitScreen() {
		System.out.println("\nThe animal shelter is already full :(\nThank you for your patronage");
		System.out.println("Here are all your animal friends!\n");
		System.out.println( asc.viewAnimals() );
	}
}
