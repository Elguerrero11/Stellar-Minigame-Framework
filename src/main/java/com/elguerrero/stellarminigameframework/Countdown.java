package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarminigameframework.config.StellarMinigameConfig;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

	// The time is in seconds
    @Setter
	private int remainingTime = StellarMinigameConfig.getCOUNTDOWN_SECONDS();
	@Setter
	@Getter
	public Boolean isRunning = false;
	private StellarArena arena;

	public Countdown(StellarArena arena) {

		this.arena = arena;

	}


	@Override
	public void run() {

		if (remainingTime == 0){

			arena.startGame();
			this.remainingTime = 60;
			this.arena.setArenaStatus(ArenaStatus.PLAYING);
			this.isRunning = false;
			cancel();

		}

		StellarMinigameUtils.sendCountdownMessage(arena, remainingTime);

	}



}
