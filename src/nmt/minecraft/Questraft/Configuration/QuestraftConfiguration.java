package nmt.minecraft.Questraft.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import nmt.minecraft.QuestManager.NPC.NPC;
import nmt.minecraft.QuestManager.Quest.Goal;

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
	
	private List<Goal> goals;
	
	private List<NPC> npcs;
	
	private NPC startNPC;
	
	private EndConfiguration end;
	
	public QuestraftConfiguration(String name, String description) {
		this.questName = name;
		this.description = description;
		
		rewards = new LinkedList<ItemStack>();
		goals = new LinkedList<Goal>();
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
		config.set("goals", goals);
		config.set("npcs", npcs);
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
	
	
	
}
