package space.eightbits.ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import space.eightbits.ranks.bit.Bit;
import space.eightbits.ranks.bytea.Byte;
import space.eightbits.ranks.electricty.Electricity;
import space.eightbits.ranks.image.Image;

public class Main extends JavaPlugin implements Listener, CommandExecutor{
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new Electricity(), this);
		getServer().getPluginManager().registerEvents(new Bit(), this);
		getServer().getPluginManager().registerEvents(new Byte(), this);
		getServer().getPluginManager().registerEvents(new Image(), this);
		getServer().getPluginManager().registerEvents(this, this);
		this.getConfig().options().copyDefaults(true);
	    this.saveConfig();
	    this.getCommand("setrank").setExecutor(this);
	    
	}
	@Override
	public void onDisable(){
		
	}
	@EventHandler
	public void noDying(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) { e.setCancelled(true); }
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		System.out.println("Player joined.");
		if(this.getConfig().contains("id."+player.getUniqueId())) {
			this.getConfig().addDefault("id."+player.getUniqueId(),ChatColor.RED+ "Yeah!!!!!");
			this.getConfig().addDefault("id."+player.getUniqueId()+".name", player.getName());
			this.getConfig().addDefault("id."+player.getUniqueId()+".rank.type", "default");
			this.getConfig().addDefault("id."+player.getUniqueId()+".rank.fake", false);
			this.getConfig().options().copyDefaults(true);
		    this.saveConfig();
		    System.out.println("Created config for them!");
		    
		}else {
			System.out.println("But they have their own config!");
		}
	}
	public void setPlayerConfig(String uuid, String name) {
		this.getConfig().addDefault("id."+uuid,ChatColor.RED+ "Yeah!!!!!");
		this.getConfig().addDefault("id."+uuid+".name", name);
		this.getConfig().addDefault("id."+uuid+".rank.type", "default");
		this.getConfig().addDefault("id."+uuid+".rank.fake", false);
		this.getConfig().options().copyDefaults(true);
	    this.saveConfig();
	}
	public void setElectricity(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","electricity");
		this.saveConfig();
	}
	public void setBit(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","bit");
		this.saveConfig();
	}
	public void setByte(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","byte");
		this.saveConfig();
	}
	public void setImage(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","image");
		this.saveConfig();
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player) && args.length==3) {
			if(!this.getConfig().contains("id."+args[1])) {
				setPlayerConfig(args[1],args[2]);
			}
			if(args[0]=="electricity") {
				setElectricity(args[1]);
				return true;
			}
			if(args[0]=="bit") {
				setBit(args[1]);
				return true;
			}
			if(args[0]=="byte") {
				setByte(args[1]);
				return true;
			}
			if(args[0]=="image") {
				setImage(args[1]);
				return true;
			}
			
		}
		sender.sendMessage("Hahaha, just kiddin'!");
        return true;
    }
	
}
