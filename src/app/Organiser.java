/**
 * 
 */
package app;

import java.io.IOException;
import java.util.List;

/**
 * @author Cian McCarthy
 */

public class Organiser {

	/**
	 * @throws IOException  
	 */
	
	public static void main(String[] args) throws IOException {
		ReadFileInput reader = new ReadFileInput();
		List<String> contents = reader.readFile();
		Report report = new Report();
		report.runReport(contents);
		}
}