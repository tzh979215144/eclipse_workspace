package com.tanpang.day01;

public class PetEnterQueue {

	private Pet pet;
	private long count;
	
	public PetEnterQueue(Pet pet,long count) {
		this.pet=pet;
		this.count=count;
	}
	public Pet getPet() {
		return this.pet;
	}
	public long getCount() {
		return this.count;
	}
	
	public String getEnterPetType() {
		return this.pet.getPetType();
	}
	
	
}

class Dog extends Pet{

	public Dog() {
		super("dog");
	}
}
class Cat extends Pet{

	public Cat() {
		super("cat");
	}
}
class Pet{
	private String type;
	
	public Pet(String type) {
		this.type=type;
	}
	public String getPetType() {
		return this.type;
	}
}