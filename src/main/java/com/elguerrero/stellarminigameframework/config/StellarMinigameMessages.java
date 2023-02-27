package com.elguerrero.stellarminigameframework.config;

import com.elguerrero.stellarminigameframework.stellarframework.config.StellarLangManager;
import com.elguerrero.stellarminigameframework.stellarframework.config.StellarMessages;
import lombok.Getter;

public abstract class StellarMinigameMessages extends StellarMessages {

	@Getter
	private static String NO_ARENA_AVALIBLE = null;
	@Getter
	private static String ARENA_JOIN = null;
	@Getter
	private static String ARENA_LEAVE = null;
	@Getter
	private static String ARENA_ALREADY_EXIST = null;
	@Getter
	private static String NOT_IN_ARENA = null;
	@Getter
	private static String PLAYER_JOIN_ARENA = null;
	@Getter
	private static String PLAYER_LEAVE_ARENA = null;

	public static void loadMessages() {

		NO_ARENA_AVALIBLE = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("No_Arena_Avalible");
		ARENA_JOIN = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Join");
		ARENA_LEAVE = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Leave");
		ARENA_ALREADY_EXIST = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Already_Exist");
		NOT_IN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Not_In_Arena");
		PLAYER_JOIN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Join_Arena");
		PLAYER_LEAVE_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Leave_Arena");

	}

}
