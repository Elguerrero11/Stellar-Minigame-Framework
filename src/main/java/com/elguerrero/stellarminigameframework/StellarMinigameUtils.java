package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarminigameframework.config.StellarMinigameConfig;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import com.elguerrero.stellarminigameframework.stellarframework.utils.StellarUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.*;

public abstract class StellarMinigameUtils implements ArenaStructure {


	/**
	 * The player join a random arena
	 */
	public static void joinRandomArena(Player player) {

		List<String> arenasList = new ArrayList<>(Arena.getARENAS());


		if (arenasList.isEmpty()) {
			StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getNO_ARENA_AVALIBLE());
			return;
		}

		String randomArena = arenasList.get(new Random().nextInt(arenasList.size()));


		playerJoinArena(player, randomArena);
		StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getARENA_JOIN().replaceAll("%arena%", randomArena));

	}


	/**
	 * Method for add the player to a arena
	 *
	 * @param player    - The player to add
	 * @param arenaName - The name of the arena
	 */
	public static void playerJoinArena(Player player, String arenaName) {

		Set<UUID> arenaPlayersList = Arena.getPLAYERS_IN_EACH_ARENA().get(arenaName);

		arenaPlayersList.stream()
				.map(Bukkit::getPlayer)
				.filter(Player -> arenaPlayersList.contains(player.getUniqueId()))
				.forEach(Player -> StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getPLAYER_JOIN_ARENA().replaceAll("%player%", player.getName())));

		Arena.getPLAYERS_IN_ALL_ARENAS().put(player.getUniqueId(), arenaName);

		arenaPlayersList.add(player.getUniqueId());

		StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getARENA_JOIN());

	}

	/**
	 * Method for remove the player from a arena
	 *
	 * @param player    - The player to remove
	 * @param arenaName - The name of the arena
	 */
	public static void playerLeaveArena(Player player, String arenaName) {

		Set<UUID> arenaPlayersList = Arena.getPLAYERS_IN_EACH_ARENA().get(arenaName);


		Arena.getPLAYERS_IN_ALL_ARENAS().remove(player.getUniqueId());

		arenaPlayersList.remove(player.getUniqueId());

		arenaPlayersList.stream()
				.map(Bukkit::getPlayer)
				.filter(Player -> arenaPlayersList.contains(player.getUniqueId()))
				.forEach(Player -> StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getPLAYER_LEAVE_ARENA().replaceAll("%player%", player.getName())));

		StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getARENA_LEAVE());

	}

	/**
	 * Check if the player is in an arena and return the name of the arena
	 *
	 * @param player - The player to check
	 * @return - The name of the arena or null if the player is not in an arena
	 */
	public static String playerIsInArena(Player player) {

		return Arena.getPLAYERS_IN_ALL_ARENAS().getOrDefault(player.getUniqueId(), null);

	}

	/**
	 * Method that is called in the final plugin that is use this framework to load the minigame system
	 */

	public static void onLoad() {

		checkArenasFolder();
		checkArenasConfigFile();
		checkAddonsFolder();
		StellarMinigameMessages.loadMessages();
		StellarMinigameConfig.loadMinigameConfig();

	}


	// METHODS FOR CHECK THE FILES AND FOLDERS

	/**
	 * Method for check if the global arenas config file exist, if not, create it
	 */

	public static void checkArenasConfigFile() {

		try {
			if (!Arena.getARENAS_CONFIG_FILE().exists()) {
				Arena.getARENAS_CONFIG_FILE().createNewFile();
			}
		} catch (IOException ex) {

			StellarUtils.logException(ex);

		}
	}

	/**
	 * Check if the Addons folder exist, if not, create it
	 */
	public static void checkAddonsFolder() {

		if (!Arena.getADDONS_FOLDER().exists()) {
			Arena.getADDONS_FOLDER().mkdir();
		}
	}

	/**
	 * Check if the Arenas folder exist, if not, create it
	 */
	public static void checkArenasFolder() {

		if (!Arena.getARENAS_FOLDER().exists()) {
			Arena.getARENAS_FOLDER().mkdir();
		}
	}

}
