package com.step.myspring.context;


import com.step.myspring.beans.BeanFactory;

public class StartContext {
	
    BeanFactory bf;
    
    public <T> T getObjectByType(String alias,Class<T> t){
    	Object returnVal = null;
    	returnVal = bf.getObject(alias);
    	if (null != returnVal) {
    		return (T) returnVal;
    	}
		return null;
    }

	public BeanFactory getBf() {
		return bf;
	}

	public void setBf(BeanFactory bf) {
		this.bf = bf;
	}
    
}
