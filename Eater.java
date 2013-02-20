package GDKPro;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.interactive.Player;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Eater extends Node {

	Player p = Players.getLocal();
	
	@Override
	public boolean activate() {
		return p.getHealthPercent() < 40;
	}

	@Override
	public void execute() {
		WidgetChild i = Inventory.getItem(Vars.FOOD).getWidgetChild();
		Vars.Status = "Eating food";
		i.click(true);
		sleep(500);
	}
}
