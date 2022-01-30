package upgrades;

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
				return 75000;
			case 2:
				return 150000;
		}
	}
	
}
