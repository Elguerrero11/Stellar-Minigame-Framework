package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;

public enum ArenaStatus {
	WAITING {
		@Override
		public String getName() {
			return StellarMinigameMessages.getARENA_STATUS_WAITING();
		}
	}, STARTING {
		@Override
		public String getName() {
			return StellarMinigameMessages.getARENA_STATUS_STARTING();
		}
	}, PLAYING {
		@Override
		public String getName() {
			return StellarMinigameMessages.getARENA_STATUS_PLAYING();
		}
	}, ENDING {
		@Override
		public String getName() {
			return StellarMinigameMessages.getARENA_STATUS_ENDING();
		}
	}, RESTARTING {
		@Override
		public String getName() {
			return StellarMinigameMessages.getARENA_STATUS_RESTARTING();
		}
	};

	public abstract String getName();

}

