package Factory;

import java.io.File;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;



/**
 * The FielHierarchy class creates a file hierarchy for
 * the current or a given year with a simple structure:
 *
 * year => month1,..,month12 =>(for every month) Day1,...,Day31.
 * 
 * @author Martin Machajewski
 *
 * 
 */
public class FolderHierarchy {

	private String filePath;
	/**
	 * creates a folder hierarchy for the current year
	 * 
	 * initializing an object using this constructor creates a file hierarchy which
	 * creates a folder using the following structure:
	 * current_year => month1,..,month12 =>(for every month) YYYY_MM_DD,...,YYYY_MM_DD.
	 * 
	 * @param path the path where the file hierarchy will be created 
	 */
	public FolderHierarchy(String path) {
		filePath = path;
		createStandartHierachy(Year.now());
	}
	
	/**
	 * Creates a folder hierarchy for all years, from the startYear to the endYear
	 * 
	 * initializing an object using this constructor creates a file hierarchy which
	 * creates a folder using the following structure:
	 * startYear,...,endYear =>(for every year) month1,..,month12 =>
	 * 							(for every month) YYYY_MM_DD,...,YYYY_MM_DD.
	 * @param startYear
	 * @param endYear
	 * @param path
	 */
	public FolderHierarchy(Year startYear, Year endYear, String path) {
		filePath = path;
		createStandartHierarchyFromTo(startYear, endYear);
	}
	
	public void createStandartHierarchyFromTo(Year startYear, Year endYear) 
	{
		Year tempYear = startYear;
		while(tempYear.getValue() <= endYear.getValue()) 
		{
			createStandartHierachy(tempYear); 
			tempYear = tempYear.plusYears(1);
		}
	}
	
	/**
	 * creates a file hierarchy which
	 * creates a folder using the following structure:
	 * folder year => month1,..,month12 =>(for every month) Day1,...,Day31.
	 * Takes leap years into account
	 */
	public void createStandartHierachy(Year year) 
	{
		//create a directory and folder named with your current year
		String yearPath = makeDir(year.toString(), filePath);
		
		//create a directory and folder for every month
		for(Month c : Month.values()) 
		{
			//create the folder
			String pathMonth = makeDir(year.toString() + "_" + c.name(), yearPath);
			//use YearMonth to get the LocalDate
			YearMonth yMonth = YearMonth.of(year.getValue(), c);
			
			//create folders for every day of the month while taking leap years into account
			if(year.isLeap()) 
			{
				for(int j = 1; j <= c.length(true); j++) 
				{
					//if we have a leap year
					//get the date at the year and month => 2013-01-01
					//create a directory for that day inside the month folder
					LocalDate lDate = yMonth.atDay(j);
					makeDir(lDate.toString(), pathMonth);

				};
			}else {
				for(int j = 1; j <= c.length(false); j++) 
				{
					//if we don't have a leap year
					//get the date at the year and month => 2013-01-01
					//create a directory for that day inside the month folder
					LocalDate lDate = yMonth.atDay(j);
					makeDir(lDate.toString(), pathMonth);
				};
			}
		}

	}
	
	/**
	 * Created a directory with a given name at the given location
	 * provided by the path
	 * @param dirName name the directory should have
	 * @param path to the location where the directory will be created
	 * @return the absolute path or null if creation was unsuccessful
	 */
	private String makeDir(String dirName, String path) 
	{
		File rootDir = new File(path + "/" + dirName);
		Boolean wasCreated = rootDir.mkdir();

		if(wasCreated) 
		{
			System.out.println("Directory created: " + dirName);
			return rootDir.getAbsolutePath();
		}else {
			System.out.println("Failed to create directory: " + dirName);
		}
		return null;
	}
	
}
