package com.serializationusingemployeeapi;

public class Employee {
	
	public String name;
	public int age;
	public int salary;

	public Employee(String string, int i, int j) {
	
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "employee name is "+this.name + " age is "+this.age+"salary is "+this.salary;
	}

}
