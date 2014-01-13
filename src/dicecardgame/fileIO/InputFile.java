package dicecardgame.fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * @author mom
 * 
 *         Input file sent from server. This file should only have 5 lines.
 *         First line is our hand, the next for lines have the suits and cards
 *         played for each suit.
 */
public class InputFile
{

    Path inputFile;
    String hand;
    String[] suits;

    /**
     * InputFile will crate a java Path for reading the file.
     * @param string
     */
    public InputFile(String string)
    {
        inputFile = Paths.get(string);
    }

    public boolean exists() {
        return Files.exists(inputFile);
    }

    /**
     * Checks the input file is valid and has only 4 suits and  the cards in your hand are valid cards.
     * @return
     * @throws IOException
     */
    public boolean isValid() throws IOException {
        Boolean flag = Files.isReadable(inputFile);
        if (flag) flag = Files.isDirectory(inputFile);
        if (!flag)
        {
            byte[] temp = Files.readAllBytes(inputFile);
            String record = new String(temp, "ISO-8859-1");
            StringTokenizer st = new StringTokenizer(record,
                    System.lineSeparator());
            if (st.countTokens() == 5)
            {
                flag = true;
                hand = st.nextToken().trim();

                int lines = st.countTokens();
                suits = new String[lines];
                for (int i = 0; i < lines; i++)
                    suits[i] = st.nextToken().trim();
                System.out.println(suits);
            }
        }
        return flag;
    }

    public String getHand() {
        return hand;
    }

    public String[] getSuits() {
        return suits;
    }
}
