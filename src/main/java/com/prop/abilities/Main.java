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
        getLogger().info("Doctor Strange plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Doctor Strange plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("doctorstrange")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.DARK_PURPLE + "Doctor Strange power activated!");

                // Fireball spawn
                Fireball fireball = player.launchProjectile(Fireball.class);
                fireball.setYield(2); // explosion power

                // Particles
                player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 100);

                // Broadcast message
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + player.getName() + " used Doctor Strange powers!");
            }
            return true;
        }
        return false;
    }
}
