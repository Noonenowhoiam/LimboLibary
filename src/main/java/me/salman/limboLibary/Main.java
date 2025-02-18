package me.salman.limboLibary;


import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        getLogger().info("LimboLibrary has been enabled!");
        this.getCommand("limbo").setExecutor(new LimboCommand());
//        Bukkit.getPluginManager().registerEvents(new LimboListener(), this);
//        Bukkit.getPluginManager().registerEvents(new VoidWorldManager(), this);
        VoidWorldManager.initializePacketBlocking(this);

    }

    @Override
    public void onDisable() {
        getLogger().info("LimboLibrary has been disabled!");
        instance = null;
    }

    public static Main getInstance() {
        return instance;
    }

}


