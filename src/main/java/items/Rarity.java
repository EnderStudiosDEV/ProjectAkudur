package items;

public enum Rarity {
	
	COMMON("§f", "§fCommon"),
	UNCOMMON("§a", "§aUncommon"),
	RARE("§9", "§9Rare"),
	EPIC("§5", "§5Epic"),
	LEGENDARY("§b", "§bLegendary"),
	FABLED("§c", "§cFabled");
	
	public final String code;
	public final String desc;
	
	
	Rarity(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
