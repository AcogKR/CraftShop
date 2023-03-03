package dev.acog.craftshop;

import dev.acog.craftshop.bukkit.command.CraftShopCommand;
import io.typecraft.command.bukkit.BukkitCommands;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

public class CraftShop extends JavaPlugin {
    @Override
    public void onEnable() {
        BukkitCommands.register(
                "shop",
                CraftShopCommand.node,
                (sender, cmd) -> Collections.emptyList(),
                this
        );
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
