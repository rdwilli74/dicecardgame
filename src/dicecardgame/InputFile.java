package dicecardgame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class InputFile {

	Path inputFile;
	String hand;
	String[] suits;

	public InputFile(String string) {
		inputFile = Paths.get(string);
	}

	public boolean exists() {
		return Files.exists(inputFile);
	}

	public boolean isValid() throws IOException {
		Boolean flag = Files.isReadable(inputFile);
		if (flag)
			flag = Files.isDirectory(inputFile);
		if (!flag) {
			byte[] temp = Files.readAllBytes(inputFile);
			String record = new String(temp, "ISO-8859-1");
			StringTokenizer st = new StringTokenizer(record, System.lineSeparator());
			if (st.countTokens() == 5) {
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
