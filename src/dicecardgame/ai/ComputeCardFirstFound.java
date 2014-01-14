/**
 * 
 */
package dicecardgame.ai;

import java.util.ArrayList;

import dicecardgame.board.Board;
import dicecardgame.card.Card;
import dicecardgame.exceptions.InvalidCard;
import dicecardgame.hand.Hand;

/**
 * @author mom Method used to compute the card to play for this hand and board
 */
public class ComputeCardFirstFound extends ComputeCardAB implements ComputeCardInterface
{
    public ComputeCardFirstFound(Hand hand, Board board)
    {
        this.hand = hand;
        this.board = board;
    }

    public Card pickCard() {
        Card c = null;
        ArrayList<Card> playableCards = board.getPlayableCards();
        ArrayList<Card> handCards = hand.getCards();
        for (Card playC : playableCards)
        {
            if (c == null)
            {
                for (Card handCard : handCards)
                {
                    if (playC.toString().equals(handCard.toString()))
                    {
                        c = handCard;
                        break;
                    }
                }
            }
        }
        return c;
    }
}
