package SaveCounter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class SaveCounter {

		//TODO: CREATE A FILE SaveFileSystemCounter if not existent
		//      Should the file exists, you will be able to load and save and get the counter
	
	private static File saveFile;
	private static int _counter = -1;
	
	/**
	 * Saves the counter you used to the SaveFileSystemCounter.txt 
	 * via createSaveFile()
	 * @param counter the counter for the FileSystemHierarchy name
	 * @return true if the new counter is higher than the saved counter and if writing was successful,
	 * 			if not it returns false
	 * @throws IOException
	 */
	public static boolean save(int counter) throws IOException {
		
		_counter = SaveCounter.load();//try to load the counter var
		
		if(_counter < counter) {
				
			SaveCounter.createSaveFile(); //if file doesn't exist, create a file
			
			String tempCount = "counter=" + counter;
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile.getAbsolutePath()));
			writer.write(tempCount);
			writer.close();
			
			return true;
			
		} else {
			System.out.println("unable to save the same counter twice or "
					+ "your counter must be bigger than:" + _counter);
			return false;
		}

	}
	
	/**
	 * Load the SaveFileSystemCounter.txt file and get the saved counter value
	 * @return saved counter value
	 * @throws IOException
	 */
	public static int load() throws IOException {
		
		SaveCounter.createSaveFile();
		
		BufferedReader buffread = new BufferedReader(new FileReader(saveFile.getAbsolutePath()));
		
		String line = buffread.readLine();
		int number = Character.getNumericValue(line.charAt(line.length()-1));
		_counter = number;
		
		buffread.close();
		
		return number;
	}
	
	
	/**
	 * Creates a save file named SaveFileSystemCounter.txt inside
	 * your projects SaveTxtFile folder
	 * @throws IOException
	 */
	private static void createSaveFile() throws IOException {
		saveFile = new File("SaveTxtFile/SaveFileSystemCounter.txt");
		if(saveFile.exists() == false) {

			saveFile.createNewFile();
		}
	}
}
