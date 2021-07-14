package com.diplobot.game;

public class Province {
	private String name;
	private boolean supplyCenter;

	public Province( String name, boolean supplyCenter){
		this.name = name;
		this.supplyCenter = supplyCenter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSupplyCenter() {
		return supplyCenter;
	}

	public void setSupplyCenter(boolean supplyCenter) {
		this.supplyCenter = supplyCenter;
	}
}
