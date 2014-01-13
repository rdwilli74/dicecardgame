package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InputTextTest.class, OutputFileTest.class, HandTest.class, CardTest.class, BoardTest.class, PlayGameTest.class })
public class AllTests {

}
