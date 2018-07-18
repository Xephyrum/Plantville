package plantville;

/**
 * The Wallet class displays all the information and contains
 * all the necessary operations with regards to the player's
 * money.
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.0, 7/2/2016
 */

public class Wallet {
    
    private int money;
    
    
    /**
     * Initializes the starting money.
     */
    public Wallet() 
    {
        this.money = 100;
    }
    
    /**
     * Additional constructor to adjust starting money.
     * @param money Accepts an integer value to set as starting money
     */
    public Wallet(int money) 
    {
        this.money = money;
    }
    
    /**
     * Returns the current value of money inside the wallet.
     * @return the current value of the player's money
     */
    public int getMoney() 
    {
        return money;
    }
    
    /**
     * Increases money when harvesting crops or selling items.
     * @param m Accepts the harvest price or selling price of an item to add to the player's money
     */
    public void addMoney(int m) 
    {
        money += m;
    }
    
    /**
     * Reduces money when buying items from the store.
     * @param m Accepts the store price of the items to deduct from the player's money when buying
     */
    public void subtractMoney(int m) 
    {
        money -= m;
              
        if (money < 0)
        	money = 0;
    }
    
    
}
