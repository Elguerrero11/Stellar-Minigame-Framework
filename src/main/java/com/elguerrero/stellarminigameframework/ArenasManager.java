package com.elguerrero.stellarminigameframework;

import com.elguerrero.stellarframework.StellarPlugin;
import com.elguerrero.stellarframework.utils.StellarUtils;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import lombok.Getter;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public abstract class ArenasManager {

	// File variables
	@Getter
	private static YamlDocument CONFIG_FILE = null;
	private static final InputStream resourceStream = StellarPlugin.getPLUGIN_INSTANCE().getResource("/StellarMinigame/Arenas/arenas.yml");


	// The config options

	@Getter
	private static Location LOBBY_SPAWN = null;
	@Getter
	private static boolean WAIT_LOBBY = true;

	@Getter
	private static Integer CONFIG_VERSION = null;


	/**
	 * Happen when the plugin load and reload
	 * <p>
	 * Create the file if dont exist and update it if is not updated
	 */
	public static void loadConfigFile() {

		try {
			CONFIG_FILE = YamlDocument.create(new File(StellarPlugin.getPLUGIN_FOLDER(), "arenas.yml"), Objects.requireNonNull(resourceStream),
					GeneralSettings.DEFAULT, LoaderSettings.builder().setAutoUpdate(true).build(), DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("Config_Version")).build());
		} catch (IOException ex) {
			StellarUtils.logErrorException(ex,"default");
		}

	}

	/**
	 * Happen when the plugin load and reload
	 * Set the variables to the config values
	 */

	public static void loadConfigVariables() {

		LOBBY_SPAWN = (Location) CONFIG_FILE.get("Lobby_Spawn");
		WAIT_LOBBY = CONFIG_FILE.getBoolean("Wait_Lobby");

		CONFIG_VERSION = CONFIG_FILE.getInt("Config_Version");



	}


}
