package com.step.myspring.test;

public class Dog {
	
	String name;
	
	DogHua gh;
	
	public Dog() {
	}

	public Dog(String na) {
		this.name = na;
	}

	public DogHua getGh() {
		return gh;
	}

	public void setGh(DogHua gh) {
		System.out.println(this.name + " set {gh} : " + gh.getRoot());
		this.gh = gh;
	}
	
	public void say() {
		System.out.println(this.name + " get {gh} : " + gh.getRoot());
	}
	
}
