package com.elguerrero.stellarminigameframework;

import java.util.HashMap;

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

}
