/**
 * 
 */
package dicecardgame.ai;

import dicecardgame.board.Board;
import dicecardgame.card.Card;
import dicecardgame.exceptions.InvalidCard;
import dicecardgame.hand.Hand;

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
    
    public Card pickCard()
    {
        Card c = null;
        try
        {
            c= new Card("2H");
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;
    }
}
