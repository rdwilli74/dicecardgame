package dicecardgame.hand;

import java.util.ArrayList;
import java.util.StringTokenizer;

import dicecardgame.card.Card;
import dicecardgame.exceptions.InvalidCard;

/**
 * @author mom
 * Holds all the cards in your hand for this turn.
 */
public class Hand {

	private ArrayList<Card> cards;
	
	/**
	 * Take the string from the input.txt file and create an array of Cards.
	 * 
	 * @param handString
	 * @throws InvalidCard
	 */
	public Hand(String handString) throws InvalidCard {
		StringTokenizer st = new StringTokenizer(handString," ");
		int count = st.countTokens();
		cards = new ArrayList<Card>(count);
		for (int i =0; i< count; i++)
		{
		    cards.add(new Card(st.nextToken()));
		}
	}

	public ArrayList<Card> getCards() {
        return cards;
    }

    public String toString()
	{
	    StringBuffer hand = new StringBuffer();
	    if (cards != null)
	    {
	        for (Card c : cards)
	        {
	            hand.append(c.toString() + " ");
	        }
	    }
	    return hand.toString();
	}
}
