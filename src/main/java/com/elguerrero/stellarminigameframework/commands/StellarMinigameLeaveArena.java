package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarminigameframework.Arena;
import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import com.elguerrero.stellarminigameframework.stellarframework.StellarPlugin;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import com.elguerrero.stellarminigameframework.stellarframework.utils.StellarUtils;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.entity.Player;

public class StellarMinigameLeaveArena {

	public static void leaveArena() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-leave")
				.withRequirement(sender -> sender instanceof Player)
				.withHelp("Leave the" + Arena.getMINIGAME_NAME() + "arena.", "")
				.executes((sender, args) -> {

					Player Player = (Player) sender;

					if (StellarMinigameUtils.playerIsInArena(Player) != null) {
						StellarMinigameUtils.playerLeaveArena(Player, StellarMinigameUtils.playerIsInArena((Player) sender));
					} else {
						StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getNOT_IN_ARENA());
					}

				})
				.register();

	}
}
