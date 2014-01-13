package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.FileIO.InputTextTest;
import tests.FileIO.OutputFileTest;
import tests.ai.ComputeCardTest;
import tests.board.BoardTest;
import tests.card.CardTest;
import tests.hand.HandTest;

@RunWith(Suite.class)
@SuiteClasses({ InputTextTest.class, OutputFileTest.class, HandTest.class, CardTest.class, BoardTest.class, ComputeCardTest.class, PlayGameTest.class })
public class AllTests {

}
