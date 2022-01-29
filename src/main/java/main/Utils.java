package main;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
		DecimalFormat formatter = new DecimalFormat("#,###,###,###");
		return formatter.format(num);
	}
	
	public ItemStack[] armor(long lvl) {
		ItemStack[] armor = new ItemStack[10];
		armor[1] = new ItemStack(Material.LEATHER_HELMET);
		armor[2] = new ItemStack(Material.LEATHER_CHESTPLATE);
		armor[3] = new ItemStack(Material.LEATHER_LEGGINGS);
		armor[4] = new ItemStack(Material.LEATHER_BOOTS);
		if(lvl >= 3) {
			armor[4] = new ItemStack(Material.CHAINMAIL_BOOTS);
		}
		if(lvl >= 6) {
			armor[1] = new ItemStack(Material.CHAINMAIL_HELMET);
		}
		if(lvl >= 9) {
			armor[3] = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		}
		if(lvl >= 12) {
			armor[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		}
		
		if(lvl >= 15) {
			armor[4] = new ItemStack(Material.GOLDEN_BOOTS);
		}
		if(lvl >= 18) {
			armor[1] = new ItemStack(Material.GOLDEN_HELMET);
		}
		if(lvl >= 21) {
			armor[3] = new ItemStack(Material.GOLDEN_LEGGINGS);
		}
		if(lvl >= 24) {
			armor[2] = new ItemStack(Material.GOLDEN_CHESTPLATE);
		}
		
		if(lvl >= 27) {
			armor[4] = new ItemStack(Material.IRON_BOOTS);
		}
		if(lvl >= 30) {
			armor[1] = new ItemStack(Material.IRON_HELMET);
		}
		if(lvl >= 33) {
			armor[3] = new ItemStack(Material.IRON_LEGGINGS);
		}
		if(lvl >= 36) {
			armor[2] = new ItemStack(Material.IRON_CHESTPLATE);
		}
		
		if(lvl >= 39) {
			armor[4] = new ItemStack(Material.DIAMOND_BOOTS);
		}
		if(lvl >= 42) {
			armor[1] = new ItemStack(Material.DIAMOND_HELMET);
		}
		if(lvl >= 45) {
			armor[3] = new ItemStack(Material.DIAMOND_LEGGINGS);
		}
		if(lvl >= 48) {
			armor[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
		}
		
		if(lvl >= 51) {
			armor[4] = new ItemStack(Material.NETHERITE_BOOTS);
		}
		if(lvl >= 54) {
			armor[1] = new ItemStack(Material.NETHERITE_HELMET);
		}
		if(lvl >= 57) {
			armor[3] = new ItemStack(Material.NETHERITE_LEGGINGS);
		}
		if(lvl >= 60) {
			armor[2] = new ItemStack(Material.NETHERITE_CHESTPLATE);
		}
		return armor;
	}
	
}
