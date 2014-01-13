package dicecardgame;

/**
 * @author mom
 *
 * throws an exception when a invalid card is detected.
 */
public class InvalidCard extends Exception {

	public InvalidCard(String msg)
	{
		super(msg);
	}
}
