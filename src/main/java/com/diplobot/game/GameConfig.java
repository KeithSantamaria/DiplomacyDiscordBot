package com.diplobot.game;

import java.util.ArrayList;


public class GameConfig {

	private static int getNumOfSupplyCentersInProvinces(ArrayList<Province> provinces){
		int supplyCount = 0;
		for ( Province province : provinces){
			if(province.isSupplyCenter()){
				supplyCount++;
			}
		}
		return supplyCount;
	}

	public static Game createNewGame(int numOfSupplyCenters, int numOfProvinces, ArrayList<Province> provinces){
		if( numOfSupplyCenters > numOfProvinces){
			return null;
		}

		if( provinces.size() != numOfProvinces ){
			return null;
		}

		if( getNumOfSupplyCentersInProvinces(provinces) != numOfSupplyCenters){
			return null;
		}

		return new Game( numOfSupplyCenters, numOfProvinces);
	}
}
