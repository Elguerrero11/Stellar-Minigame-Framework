package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import com.elguerrero.stellarminigameframework.config.StellarMinigameConfig;
import com.elguerrero.stellarminigameframework.config.StellarMinigameMessages;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

public abstract class StellarArena {

	// General variables of this minigame plugin

	@Getter
	private static String MINIGAME_NAME = "StellarMinigame";

	@Getter
	private static final File ARENAS_FOLDER = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Arenas");

	@Getter
	private static final File ARENAS_CONFIG_FILE = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Arenas/arenas.yml");

	@Getter
	private static final File ADDONS_FOLDER = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Addons");


	private static List<StellarArena> ARENAS_LIST = new ArrayList<>();

	private static HashMap<String, StellarArena> ARENAS_LIST_HASHMAP = new HashMap<>();

	/**
	 * This variable is only used for get all the arenas names list.
	 *
	 * This variable is used in the next classes:
	 *
	 * - StellarMinigameJoinArena (Command)
	 */
	private static Set<String> ARENAS_NAMES_LIST = new HashSet<>();

	private static HashMap<UUID, StellarArena> PLAYERS_IN_ARENAS = new HashMap<>();





	// Variables for each arena

	@Getter
	private String arenaName = "";
	@Getter
	private int minPlayers = 2;
	@Getter
	private int maxPlayers = 6;

	@Getter
	private int cooldownTime = StellarMinigameConfig.getCOOLDOWN_SECONDS();

	@Setter
	private ArenaStatus arenaStatus = ArenaStatus.WAITING;

	/**
	 * This variable will be null if the Wait_Lobby option in the config is false
	 */
	@Getter
	private Location waitingLobbySpawn = null;

	private Set<UUID> playersInThisArena = new HashSet<>();


	public StellarArena(String arenaName) {

		this.arenaName = arenaName;

		// Extra functions to do when an arena is created

		ARENAS_LIST.add(this);
		ARENAS_LIST_HASHMAP.put(arenaName,this);
		ARENAS_NAMES_LIST.add(arenaName);

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

	/**
	 * Remove this arena from the three list of arenas
	 */
	public void removeArena(){

		ARENAS_LIST.remove(this);
		ARENAS_LIST_HASHMAP.remove(this.arenaName);
		ARENAS_NAMES_LIST.remove(this.arenaName);

	}

	// Manual getters and setters for modification motives that I cant do with Lombok

	public Set<UUID> getPlayersInThisArena() {
		return new HashSet<>(this.playersInThisArena);
	}

	public ArenaStatus getArenaStatus() {
		return ArenaStatus.valueOf(this.arenaStatus.name());
	}


	public static Map<UUID, StellarArena> getPLAYERS_IN_ARENAS() {
		return new HashMap<>(PLAYERS_IN_ARENAS);
	}

	public static List<StellarArena> getARENAS_LIST() {
		return new ArrayList<>(ARENAS_LIST);
	}

	public static Set<String> getARENAS_NAMES_LIST() {
		return new HashSet<>(ARENAS_NAMES_LIST);
	}

	public static HashMap<String, StellarArena> getARENAS_LIST_HASHMAP() {
		return new HashMap<>(ARENAS_LIST_HASHMAP);
	}


}
