package com.diplobot.game;

public class Player {

	private String name;
	private int numOfSupplyCenters;

	public Player( String name, int numOfSupplyCenters){
		this.name = name;
		this.numOfSupplyCenters = numOfSupplyCenters;
	}

	public String getName() {
		return name;
	}

	public int getNumOfSupplyCenters() {
		return numOfSupplyCenters;
	}

	public void setNumOfSupplyCenters(int numOfSupplyCenters) {
		this.numOfSupplyCenters = numOfSupplyCenters;
	}

}
