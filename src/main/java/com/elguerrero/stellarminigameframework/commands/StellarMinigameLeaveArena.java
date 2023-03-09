package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.StellarArena;
import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.entity.Player;

public class StellarMinigameLeaveArena {

	public static void registerLeaveArenaCommand() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-leave")
				.withRequirement(sender -> sender instanceof Player && StellarUtils.checkPlayerPermission((Player) sender, "leave", true))
				.withHelp("Leave the " + StellarArena.getMINIGAME_NAME() + " arena.", "")
				.executes((sender, args) -> {

					Player Player = (Player) sender;

					if (StellarMinigameUtils.playerIsInAnArena(Player)) {
						StellarMinigameUtils.inWhichArenaIsThePlayer(Player).playerLeaveArena(Player);
					} else {
						StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getNOT_IN_ARENA());
					}

				})
				.register();

	}

}
