package com.elguerrero.stellarminigameframework.config;

import com.elguerrero.stellarframework.config.StellarConfig;
import com.elguerrero.stellarframework.config.StellarConfigManager;
import lombok.Getter;

public class StellarMinigameConfig extends StellarConfig implements StellarConfigManager {

	@Getter
	private static Integer COUNTDOWN_SECONDS = null;
	@Getter
	private static Boolean WAITING_LOBBY = true;

	// Options related to countdown

	@Getter
	private static Boolean COUNTDOWN_TITLE_MESSAGE_ENABLED = true;

	@Getter
	private static Boolean COUNTDOWN_SUBTITLE_MESSAGE_ENABLED = true;

	@Getter
	private static Boolean COUNTDOWN_ACTIONBAR_MESSAGE_ENABLED = true;

	@Getter
	private static Boolean COUNTDOWN_CHAT_MESSAGE_ENABLED = true;

	@Getter
	private static Boolean SEND_COUNTDOWN_MESSAGE_IN_ALL_NUMBERS = true;

	@Getter
	private static Integer COUNTDOWN_NUMBER_TYPE = 1;


	@Override
	public void loadStellarPluginConfigVariables() {


		// Temp notes, to fix later when change the stellar framework
		/*
		COUNTDOWN_SECONDS = StellarConfig.getCONFIG_FILE().getInt("Countdown");
		WAITING_LOBBY = StellarConfig.getCONFIG_FILE().getBoolean("Waiting_Lobby");
		COUNTDOWN_TITLE_MESSAGE_ENABLED = StellarConfig.getCONFIG_FILE().getBoolean("Countdown_Title_Message_Enabled");
		COUNTDOWN_SUBTITLE_MESSAGE_ENABLED = StellarConfig.getCONFIG_FILE().getBoolean("Countdown_SubTitle_Message_Enabled");
		COUNTDOWN_ACTIONBAR_MESSAGE_ENABLED = StellarConfig.getCONFIG_FILE().getBoolean("Countdown_ActionBar_Message_Enabled");
		COUNTDOWN_CHAT_MESSAGE_ENABLED = StellarConfig.getCONFIG_FILE().getBoolean("Countdown_Chat_Message_Enabled");
		SEND_COUNTDOWN_MESSAGE_IN_ALL_NUMBERS = StellarConfig.getCONFIG_FILE().getBoolean("Send_Countdown_Message_In_All_Numbers");
		COUNTDOWN_NUMBER_TYPE = StellarConfig.getCONFIG_FILE().getInt("Countdown_Number_Type");
		 */

	}

}
