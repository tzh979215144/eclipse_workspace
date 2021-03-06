package com.tanpang.day01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #10
 * 猫狗队列
 * @author tanpang
 *
 */
public class DogCatQueue {

	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;
	public DogCatQueue() {
		dogQ=new LinkedList<PetEnterQueue>();
		catQ=new LinkedList<PetEnterQueue>();
		this.count=0;
	}
	
	public void add(Pet pet) {
		if(pet.getPetType().equals("dog")) {
			this.dogQ.add(new PetEnterQueue(pet,this.count++));
		}else if(pet.getPetType().equals("cat")) {
			this.catQ.add(new PetEnterQueue(pet,this.count++));
		}else {
			throw new RuntimeException("err,not dog or cat");
		}
	}
	public Pet pollAll() {
		if(!this.catQ.isEmpty()&&!this.dogQ.isEmpty()) {
			if(this.catQ.peek().getCount()  <   this.dogQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			}else {
				return this.catQ.poll().getPet();
			}
		}else if(!this.dogQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		}else if(!this.catQ.isEmpty()) {
			return this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("err,queue is empty");
		}
	}
	public Pet pollDog() {
		if(!this.dogQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		}else {
			throw new RuntimeException("err,the dog queue is empty");
		}
	}
	public Pet pollCat() {
		if(!this.catQ.isEmpty()) {
			return this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("err,the cat queue is empty");
		}
	}
	public boolean isEmpty() {
			return this.dogQ.isEmpty()&&this.catQ.isEmpty();
	}
	public boolean isDogEmpty() {
		return this.dogQ.isEmpty();
	}
	public boolean isCatEmpty() {
		return this.catQ.isEmpty();
	}
	
}
