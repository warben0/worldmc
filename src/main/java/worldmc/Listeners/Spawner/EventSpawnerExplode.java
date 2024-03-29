package main.java.worldmc.Listeners.Spawner;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import main.java.worldmc.WMC;

public class EventSpawnerExplode implements Listener {

	private WMC plugin;

	public EventSpawnerExplode(WMC plugin) {
		this.plugin = plugin;
	}

	// Cancel explosion if it would explode a spawner

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent event) {
		if (plugin.getConfig().getBoolean("spawners.enabled")
				&& plugin.getConfig().getBoolean("spawners.cancel-explosion")) {
			for (Block block : event.blockList()) {
				if (block.getType() == Material.SPAWNER) {
					event.setCancelled(true);
				}
			}
		}
	}
}
