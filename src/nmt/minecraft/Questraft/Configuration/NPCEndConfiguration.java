package nmt.minecraft.Questraft.Configuration;

import nmt.minecraft.QuestManager.NPC.NPC;

import org.bukkit.configuration.file.YamlConfiguration;

public class NPCEndConfiguration extends EndConfiguration {

	private NPC npc;
	
	public NPCEndConfiguration(NPC npc) {
		super("same");
		this.npc = npc;
	}

	@Override
	public YamlConfiguration getConfiguration() {
		
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("type", type);
		
		config.set("value", npc);
		
		
		return config;
	}
	
}
