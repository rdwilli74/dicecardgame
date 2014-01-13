package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dicecardgame.Hand;
import dicecardgame.InvalidCard;

public class HandTest {

	String handString = "4H 5H 7D AC QH 9D 3S JH KC 7C KH 8D QD";
	
	@Test
	public void testHand() {
		try
        {
            Hand hand = new Hand(handString);
            String temp = hand.toString().trim();
            assertEquals(temp,handString);
        }
        catch (InvalidCard e)
        {
            fail(e.getMessage());
        }
	}
}
