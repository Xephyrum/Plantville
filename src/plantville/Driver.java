package plantville;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * The Driver class is in charge of running all other
 * classes made for this project.
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.1, 7/3/2016
 * 
 * Disclaimer: We do not own majority of the sprites that we used in this game. 
 * All the images listed below are owned by their respective owners.
 * 
 * Sources:
 * http://www.clipart-box.com/images/legumes-picto.jpg
 * http://image.shutterstock.com/display_pic_with_logo/3628061/335654087/stock-vector-set-of-pixel-art-vegetables-vector-game-icons-335654087.jpg
 * http://www.ludumdare.com/compo/wp-content/uploads/2011/05/shrub.png
 * http://www.zeldadungeon.net/wiki/images/7/70/Rat-Sprite-2.png
 * http://s17.photobucket.com/user/jgs85/media/Monster_Worm2.png.html
 * https://www.themanaworld.org/images/7/7c/Fother-snail.png
 * http://www.create-games.com/article.asp?id=1768
 * http://m.rgbimg.com/cache1nDIR5/users/m/mz/mzacha/600/mhiHtOk.jpg
 * http://christchurchfulham.com/wp-content/uploads/2013/12/Kids_flyer_background.jpg
 */
public class Driver {
	private static Plantville game;
	private static Frame app;
	
	public static void main(String[] args)
	{
		Field field = new Field();
		God simulator = new God ();
		Player player = new Player ();
		Store store = new Store ();
		
		game = new Plantville(field, player, store, simulator);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			JOptionPane.showMessageDialog(null, "Unable to get look and feel from system.");
		}
		
		app = new Frame();
		app.setVisible(true);
		
		while(true)
		{
			if (!game.isPlayable()) {
				JOptionPane.showMessageDialog(null, "GAME OVER!");
				System.exit(0);
			}
		}
	}
	
	public static Plantville getGame()
	{
		return game;
	}
	
	public static Frame getFrame()
	{
		return app;
	}
	
	public static void setPlantville(Plantville g)
	{
		game = g;
	}
}
