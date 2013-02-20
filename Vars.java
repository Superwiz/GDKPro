package GDKPro;

import java.awt.Color;
import java.awt.Font;

import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;

public class Vars {
	public static final Color color1 = Color.WHITE;
    public static final Font font1 = new Font("BrowalliaUPC", 0, 17);
	public static String Status;
	public static String Method;
	public static Timer timer = new Timer(0);
	public static double VERSION = 0.2;
	public static int JOB_TYPE;
	
	//public static int GREEN_DRAGONS[] = {4680, 941};
	public static int GREEN_DRAGON1 = 941;
	public static int GREEN_DRAGON2 = 4680;
	public static int GREEN_DRAGON3 = 4679;
	public static int MAGIC_SHORTBOW = 861;
	public static int MITHRIL_ARROWS = 888;
	public static int FOOD = 361;
	public static int TAB = 8007;
	public static int WILD_WALL = 65076;
	public static int LOOT[] = {536, 1753, 12160};
			
	public static Area EDGE_BANK = new Area(new Tile[] { 
			new Tile(3099, 3500, 0), new Tile(3099, 3488, 0),
			new Tile(3090, 3500, 0), new Tile(3090, 3487, 0) });
	
	public static Area NORTH_OF_WALL = new Area(new Tile[] { 
			new Tile(3039, 3522, 0), new Tile(3047, 3522, 0), new Tile(3047, 3521, 0), 
			new Tile(3039, 3521, 0) });
	
	public static Area SOUTH_OF_WALL = new Area(new Tile[] { 
			new Tile(3039, 3521, 0), new Tile(3047, 3521, 0), new Tile(3047, 3520, 0), 
			new Tile(3039, 3520, 0) });
	
	public static Area WEST_DRAGS = new Area(new Tile[] { 
			new Tile(2965, 3635, 0), new Tile(2969, 3638, 0), new Tile(2974, 3640, 0), 
			new Tile(2979, 3641, 0), new Tile(2984, 3639, 0), new Tile(2989, 3637, 0), 
			new Tile(2994, 3636, 0), new Tile(2996, 3631, 0), new Tile(2999, 3627, 0), 
			new Tile(3000, 3622, 0), new Tile(3000, 3617, 0), new Tile(3000, 3612, 0), 
			new Tile(2999, 3607, 0), new Tile(2995, 3604, 0), new Tile(2991, 3601, 0), 
			new Tile(2986, 3599, 0), new Tile(2981, 3598, 0), new Tile(2976, 3597, 0), 
			new Tile(2971, 3598, 0), new Tile(2966, 3600, 0), new Tile(2962, 3603, 0), 
			new Tile(2959, 3607, 0), new Tile(2959, 3612, 0), new Tile(2958, 3617, 0), 
			new Tile(2957, 3622, 0), new Tile(2959, 3627, 0), new Tile(2962, 3631, 0), 
			new Tile(2965, 3635, 0) });
	
	public static Tile[] PathToWests = new Tile[] {
			new Tile(3092, 3495, 0), new Tile(3094, 3500, 0), new Tile(3089, 3502, 0), 
			new Tile(3084, 3502, 0), new Tile(3079, 3503, 0), new Tile(3074, 3504, 0), 
			new Tile(3071, 3508, 0), new Tile(3067, 3511, 0), new Tile(3062, 3511, 0), 
			new Tile(3057, 3511, 0), new Tile(3052, 3512, 0), new Tile(3048, 3515, 0), 
			new Tile(3044, 3518, 0), new Tile(3042, 3523, 0), new Tile(3041, 3528, 0), 
			new Tile(3039, 3533, 0), new Tile(3038, 3538, 0), new Tile(3037, 3543, 0), 
			new Tile(3035, 3548, 0), new Tile(3034, 3553, 0), new Tile(3031, 3557, 0), 
			new Tile(3026, 3558, 0), new Tile(3021, 3559, 0), new Tile(3016, 3561, 0), 
			new Tile(3011, 3563, 0), new Tile(3006, 3565, 0), new Tile(3003, 3569, 0), 
			new Tile(3000, 3573, 0), new Tile(2997, 3577, 0), new Tile(2993, 3580, 0), 
			new Tile(2989, 3583, 0), new Tile(2988, 3588, 0), new Tile(2985, 3592, 0), 
			new Tile(2984, 3597, 0), new Tile(2984, 3602, 0), new Tile(2982, 3607, 0), 
			new Tile(2980, 3612, 0) };
}
