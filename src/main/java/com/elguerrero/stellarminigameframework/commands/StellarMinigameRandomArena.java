package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.entity.Player;

public abstract class StellarMinigameRandomArena {

	public static void registerRandomArenaCommand() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-random_arena")
				.withRequirement((sender) -> StellarUtils.checkPlayerPermission((Player) sender, "randomarena", true))
				.withHelp("Join a random arena","")
				.executesPlayer((player, args) -> {
					StellarMinigameUtils.joinRandomArena(player);
				})
				.register();

	}
}
