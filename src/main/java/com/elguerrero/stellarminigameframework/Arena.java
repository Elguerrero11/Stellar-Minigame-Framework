package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarminigameframework.stellarframework.StellarPlugin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.io.File;
import java.util.*;

public abstract class Arena {

	// Some general variables of this minigame plugin

	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static String MINIGAME_NAME = "StellarMinigame";

	@Getter
	private static final File ARENAS_FOLDER = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Arenas");

	@Getter
	private static final File ADDONS_FOLDER = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Addons");

	//@Getter
	//private static final File ARENAS_CONFIG_FILE = new File(StellarPlugin.getPLUGIN_FOLDER() + "/Arenas/arenas.yml");

	@Getter
	private static Set<String> ARENAS = new HashSet<>();

	@Getter
	private static HashMap<UUID,String> PLAYERS_IN_ALL_ARENAS = new HashMap<>();

	@Getter
	private static final Map<String, Set<UUID>> PLAYERS_IN_EACH_ARENA = new HashMap<>();

	// Variables settings for all arenas

	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static boolean TEAMS = false;
	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static boolean waitingLobbyExist = true;
	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static boolean oneSpawnForAll = false;
	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static boolean multipleSpawnsForAll = false;
	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static boolean oneSpawnForEachTeam = false;
	@Getter
	@Setter(AccessLevel.PROTECTED)
	private static boolean multipleSpawnsForEachTeam = false;

	// Variables settings for each arena

	@Getter
	private String arenaName = "";
	@Getter
	private int minPlayers = 2;
	@Getter
	private int maxPlayers = 6;
	/**
	 * This variable will be null if the Wait_Lobby option in the config is false
	 */
	@Getter
	private Location waitingLobbySpawn = null;



	// Optional variables, are used if each one is enabled in the variables settings







	public Arena(Location lobbySpawn, Location waitingLobbySpawn, int maxPlayers, int minPlayers, String arenaName) {

		this.arenaName = arenaName;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.waitingLobbySpawn = waitingLobbySpawn;

		// Extra functions to do when an arena is created

		ARENAS.add(arenaName);
		PLAYERS_IN_EACH_ARENA.put(arenaName, new HashSet<UUID>());

	}




}
