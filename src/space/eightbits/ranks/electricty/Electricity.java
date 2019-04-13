package space.eightbits.ranks.electricty;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class Electricity implements Listener{

	@EventHandler
	public void WhenChats(AsyncPlayerChatEvent event){
		if(false){
		event.setFormat(ChatColor.BLUE+"ELECTRICTY"+ChatColor.BLACK+"-"+ChatColor.GRAY+"%s"+ChatColor.RESET+": %s");
	}}
}
