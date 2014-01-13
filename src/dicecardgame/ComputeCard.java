/**
 * 
 */
package dicecardgame;

/**
 * @author mom
 *  Method used to compute the card to play for this hand and board
 */
public class ComputeCard
{
    Hand hand;
    Board board;
    
    public ComputeCard(Hand hand, Board board)
    {
        this.hand = hand;
        this.board = board;
    }
}
