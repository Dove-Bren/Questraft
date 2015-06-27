package nmt.minecraft.Questraft.Configuration;

import nmt.minecraft.QuestManager.UI.Menu.Message.Message;

import org.bukkit.configuration.file.YamlConfiguration;

public class MessageEndConfiguration extends EndConfiguration {
	
	private Message message;
	
	public MessageEndConfiguration(Message message) {
		super("same");
		this.message = message;
	}

	@Override
	public YamlConfiguration getConfiguration() {
		
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("type", type);
		
		config.set("value", message);
		
		
		return config;
	}
	
}
