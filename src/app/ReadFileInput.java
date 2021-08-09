/**
 * 
 */
package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Cian McCarthy
 *
 */
public class ReadFileInput {

	List<String> lines = new ArrayList<String>();

	public List<String> readFile() throws IOException {
		try {
			String data_file = System.getProperty("user.dir") + "\\src\\app\\data.txt";
			File file_content = new File(data_file);
			BufferedReader br = new BufferedReader(new FileReader(file_content));
			String st;
			while ((st = br.readLine()) != null)
				this.lines.add(st);
			br.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		return lines;
	}
}