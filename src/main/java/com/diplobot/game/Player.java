package com.diplobot.game;

public class Player {

	private String name;
	private int numOfSupplyCenters;
	private boolean wantsToEnd;
	private boolean stillInGame;

	public Player( String name, int numOfSupplyCenters){
		this.name = name;
		this.numOfSupplyCenters = numOfSupplyCenters;
		this.wantsToEnd = false;
		this.stillInGame = true;

	}

	public boolean isWantsToEnd() {
		return wantsToEnd;
	}

	public void setWantsToEnd(boolean wantsToEnd) {
		this.wantsToEnd = wantsToEnd;
	}

	public boolean isStillInGame() {
		return stillInGame;
	}

	public void setStillInGame(boolean stillInGame) {
		this.stillInGame = stillInGame;
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
