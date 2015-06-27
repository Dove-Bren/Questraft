package nmt.minecraft.Questraft.Configuration;

import java.util.LinkedList;
import java.util.List;

import nmt.minecraft.Questraft.Configuration.Requirements.RequirementConfiguration;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Configuration wrapper for a Goal
 * @author Skyler
 *
 */
public class GoalConfiguration {
	
	private String name;
	
	private String type;
	
	private String description;
	
	private List<RequirementConfiguration> requirements;
	
	public GoalConfiguration() {
		requirements = new LinkedList<RequirementConfiguration>();
		type = "goalcnf";
	}
	
	/**
	 * Loads up a goal from passed configuration following configuration standards
	 * @param config
	 */
	public void fromConfig(ConfigurationSection config) {
		name = config.getString("name", name);
		description = config.getString("description", description);
		type = config.getString("type", type);
		
		ConfigurationSection reqSex = config.getConfigurationSection("requirements");
		
		if (!reqSex.getKeys(false).isEmpty())
		for (String key : reqSex.getKeys(false)) {
			addRequirement(
					RequirementConfiguration.parseConfig(
							config.getConfigurationSection(key)
						)
					);
		}
	}
	
	/**
	 * Returns the currently-kept quest in config format
	 * @return
	 */
	public YamlConfiguration asConfig() {
				
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("type", type);
		config.set("name", name);
		config.set("description", description);
		
		ConfigurationSection reqSex = config.createSection("requirements");
		
		int i = 1;
		
		if (!requirements.isEmpty())
		for (RequirementConfiguration req : requirements) {
			reqSex.set(i + "", req.asConfig());
			i++;
		}
		
		
		return config;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the requirements
	 */
	public List<RequirementConfiguration> getRequirements() {
		return requirements;
	}
	
	public void addRequirement(RequirementConfiguration req) {
		this.requirements.add(req);
	}
	
	
}
