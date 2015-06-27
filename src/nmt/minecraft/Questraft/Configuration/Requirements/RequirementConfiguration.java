package nmt.minecraft.Questraft.Configuration.Requirements;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public abstract class RequirementConfiguration {
	
	public abstract YamlConfiguration asConfig();
	
	public abstract void fromConfig(ConfigurationSection config);
	
}
