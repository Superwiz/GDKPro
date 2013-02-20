package GDKPro;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class WalkToEdgeBank extends Node {

	public boolean conditions() {
		if (!Inventory.contains(Vars.FOOD) 
				|| !Equipment.appearanceContainsOneOf(Vars.MAGIC_SHORTBOW)
				|| !Equipment.appearanceContainsOneOf(Vars.MITHRIL_ARROWS)
				|| Players.getLocal().getHealthPercent() <= 30 && !Inventory.contains(Vars.FOOD)
				|| Inventory.isFull()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean activate() {
		return !Vars.EDGE_BANK.contains(Players.getLocal().getLocation())
				&& conditions();
	}

	@Override
	public void execute() {
		Vars.Status = "Walking to edge bank";
		Walking.newTilePath(Vars.PathToWests).reverse().traverse();
		
		SceneObject wild_wall = SceneEntities.getNearest(Vars.WILD_WALL);
		
		if (Vars.NORTH_OF_WALL.contains(Players.getLocal().getLocation())) {
			Vars.Status = "Crossing wilderness wall";
			wild_wall.click(true);
		}
	}
}
