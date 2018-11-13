package me.jazzcuzzi.bots.tutorialbot;

import java.util.Random;

import javax.security.auth.login.LoginException;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TutorialBot extends ListenerAdapter {

	public static void main(String[] args) {
		try {
			JDA api = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).buildBlocking();
			api.getPresence();
			api.addEventListener(new TutorialBot());

		} catch (LoginException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent evt) {
		User objUser = evt.getAuthor();
		MessageChannel objMsgChannel = evt.getChannel();
		Message objMessage = evt.getMessage();
		String[] remArray = { "https://imgur.com/gallery/Ee6yZ", "https://i.imgur.com/cUuXxvG.jpg",
				"https://i.imgur.com/dtweihV.png", "https://i.imgur.com/znsUxaN.png", "https://i.imgur.com/OpFN9i3.jpg",
				"https://i.imgur.com/4SE5vLy.jpg", "https://i.imgur.com/d0oa8Ds.jpg", "https://i.imgur.com/a499L7Y.jpg",
				"https://imgur.com/5irjHIA", "https://imgur.com/yUxKBAg", "https://imgur.com/PnwpbqO",
				"https://imgur.com/iIWwY8z", "https://imgur.com/p03GmLj", "https://imgur.com/bIVXJ76",
				"https://imgur.com/cn87PJY", "https://imgur.com/exMRN8y", "https://imgur.com/gqluTTk",
				"https://imgur.com/q6aySyK", "https://imgur.com/BLsDGKX", "https://imgur.com/K6SjkCA",
				"https://imgur.com/Eejoi1g", "https://imgur.com/aA4l7gv", "https://imgur.com/IXybN5V",
				"https://imgur.com/yw4XJRn", "https://imgur.com/9YsHoKR", "https://imgur.com/1bKF5bg",
				"https://imgur.com/bOJGKeI", "https://imgur.com/jvv7Q8X", "https://imgur.com/S5Vwmg8",
				"https://imgur.com/Kkg8gvM", "https://imgur.com/DN8XkYl", "https://imgur.com/K7RMPxO",
				"https://imgur.com/65VnZf7", "https://imgur.com/KR4hMMT", "https://imgur.com/1LVivCM",
				"https://imgur.com/HOO7VKs", "https://imgur.com/2ZYSx1Z", "https://imgur.com/CEY8erv",
				"https://imgur.com/EM2XozK", "https://imgur.com/xAVlxlX", "https://imgur.com/0OnGZlx",
				"https://imgur.com/D3UoTnl", "https://imgur.com/LLPy5As", "https://imgur.com/DaYF0WC",
				"https://imgur.com/39YnGJK", "https://imgur.com/BtLCSfl", "https://imgur.com/uu3gbag",
				"https://imgur.com/hLcqMs6", "https://imgur.com/g33dxC8", "https://imgur.com/oLCXT9x",
				"https://imgur.com/nR1XJiT", "https://imgur.com/HOuwc1q", "https://imgur.com/rZolbJp",
				"https://imgur.com/n9t92M3", "https://imgur.com/XYpc9CD", "https://imgur.com/xo3oks6",
				"https://imgur.com/BgTYTge", "https://imgur.com/E2U3sW4", "https://imgur.com/xuHyO3B",
				"https://imgur.com/ZD79K90", "https://imgur.com/oCCPoNj", "https://imgur.com/hXIpykv",
				"https://imgur.com/LF8Quzy", "https://imgur.com/5Bar2GR", "https://imgur.com/dEgkD3j",
				"https://imgur.com/zJngKWM", "https://imgur.com/J34ziaY", "https://imgur.com/zwEUYrB",
				"https://imgur.com/nfGqoZe", "https://imgur.com/OPY7eMx", "https://imgur.com/XhORMBL",
				"https://imgur.com/mdMfrgZ", "https://imgur.com/8EE2QTo", "https://imgur.com/gRDKaxL",
				"https://imgur.com/rZcGHLS", "https://imgur.com/wlFCqZI", "https://imgur.com/IqlTlo9",
				"https://imgur.com/Simh1tq", "https://imgur.com/HltxOlD", "https://imgur.com/R2T7zUq",
				"https://imgur.com/Fzb6z3I", "https://imgur.com/fchdtVh", "https://imgur.com/XCpxlX8",
				"https://imgur.com/mQjbXeP", "https://imgur.com/ki9sU7A", "https://imgur.com/bJM2P0v",
				"https://imgur.com/W9E8OgV", "https://imgur.com/QODBjQt", "https://imgur.com/WvFWAxk",
				"https://imgur.com/IjIgB2W", "https://imgur.com/gzyZfcm", "https://imgur.com/xmU09fv",
				"https://imgur.com/DUxclO7", "https://imgur.com/8EzniSh", "https://imgur.com/cFgw4c4",
				"https://imgur.com/53MMntS", "https://imgur.com/WFY4Sto" };
		Random numberPicker = new Random();

		if (objMessage.getContentRaw().equalsIgnoreCase(Ref.PREFIX + "ping")) {
			objMsgChannel.sendMessage("Your current ping is " + objUser.getJDA().getPing() + " ms").queue();
		}

		if (objMessage.getContentRaw().equalsIgnoreCase(Ref.PREFIX + "rem")) {
			int n = numberPicker.nextInt(98) + 0;
			objMsgChannel.sendMessage("A glorious picture for you " + remArray[n]).queue();
		}

		if (objMessage.getContentRaw().equalsIgnoreCase(Ref.PREFIX + "help")) {
			objMsgChannel.sendMessage(
					"```Type in the following Commands: " + "\n" + "\n" + "!ping       Gives you current ping" + "\n"
							+ "\n" + "!rem        Gives you random picture of best girl```").queue();
		}
		
	}

}
