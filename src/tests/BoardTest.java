package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dicecardgame.Board;
import dicecardgame.Card;
import dicecardgame.InvalidBoard;
import dicecardgame.InvalidCard;

public class BoardTest
{

    @Test
    public void testBoard() {
        Board board = new Board();
        String[] b = new String[] { "C", "D7", "S59", "H2K" };
        try
        {
            board.addBoard(b);
            assertEquals(board.getClubLine(), "C");
            assertNull(board.getLowClub());
            assertNull(board.getHighClub());
            assertEquals(board.getSpadeLine(), "S59");
            assertEquals(board.getLowSpade().toString(), "5S");
            assertEquals(board.getHighSpade().toString(), "9S");

            assertEquals(board.getHeartLine(), "H2K");
            assertEquals(board.getLowHeart().toString(), "2H");
            assertEquals(board.getHighHeart().toString(), "KH");

            assertEquals(board.getDiamondLine(), "D7");
            assertEquals(board.getLowDiamond().toString(), "7D");
            assertEquals(board.getHighDiamond().toString(), "7D");
        }
        catch (InvalidBoard e)
        {
            fail(e.getMessage());
        }
        b = new String[] { "C", "D7", "S59", "H2K", "K34" };
        try
        {
            board.addBoard(b);
            fail("Should not be a valid board");
        }
        catch (InvalidBoard e)
        {
            // error is expected;
        }
    }

    @Test
    public void testGetPlayableCards() {
        Board board = new Board();
        String[] b = new String[] { "C", "D7", "S59", "H2K" };
        ArrayList<Card> cards = new ArrayList<Card>();
        try
        {
            cards.add(new Card("7C"));
            cards.add(new Card("6D"));
            cards.add(new Card("8D"));
            cards.add(new Card("4S"));
            cards.add(new Card("TS"));
            cards.add(new Card("AH"));
            board.addBoard(b);
            assertEquals(board.getPlayableCards().toString(), cards.toString());
        }
        catch (InvalidCard e)
        {
            fail("Invalid card: " + e.getMessage());
        }
        catch (InvalidBoard e)
        {
            fail("Invalid Board: " + e.getMessage());
        }
    }
}
