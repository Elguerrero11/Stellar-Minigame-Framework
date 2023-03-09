package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import org.bukkit.entity.Player;

import java.util.*;

public abstract class StellarMinigameUtils implements ArenaStructure {

	/**
	 * Method for check if a player is in an arena
	 *
	 * @param player - The player to check
	 * @return - True if the player is in an arena, false if not
	 */
	public static boolean playerIsInAnArena(Player player) {

		if (StellarArena.getPLAYERS_IN_ARENAS().containsKey(player.getUniqueId())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Check for see in which arena is the player
	 *
	 * @param player - The player to check
	 * @return - The name of the arena
	 */
	public static StellarArena inWhichArenaIsThePlayer(Player player) {

		return StellarArena.getPLAYERS_IN_ARENAS().get(player.getUniqueId());

	}

	/**
	 * Method that is called in the final plugin that is use this framework to load the minigame system
	 */

	public static void onLoad() {

		StellarUtils.pluginFileExist(StellarArena.getARENAS_FOLDER(), true);
		StellarUtils.pluginFileExist(StellarArena.getARENAS_CONFIG_FILE(), false);
		StellarUtils.pluginFileExist(StellarArena.getADDONS_FOLDER(), true);


	}

	/**
	 * Method for write the basic things in the arenas.yml file if the file is empty
	 * <p>
	 * TODO: Rename the method maybe
	 * TODO: Add the basic things like the mainlobby spawn
	 * TODO: Add a try and catch method to all the method code
	 */
	public static void writeBasicArenaConfig() {

	}

}
