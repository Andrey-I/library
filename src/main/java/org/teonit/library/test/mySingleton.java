package org.teonit.library.test;

import org.springframework.stereotype.Component;

@Component
public class mySingleton {

	String testField;
	Integer integer;

	public mySingleton() {
		this.testField = "Test value";
		integer = 777;
	}
	public String getTestField() {
		return testField;
	}

	public void setTestField(String testField) {
		this.testField = testField;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}
	
	@Override
	public String toString() {
		return "mySingleton [testField=" + testField + ", integer=" + integer + "]";
	}

	
}
