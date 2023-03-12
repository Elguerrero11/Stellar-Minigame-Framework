package com.elguerrero.stellarminigameframework.commands;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.StellarArena;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public abstract class StellarMinigameRandomArena {

	public static void registerRandomArenaCommand() {

		new CommandAPICommand(StellarPlugin.getPLUGIN_NAME() + "-join_random_arena")
				.withRequirement((sender) -> StellarUtils.checkPlayerPermission((Player) sender, "joinrandomarena", true))
				.withHelp("Join a random arena.","")
				.executesPlayer((player, args) -> {
					joinRandomArena(player);
				})
				.register();

	}

	/**
	 * The method used for that the player join a random arena
	 */
	public static void joinRandomArena(Player player) {

		List<StellarArena> arenasList = StellarArena.getARENAS_LIST();

		if (arenasList.isEmpty()) {

			StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getNO_ARENA_AVALIBLE());

		} else {

			StellarArena randomStellarArena = arenasList.get(new Random().nextInt(arenasList.size()));

			randomStellarArena.playerJoinArena(player);

		}
	}

}
