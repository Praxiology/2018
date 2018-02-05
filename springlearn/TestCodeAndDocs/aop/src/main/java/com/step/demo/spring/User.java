package com.step.demo.spring;

public class User {

	private String name="jack";
	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		//System.out.println("User equers()");
		if (obj instanceof User) {
			if (((User) obj).getName().equals(this.getName())) {
				return true;
			}
		}
		return false;
	}

}
