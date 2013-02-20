package GDKPro;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;

public class Equip extends Node {

	@Override
	public boolean activate() {
		return Inventory.contains(Vars.MAGIC_SHORTBOW) 
				|| Inventory.contains(Vars.MITHRIL_ARROWS);
	}

	@Override
	public void execute() {
		if (Inventory.contains(Vars.MAGIC_SHORTBOW)
				&& !Equipment.appearanceContainsOneOf(Vars.MAGIC_SHORTBOW)) {
			Vars.Status = "Equiping Magic Shortbow";
			Equipment.equip(Vars.MAGIC_SHORTBOW);
			sleep(400, 450);
		} else if (Inventory.contains(Vars.MITHRIL_ARROWS)
				&& !Equipment.appearanceContainsOneOf(Vars.MITHRIL_ARROWS)) {
			Vars.Status = "Equiping Mithril Arrows";
			Equipment.equip(Vars.MITHRIL_ARROWS);
			sleep(400, 450);
		}
	}
}
