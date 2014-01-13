package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import dicecardgame.card.Card;
import dicecardgame.exceptions.InvalidCard;

public class CardTest
{

    String cardString = "4D";

    @Test
    public void testCard() {
        Card card;
        try
        {
            card = new Card(cardString);
            assertEquals(card.getRank(), 4);
            assertEquals(card.getSuit(), "D");
            assertEquals(card.toString(), "4D");
        }
        catch (InvalidCard e)
        {
            fail(e.getMessage());
        }

        cardString = "TS";
        try
        {
            card = new Card(cardString);
            assertEquals(card.getRank(), 10);
            assertEquals(card.getSuit(), "S");
            assertEquals(card.toString(), "TS");
        }
        catch (InvalidCard e)
        {
            fail(e.getMessage());
        }

        cardString = "AH";
        try
        {
            card = new Card(cardString);
            assertEquals(card.getRank(), 14);
            assertEquals(card.getSuit(), "H");
            assertEquals(card.toString(), "AH");
        }
        catch (InvalidCard e)
        {
            fail(e.getMessage());
        }

        cardString = "D4";
        try
        {
            card = new Card(cardString);
            fail("this is an invalid card format " + cardString);
        }
        catch (InvalidCard e)
        {
            // should throw and error. This is ok.
        }
    }

    @Test
    public void testGetNextLowest() {
        try
        {
            Card c = new Card("2H");
            Card nextCard = Card.getNextLowest(c);
            assertNull(nextCard);
            c = new Card("3S");
            nextCard = Card.getNextLowest(c);
            assertEquals(nextCard.toString(), new Card("2S").toString());
            c = new Card("AD");
            nextCard = Card.getNextLowest(c);
            assertEquals(nextCard.toString(), new Card("KD").toString());
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNextHighest() {
        try
        {
            Card c = new Card("2H");
            Card nextCard = Card.getNextHighest(c);
            assertEquals(nextCard.toString(), new Card("3H").toString());
            c = new Card("3S");
            nextCard = Card.getNextHighest(c);
            assertEquals(nextCard.toString(), new Card("4S").toString());
            c = new Card("AD");
            nextCard = Card.getNextHighest(c);
            assertNull(nextCard);
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
