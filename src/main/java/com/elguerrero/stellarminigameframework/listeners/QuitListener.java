package com.elguerrero.stellarminigameframework.listeners;

import com.elguerrero.stellarminigameframework.StellarMinigameUtils;
import com.elguerrero.stellarminigameframework.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {

		if (Arena.getPLAYERS_IN_ALL_ARENAS().containsKey(event.getPlayer().getUniqueId())) {

			StellarMinigameUtils.playerLeaveArena(event.getPlayer(), Arena.getPLAYERS_IN_ALL_ARENAS().get(event.getPlayer().getUniqueId()));

		}
	}

}
