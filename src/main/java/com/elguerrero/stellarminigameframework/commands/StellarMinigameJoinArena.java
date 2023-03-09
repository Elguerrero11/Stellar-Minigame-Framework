package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.ArenaStatus;
import com.elguerrero.stellarminigameframework.StellarArena;
import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.entity.Player;


public class StellarMinigameJoinArena {

	public static void registerJoinArenaCommand() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-join")
				.withRequirement(sender -> sender instanceof Player && StellarUtils.checkPlayerPermission((Player) sender, "join", true))
				.withHelp("Leave the " + StellarArena.getMINIGAME_NAME() + " arena.", "")
				.withArguments(new StringArgument("<arena_name>")
				.replaceSuggestions((ArgumentSuggestions) StellarArena.getARENAS_NAMES_LIST()))
				.executes((sender, args) -> {

					Player Player = (Player) sender;

					String arenaName = (String) args[0];
					StellarArena arena = StellarArena.getARENAS_LIST_HASHMAP().get(arenaName);

					if (arena != null) {

						if (StellarArena.getARENAS_NAMES_LIST().contains(arenaName)) {

							if (arena.getArenaStatus() == ArenaStatus.WAITING) {

								if (!StellarMinigameUtils.playerIsInAnArena(Player)) {

									arena.playerJoinArena(Player);

								} else {

									StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getPLAYER_ALREADY_IN_ARENA());

								}

							} else {

								StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getARENA_NO_IN_WAITING());

							}

						} else {

							StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getNO_ARENA());

						}

					}

				})
				.register();

	}

}
