package tests.FileIO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import dicecardgame.exceptions.InvalidBoard;
import dicecardgame.exceptions.InvalidCard;
import dicecardgame.fileIO.InputFile;

public class InputTextTest
{

    String fileName = "input.txt";
    InputFile inputFile;

    @Test
    public void testInputFile() {
        inputFile = new InputFile(fileName);
        assertTrue(inputFile.exists());
    }

    @Test
    public void testInputFileValid() {
        inputFile = new InputFile(fileName);
        try
        {
            assertTrue(inputFile.isValid());
        }
        catch (IOException e)
        {
            fail("File " + fileName + " can't be read ");
        }
        catch (InvalidCard e)
        {
            fail("Invalid card found in hand line: "
                    + inputFile.getHandString());
        }
        catch (InvalidBoard e)
        {
            fail("Invalid played car line: " + inputFile.getSuits());
        }
    }

    @Test
    public void testGetHand() {
        inputFile = new InputFile(fileName);
        try
        {
            inputFile.isValid();

            assertEquals(inputFile.getHandString(),
                    "4H 5H 7D AC QH 9D 3S JH KC 7C KH 8D QD");
        }
        catch (IOException e)
        {
            fail("File " + fileName + " is not a valid format");
            e.printStackTrace();
        }
        catch (InvalidCard e)
        {
            fail("Invalid card found in hand line: "
                    + inputFile.getHandString());
        }
        catch (InvalidBoard e)
        {
            fail("Invalid played car line: " + inputFile.getSuits());
        }
    }

    @Test
    public void testGetSuit() {
        inputFile = new InputFile(fileName);
        String[] suits = new String[] { "C", "D7", "H49", "S" };
        try
        {
            inputFile.isValid();
            assertArrayEquals(inputFile.getSuits(), suits);
        }
        catch (IOException e)
        {
            fail("File " + fileName + " is not a valid format");
            e.printStackTrace();
        }
        catch (InvalidCard e)
        {
            fail("Invalid card found in hand line: "
                    + inputFile.getHandString());
        }
        catch (InvalidBoard e)
        {
            fail("Invalid played car line: " + inputFile.getSuits());
        }
    }
}
