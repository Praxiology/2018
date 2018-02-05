package com.step.demo.spring;

public class UserDao implements UserDaoInf,UserDaoInf2 {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		//System.out.println(user.getClass().getName());
		this.user = user;
	}
	
	@Override
	public void syaHello(User usr) {
		if ( this.user != null && this.user.equals(usr)) {
			System.out.println("we are same!");
		} else {
			System.out.println("we are not same!");
		}
	}

	@Override
	public void sayHi(String name) {
		
		if (null != this.user) {
			System.out.println("we here " + name);
		} else {
			System.out.println("we not here " + name);
		}
		
	}
	
}
