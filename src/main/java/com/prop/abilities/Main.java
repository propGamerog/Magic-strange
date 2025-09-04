package com.prop.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DocterStrange plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DocterStrange plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("magic")) {
            // Fireball throw
            Fireball fireball = player.launchProjectile(Fireball.class);
            fireball.setIsIncendiary(false);
            fireball.setYield(2F);

            // Chakra effect
            Bukkit.getScheduler().runTaskTimer(this, () -> {
                player.getWorld().spawnParticle(
                        Particle.ENCHANTMENT_TABLE,
                        player.getLocation().add(0, 1, 0),
                        30, 1, 1, 1, 0.1
                );
            }, 0L, 10L);

            player.sendMessage(ChatColor.GOLD + "You used Doctor Strange’s magic!");
            return true;
        }

        return false;
    }
}
