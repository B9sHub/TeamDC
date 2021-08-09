/**
 * 
 */
package app;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Cian McCarthy
 *
 */
class ReportTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	Report report = new Report();
	Collator collate = new Collator();
	
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
		collate.collateContent("2343225,2345,us_east,RedTeam,ProjectApple,3445s");
		collate.collateContent("3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link app.Report#runReport(java.util.List)}.
	 */
	@Test
	final void testRunReport() {
		List<String> contents = Arrays.asList("2343225,2345,us_east,RedTeam,ProjectApple,3445s", "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s");
		report.runReport(contents);
	}

	/**
	 * Test method for {@link app.Report#getCustomerIdCount(java.util.HashMap)}.
	 */
	@Test
	final void testGetCustomerIdCount() {
		for (String key : collate.getCustomerIdsPerContractId().keySet()) {
			assertTrue(collate.getCustomerIdsPerContractId().keySet().contains(key));
			assertTrue(collate.getCustomerIdsPerContractId().get(key).size() >= 1);
		}
		report.getCustomerIdCount(collate.getCustomerIdsPerContractId());
	}

	/**
	 * Test method for {@link app.Report#getGeoZoneCustomerIdCount(java.util.HashMap)}.
	 */
	@Test
	final void testGetGeoZoneCustomerIdCount() {
		for (String key : collate.getCustomerIdsPerGeoZone().keySet()) {
			assertTrue(collate.getCustomerIdsPerGeoZone().keySet().contains(key));
			assertTrue(collate.getCustomerIdsPerGeoZone().get(key).size() >= 1);
		}
		report.getGeoZoneCustomerIdCount(collate.getCustomerIdsPerGeoZone());
	}

	/**
	 * Test method for {@link app.Report#getAverageBuildDurationPerGeoZone(java.util.HashMap)}.
	 */
	@Test
	final void testGetAverageBuildDurationPerGeoZone() {
		for (String key : collate.getAverageBuildDurationPerGeoZone().keySet()) {
			assertTrue(collate.getAverageBuildDurationPerGeoZone().keySet().contains(key));
			assertTrue(collate.getAverageBuildDurationPerGeoZone().get(key).size() >= 1);
		}
		report.getAverageBuildDurationPerGeoZone(collate.getAverageBuildDurationPerGeoZone());
	}

	/**
	 * Test method for {@link app.Report#uniqueCustomerIdsPerGeoZone(java.util.HashMap)}.
	 */
	@Test
	final void testUniqueCustomerIdsPerGeoZone() {
		System.out.print(collate.getCustomerIdsPerGeoZone());
		for (String key : collate.getCustomerIdsPerGeoZone().keySet()) {
			assertTrue(collate.getCustomerIdsPerGeoZone().keySet().contains(key));
			assertTrue(collate.getCustomerIdsPerGeoZone().get(key).size() >= 1);
		}
		report.uniqueCustomerIdsPerGeoZone(collate.getCustomerIdsPerGeoZone());
	}
}
