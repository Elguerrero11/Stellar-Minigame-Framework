package com.elguerrero.stellarminigameframework.config;

import com.elguerrero.stellarframework.config.StellarConfig;
import com.elguerrero.stellarframework.config.StellarLangManager;
import com.elguerrero.stellarframework.config.StellarMessages;
import com.elguerrero.stellarframework.config.StellarMessagesManager;
import lombok.Getter;

public abstract class StellarMinigameMessages extends StellarMessages implements StellarMessagesManager {

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

	// Arena status messages

	@Getter
	private static String ARENA_STATUS_WAITING = null;
	@Getter
	private static String ARENA_STATUS_STARTING = null;
	@Getter
	private static String ARENA_STATUS_PLAYING = null;
	@Getter
	private static String ARENA_STATUS_ENDING = null;
	@Getter
	private static String ARENA_STATUS_RESTARTING = null;

	@Override
	public void loadStellarPluginMessagesVariables() {

		NO_ARENA_AVALIBLE = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("No_Arena_Avalible");
		ARENA_JOIN = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Join");
		ARENA_LEAVE = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Leave");
		ARENA_ALREADY_EXIST = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Already_Exist");
		NOT_IN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Not_In_Arena");
		PLAYER_JOIN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Join_Arena");
		PLAYER_LEAVE_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Leave_Arena");

		// Arena status messages

		ARENA_STATUS_WAITING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Waiting");
		ARENA_STATUS_STARTING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Starting");
		ARENA_STATUS_PLAYING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Playing");
		ARENA_STATUS_ENDING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Ending");
		ARENA_STATUS_RESTARTING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Restarting");

	}

}
