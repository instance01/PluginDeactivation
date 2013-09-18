package com.comze_instancelabs.ingameplugindeactivation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;


public class Main extends JavaPlugin implements Listener{
	
	
	@Override
    public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		getConfig().options().copyDefaults(true);
		this.saveConfig();
		
    }

    @Override
    public void onDisable() {
    	getLogger().info("Disabling.");
    }
    
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("dp") || cmd.getName().equalsIgnoreCase("deactivate") || cmd.getName().equalsIgnoreCase("deactivateplugin")){
    		// deactivate plugin
    		if(args.length > 0){
    			try{
    			    this.getServer().getPluginManager().disablePlugin(getServer().getPluginManager().getPlugin(args[0]));
    			}catch(Exception e){
    				sender.sendMessage("§3[DeactivatePlugin] §4An error occurred! Maybe you misstyped the plugin name?");
    			}
    		}
    		return true;
    	}else if(cmd.getName().equalsIgnoreCase("activate") || cmd.getName().equalsIgnoreCase("ap") || cmd.getName().equalsIgnoreCase("activateplugin")){
    		// TODO: activate plugin
    		return true;
    	}else if(cmd.getName().equalsIgnoreCase("deleteplugin")){
    		// TODO: permanently remove a plugin
    		// first deactivate, then remove
    		return true;
    	}
    	return false;
    }
    
}


