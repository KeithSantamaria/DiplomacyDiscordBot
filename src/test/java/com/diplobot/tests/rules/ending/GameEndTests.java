package com.diplobot.tests.rules.ending;

import com.diplobot.game.Game;
import com.diplobot.game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameEndTests {

	Game testGame;

	@BeforeEach
	public void beforeEachTest(){
		testGame = new Game(34);
		testGame.getPlayers().add( new Player("Player A", 10) );
		testGame.getPlayers().add( new Player("Player B", 18) );
		testGame.getPlayers().add( new Player("Player C", 6 ) );
	}

	@Test
	public void shouldEndGameByWin(){

		boolean result =  testGame.isGameEnd();

		Assertions.assertTrue(result, "Should have ended game");
	}

	@Test
	public void shouldNotEndGame(){
		testGame.getPlayers().get(1).setNumOfSupplyCenters(17);

		boolean result = testGame.isGameEnd();

		Assertions.assertFalse(result, "Should have NOT ended gamed");
	}


	@Test
	public void shouldEndGameByAgreement(){

	}

	@Test
	public void shouldRejectEndGameAgreement(){

	}

	@Test
	public void shouldCallPlayerForfeit(){

	}
}
