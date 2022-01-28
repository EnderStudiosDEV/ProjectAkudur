/**
 * 
 */
package loops;

import main.Main;

public class Core {

	public void callLoop() {
		Main.instance.getLogger().info("If you see this, it means the Loop Core is registered!");
		Main.instance.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
	        public void run() {
	        	Announcements.call();
	        	EssentialDisplays.call();
	        	PlayerStatManager.call();
	        	AutoPickaxe.call();
	        }
	    },1, 1);
	}
}
