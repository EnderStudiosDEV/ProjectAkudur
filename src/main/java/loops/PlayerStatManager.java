package loops;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import hashmaps.HashMaps;
public class PlayerStatManager {

	public static void call() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			String uuid = p.getUniqueId().toString();
			
			int level = HashMaps.level.get(uuid);
			int xp = HashMaps.xp.get(uuid);
			if(xp > xpReq(level)) {
				xp -= xpReq(level);
				level += 1;
				p.sendMessage("§b§lLEVEL UP! §7§rYou have leveled up!");
			}
			p.setLevel(level);
			float x = ((float) xp / (float) xpReq(level));
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
				return 40;
			case 2:
				return 60;
			case 3:
				return 100;
			case 4:
				return 150;
			case 5:
				return 210;
			case 6:
				return 270;
			case 7:
				return 390;
			case 8:
				return 480;
			case 9:
				return 560;
			case 10:
				return 700;
			case 11:
				return 850;
			case 12:
				return 1000;
			case 13:
				return 1200;
			case 14:
				return 1500;
			case 15:
				return 2000;
			case 16:
				return 2400;
			case 17:
				return 3200;
			case 18:
				return 4000;
			case 19:
				return 5000;
			case 20:
				return 6000;
		}
	}

}
