package tests.ai;

import static org.junit.Assert.*;

import org.junit.Test;

import dicecardgame.ai.ComputeCard;
import dicecardgame.board.Board;
import dicecardgame.exceptions.InvalidBoard;
import dicecardgame.exceptions.InvalidCard;
import dicecardgame.hand.Hand;

public class ComputeCardTest
{
    String handString = "4H 5H 7D AC QH 9D 3S JH KC 7C KH 8D QD";
    String[] board = new String[] { "C", "D7", "S59", "H2K" };


    @Test
    public void test() {
        try
        {
            Hand hand = new Hand(handString);
            Board b = new Board(board);
            ComputeCard cc = new ComputeCard(hand, b);
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvalidBoard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
