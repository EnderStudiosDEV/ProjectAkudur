package main;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.bukkit.entity.Player;

public class Utils {

	public static int random(
			int min,
			int max) {
		
		int n = (int)Math.floor(Math.random()*(max-min+1)+min);
		return n;
	}
	
	public String num(int number) {
		 // Example 1 - by using NumberFormat class
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true); // this will also round numbers, 3
       
        return myFormat.format(number);
	}
	
	public String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 180) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return "N";
        } else if (22.5 <= rotation && rotation < 67.5) {
            return "NE";
        } else if (67.5 <= rotation && rotation < 112.5) {
            return "E";
        } else if (112.5 <= rotation && rotation < 157.5) {
            return "SE";
        } else if (157.5 <= rotation && rotation < 202.5) {
            return "S";
        } else if (202.5 <= rotation && rotation < 247.5) {
            return "SW";
        } else if (247.5 <= rotation && rotation < 292.5) {
            return "W";
        } else if (292.5 <= rotation && rotation < 337.5) {
            return "NW";
        } else if (337.5 <= rotation && rotation < 360.0) {
            return "N";
        } else {
            return null;
        }
    }
	
	public String format(int num) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		return formatter.format(num);
	}
	
}
