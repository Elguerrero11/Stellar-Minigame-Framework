package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.ArenaStructure;
import com.elguerrero.stellarminigameframework.StellarArena;
import com.elguerrero.stellarminigameframework.config.StellarMinigameConfig;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import jdk.nashorn.internal.ir.IfNode;
import org.bukkit.Bukkit;
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

	// Methods for send messages to all the players of a arena

	/**
	 * Method for send a title message to all players of a arena
	 * <p>
	 * I ignore the warn about the null pointer exception because the player is not null never
	 *
	 * @param arena   - The arena where the message will be send
	 * @param message - The message to send
	 * @param fadeIn  - The time that the title will take to appear
	 * @param stay    - The time that the title will stay
	 * @param fadeOut - The time that the title will take to disappear
	 */

	public static void sendTitleToArenaPlayers(StellarArena arena, String message, int fadeIn, int stay, int fadeOut) {

		arena.getPlayersInThisArena().stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> player.sendTitle(message, "", fadeIn, stay, fadeOut));

	}

	/**
	 * Method for send a subtitle message to all players of a arena
	 * <p>
	 * I ignore the warn about the null pointer exception because the player is not null never
	 *
	 * @param arena   - The arena where the message will be send
	 * @param message - The message to send
	 * @param fadeIn  - The time that the subtitle will take to appear
	 * @param stay    - The time that the subtitle will stay
	 * @param fadeOut - The time that the subtitle will take to disappear
	 */
	public static void sendSubtitleToArenaPlayers(StellarArena arena, String message, int fadeIn, int stay, int fadeOut) {

		arena.getPlayersInThisArena().stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> player.sendTitle("", message, fadeIn, stay, fadeOut));

	}

	// TODO: I dont remember right now how to send a actionbar
	/*
	public static void sendActionBarToArenaPlayers(StellarArena arena, String message, Player player) {

		arena.getPlayersInThisArena().stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> );

	}*/

	/**
	 * Method for send a chat message to all players of a arena
	 * <p>
	 * I ignore the warn about the null pointer exception because the player is not null never
	 *
	 * @param arena   - The arena where the message will be send
	 * @param message - The message to send
	 */

	public static void sendChatMessageToArenaPlayers(StellarArena arena, String message) {

		arena.getPlayersInThisArena().stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> player.sendMessage(message));

	}

	// Methods for send messages to all the players of a arena of a team


	/**
	 * Method for send a title message to all players of a arena of a team
	 * <p>
	 * I ignore the warn about the null pointer exception because the player is not null never
	 *
	 * @param arena   - The arena where the message will be send
	 * @param message - The message to send
	 * @param fadeIn  - The time that the title will take to appear
	 * @param stay    - The time that the title will stay
	 * @param fadeOut - The time that the title will take to disappear
	 */

	public static void sendTitleToArenaTeamPlayers(StellarArena arena, String teamName, String message, int fadeIn, int stay, int fadeOut) {

		arena.getTeamPlayers(teamName).stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> player.sendTitle(message, "", fadeIn, stay, fadeOut));


	}

	/**
	 * Method for send a subtitle message to all players of a arena of a team
	 * <p>
	 * I ignore the warn about the null pointer exception because the player is not null never
	 *
	 * @param arena   - The arena where the message will be send
	 * @param message - The message to send
	 * @param fadeIn  - The time that the subtitle will take to appear
	 * @param stay    - The time that the subtitle will stay
	 * @param fadeOut - The time that the subtitle will take to disappear
	 */

	public static void sendSubtitleToArenaTeamPlayers(StellarArena arena, String teamName, String message, int fadeIn, int stay, int fadeOut) {

		arena.getTeamPlayers(teamName).stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> player.sendTitle("", message, fadeIn, stay, fadeOut));

	}

	/**
	 * Method for send a chat message to all players of a arena of a team
	 * <p>
	 * I ignore the warn about the null pointer exception because the player is not null never
	 *
	 * @param arena   - The arena where the message will be send
	 * @param message - The message to send
	 */

	public static void sendChatMessageToArenaTeamPlayers(StellarArena arena, String teamName, String message) {

		arena.getTeamPlayers(teamName).stream()
				.map(Bukkit::getPlayer)
				.forEach(player -> player.sendMessage(message));

	}


	// Methods related to countdown system

	// TODO: This method
	/*public static void sendCountdownMessageToArenaPlayers(StellarArena arena, int time) {

		if (StellarMinigameConfig.get)

	}
    */

	private static String replaceNumberType(String messageToReplace, int numberType) {

		String replacedMessage = messageToReplace;

		switch (numberType) {

			case 2:

				replacedMessage = replacedMessage.replace("1", "???");
				replacedMessage = replacedMessage.replace("2", "???");
				replacedMessage = replacedMessage.replace("3", "???");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");
				replacedMessage = replacedMessage.replace("10", "???");

				break;

			case 3:

				replacedMessage = replacedMessage.replace("1", "???");
				replacedMessage = replacedMessage.replace("2", "???");
				replacedMessage = replacedMessage.replace("3", "???");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");
				replacedMessage = replacedMessage.replace("10", "???");

				break;

			case 4:

				replacedMessage = replacedMessage.replace("1", "???");
				replacedMessage = replacedMessage.replace("2", "???");
				replacedMessage = replacedMessage.replace("3", "???");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");
				replacedMessage = replacedMessage.replace("10", "???");
				replacedMessage = replacedMessage.replace("11", "???");
				replacedMessage = replacedMessage.replace("12", "???");
				replacedMessage = replacedMessage.replace("13", "???");
				replacedMessage = replacedMessage.replace("14", "???");
				replacedMessage = replacedMessage.replace("15", "???");
				replacedMessage = replacedMessage.replace("16", "???");
				replacedMessage = replacedMessage.replace("17", "???");
				replacedMessage = replacedMessage.replace("18", "???");
				replacedMessage = replacedMessage.replace("19", "???");
				replacedMessage = replacedMessage.replace("20", "???");

				break;

			case 5:

				replacedMessage = replacedMessage.replace("0", "???");
				replacedMessage = replacedMessage.replace("1", "???");
				replacedMessage = replacedMessage.replace("2", "???");
				replacedMessage = replacedMessage.replace("3", "???");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");
				replacedMessage = replacedMessage.replace("10", "???");

				break;

			case 6:

				replacedMessage = replacedMessage.replace("0", "???");
				replacedMessage = replacedMessage.replace("1", "??");
				replacedMessage = replacedMessage.replace("2", "??");
				replacedMessage = replacedMessage.replace("3", "??");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");

				break;

			case 7:

				replacedMessage = replacedMessage.replace("1", "???");
				replacedMessage = replacedMessage.replace("2", "???");
				replacedMessage = replacedMessage.replace("3", "???");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");

				break;

			case 8:

				replacedMessage = replacedMessage.replace("1", "???");
				replacedMessage = replacedMessage.replace("2", "???");
				replacedMessage = replacedMessage.replace("3", "???");
				replacedMessage = replacedMessage.replace("4", "???");
				replacedMessage = replacedMessage.replace("5", "???");
				replacedMessage = replacedMessage.replace("6", "???");
				replacedMessage = replacedMessage.replace("7", "???");
				replacedMessage = replacedMessage.replace("8", "???");
				replacedMessage = replacedMessage.replace("9", "???");
				replacedMessage = replacedMessage.replace("10", "???");
				replacedMessage = replacedMessage.replace("11", "???");
				replacedMessage = replacedMessage.replace("12", "???");
				replacedMessage = replacedMessage.replace("13", "???");
				replacedMessage = replacedMessage.replace("14", "???");
				replacedMessage = replacedMessage.replace("15", "???");
				replacedMessage = replacedMessage.replace("16", "???");
				replacedMessage = replacedMessage.replace("17", "???");
				replacedMessage = replacedMessage.replace("18", "???");
				replacedMessage = replacedMessage.replace("19", "???");
				replacedMessage = replacedMessage.replace("20", "???");

				break;

		}

		return replacedMessage;

	}


	private static String doAllCountdownMessageReplaces(String messageToReplace, int countdownNumber){

		String chat_message = messageToReplace;
		int numberType = StellarMinigameConfig.getCOUNTDOWN_NUMBER_TYPE();

		if (chat_message.contains("%time%") && !chat_message.isEmpty()){


			chat_message = chat_message.replace("%time%", StellarMinigameMessages.getCOUNTDOWN_NUMBER_FORMAT())
					.replace("%time%", String.valueOf(countdownNumber));
			chat_message = StellarMinigameUtils.replaceNumberType(chat_message, numberType);


		} else if (!chat_message.contains("%time%")) {

			chat_message = chat_message + countdownNumber;
			chat_message = replaceNumberType(chat_message, numberType);


		} else if (chat_message.isEmpty()){

			chat_message = String.valueOf(countdownNumber);
			chat_message = replaceNumberType(chat_message, numberType);

		}

		return chat_message;

	}


	// TODO: To finish
	public static void sendCountdownMessage(StellarArena arena, int countdownNumber){


		String countdown_message = StellarMinigameUtils.doAllCountdownMessageReplaces(StellarMinigameMessages.getCOUNTDOWN_NUMBER_FORMAT(), countdownNumber);


		// Send Chat message

		if (StellarMinigameConfig.getCOUNTDOWN_CHAT_MESSAGE_ENABLED()){

			if (StellarMinigameConfig.getSEND_COUNTDOWN_MESSAGE_IN_ALL_NUMBERS()){

				StellarMinigameUtils.sendChatMessageToArenaPlayers(arena, countdown_message);

			} else {

				if (StellarMinigameMessages.getCHAT_NUMBERS_TO_SEND_COOLDOWN_MESSAGE().containsKey(countdownNumber)){

					sendChatMessageToArenaPlayers(arena, countdown_message);

				}

			}

		}

		// Send Title message

		if (StellarMinigameConfig.getCOUNTDOWN_TITLE_MESSAGE_ENABLED()){

			if (StellarMinigameConfig.getSEND_COUNTDOWN_MESSAGE_IN_ALL_NUMBERS()){

				sendTitleToArenaPlayers(arena, countdown_message,0, 20, 0);

			} else {

				if (StellarMinigameMessages.getTITLE_NUMBERS_TO_SEND_COOLDOWN_MESSAGE().containsKey(countdownNumber)){

					sendTitleToArenaPlayers(arena, countdown_message,0, 20, 0);

				}

			}

		}

		// Send SubTitle message

		if (StellarMinigameConfig.getCOUNTDOWN_SUBTITLE_MESSAGE_ENABLED()){

			if (StellarMinigameConfig.getSEND_COUNTDOWN_MESSAGE_IN_ALL_NUMBERS()){

				sendSubtitleToArenaPlayers(arena, countdown_message,0, 20, 0);

			} else {

				if (StellarMinigameMessages.getSUBTITLE_NUMBERS_TO_SEND_COOLDOWN_MESSAGE().containsKey(countdownNumber)){

					sendSubtitleToArenaPlayers(arena, countdown_message,0, 20, 0);

				}

			}

		}

		// Send ActionBar message
		// TODO: To do the ActionBar message

		/*
		if (StellarMinigameConfig.getCOUNTDOWN_ACTIONBAR_MESSAGE_ENABLED()){

			if (StellarMinigameConfig.getSEND_COUNTDOWN_MESSAGE_IN_ALL_NUMBERS()){

				sendActionBarToArenaPlayers(arena, countdown_message);

			} else {

				if (StellarMinigameMessages.getACTIONBAR_NUMBERS_TO_SEND_COOLDOWN_MESSAGE().containsKey(countdownNumber)){

					sendActionBarToArenaPlayers(arena, countdown_message);

				}

			}

		}*/

	}


}
