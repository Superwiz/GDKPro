package GDKPro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.text.NumberFormat;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Environment;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;

@Manifest(authors = { "Programming" }, 
name = "GDKPro", 
description = "Kills Green Dragons", 
website = "",
version = 0.2)

public class Main extends ScriptWrapper implements PaintListener {
    
	@Override
	public void onStart() {
		
		switch (Vars.JOB_TYPE) {
		case 1://Wests
			//Vars.Method  = "Powerchop";
			//provide(new Chop());
			//provide(new Drop());
		break;
		default:
			provide(new Equip());
			provide(new Eater());
			provide(new Banker());
			//provide(new Loot());
			provide(new Attack());
			provide(new WalkToWests());
			provide(new WalkToEdgeBank());
			Vars.Method  = "Wests";
		break;
		}
		
		Vars.Status = "Starting script";

	}
	
	public void onStop() {
          Environment.captureScreen();
          stop();
	}
	 
	public boolean OpenInv() {
		if (Tabs.getCurrent() != Tabs.INVENTORY) {
			Tabs.INVENTORY.open();
		}
		return true;
	}
	
    public static String PerHour(long arg) {
        return NumberFormat.getIntegerInstance().format(
                        arg * 3600000D / (Vars.timer.getElapsed()));
    }

    public static String niceNumbers(int a) {
        return NumberFormat.getIntegerInstance().format(a);
    }	

	public void onRepaint(Graphics g1) {
        //int WC_GAINED = Skills.getExperience(Skills.WOODCUTTING) - Vars.startWCExp;
        
		// Creates the text
        g1.setFont(Vars.font1);
        g1.setColor(Vars.color1);
        g1.drawString("GDK Pro (v" + Vars.VERSION + ")", 4, 90);
        g1.drawString("Time: " + Vars.timer.toElapsedString(), 4, 100);
        g1.drawString("Status: " + Vars.Status, 4, 110);
        /*g1.drawString("Logs: " + Vars.logCount + " ("
                        + PerHour(Vars.logCount) + ")", 4, 120);
        g1.drawString("Exp: " + niceNumbers(WC_GAINED) + " (" + PerHour(WC_GAINED)
                        + ")", 4, 130);
        */
		// Creates the mouse
		Point mousey = Mouse.getLocation();
		int x = (int) mousey.getX();
		int y = (int) mousey.getY();
		if (System.currentTimeMillis() - Mouse.getPressTime() < 900)
			g1.setColor(Color.WHITE); //Pressed
		else
			g1.setColor(new Color(153, 153, 153, 160)); //Regular
		g1.drawLine(x, 0, x, Game.getBaseX());
		g1.drawLine(0, y, Game.getBaseY(), y);
		g1.fillRect(x - 1, y - 1, 3, 3);
	}
}
