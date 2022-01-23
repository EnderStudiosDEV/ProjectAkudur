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
					message = "Hey you! Want to support Akudur? Join our discord at <link>!";
				} else if (rng == 2) {
					message = "Thanks for playing Akudur! If you're confused, feel free to ask a staff member for help at any time!";
				} else if (rng == 3) {
					message = "Thanks to Enderae for coming up with the server name!";
				} else if (rng == 4) {
					message = "Thanks to all of our playtesters for ensuring quality!";
				}
				
				Bukkit.broadcastMessage("§c[Announcement] §f" + message);
			} else {
				// Pro tips for gameplay.
				int rng = Utils.random(1,6);
				String message = "";
				
				if(rng == 1) {
					message = "If you fall in the void, you just get teleported back to spawn!";
				} else if (rng == 2) {
					message = "You can get better pickaxes by buying from Merchants!";
				} else if (rng == 3) {
					message = "Remember to weigh stats, and figure out which pickaxes suit your needs!";
				} else if (rng == 4) {
					message = "You can quickly see your stats on the action bar!";
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
