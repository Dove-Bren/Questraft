package nmt.minecraft.Questraft.Configuration;

import org.bukkit.configuration.file.YamlConfiguration;

public abstract class EndConfiguration {
	
	protected String type;
	
	protected EndConfiguration(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public abstract YamlConfiguration getConfiguration();
	
}
