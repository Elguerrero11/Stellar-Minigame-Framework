package com.elguerrero.stellarminigameframework.config;

import com.elguerrero.stellarframework.config.StellarConfig;
import com.elguerrero.stellarframework.config.StellarConfigManager;
import lombok.Getter;

public class StellarMinigameConfig extends StellarConfig implements StellarConfigManager {

	@Getter
	private static Integer COOLDOWN_SECONDS = null;
	@Getter
	private static boolean WAITING_LOBBY = true;

	@Override
	public void loadStellarPluginConfigVariables() {

		COOLDOWN_SECONDS = StellarConfig.getCONFIG_FILE().getInt("Cooldown");
		WAITING_LOBBY = StellarConfig.getCONFIG_FILE().getBoolean("Waiting_Lobby");

	}

}
