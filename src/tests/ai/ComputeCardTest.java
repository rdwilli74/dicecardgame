package tests.ai;

import static org.junit.Assert.*;

import org.junit.Test;

import dicecardgame.ai.ComputeCardAB;
import dicecardgame.ai.ComputeCardFirstFound;
import dicecardgame.board.Board;
import dicecardgame.exceptions.InvalidBoard;
import dicecardgame.exceptions.InvalidCard;
import dicecardgame.hand.Hand;

public class ComputeCardTest
{
    String handString = "AC QH 9D 3S JH KC 7C KH 8D QD";
    String[] board = new String[] { "C", "D7", "S59", "H49" };


    @Test
    public void test() {
        try
        {
            Hand hand = new Hand(handString);
            Board b = new Board(board);
            ComputeCardAB cc = new ComputeCardFirstFound(hand, b);
            assertEquals(cc.pickCard().toString(),"7C");
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
