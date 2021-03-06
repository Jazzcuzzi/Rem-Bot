package me.jazzcuzzi.bots.tutorialbot;

import java.util.HashMap;
import java.util.Map;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;

import net.dv8tion.jda.core.entities.Invite.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

public class MusicManager {

	private final AudioPlayerManager manager = new DefaultAudioPlayerManager();
	private final Map<String, MusicPlayer> players = new HashMap<>();

	public MusicManager() {
		AudioSourceManagers.registerRemoteSources(manager);
		AudioSourceManagers.registerLocalSource(manager);
	}

	public synchronized MusicPlayer getPlayer(Guild guild) {
		if (!players.containsKey(guild.getId()))
			players.put(guild.getId(), new MusicPlayer(manager.createPlayer(), guild));
		return players.get(guild.getId());
	}
	
	public void loadTrack(final TextChannel channel, final String source){
		MusicPlayer player = getPlayer(channel.getGuild());
		
		channel.getGuild().getAudioManager().setSendingHandler(player.getAudioHandler());
		
		manager.loadItemOrdered(player, source, new AudioLoadResultHandler());
		
	}

}
