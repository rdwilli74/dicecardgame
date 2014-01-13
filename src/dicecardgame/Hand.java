package dicecardgame;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Hand {

	private ArrayList<Card> cards;
	
	public Hand(String handString) throws InvalidCard {
		StringTokenizer st = new StringTokenizer(handString," ");
		int count = st.countTokens();
		cards = new ArrayList<Card>(count);
		for (int i =0; i< count; i++)
		{
		    cards.add(new Card(st.nextToken()));
		}
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
