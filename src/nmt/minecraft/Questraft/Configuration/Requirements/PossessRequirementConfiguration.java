package nmt.minecraft.Questraft.Configuration.Requirements;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class PossessRequirementConfiguration extends RequirementConfiguration {
	
	private Material itemType;
	
	private int count;
	
	@Override
	public YamlConfiguration asConfig() {
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("type", "pr");
		config.set("itemType", itemType.name());
		config.set("count", count);
		
		return config;
	}

	@Override
	public void fromConfig(ConfigurationSection config) {
		
		itemType = Material.valueOf(config.getString("itemType"));
		count = config.getInt("count", 1);
	}

}
