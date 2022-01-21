/**
 * 
 */
package loops;

import org.bukkit.Bukkit;

import main.Utils;

public class Announcements {

	static int timer = 0;
	public static void call() {
		timer += 1;
		if(timer > (60 * 20)) {
			timer = 0;
			
			int type = Utils.random(1,3);
			if(type == 1) {
				// Thank you for supporting us messages.
				int rng = Utils.random(1,2);
				String message = "";
				
				if(rng == 1) {
					message = "Hey you! Want to support Halt Mines? Join our discord at <link>!";
				} else if (rng == 2) {
					message = "Thanks for playing Halt Mines! If you're confused, feel free to ask a staff member for help at any time!";
				}
				
				Bukkit.broadcastMessage("§c[Announcement] §f" + message);
			} else {
				// Pro tips for gameplay.
				int rng = Utils.random(1,6);
				String message = "";
				
				if(rng == 1) {
					message = "If you're lost, you can return to the Camp at 0, 0!";
				} else if (rng == 2) {
					message = "You can get better pickaxes by completing Objectives and buying from Shops!";
				} else if (rng == 3) {
					message = "Don't try to powerlevel through the game. Instead, take it slow and complete Objectives for a much more fun experience. And if you do, you'll run out of content too fast.";
				} else if (rng == 4) {
					message = "The Statue mechanic is inspired by a good friend of mine, Ender_Stone.";
				} else if (rng == 5) {
					message = "Remember to take breaks to eat, drink water, and take care of yourself!";
				} else if (rng == 6) {
					message = "This server uses a custom mining system, so be aware!";
				}
				
				Bukkit.broadcastMessage("§e[Tip] §f" + message);
			}
			
		}
	}
}
