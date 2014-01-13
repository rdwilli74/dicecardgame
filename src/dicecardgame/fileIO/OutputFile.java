package dicecardgame.fileIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author mom Object is used to write the output txt file for the server. The
 *         output text file represents your played card. It should only contain
 *         2 characters. I.E. only on Card.toString().
 */
public class OutputFile
{

    Path newFile = null;
    String fileName;

    public OutputFile(String file)
    {
        fileName = file;
        createFile();
    }

    private void createFile() {
        newFile = FileSystems.getDefault().getPath(fileName);

    }

    public boolean canWrite() {
        return Files.isWritable(newFile);
    }

    public boolean deleteFile() throws IOException {
        Files.delete(newFile);
        return true;
    }

    /**
     * test code. Need to have it take in a Card object and write the string to
     * the file.
     * 
     * @return
     * @throws IOException
     */
    public boolean writeFile() throws IOException {
        boolean Flag = false;
        String temp = "bobbobobobobobobobbobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob";
        byte[] byteArray = temp.getBytes("UTF-8");
        Files.write(newFile, byteArray);

        Flag = true;
        return Flag;

    }

    public Path getNewFile() {
        return newFile;
    }
}
