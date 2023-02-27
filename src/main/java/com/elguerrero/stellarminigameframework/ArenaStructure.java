package com.elguerrero.stellarminigameframework;

import java.util.Set;

public interface ArenaStructure {

	/**
	 * This method is called before the game start
	 * Like in the pre-game lobby with the countdown
	 */
	void startPreGame();

	/**
	 * This method is called when the game start
	 */
	void startGame();

	/**
	 * This method is called when the game end
	 */
	void endGame();

	default void start() {
		startPreGame();
		startGame();
		endGame();
	}

	static Set<String> getAllArenas(){
		return Arena.getARENAS();
	}

	static void getAllPlayersInArenas(){
		Arena.getPLAYERS_IN_ALL_ARENAS();
	}

}
