package loops;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveManager {

	public List<String> returnDescription(Integer num) {
		List<String> desc = new ArrayList<String>();
		List<String> defaults = new ArrayList<String>();
		defaults.add("§7You did all of the objectives!");
		defaults.add("§7You can do whatever for now.");
		
		switch(num) {
			default:
				return defaults;
			case 1:
				desc.add("§7Type §e/start§7.");
				return desc;
			case 2:
				desc.add("§7Talk to the Seraph §7at §f[0, 100, 42]§7.");
				return desc;
			case 3:
				desc.add("§7Bring the Seraph §3[10 Endstone]§7.");
				return desc;
		}
		
	}
}
