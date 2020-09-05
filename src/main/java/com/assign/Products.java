package com.assign;

public class Products {

	public String name;
	public String url;
	public Kitchen kitchen;
	public Electronics electronics;

	public Kitchen getKitchen() {
		return kitchen;
	}

	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	public Electronics getElectronics() {
		return electronics;
	}

	public void setElectronics(Electronics electronics) {
		this.electronics = electronics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
