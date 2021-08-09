/**
 * 
 */
package app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author cmccarth
 *
 */
class ReadFileInputTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	ReadFileInput input = new ReadFileInput();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link app.ReadFileInput#readFile()}.
	 * @throws IOException 
	 */
	@Test
	final void testReadFile() throws IOException {
		// ReadFileInput input = new ReadFileInput();
		// System.out.print(input.readFile());
		for (String key : input.readFile()) {
			assertTrue(key.length() >= 0);
		}
	}

}
