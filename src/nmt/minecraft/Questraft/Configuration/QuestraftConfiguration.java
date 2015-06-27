package nmt.minecraft.Questraft.Configuration;

import java.util.List;

import nmt.minecraft.QuestManager.NPC.NPC;
import nmt.minecraft.QuestManager.Quest.Goal;

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
	
	
	
}
