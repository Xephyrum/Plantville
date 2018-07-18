package plantville;

/**
 * The Plantville class serves as the main game class 
 * which holds all the necessary objects needed for the game
 * to run.
 * @author James Buizon 
 * @author Gabriel Santiago
 * @version 1.0, 8/10/2016
 */

public class Plantville {
	private Field field;
	private Player player;
	private Store store;
	private God timeSim;
	
        /**
         * Initializes the essential game components
         */
	public Plantville()
	{
		this.field = new Field();
		this.player = new Player();
		this.store = new Store();
		this.timeSim = new God();
	}
	/**
         * Initializes the essential game components.
         * @param name Contains the player name.
         */
	public Plantville (String name)
	{
		this.field = new Field();
		this.player = new Player(name);
		this.store = new Store();
		this.timeSim = new God();
	}
	/**
         * Initializes the essential game components. 
         * @param field Contains the field object that will be initialized.
         * @param player Contains the player object that will be initialized.
         * @param store Contains the store object that will be initialized.
         * @param timeSim Contains the time simulator object that will be initialized.
         */
        public Plantville(Field field, Player player, Store store, God timeSim)
	{
		this.field = field;
		this.player = player;
		this.store = store;
		this.timeSim = timeSim;
	}
	/**
         * Allows access to the in-game field.
         * @return the in-game field
         */
	public Field getField()
	{
		return field;
	}
	
        /**
         * Allows access to the player.
         * @return the player
         */
	public Player getPlayer()
	{
		return player;
	}
	/**
         * Allows access to the in-game store.
         * @return the in-game store
         */
	public Store getStore()
	{
		return store;
	}
	/**
         * Allows access to the in-game time simulator.
         * @return the in-game time simulator
         */        
	public God getTimeSim()
	{
		return timeSim;
	}
	/**
         * Allows the player to advance to the next day.         * 
         */
	public void nextDay()
	{
		timeSim.endDay();
		field.growPlants();
		field.elementsEffect();
		field.pestEffect();
		field.randomizePest();
		field.checkElements();
	}
	/**
         * Updates the in-game time.
         * @param n Contains the number of minutes or hours that will be added for every action performed.
         */
	public void updateTime(int n)
	{
		if (timeSim.updateTime(n)) {
			field.growPlants();
			field.elementsEffect();
			field.pestEffect();
			field.randomizePest();
                }
	}
	/**
         * Checks the money and the fertility of the soil to determine if the game is already over.
         * @return <code> false</code> if the game is already over; <code>true</code> otherwise.
         */
	public boolean isPlayable()
	{
		if (this.player.getWallet().getMoney() > 0 && this.field.isPlayable())
			return true;
		else
			return false;
	}
}
