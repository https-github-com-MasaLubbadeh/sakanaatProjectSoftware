package najah.edu.acceptance.service;

import java.util.HashMap;
import java.util.Map;

import najah.edu.acceptance.housing;

public class HousingService {

	private Map<Integer,housing> housingDB = new HashMap<>();
	
	public housing createHousing(housing entry) {
		int newIndex = getHousingDB().size() + 1;
		entry.setHousingID(newIndex);
		getHousingDB().put(newIndex, entry);
		return entry;
	}

	
	public housing updateHousing(housing entry) throws Exception{
		if(!getHousingDB().containsKey(entry.getHousingID())) {
			throw new Exception("ID not found");
		}
		housing exitingEntry = getHousingDB().get(entry.getHousingID());
		// manipulate existing entry by new entry
		exitingEntry.setLocation(entry.getLocation());
		// save to DB
		getHousingDB().put(entry.getHousingID(), exitingEntry);
		return entry;
	}
	
	public Map<Integer,housing> getHousingDB() {
		return this.housingDB;
	}

}
