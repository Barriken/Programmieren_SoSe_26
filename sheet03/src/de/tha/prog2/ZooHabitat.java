package de.tha.prog2;

import de.tha.prog2.animals.Animal;
import de.tha.prog2.animals.AnimalClass;
import de.tha.prog2.animals.Carnivore;
import de.tha.prog2.animals.Herbivore;
import de.tha.prog2.animals.Omnivore;
import de.tha.prog2.container.DoubleLinkedList;
import de.tha.prog2.container.ListElement;
import de.tha.prog2.exceptions.HabitatFullException;
import de.tha.prog2.exceptions.InvalidAnimalException;

public class ZooHabitat {

	
		
	private int maxCapacity;
	
	private DoubleLinkedList animals;
	
	public ZooHabitat(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		animals = new DoubleLinkedList();
	}
	
	public int animals() {
		ListElement currentElement = animals.head;
		if (currentElement != null) {
			if(currentElement.content instanceof AnimalClass) {
				do {
					AnimalClass currentAnimal = (AnimalClass) currentElement.content;
						System.out.println("Gewicht:" + currentAnimal.weight());
						currentElement = currentElement.next;
				} while (currentElement != null);
			}
		}
		
		return animals.size();
	}
	


	public void addAnimal (Object animal) throws HabitatFullException, InvalidAnimalException {
		if (animals.size() == maxCapacity) {
			throw new HabitatFullException("Voll");
		}
		
		else if (animals() == 0) {
			animals.add(animal);
			return;
		}
		else {
			ListElement currentElement = animals.head;
			do {
				if (currentElement.content.equals(animal)) {
					return;
				}
				currentElement = currentElement.next;
			} while (currentElement != null);
			
			
			
				if (animals.head.content instanceof Herbivore && animal instanceof Herbivore ||
						animals.head.content instanceof Carnivore && animal instanceof Carnivore ||
						animals.head.content instanceof Omnivore && animal instanceof Omnivore) {
					animals.add(animal);
					return;
				}
				else {
					throw new InvalidAnimalException("Keine Mischung!");
				}
			}
		
		
	}

	public int getMaxCapacity() {
		return this.maxCapacity;
	}
}
