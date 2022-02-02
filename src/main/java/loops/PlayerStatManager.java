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
			
			try {
				if(HashMaps.debrisSummoner.get(uuid) == null) {
					HashMaps.debrisSummoner.put(uuid, 1L);
					HashMaps.enderSummoner.put(uuid, 1L);
				}
				if(HashMaps.efficientMiner.get(uuid) == null) {
					HashMaps.efficientMiner.put(uuid, 1L);
				}
			} catch (Exception e) {
				HashMaps.debrisSummoner.put(uuid, 1L);
				HashMaps.enderSummoner.put(uuid, 1L);
			}
			
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
				return 196800;
			case 8:
				return 540000;
			case 9:
				return 849500;
			case 10:
				return 1641750;
			case 11:
				return 2202500;
			case 12:
				return 3303750;
			
		}
	}

}
