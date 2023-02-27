package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import com.elguerrero.stellarminigameframework.stellarframework.StellarPlugin;
import com.elguerrero.stellarminigameframework.stellarframework.utils.StellarUtils;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.entity.Player;

public abstract class StellarMinigameRandomArena {

	public static void randomArena() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-random_arena")
				.withRequirement((sender) -> StellarUtils.checkPlayerPermission((Player) sender, "randomarena", true))
				.withHelp("Join a random arena","")
				.executesPlayer((player, args) -> {
					StellarMinigameUtils.joinRandomArena(player);
				})
				.register();

	}
}
