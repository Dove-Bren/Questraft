package nmt.minecraft.Questraft.Configuration.Requirements;

import nmt.minecraft.QuestManager.Configuration.Utils.LocationState;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ArriveRequirementConfiguration extends RequirementConfiguration {

	private double range;
	
	private Location location;
	
	@Override
	public YamlConfiguration asConfig() {
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("type", "arrr");
		config.set("range", range);
		config.set("destination", location);
		
		return config;
	}

	@Override
	public void fromConfig(ConfigurationSection config) {
		
		//don't check type, who cares? :S //TODO
		range = config.getDouble("range", range);
		
		if (config.contains("destination")) {
			LocationState loc = (LocationState) config.get("destination");
			location = loc.getLocation();
		}
		
	}

}
