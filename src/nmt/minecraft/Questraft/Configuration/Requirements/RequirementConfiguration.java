package nmt.minecraft.Questraft.Configuration.Requirements;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public abstract class RequirementConfiguration {
	
	public abstract YamlConfiguration asConfig();
	
	public abstract void fromConfig(ConfigurationSection config);
	
	public static RequirementConfiguration parseConfig(ConfigurationSection config) {
		RequirementConfiguration req;
		
		String key = config.getKeys(false).iterator().next();
		
		switch (key) {
		case "POSSESS":
			req = new PossessRequirementConfiguration();
			break;
		case "VANQUISH":
			req = new VanquishRequirementConfiguration();
			break;
		case "ARRIVE":
			req = new ArriveRequirementConfiguration();
			break;
		case "POSITION":
			req = new PositionRequirementConfiguration();
			break;
		default:
			System.err.println("Unable to find matching requirement"
					+ " key: " + key);
			return null;
		}
		
		req.fromConfig(config.getConfigurationSection(key));
		
		return req;
	}
	
}
