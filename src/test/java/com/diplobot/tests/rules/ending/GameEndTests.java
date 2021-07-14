package com.diplobot.tests.rules.ending;

import com.diplobot.game.Game;
import com.diplobot.game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameEndTests {

	Game testGame;

	@BeforeEach
	public void beforeEachTest(){
		testGame = new Game(34, 75);
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
		//Changing Player B to have 17 centers instead of 18
		testGame.getPlayers().get(1).setNumOfSupplyCenters(17);
		boolean result = testGame.isGameEnd();
		Assertions.assertFalse(result, "Should have NOT ended gamed");
	}


	@Test
	public void shouldEndGameByAgreement(){
		testGame.getPlayers().get(0).setWantsToEnd(true);
		testGame.getPlayers().get(1).setWantsToEnd(true);
		testGame.getPlayers().get(2).setWantsToEnd(true);

		boolean result = testGame.isGameEndByAgreement();
		Assertions.assertTrue(result, "Should have ended game by agreement");
	}

	@Test
	public void shouldEndGameByAgreementWithDeadPlayers(){
		testGame.getPlayers().get(0).setWantsToEnd(true);
		testGame.getPlayers().get(1).setWantsToEnd(true);
		testGame.getPlayers().get(2).setWantsToEnd(false);
		testGame.getPlayers().get(2).setStillInGame(false);

		boolean result = testGame.isGameEndByAgreement();
		Assertions.assertTrue(result, "Should have ended game by agreement");
	}

	@Test
	public void shouldRejectEndGameAgreement(){
		testGame.getPlayers().get(0).setWantsToEnd(true);
		testGame.getPlayers().get(1).setWantsToEnd(true);
		testGame.getPlayers().get(2).setWantsToEnd(false);

		boolean result = testGame.isGameEndByAgreement();
		Assertions.assertFalse(result, "Should have NOT ended game by agreement");
	}

//	@Test
//	public void shouldCallPlayerForfeit(){
//
//	}
}
