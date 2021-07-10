package com.diplobot.game;

import java.util.ArrayList;

public class Game {

	private int totalNumberOfSupplyCenters;
	private ArrayList<Player> players;

	public Game( int totalNumberOfSupplyCenters){
		this.players = new ArrayList<>();
		this.totalNumberOfSupplyCenters = totalNumberOfSupplyCenters;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getTotalNumberOfSupplyCenters() {
		return totalNumberOfSupplyCenters;
	}

	public boolean isGameEnd(){

		int victoryCount = (this.totalNumberOfSupplyCenters / 2) + 1;

		for (Player player : this.players) {
			if (player.getNumOfSupplyCenters() >= victoryCount ){
				return true;
			}
		}
		return false;
	}

}
