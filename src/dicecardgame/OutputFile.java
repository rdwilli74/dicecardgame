package dicecardgame;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputFile {

	Path newFile = null;
	String fileName;
	
	public OutputFile(String file) {
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
