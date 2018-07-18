package plantville;

/**
 * The Player class contains all the essential information
 * about the player's current state and displays them
 * while playing. 
 * @author James Buizon 
 * @author Gabriel Santiago
 * @version 1.0, 7/2/2016
 */

public class Player {
    
    private String name;
    private Wallet wallet;
    private Storage storage;
    
    /**
     * Initializes the player.
     */
    public Player() 
    {
        this.name = "";
        this.wallet = new Wallet();
        this.storage = new Storage();
    }
    
    /**
     * Initializes the player.
     * @param name Accepts a String input from the user to set the player's name
     */
    public Player(String name)
    {
    	this.name = name;
    	this.wallet = new Wallet();
        this.storage = new Storage();
    }
    
    /**
     * Returns the player's name.
     * @return the the player's name 
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * The method is used to access the player's wallet.
     * @return the player's wallet
     * @see Wallet
     */ 
    public Wallet getWallet()
    {
        return wallet;
    }
    /**
     * The method is used to access the player's storage.
     * @return the player's storage
     * @see Storage
     */
    public Storage getStorage() 
    {
        return storage;
    }
    
    /**
     * The method is used to let the player customize his name .
     * @param s Accepts a String input from the user to set the player's name
     */
    public void setName(String s) 
    {
        name = s;
    }
    
    /**
     * Displays the string format of all the necessary information about the status of the player
     * @return the string format of the information about the player
     */
    public String toString()
    {
    	String s;
    	s = "Player Name: " + this.name + "   Money: " + wallet.getMoney() + " C";
    	return s;
    }
}
