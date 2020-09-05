package com.serializationusingemployeeapi;

public class Car {
	public String make;
	public String model;
	public String variant;
	public String color;
	public Engine detail;
	
	
	public Engine getDetail() {
		return detail;
	}
	public void setDetail(Engine detail) {
		this.detail = detail;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
		}
}