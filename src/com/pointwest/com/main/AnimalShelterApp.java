package com.pointwest.com.main;

import java.util.HashMap;

import com.pointwest.com.beans.Animal;
import com.pointwest.com.controller.AnimalShelterController;
import com.pointwest.com.ui.AnimalShelterUI;

public class AnimalShelterApp {

	public static void main(String[] args) {
	
		HashMap<String, Animal> animalMap = new HashMap<String, Animal>();
		
		AnimalShelterUI ui = new AnimalShelterUI();
		AnimalShelterController manager = new AnimalShelterController();
		
		ui.setManager( manager );
		ui.setAnimalMap( animalMap );
		
		int maxShelterSize = 2;
		int maxTotalSize = maxShelterSize * 3;
		
		while ( animalMap.size() < maxTotalSize ) {
			ui.run(maxShelterSize);
		}
		ui.displayExitScreen();
		ui.closeScanner();
	}
}
