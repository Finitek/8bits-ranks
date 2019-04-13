package space.eightbits.ranks.bit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class Bit implements Listener{
public void SetRank(Player player){
		
		
	}
	@EventHandler
	public void OnChat(AsyncPlayerChatEvent event){
		if(false){
			event.setFormat(ChatColor.DARK_PURPLE+"BIT"+ChatColor.BLACK+"-"+ChatColor.GRAY+"%s"+ChatColor.RESET+": %s");
		}
	}
}
