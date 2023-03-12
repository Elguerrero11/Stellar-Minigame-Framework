package com.elguerrero.stellarminigameframework.config;

import com.elguerrero.stellarframework.config.StellarConfig;
import com.elguerrero.stellarframework.config.StellarLangManager;
import com.elguerrero.stellarframework.config.StellarMessages;
import com.elguerrero.stellarframework.config.StellarMessagesManager;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class StellarMinigameMessages extends StellarMessages implements StellarMessagesManager {

	@Getter
	private static String ARENA_NO_IN_WAITING = null;
	@Getter
	private static String PLAYER_ALREADY_IN_ARENA = null;
	@Getter
	private static String NO_ARENA = null;
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
	@Getter
	private static String ARENA_CANT_BE_DELETED = null;

	@Getter
	private static String COUNTDOWN_CANCELLED = null;

	// StellarArena status messages

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

	// Messages related to the countdown

	@Getter
	private static String COUNTDOWN_NUMBER_FORMAT = null;


	@Getter
	private static HashMap<Integer, String> CHAT_NUMBERS_TO_SEND_COOLDOWN_MESSAGE = new HashMap<>();

	@Getter
	private static HashMap<Integer, String> TITLE_NUMBERS_TO_SEND_COOLDOWN_MESSAGE = new HashMap<>();

	@Getter
	private static HashMap<Integer, String> SUBTITLE_NUMBERS_TO_SEND_COOLDOWN_MESSAGE = new HashMap<>();

	@Getter
	private static HashMap<Integer, String> ACTIONBAR_NUMBERS_TO_SEND_COOLDOWN_MESSAGE = new HashMap<>();


	@Override
	public void loadStellarPluginMessagesVariables() {

		ARENA_CANT_BE_DELETED = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Cant_Be_Deleted");
		ARENA_NO_IN_WAITING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_No_In_Waiting");
		PLAYER_ALREADY_IN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Already_In_Arena");
		NO_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("No_Arena");
		NO_ARENA_AVALIBLE = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("No_Arena_Avalible");
		ARENA_JOIN = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Join");
		ARENA_LEAVE = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Leave");
		ARENA_ALREADY_EXIST = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Already_Exist");
		NOT_IN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Not_In_Arena");
		PLAYER_JOIN_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Join_Arena");
		PLAYER_LEAVE_ARENA = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Player_Leave_Arena");
		COUNTDOWN_CANCELLED = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Countdown_Cancelled");

		// StellarArena status messages

		ARENA_STATUS_WAITING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Waiting");
		ARENA_STATUS_STARTING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Starting");
		ARENA_STATUS_PLAYING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Playing");
		ARENA_STATUS_ENDING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Ending");
		ARENA_STATUS_RESTARTING = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Arena_Status_Restarting");

		// Messages related to the countdown

		COUNTDOWN_NUMBER_FORMAT = StellarLangManager.getSELECTED_LANGUAGE_FILE().getString("Countdown_Number_Format");

		StellarLangManager.getSELECTED_LANGUAGE_FILE().getList("Chat_Numbers_To_Send_Cooldown_Message").forEach(map -> {
			Map.Entry<?, ?> entry = ((HashMap<?, ?>) map).entrySet().iterator().next();
			Integer number = entry.getKey() instanceof Number ? ((Number) entry.getKey()).intValue() : 0;
			String message = entry.getValue().toString();
			CHAT_NUMBERS_TO_SEND_COOLDOWN_MESSAGE.put(number, message);
		});

		StellarLangManager.getSELECTED_LANGUAGE_FILE().getList("Title_Numbers_To_Send_Cooldown_Message").forEach(map -> {
			Map.Entry<?, ?> entry = ((HashMap<?, ?>) map).entrySet().iterator().next();
			Integer number = entry.getKey() instanceof Number ? ((Number) entry.getKey()).intValue() : 0;
			String message = entry.getValue().toString();
			TITLE_NUMBERS_TO_SEND_COOLDOWN_MESSAGE.put(number, message);
		});

		StellarLangManager.getSELECTED_LANGUAGE_FILE().getList("Subtitle_Numbers_To_Send_Cooldown_Message").forEach(map -> {
			Map.Entry<?, ?> entry = ((HashMap<?, ?>) map).entrySet().iterator().next();
			Integer number = entry.getKey() instanceof Number ? ((Number) entry.getKey()).intValue() : 0;
			String message = entry.getValue().toString();
			SUBTITLE_NUMBERS_TO_SEND_COOLDOWN_MESSAGE.put(number, message);
		});

		StellarLangManager.getSELECTED_LANGUAGE_FILE().getList("Actionbar_Numbers_To_Send_Cooldown_Message").forEach(map -> {
			Map.Entry<?, ?> entry = ((HashMap<?, ?>) map).entrySet().iterator().next();
			Integer number = entry.getKey() instanceof Number ? ((Number) entry.getKey()).intValue() : 0;
			String message = entry.getValue().toString();
			ACTIONBAR_NUMBERS_TO_SEND_COOLDOWN_MESSAGE.put(number, message);
		});


	}

}
