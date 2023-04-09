package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.config.StellarMinigameConfig;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
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

		UUID playerUUID = player.getUniqueId();

		return StellarArena.getPLAYERS_IN_ARENAS().containsKey(playerUUID);

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

				replacedMessage = replacedMessage.replace("1", "➀");
				replacedMessage = replacedMessage.replace("2", "➁");
				replacedMessage = replacedMessage.replace("3", "➂");
				replacedMessage = replacedMessage.replace("4", "➃");
				replacedMessage = replacedMessage.replace("5", "➄");
				replacedMessage = replacedMessage.replace("6", "➅");
				replacedMessage = replacedMessage.replace("7", "➆");
				replacedMessage = replacedMessage.replace("8", "➇");
				replacedMessage = replacedMessage.replace("9", "➈");
				replacedMessage = replacedMessage.replace("10", "➉");

				break;

			case 3:

				replacedMessage = replacedMessage.replace("1", "⓵");
				replacedMessage = replacedMessage.replace("2", "⓶");
				replacedMessage = replacedMessage.replace("3", "⓷");
				replacedMessage = replacedMessage.replace("4", "⓸");
				replacedMessage = replacedMessage.replace("5", "⓹");
				replacedMessage = replacedMessage.replace("6", "⓺");
				replacedMessage = replacedMessage.replace("7", "⓻");
				replacedMessage = replacedMessage.replace("8", "⓼");
				replacedMessage = replacedMessage.replace("9", "⓽");
				replacedMessage = replacedMessage.replace("10", "⓾");

				break;

			case 4:

				replacedMessage = replacedMessage.replace("1", "①");
				replacedMessage = replacedMessage.replace("2", "②");
				replacedMessage = replacedMessage.replace("3", "③");
				replacedMessage = replacedMessage.replace("4", "④");
				replacedMessage = replacedMessage.replace("5", "⑤");
				replacedMessage = replacedMessage.replace("6", "⑥");
				replacedMessage = replacedMessage.replace("7", "⑦");
				replacedMessage = replacedMessage.replace("8", "⑧");
				replacedMessage = replacedMessage.replace("9", "⑨");
				replacedMessage = replacedMessage.replace("10", "⑩");
				replacedMessage = replacedMessage.replace("11", "⑪");
				replacedMessage = replacedMessage.replace("12", "⑫");
				replacedMessage = replacedMessage.replace("13", "⑬");
				replacedMessage = replacedMessage.replace("14", "⑭");
				replacedMessage = replacedMessage.replace("15", "⑮");
				replacedMessage = replacedMessage.replace("16", "⑯");
				replacedMessage = replacedMessage.replace("17", "⑰");
				replacedMessage = replacedMessage.replace("18", "⑱");
				replacedMessage = replacedMessage.replace("19", "⑲");
				replacedMessage = replacedMessage.replace("20", "⑳");

				break;

			case 5:

				replacedMessage = replacedMessage.replace("0", "⓿");
				replacedMessage = replacedMessage.replace("1", "➊");
				replacedMessage = replacedMessage.replace("2", "➋");
				replacedMessage = replacedMessage.replace("3", "➌");
				replacedMessage = replacedMessage.replace("4", "➍");
				replacedMessage = replacedMessage.replace("5", "➎");
				replacedMessage = replacedMessage.replace("6", "➏");
				replacedMessage = replacedMessage.replace("7", "➐");
				replacedMessage = replacedMessage.replace("8", "➑");
				replacedMessage = replacedMessage.replace("9", "➒");
				replacedMessage = replacedMessage.replace("10", "➓");

				break;

			case 6:

				replacedMessage = replacedMessage.replace("0", "⁰");
				replacedMessage = replacedMessage.replace("1", "¹");
				replacedMessage = replacedMessage.replace("2", "²");
				replacedMessage = replacedMessage.replace("3", "³");
				replacedMessage = replacedMessage.replace("4", "⁴");
				replacedMessage = replacedMessage.replace("5", "⁵");
				replacedMessage = replacedMessage.replace("6", "⁶");
				replacedMessage = replacedMessage.replace("7", "⁷");
				replacedMessage = replacedMessage.replace("8", "⁸");
				replacedMessage = replacedMessage.replace("9", "⁹");

				break;

			case 7:

				replacedMessage = replacedMessage.replace("1", "₁");
				replacedMessage = replacedMessage.replace("2", "₂");
				replacedMessage = replacedMessage.replace("3", "₃");
				replacedMessage = replacedMessage.replace("4", "₄");
				replacedMessage = replacedMessage.replace("5", "₅");
				replacedMessage = replacedMessage.replace("6", "₆");
				replacedMessage = replacedMessage.replace("7", "₇");
				replacedMessage = replacedMessage.replace("8", "₈");
				replacedMessage = replacedMessage.replace("9", "₉");

				break;

			case 8:

				replacedMessage = replacedMessage.replace("1", "⑴");
				replacedMessage = replacedMessage.replace("2", "⑵");
				replacedMessage = replacedMessage.replace("3", "⑶");
				replacedMessage = replacedMessage.replace("4", "⑷");
				replacedMessage = replacedMessage.replace("5", "⑸");
				replacedMessage = replacedMessage.replace("6", "⑹");
				replacedMessage = replacedMessage.replace("7", "⑺");
				replacedMessage = replacedMessage.replace("8", "⑻");
				replacedMessage = replacedMessage.replace("9", "⑼");
				replacedMessage = replacedMessage.replace("10", "⑽");
				replacedMessage = replacedMessage.replace("11", "⑾");
				replacedMessage = replacedMessage.replace("12", "⑿");
				replacedMessage = replacedMessage.replace("13", "⒀");
				replacedMessage = replacedMessage.replace("14", "⒁");
				replacedMessage = replacedMessage.replace("15", "⒂");
				replacedMessage = replacedMessage.replace("16", "⒃");
				replacedMessage = replacedMessage.replace("17", "⒄");
				replacedMessage = replacedMessage.replace("18", "⒅");
				replacedMessage = replacedMessage.replace("19", "⒆");
				replacedMessage = replacedMessage.replace("20", "⒇");

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

	public static boolean playerArenaIsInThisArenaMinigame(Player player, StellarArena Arena, String minigameName){

		return Arena.getMinigameName().equals(minigameName);

	}

}
