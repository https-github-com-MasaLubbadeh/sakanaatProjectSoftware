package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class housing {
	private int housingID;
	private String ownerName;
	private String location;
	private int numbersOfFloors;
	private int numbersOfApartmentInEachFloor;
	//private static ArrayList <apartment> apartmentObj;
    static Logger logger = LogManager.getLogger(Apartment.class);

	public housing(int housingID, String ownerName, String location, int numbersOfFloors,int numbersOfApartmentInEachFloor) {
		super();
		this.housingID = housingID;
		this.ownerName = ownerName;
		this.location = location;
		this.numbersOfFloors = numbersOfFloors;
		this.numbersOfApartmentInEachFloor = numbersOfApartmentInEachFloor;
	}
	public housing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHousingID() {
		return housingID;
	}
	public void setHousingID(int housingID) {
		this.housingID = housingID;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNumbersOfFloors() {
		return numbersOfFloors;
	}
	public void setNumbersOfFloors(int numbersOfFloors) {
		this.numbersOfFloors = numbersOfFloors;
	}
	public int getNumbersOfApartmentInEachFloor() {
		return numbersOfApartmentInEachFloor;
	}
	public void setNumbersOfApartmentInEachFloor(int numbersOfApartmentInEachFloor) {
		this.numbersOfApartmentInEachFloor = numbersOfApartmentInEachFloor;
	}
	public static boolean doesExist(int id, List<housing> housing) {
		//int index = -1;

		for (int i = 0; i < housing.size(); i++) {

			if (housing.get(i).getHousingID()==id) {

				return true;
			}
			
		}

		return false;
	}
	public static int getIndex(int id, List<housing> house) {
		int index = -1;

		for (int i = 0; i < house.size(); i++) {

			if (house.get(i).getHousingID()==id) {

				return i;
			}
		}

		return index;
	}
	
	@Override
	public String toString() {
		return "housing [housingID=" + housingID + ", ownerName=" + ownerName + ", location=" + location
				+ ", numbersOfFloors=" + numbersOfFloors + ", numbersOfApartmentInEachFloor="
				+ numbersOfApartmentInEachFloor + "]";
	}
	
	public static int getIndexByHousingID(int id, List<housing> housings) {
		int index = -1;

		for (int i = 0; i < housings.size(); i++) {

			if (housings.get(i).getHousingID()==id) {

				return i;
			}
		}

		return index;
	}

	
	public static void printNumberOfFloors(List<housing> housings, int housingID) {
		int housingIndex=housing.getIndexByHousingID(housingID, housings);
		logger.info("\n number of Floors: "+ housings.get(housingIndex).getNumbersOfFloors());
		logger.info( "\n");
	}

public static void printTenantsCount(List<Apartment> apartments,List<housing> housings, String ownerName) {
		int count=0;
		for(int i=0; i<apartments.size();i++) {
		int housingIndex=housing.getIndexByHousingID(apartments.get(i).getHousingID(), housings);
		 if( housings.get( housingIndex).getOwnerName().equalsIgnoreCase(ownerName) ) {
			if(apartments.get(i).isStudentHousing()) {// each student is a tenant
				count+=apartments.get(i).getCurrentNumberOfRoommates();
			}
	         if(apartments.get(i).isFamilyHousing() && !( apartments.get(i).isAvailabe()) ) { //each family is a tenant
		    	count++;
		    }
		 }
		}
	
		logger.info( "\n number of tenants in this housing: "+count);
		logger.info("\n");
		
	} 


}