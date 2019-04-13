package space.eightbits.ranks.image;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class Image implements Listener{

	@EventHandler
	public void OnChat(AsyncPlayerChatEvent event){
		if(true){
		event.setFormat(ChatColor.GREEN+"IMAGE"+ChatColor.BLACK+"-"+ChatColor.GRAY+"%s"+ChatColor.RESET+": %s");
		}
	}
	
}
