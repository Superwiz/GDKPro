package GDKPro;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class WalkToWests extends Node {

	public boolean conditions() {
		if (Inventory.contains(Vars.FOOD) 
				&& Equipment.appearanceContainsOneOf(Vars.MAGIC_SHORTBOW)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean activate() {
		return !Vars.WEST_DRAGS.contains(Players.getLocal().getLocation())
				&& conditions();
	}

	@Override
	public void execute() {
		Vars.Status = "Walking to wests";
		Walking.newTilePath(Vars.PathToWests).traverse();
		
		SceneObject wild_wall = SceneEntities.getNearest(Vars.WILD_WALL);
		
		if (Vars.SOUTH_OF_WALL.contains(Players.getLocal().getLocation())) {
			Vars.Status = "Crossing wilderness wall";
			wild_wall.click(true);
		}
	}
}
