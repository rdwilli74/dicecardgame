package tests.FileIO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import dicecardgame.fileIO.OutputFile;

public class OutputFileTest {

	String fileName = "output.txt";
	OutputFile outputFile = new OutputFile(fileName);;

	@Test
	public void testCreateFile() {
		
		assertNotNull(outputFile.getNewFile());
	}

	@Test
	public void testCanWriteOutputFile() {
		assertTrue(outputFile.canWrite());
	}

	@Test
	public void testWriteOutputFile() {
		try {
			outputFile.writeFile();
		} catch (IOException e) {
			fail("can't write " + fileName + " file");
			e.printStackTrace();
		}
	}

//	@Test
//	public void testDeleteOutputFile() {
//		try {
//			outputFile.deleteFile();
//		} catch (IOException e) {
//			fail("can't delete " + fileName + " file");
//		}
//	}
}
