package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.entity.Player;

public class StellarMinigameForceStartArena {

	public static void registerForceStartArenaCommand() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-force_start")
				.withRequirement(sender -> {
					if (sender instanceof Player) {
						return StellarUtils.checkPlayerPermission((Player) sender, "forcestart", true);
					} else {
						return true;
					}
				})
				.withHelp("Force the " + StellarPlugin.getPLUGIN_NAME() + " arena to start now.", "")
				.executes((sender, args) -> {

					if (StellarUtils.senderIsConsole(sender)) {

						// TODO: Add the method to start the arena now sending the arena name as a parameter

					} else {

						// TODO: Add the method to start the arena now sending the arena name as a parameter

					}
				})
				.register();

	}

}
