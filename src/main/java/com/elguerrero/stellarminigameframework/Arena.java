package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.config.StellarMinigameConfig;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

public abstract class Arena {

	// General variables of this minigame plugin


	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static Arena CHILD_INSTANCE = null;

	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static String MINIGAME_NAME = "StellarMinigame";

	@Getter
	private static final File ARENAS_FOLDER = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Arenas");

	@Getter
	private static final File ARENAS_CONFIG_FILE = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Arenas/arenas.yml");

	@Getter
	private static final File ADDONS_FOLDER = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Addons");

	@Getter
	private static List<Arena> ARENAS_LIST = new ArrayList<>();

	private static HashMap<String,Arena> ARENAS_LIST_HASHMAP = new HashMap<>();


	@Getter
	private static HashMap<UUID,Arena> PLAYERS_IN_ARENAS = new HashMap<>();


	// Variables for each arena

	@Getter
	private String arenaName = "";
	@Getter
	private int minPlayers = 2;
	@Getter
	private int maxPlayers = 6;

	@Getter
	private int cooldownTime = StellarMinigameConfig.getCOOLDOWN_SECONDS();

	private ArenaStatus arenaStatus = ArenaStatus.WAITING;

	/**
	 * This variable will be null if the Wait_Lobby option in the config is false
	 */
	@Getter
	private Location waitingLobbySpawn = null;

	private Set<UUID> playersInThisArena = new HashSet<>();


	public Arena(String arenaName) {

		this.arenaName = arenaName;

		// Extra functions to do when an arena is created

		ARENAS_LIST.add(this);
		ARENAS_LIST_HASHMAP.put(arenaName,this);

	}


	// Methods to manage the arena

	public void playerJoinArena(Player player) {

		UUID playerUUID = player.getUniqueId();

		PLAYERS_IN_ARENAS.put(playerUUID,this);
		this.playersInThisArena.add(playerUUID);

		this.playersInThisArena.stream()
				.map(Bukkit::getPlayer)
				.forEach(Player -> StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getPLAYER_JOIN_ARENA().replaceAll("%player%", player.getName())));

		StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getARENA_JOIN().replaceAll("%arena%", arenaName));

	}

	public void playerLeaveArena(Player player) {

		UUID playerUUID = player.getUniqueId();

		PLAYERS_IN_ARENAS.remove(playerUUID);
		this.playersInThisArena.remove(playerUUID);

		this.playersInThisArena.stream()
				.map(Bukkit::getPlayer)
				.forEach(Player -> StellarUtils.sendMessagePlayer(Player, StellarMinigameMessages.getPLAYER_LEAVE_ARENA().replaceAll("%player%", player.getName())));

		StellarUtils.sendMessagePlayer(player, StellarMinigameMessages.getARENA_LEAVE().replaceAll("%arena%", arenaName));

	}

	public void setArenaStatus(ArenaStatus arenaStatus) {
		this.arenaStatus = arenaStatus;
	}


	// Manual getters and setters for modification motives that I cant do with Lombok

	public Set<UUID> getPlayersInThisArena() {
		return new HashSet<>(this.playersInThisArena);
	}

	public ArenaStatus getArenaStatus() {
		return ArenaStatus.valueOf(this.arenaStatus.name());
	}

	public static Map<String, Arena> getARENASLISTHASHMAP() {

		return new HashMap<>(ARENAS_LIST_HASHMAP);

	}


}
