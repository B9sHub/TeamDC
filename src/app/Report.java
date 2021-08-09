/**
 * 
 */
package app;

// import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Cian McCarthy
 *
 */
public class Report {

	HashMap<String, String> reportContents = new HashMap<String, String>();
	Collator collate = new Collator();		

	public void runReport(List<String> contents) {
		for (String entry : contents) {
			collate.collateContent(entry);
			}
		this.getCustomerIdCount(collate.getCustomerIdsPerContractId());
		this.getGeoZoneCustomerIdCount(collate.getCustomerIdsPerGeoZone());
		this.getAverageBuildDurationPerGeoZone(collate.getAverageBuildDurationPerGeoZone());
		this.uniqueCustomerIdsPerGeoZone(collate.getCustomerIdsPerGeoZone());
	}

	public void getCustomerIdCount(HashMap<String, List<String>> IdMap) {
		System.out.print("The number of unique customerId for each contractId ...\n");
		for (String key : IdMap.keySet()){
			System.out.print("ContractId "+ key + " has " + IdMap.get(key).size() + " Customer IDs\n");
		}
		System.out.print("\n");
	}

	public void getGeoZoneCustomerIdCount(HashMap<String, List<String>> IdMap) {
		System.out.print("The number of unique customerId for each geozone ...\n");
		for (String key : IdMap.keySet()){
			System.out.print("GeoZone "+ key + " has " + IdMap.get(key).size() + " Customer IDs\n");
		}
		System.out.print("\n");
	}
	
	public void getAverageBuildDurationPerGeoZone(HashMap<String, List<String>> IdMap) {
		System.out.print("The average buildduration for each geozone ...\n");
		for (String key : IdMap.keySet()){
			int TotalTime = 0;
			for (String time : IdMap.get(key)) {
				TotalTime += Integer.parseInt(time);
			}
			System.out.print("GeoZone "+ key + " has " + TotalTime/IdMap.get(key).size() + " Average Build Time\n");
		}
		System.out.print("\n");
	}
	
	public void uniqueCustomerIdsPerGeoZone(HashMap<String, List<String>> IdMap) {
		System.out.print("The list of unique customerId for each geozone ...\n");
		System.out.print(IdMap + "\n");
		System.out.print("\n");
	}
}