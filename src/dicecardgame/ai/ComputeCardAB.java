/**
 * 
 */
package dicecardgame.ai;

import dicecardgame.board.Board;
import dicecardgame.card.Card;
import dicecardgame.hand.Hand;

/**
 * @author mom
 *
 */
public abstract class ComputeCardAB 
{
    protected Hand hand;
    protected Board board;
    
    public abstract Card pickCard();
}
