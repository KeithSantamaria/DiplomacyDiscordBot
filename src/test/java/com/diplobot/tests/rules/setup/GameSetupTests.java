package com.diplobot.tests.rules.setup;

import com.diplobot.game.Game;
import com.diplobot.game.GameConfig;
import com.diplobot.game.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameSetupTests {

	Game testGame;
	ArrayList<Province> testProvinces;
	@BeforeEach
	public void beforeEachTest(){
		testProvinces = new ArrayList<>();
		testProvinces.add( new Province("A" , true ) );
		testProvinces.add( new Province("B" , false) );
		testProvinces.add( new Province("C" , true ) );
		testProvinces.add( new Province("D" , true ) );
		testProvinces.add( new Province("E" , false) );
	}

	@Test
	public void shouldHaveValidGameConfig(){
		testGame = GameConfig.createNewGame(3, 5, testProvinces);

		Assertions.assertNotNull(testGame, "Game should exist");
	}

	@Test
	public void shouldFailConfigDueToInvalidProvinceSet(){
		testProvinces.add( new Province("F" , false) );
		testGame = GameConfig.createNewGame(3, 5, testProvinces);

		Assertions.assertNull(testGame, "Game should not exist");
	}

	@Test
	public void shouldFailConfigDueToTooManySupplyCenters(){
		testGame = GameConfig.createNewGame(6, 5, testProvinces);

		Assertions.assertNull(testGame, "Game should not exist");
	}

	@Test
	public void shouldFailConfigDueToMismatchSupplyCenters(){
		testProvinces.get(1).setSupplyCenter(true);
		testGame = GameConfig.createNewGame(3, 5, testProvinces);

		Assertions.assertNull(testGame, "Game should not exist");
	}

}
