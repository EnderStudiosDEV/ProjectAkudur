package loops;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import hashmaps.HashMaps;
public class PlayerStatManager {

	public static void call() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			String uuid = p.getUniqueId().toString();
			
			Long level = HashMaps.level.get(uuid);
			Long xp = HashMaps.xp.get(uuid);
			if(xp > xpReq(level.intValue())) {
				xp -= xpReq(level.intValue());
				level += 1;
				p.sendMessage("§b§lLEVEL UP! §7§rYou have leveled up!");
			}
			p.setLevel(level.intValue());
			float x = ((float) xp / (float) xpReq(level.intValue()));
			if(x > 1) {
				x = 1;
			}
			p.setExp(x);
			HashMaps.xp.put(uuid, xp);
			HashMaps.level.put(uuid, level);
		}
	}
	
	public static Integer xpReq(int level) {
		switch(level) {
			default:
				return 2147483647;
			case 1:
				return 1120;
			case 2:
				return 3060;
			case 3:
				return 7400;
			case 4:
				return 16560;
			case 5:
				return 31320;
			case 6:
				return 51840;
			case 7:
				return 90720;
			case 8:
				return 136800;
			case 9:
				return 260000;
			case 10:
				return 479500;
			case 11:
				return 871750;
			case 12:
				return 1102500;
			
		}
	}

}
