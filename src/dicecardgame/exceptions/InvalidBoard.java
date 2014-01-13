package dicecardgame.exceptions;

/**
 * @author mom
 *
 * throws exception when an invalid board is detected.
 */
public class InvalidBoard extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = 8812340350766463041L;

    public InvalidBoard(String msg)
    {
        super(msg);
    }
}
