package dicecardgame.exceptions;

/**
 * @author mom
 *
 * throws an exception when a invalid card is detected.
 */
public class InvalidCard extends Exception {

	/**
     * 
     */
    private static final long serialVersionUID = -4695880888942344333L;

    public InvalidCard(String msg)
	{
		super(msg);
	}
}
