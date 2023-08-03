package najah.edu.acceptance.service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import najah.edu.acceptance.Housing;

public class HousingService {

	private Map<Integer,Housing> housingDB = new HashMap<>();
	
	public Housing createHousing(Housing entry) {
		int newIndex = getHousingDB().size() + 1;
		entry.setHousingID(newIndex);
		getHousingDB().put(newIndex, entry);
		return entry;
	}

	
	public Housing updateHousing(Housing entry) throws NoSuchElementException{
		if(!getHousingDB().containsKey(entry.getHousingID())) {
			throw new NoSuchElementException("ID not found");
		}
		Housing exitingEntry = getHousingDB().get(entry.getHousingID());
		// manipulate existing entry by new entry
		exitingEntry.setLocation(entry.getLocation());
		// save to DB
		getHousingDB().put(entry.getHousingID(), exitingEntry);
		return entry;
	}
	
	public Map<Integer,Housing> getHousingDB() {
		return this.housingDB;
	}

}
