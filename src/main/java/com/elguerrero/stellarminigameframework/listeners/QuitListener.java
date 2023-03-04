package com.elguerrero.stellarminigameframework.listeners;

import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import com.elguerrero.stellarminigameframework.Arena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class QuitListener implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {

		Player player = event.getPlayer();
		UUID playerUUID = player.getUniqueId();

		if (Arena.getPLAYERS_IN_ARENAS().containsKey(playerUUID)) {

			Arena.getPLAYERS_IN_ARENAS().get(playerUUID).playerLeaveArena(player);

		}
	}

}
