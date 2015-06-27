package nmt.minecraft.Questraft.Configuration.Requirements;

import nmt.minecraft.QuestManager.Configuration.EquipmentConfiguration;
import nmt.minecraft.QuestManager.Configuration.Utils.LocationState;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

public class VanquishRequirementConfiguration extends RequirementConfiguration {

	private EntityType type;
	
	private Location location;
	
	private int maxhp, hp;
	
	private String name;
	
	private EquipmentConfiguration equipConf;
	
	@Override
	public YamlConfiguration asConfig() {
		YamlConfiguration config = new YamlConfiguration();
		
		config.set("type", "vr");
		ConfigurationSection foeSex = config.createSection("foe");
			foeSex.set("type", type.name());
			foeSex.set("location", location);
			foeSex.set("maxhp", maxhp);
			foeSex.set("hp", hp);
			foeSex.set("name", name);
			foeSex.set("equipment", equipConf.getConfiguration());
			
		return config;
	}

	@Override
	public void fromConfig(ConfigurationSection config) {
		ConfigurationSection sec = config.getConfigurationSection("foe");
		type = EntityType.valueOf(sec.getString("type"));
		location = ((LocationState) sec.get("location")).getLocation();
		name = sec.getString("name", name);
		hp = sec.getInt("hp", hp);
		maxhp = sec.getInt("maxhp", maxhp);
		equipConf = new EquipmentConfiguration();
		try {
			equipConf.load(sec.getConfigurationSection("equipment"));
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}
