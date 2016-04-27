package org.teonit.library.test;

public class MyTestClass {

	String testField;
	
	public MyTestClass(String initialString) {
		testField = initialString;
	}
	
	public String getTestField() {
		return testField;
	}
	
	public void setTestField(String testField) {
		this.testField = testField;
	}

	@Override
	public String toString() {
		return "MyTestClass [testField=" + testField + "]";
	}

	
}
