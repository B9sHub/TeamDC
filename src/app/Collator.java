/**
 * 
 */
package app;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Cian McCarthy
 *
 */
public class Collator {

	List<String> ListOfCustomerIdsPerGeoZone = new ArrayList<String>();
	HashMap<String, List<String>> CustomerIdsPerContract = new HashMap<String, List<String>>();
	HashMap<String, List<String>> CustomerIdsPerGeoZone = new HashMap<String, List<String>>();
	HashMap<String, List<String>> BuildDurationPerGeoZone = new HashMap<String, List<String>>();
	HashMap<String, List<String>> AverageBuildDurationPerGeoZone = new HashMap<String, List<String>>();

	public void collateContent(String entry) {
		String[] splitContents = entry.split(",");
		this.setCustomerIdsPerContractId(splitContents[0], splitContents[1]);
		this.setCustomerIdsPerGeoZone(splitContents[0], splitContents[2]);
		this.setBuildDurationPerGeoZone(splitContents[5], splitContents[2]);
		this.setListOfCustomerIdsPerGeoZone(splitContents[2]);
	}
	
	public HashMap<String, List<String>> getCustomerIdsPerContractId() {
		return this.CustomerIdsPerContract;
	}

	public void setCustomerIdsPerContractId(String customerId, String contractId) {
		if (this.CustomerIdsPerContract.get(contractId) == null) {
			this.CustomerIdsPerContract.put(contractId, new ArrayList<String>());
		}
		this.CustomerIdsPerContract.get(contractId).add(customerId);
	}

	public HashMap<String, List<String>> getCustomerIdsPerGeoZone() {
		return this.CustomerIdsPerGeoZone;
	}

	public void setCustomerIdsPerGeoZone(String customerId, String geoZone) {
		if (this.CustomerIdsPerGeoZone.get(geoZone) == null) {
			this.CustomerIdsPerGeoZone.put(geoZone, new ArrayList<String>());
		}
		this.CustomerIdsPerGeoZone.get(geoZone).add(customerId);
	}
	
	public HashMap<String, List<String>> getAverageBuildDurationPerGeoZone() {
		return this.BuildDurationPerGeoZone;
	}
	
	public void setBuildDurationPerGeoZone(String buildDuration, String geoZone) {
		if (this.BuildDurationPerGeoZone.get(geoZone) == null) {
			this.BuildDurationPerGeoZone.put(geoZone, new ArrayList<String>());
		}
		this.BuildDurationPerGeoZone.get(geoZone).add(buildDuration.split("s")[0]);
	}

	public List<String> getListOfCustomerIdsPerGeoZone() {
		return this.ListOfCustomerIdsPerGeoZone;
	}

	public void setListOfCustomerIdsPerGeoZone(String zone) {
		if (this.ListOfCustomerIdsPerGeoZone.contains(zone)) {
		} else { 
			this.ListOfCustomerIdsPerGeoZone.add(zone);
		}
	}
}
