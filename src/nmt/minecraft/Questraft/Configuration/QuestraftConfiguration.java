package nmt.minecraft.Questraft.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import nmt.minecraft.QuestManager.NPC.NPC;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

/**
 * Top-level container for a quest configuration file
 * @author Skyler
 *
 */
public class QuestraftConfiguration {

	public double configurationVersion;
	
	public String questName;
	
	public String description;
	
	public boolean savestate;
	
	public int fame;
	
	private List<ItemStack> rewards;
	
	private List<GoalConfiguration> goals;
	
	private List<NPC> npcs;
	
	private NPC startNPC;
	
	private EndConfiguration end;
	
	public QuestraftConfiguration(String name, String description) {
		this.questName = name;
		this.description = description;
		
		rewards = new LinkedList<ItemStack>();
		goals = new LinkedList<GoalConfiguration>();
		npcs = new LinkedList<NPC>();
		
	}

	/**
	 * @param questName the questName to set
	 */
	public void setQuestName(String questName) {
		this.questName = questName;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param savestate the savestate to set
	 */
	public void setSavestate(boolean savestate) {
		this.savestate = savestate;
	}

	/**
	 * @param fame the fame to set
	 */
	public void setFame(int fame) {
		this.fame = fame;
	}

	/**
	 * @param startNPC the startNPC to set
	 */
	public void setStartNPC(NPC startNPC) {
		this.startNPC = startNPC;
	}

	/**
	 * @return the configurationVersion
	 */
	public double getConfigurationVersion() {
		return configurationVersion;
	}

	/**
	 * @param configurationVersion the configurationVersion to set
	 */
	public void setConfigurationVersion(double configurationVersion) {
		this.configurationVersion = configurationVersion;
	}
	
	/**
	 * Uses all provided information to save the quest configuration out to the passed file.<br />
	 * @param saveFile
	 */
	public boolean save(File saveFile) {
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("configversion", configurationVersion);
		config.set("name", questName);
		config.set("description", description);
		config.set("savestate", savestate);
		config.set("fame", fame);
		config.set("rewards", rewards);
		
		ConfigurationSection goalSex = config.createSection("goals");
		
		int i = 1;
		if (!goals.isEmpty())
		for (GoalConfiguration goal : goals) {
			goalSex.set(i + "", goal.asConfig());
			i++;
		}
		
		ConfigurationSection nSex = config.createSection("npcs");
		i = 1;
		if (!npcs.isEmpty())
		for (NPC npc : npcs) {
			nSex.set(i + "", npc);
		}

		config.set("end", end.getConfiguration());
		config.set("start", startNPC);
		
		try {
			config.save(saveFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Unable to save configuration file!");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Loads up configuration from the passed file
	 * @param loadFile
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean load(File loadFile) {
		
		YamlConfiguration config = new YamlConfiguration();
		try {
			config.load(loadFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid load operation!");
			return false;
		}
		
		//go through each field and load it if it's there
		if (config.contains("configurationversion")) {
			this.configurationVersion = config.getDouble("configurationversion");
		}
		
		if (config.contains("name")) {
			this.questName = config.getString("name");
		}
		
		if (config.contains("description")) {
			this.description = config.getString("description");
		}
		
		if (config.contains("savestate")) {
			this.savestate = config.getBoolean("savestate");
		}
		
		if (config.contains("fame")) {
			this.fame = config.getInt("fame");
		}
		
		if (config.contains("rewards")) {
			this.rewards = (List<ItemStack>) config.getList("rewards");
		}		
		
		if (config.contains("goals")) {
			goals = new LinkedList<GoalConfiguration>();
			
			GoalConfiguration cache;
			for (String key : config.getConfigurationSection("goals").getKeys(false)) {
				cache = new GoalConfiguration();
				cache.fromConfig(config.getConfigurationSection("goals." + key));
				goals.add(cache);
			}
		}
		
		if (config.contains("npcs")) {
			npcs = new LinkedList<NPC>();
			
			for (String key : config.getConfigurationSection("npcs").getKeys(false)) {
				npcs.add((NPC) config.get("npcs." + key));
			}
		}
		
		if (config.contains("start")) {
			this.startNPC = (NPC) config.get("start");
		}
		
//		if (config.contains("end")) {
//			
//		}
		
		
		return true;
	}
	
	
	
}
