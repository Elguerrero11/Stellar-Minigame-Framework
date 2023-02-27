package com.elguerrero.stellarminigameframework.config;

import com.elguerrero.stellarminigameframework.stellarframework.config.StellarConfig;

public class StellarMinigameConfig {

	private static Integer COOLDOWN_SECONDS = null;

	public static void loadMinigameConfig() {

		COOLDOWN_SECONDS = StellarConfig.getCONFIG_FILE().getInt("Cooldown");

	}
}
