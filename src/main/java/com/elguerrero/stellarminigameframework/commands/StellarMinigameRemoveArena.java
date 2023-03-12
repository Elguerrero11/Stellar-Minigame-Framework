package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.StellarArena;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.entity.Player;

public class StellarMinigameRemoveArena {

	public static void registerRemoveArenaCommand() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-remove")
				.withRequirement(sender -> {
					if (sender instanceof Player) {
						return StellarUtils.checkPlayerPermission((Player) sender, "remove", true);
					} else {
						return false;
					}
				})
				.withHelp("Remove a " + StellarArena.getMINIGAME_NAME() + " arena.", "")
				.withArguments(new StringArgument("<arena_name>")
						.replaceSuggestions((ArgumentSuggestions) StellarArena.getARENAS_NAMES_LIST()))
				.executes((sender, args) -> {

					Player Player = (Player) sender;

					String arenaName = (String) args[0];
					StellarArena arena = StellarArena.getARENAS_LIST_HASHMAP().get(arenaName);

					if (arena != null) {

						if (StellarArena.getARENAS_NAMES_LIST().contains(arenaName)) {

							if (arena.getPlayersInThisArena().size() == 0) {

								arena.removeArena();

							} else {

								StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getARENA_CANT_BE_DELETED());

							}

						} else {

							StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getNO_ARENA());

						}

					}

				})
				.register();

	}

}
