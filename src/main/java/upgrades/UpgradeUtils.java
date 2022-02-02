package upgrades;

import java.util.ArrayList;
import java.util.List;

public class UpgradeUtils {
	public long eff1Cost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 10;
		case 2:
			return 15;
		case 3:
			return 25;
		case 4:
			return 45;
		case 5:
			return 80;
		case 6:
			return 140;
		case 7:
			return 190;
		case 8:
			return 260;
		case 9:
			return 480;
		case 10:
			return 960;
		case 11:
			return 1140;
		case 12:
			return 1390;
		case 13:
			return 1780;
		case 14:
			return 2190;
		case 15:
			return 2610;
		case 16:
			return 3010;
		case 17:
			return 3560;
		case 18:
			return 4000;
		case 19:
			return 5200;
		case 20:
			return 6400;
		}
	}
	public long eff2Cost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 100;
		case 2:
			return 150;
		case 3:
			return 250;
		case 4:
			return 450;
		case 5:
			return 800;
		case 6:
			return 1400;
		case 7:
			return 1900;
		case 8:
			return 2600;
		case 9:
			return 4800;
		case 10:
			return 9600;
		}
	}
	
	public long fortune1Cost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 10;
		case 2:
			return 15;
		case 3:
			return 25;
		case 4:
			return 45;
		case 5:
			return 80;
		case 6:
			return 140;
		case 7:
			return 190;
		case 8:
			return 260;
		case 9:
			return 480;
		case 10:
			return 960;
		case 11:
			return 1710;
		case 12:
			return 2410;
		case 13:
			return 2930;
		case 14:
			return 3600;
		case 15:
			return 4105;
		}
	}
	public long efficientMinerCost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 10;
		case 2:
			return 25;
		case 3:
			return 45;
		case 4:
			return 80;
		case 5:
			return 140;
		case 6:
			return 260;
		case 7:
			return 480;
		case 8:
			return 960;
		case 9:
			return 1710;
		case 10:
			return 2930;
		case 11:
			return 4105;
		}
	}
	public long fortune2Cost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 100;
		case 2:
			return 150;
		case 3:
			return 250;
		case 4:
			return 450;
		case 5:
			return 800;
		case 6:
			return 1400;
		case 7:
			return 1900;
		case 8:
			return 2600;
		case 9:
			return 4800;
		case 10:
			return 9600;
		}
	}
	public long xpBoostCost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 500;
		case 2:
			return 750;
		case 3:
			return 1300;
		case 4:
			return 2700;
		case 5:
			return 4000;
		case 6:
			return 7000;
		case 7:
			return 9000;
		case 8:
			return 13000;
		case 9:
			return 24000;
		case 10:
			return 48000;
		}
	}
	
	public long hasteCost(int lvl) {
		switch(lvl) {
			default:
				return Long.MAX_VALUE;
			case 1:
				return 15000;
			case 2:
				return 45000;
		}
	}
	
	public long debrisBoostCost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 5000;
		case 2:
			return 7500;
		case 3:
			return 13000;
		case 4:
			return 27000;
		case 5:
			return 40000;
		case 6:
			return 70000;
		case 7:
			return 90000;
		case 8:
			return 130000;
		case 9:
			return 240000;
		case 10:
			return 48000;
		}
	}
	
	public long enderBoostCost(int lvl) {
		switch(lvl) {
		default:
			return Long.MAX_VALUE;
		case 1:
			return 5000;
		case 2:
			return 7500;
		case 3:
			return 13000;
		case 4:
			return 27000;
		case 5:
			return 40000;
		case 6:
			return 70000;
		case 7:
			return 90000;
		case 8:
			return 130000;
		case 9:
			return 240000;
		case 10:
			return 480000;
		}
	}
	
	public List<String> levelMessage(int lvl) {
		List<String> msg = new ArrayList<String>();
		msg.add("§3----------");
		msg.add("");
		msg.add("§b§lLEVEL UP!");
		msg.add("§7You are now level §b" + lvl);
		msg.add("");
		msg.add("§a+1 tier §7Breaking Power");
		msg.add("§6+" + (50 * ((lvl - 1)) + 50) + "§7=> §6+ " + ((50 * lvl) + 50) + "§6 Base Mining Speed");
		switch(lvl) {
			default:
				break;
			case 2:
				msg.add("§bEfficient Miner §7Upgrade Unlocked");
				msg.add("§8Right click your drill to check it out!");
				break;
			case 3:
				msg.add("§bEfficiency % §7Upgrade Unlocked");
				msg.add("§8Right click your drill to check it out!");
				break;
			case 4:
				msg.add("§bXP Boost §7Upgrade Unlocked");
				msg.add("§8Right click your drill to check it out!");
				break;
			case 6:
				msg.add("§bHaste % §7Upgrade Unlocked");
				msg.add("§8Right click your drill to check it out!");
				break;
			case 7:
				msg.add("§bDebris Summoner §7Upgrade Unlocked");
				msg.add("§bEnder Summoner §7Upgrade Unlocked");
				msg.add("§8Right click your drill to check it out!");
				break;
		}
		
		msg.add("");
		msg.add("§3----------");
		return msg;
	}
}
