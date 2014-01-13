package dicecardgame;

/**
 * @author mom
 *
 * throws exception when an invalid board is detected.
 */
public class InvalidBoard extends Exception
{
    public InvalidBoard(String msg)
    {
        super(msg);
    }
}
