package me.jazzcuzzi.bots.tutorialbot;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;

import net.dv8tion.jda.core.audio.AudioSendHandler;

public class AudioHandler implements AudioSendHandler {

	private final AudioPlayer audioPlayer;
	private AudioFrame lastframe;

	public AudioHandler(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	@Override
	public boolean canProvide() {
		if (lastframe == null)
			lastframe = audioPlayer.provide();
		return lastframe != null;
	}

	@Override
	public byte[] provide20MsAudio() {
		byte[] data = canProvide() ? lastframe.data : null;
		lastframe = null;

		return data;
	}

	@Override
	public boolean isOpus() {
		return true;
	}

}
