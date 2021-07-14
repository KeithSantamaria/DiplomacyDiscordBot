package com.diplobot.game;

import java.util.ArrayList;

public class Game {

	private int numberOfSupplyCenters;
	private int numberOfProvinces;
	private ArrayList<Player> players;

	public Game( int totalNumberOfSupplyCenters, int numberOfProvinces){
		this.players = new ArrayList<>();
		this.numberOfSupplyCenters = totalNumberOfSupplyCenters;
		this.numberOfProvinces = numberOfProvinces;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public int getNumberOfSupplyCenters() {
		return numberOfSupplyCenters;
	}

	public boolean isGameEnd(){

		int victoryCount = (this.numberOfSupplyCenters / 2) + 1;

		for (Player player : this.players) {
			if (player.getNumOfSupplyCenters() >= victoryCount ){
				return true;
			}
		}
		return false;
	}

	public boolean isGameEndByAgreement(){
		for ( Player player : this.players) {
			if( player.isStillInGame() ){
				if ( !player.isWantsToEnd() ){
					return false;
				}
			}
		}
		return true;
	}

}
