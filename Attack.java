package GDKPro;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.interactive.Player;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Attack extends Node {

	Player p = Players.getLocal();
	
	NPC target = NPCs.getNearest(new Filter<NPC>() {
		public boolean accept(NPC npc) {
			return npc.getInteracting() == null
					&& (npc.getId() == Vars.GREEN_DRAGON1 
					|| npc.getId() == Vars.GREEN_DRAGON2
					|| npc.getId() == Vars.GREEN_DRAGON3);
		}
	});
	
	public boolean conditions() {
		if (Inventory.contains(Vars.FOOD) && p.getHealthPercent() > 50
				&& Equipment.appearanceContainsOneOf(Vars.MAGIC_SHORTBOW)
				&& !Inventory.isFull()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean activate() {
		return Vars.WEST_DRAGS.contains(Players.getLocal().getLocation())
				&& conditions();
	}

	@Override
	public void execute() {	
		
		//Prayer
		if (Prayer.getPoints() > 0) {
			if (!Prayer.isQuickOn()) {
				Vars.Status = "Toggeling quick prayers";
				Prayer.toggleQuick(true);
				sleep(1000);
			}
		}
		
		//Attacking
		if (!p.isInCombat())
			if (target != null) {
				if (target.isOnScreen()) {

							Vars.Status = "Fighting";
							target.interact("Attack");
							sleep(500);
						} else if (!target.isOnScreen()) {
							Walking.walk(target.getLocation());
			
				}
			}
		}
	

}
