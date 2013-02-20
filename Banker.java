package GDKPro;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;


public class Banker extends Node {
	
	public boolean conditions() {
		if (!Inventory.contains(Vars.FOOD) 
				|| Players.getLocal().getHealthPercent() <= 30 && !Inventory.contains(Vars.FOOD)
				|| Inventory.isFull()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean activate() {
		return Vars.EDGE_BANK.contains(Players.getLocal().getLocation())
				&& conditions();
	}

	@Override
	public void execute() {
		if (!Bank.isOpen()) {
			Vars.Status = "Opening bank";
			Bank.open();
		} else {
			Vars.Status = "Depositing inventory";
			Bank.depositInventory();
			sleep(300, 500);
			Vars.Status = "Depositing equipment";
			Bank.depositEquipment();
			sleep(300, 500);
			Vars.Status = "Withdrawing items";
			Bank.withdraw(Vars.FOOD, 3);
			sleep(300, 500);
			Bank.withdraw(Vars.MAGIC_SHORTBOW, 1);
			sleep(300, 500);
			Bank.withdraw(Vars.MITHRIL_ARROWS, 60);
			sleep(300, 500);
			Bank.close();
		}
	}
}