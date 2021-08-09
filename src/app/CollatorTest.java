/**
 * 
 */
package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Cian McCarthy
 *
 */
class CollatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	
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
		collate.collateContent("1223456,2345,us_west,BlueTeam,ProjectBanana,2211s");
		collate.collateContent("1233456,2345,us_west,BlueTeam,ProjectDate,2221s");
		collate.collateContent("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link app.Collator#collateContent(java.lang.String)}.
	 */
	@Test
	final void testCollateContent() {
		Collator collate = new Collator();
		collate.collateContent("2343225,2345,us_east,RedTeam,ProjectApple,3445s");
		collate.collateContent("3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s");
		assertEquals("Checking size of List", 2, collate.CustomerIdsPerContract.size());
		assertEquals("Checking size of List", 2, collate.CustomerIdsPerGeoZone.size());
		assertEquals("Checking size of List", 2, collate.BuildDurationPerGeoZone.size());
		assertEquals("Checking size of List", 2, collate.ListOfCustomerIdsPerGeoZone.size());
	}

	/**
	 * Test method for {@link app.Collator#getCustomerIdsPerContractId()}.
	 */
	@Test
	final void testGetCustomerIdsPerContractId() {
		
		System.out.println(collate.getCustomerIdsPerContractId());
		for (String keys : collate.getCustomerIdsPerContractId().keySet()) {
			assertTrue(collate.getCustomerIdsPerContractId().keySet().contains(keys));
			assertTrue(collate.getCustomerIdsPerContractId().get(keys).size() >= 1);
		}
	}

	/**
	 * Test method for {@link app.Collator#setCustomerIdsPerContractId(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testSetCustomerIdsPerContractId() {

		Collator collate = new Collator();
		collate.setCustomerIdsPerContractId("12345", "9876");
		collate.setCustomerIdsPerContractId("12346", "9876");
		collate.setCustomerIdsPerContractId("12347", "9876");
		assertTrue(collate.getCustomerIdsPerContractId().get("9876").get(0) == "12345");
		assertTrue(collate.getCustomerIdsPerContractId().get("9876").get(1) == "12346");
		assertTrue(collate.getCustomerIdsPerContractId().get("9876").get(2) == "12347");
	}

	/**
	 * Test method for {@link app.Collator#getCustomerIdsPerGeoZone()}.
	 */
	@Test
	final void testGetCustomerIdsPerGeoZone() {

		System.out.println(collate.getCustomerIdsPerGeoZone());
		for (String key : collate.getCustomerIdsPerGeoZone().keySet()) {
			assertTrue(collate.getCustomerIdsPerGeoZone().keySet().contains(key));
			assertTrue(collate.getCustomerIdsPerGeoZone().get(key).size() >= 1);
		}
	}

	/**
	 * Test method for {@link app.Collator#setCustomerIdsPerGeoZone(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testSetCustomerIdsPerGeoZone() {

		System.out.print(collate.getCustomerIdsPerGeoZone());
		for (String key : collate.getCustomerIdsPerGeoZone().keySet()) {
			assertTrue(collate.getCustomerIdsPerGeoZone().keySet().contains(key));
			assertTrue(collate.getCustomerIdsPerGeoZone().get(key).size() >= 1);
		}
	}

	/**
	 * Test method for {@link app.Collator#getAverageBuildDurationPerGeoZone()}.
	 */
	@Test
	final void testGetAverageBuildDurationPerGeoZone() {

		System.out.print(collate.getAverageBuildDurationPerGeoZone());
		for (String key : collate.getAverageBuildDurationPerGeoZone().keySet()) {
			assertTrue(collate.getAverageBuildDurationPerGeoZone().keySet().contains(key));
			assertTrue(collate.getAverageBuildDurationPerGeoZone().get(key).size() >= 1);
		}
	}

	/**
	 * Test method for {@link app.Collator#setBuildDurationPerGeoZone(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testSetBuildDurationPerGeoZone() {

		System.out.print(collate.getAverageBuildDurationPerGeoZone());
		for (String key : collate.getAverageBuildDurationPerGeoZone().keySet()) {
			assertTrue(collate.getAverageBuildDurationPerGeoZone().keySet().contains(key));
			assertTrue(collate.getAverageBuildDurationPerGeoZone().get(key).size() >= 1);
		}
	}

	/**
	 * Test method for {@link app.Collator#getListOfCustomerIdsPerGeoZone()}.
	 */
	@Test
	final void testGetListOfCustomerIdsPerGeoZone() {

		String [] geoList = {"us_east", "eu_west", "us_west"};
		System.out.print(collate.getListOfCustomerIdsPerGeoZone());
		for (String key : geoList) {
			assertTrue(collate.getListOfCustomerIdsPerGeoZone().contains(key));
		}
		assertTrue(collate.getListOfCustomerIdsPerGeoZone().size() == geoList.length);
	}

	/**
	 * Test method for {@link app.Collator#setListOfCustomerIdsPerGeoZone(java.lang.String)}.
	 */
	@Test
	final void testSetListOfCustomerIdsPerGeoZone() {

		String [] geoList = {"us_east", "eu_west", "us_west"};
		System.out.print(collate.getListOfCustomerIdsPerGeoZone());
		for (String key : geoList) {
			assertTrue(collate.getListOfCustomerIdsPerGeoZone().contains(key));
		}
		assertTrue(collate.getListOfCustomerIdsPerGeoZone().size() == geoList.length);
	}

}
