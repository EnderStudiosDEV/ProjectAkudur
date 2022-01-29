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
			return 50;
		case 2:
			return 750;
		case 3:
			return 130;
		case 4:
			return 270;
		case 5:
			return 400;
		case 6:
			return 700;
		case 7:
			return 900;
		case 8:
			return 1300;
		case 9:
			return 2400;
		case 10:
			return 4800;
		}
	}
}
