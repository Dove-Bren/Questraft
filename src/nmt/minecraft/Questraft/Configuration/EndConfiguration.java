package nmt.minecraft.Questraft.Configuration;

public abstract class EndConfiguration {
	
	private String type;
	
	protected EndConfiguration(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public abstract YamlConfiguration getConfiguration();
	
}
