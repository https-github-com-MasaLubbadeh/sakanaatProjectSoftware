package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class apartment {
	private int apartmentID;	
	private String availableServices;
	private String type;
	private int housingID;
	private int rent;
	private int floorNum;
	private boolean isAvailabe;
	private int peopleCapacity;
	private int numberOfBathrooms;
	private int numberOfRoom;
	private int numberOfBalconies;
	
	private int currentNumberOfRoommates;
	private ArrayList<String> pictures=new ArrayList<String>();
    static Logger logger = LogManager.getLogger(apartment.class);

	public apartment() {
		super();
		this.isAvailabe=true;//default value is that the apartment is available
		this.numberOfBathrooms=2;
		this.numberOfRoom=4;
		
	}
	
	///apartment a=new apartment();
	public apartment(int apartmentID, String availableServices, String type, int housingID, int rent, int floorNum,
			boolean isAvailabe) {
		super();
		this.apartmentID = apartmentID;
		this.availableServices = availableServices;
		this.type = type;
		this.housingID = housingID;
		this.rent = rent;
		this.floorNum = floorNum;
		this.isAvailabe = isAvailabe;
	}
	
	public apartment(int apartmentID, String availableServices, String type, int housingID, int rent, int floorNum,
			boolean isAvailabe, int peopleCapacity, int currentNumberOfRoommates) {
		super();
		this.apartmentID = apartmentID;
		this.availableServices = availableServices;
		this.type = type;
		this.housingID = housingID;
		this.rent = rent;
		this.floorNum = floorNum;
		this.isAvailabe = isAvailabe;
		this.peopleCapacity = peopleCapacity;
		this.currentNumberOfRoommates = currentNumberOfRoommates;
	}

	public int getApartmentID() {
		return apartmentID;
	}
	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}
	public String getAvailableServices() {
		return availableServices;
	}
	public void setAvailableServices(String availableServices) {
		this.availableServices = availableServices;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHousingID() {
		return housingID;
	}
	public void setHousingID(int housingID) {
		this.housingID = housingID;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}
	public boolean isAvailabe() {
		return isAvailabe;
	}
	public void setAvailabe(boolean isAvailabe) {
		this.isAvailabe = isAvailabe;
	}
	public int getPeopleCapacity() {
		return peopleCapacity;
	}

	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}

	public int getCurrentNumberOfRoommates() {
		return currentNumberOfRoommates;
	}

	public void setCurrentNumberOfRoommates(int currentNumberOfRoommates) {
		this.currentNumberOfRoommates = currentNumberOfRoommates;
	}
	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public int getNumberOfRoom() {
		return numberOfRoom;
	}

	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	public int getNumberOfBalconies() {
		return numberOfBalconies;
	}

	public void setNumberOfBalconies(int numberOfBalconies) {
		this.numberOfBalconies = numberOfBalconies;
	}
	
	public boolean isFamilyHousing() {
		if(this.getType().equalsIgnoreCase("family")) 
			return true;
	   else 
		  return false;
	}
	public boolean isStudentHousing() {
		if(this.getType().equalsIgnoreCase("students")) 
			return true;
	   else 
		  return false;
	}
	public boolean thereIsSpace() {
		if(this.getPeopleCapacity()== this.getCurrentNumberOfRoommates()) 
			return false;
	   else 
		  return true;
	}
	
public static int getApartmentIndex(int apartmentID,int housingID ,ArrayList <apartment> apartments) {
	//apartment apartmentNull= new apartment();
		
		for (int i = 0; i < apartments.size(); i++) {

			if ((apartments.get(i).getApartmentID()==apartmentID) && (apartments.get(i).getHousingID()==housingID)) 

				return i;	
		}
		return -1;

	}
@Override
public String toString() {
	return "apartment [apartmentID=" + apartmentID + ", availableServices=" + availableServices + ", type=" + type
			+ ", housingID=" + housingID + ", rent=" + rent + ", floorNum=" + floorNum + ", isAvailabe="
			+ isAvailabe +", peopleCapacity="+peopleCapacity +", numberOfBathrooms="+numberOfBathrooms
			+", numberOfRoom="+numberOfRoom+", numberOfBalconies="+numberOfBalconies+ "]";
}
public static int getHouseID(apartment apart) {
	int hid = apart.getHousingID();
	return hid;
}


public static void printApartmentsOnFloor(List<apartment> apartments,int floorNum, int housingiD) {
	logger.info( "\n apartments on floor "+floorNum+" : \n");
	logger.info( "\n");
	for(int i=0; i<apartments.size();i++) {
		if(apartments.get(i).getFloorNum()==floorNum && apartments.get(i).getHousingID()==housingiD) {
			//System.out.println(apartments.get(i).toString());
			logger.info(apartments.get(i).toString());
			logger.info( "\n");
			
		}
	}
}

public static void printApartmentInfo(apartment apartmentObj,List<reservations> reservationObj,List<User>users ) {
	int tenantID=-1;
    int tenantIDArray [];
	String tenantInfo="info about the tenant and the apartment: \n ";
	for(int i=0; i< reservationObj.size();i++) {
		if( (reservationObj.get(i).getApartmentID()==apartmentObj.getApartmentID()) && (reservationObj.get(i).getHousingID()== apartmentObj.getHousingID() ) ) {
			tenantID=reservationObj.get(i).getTenantID();
			System.out.println("tenantID:"+tenantID);
			for(int j=0; j< users.size();j++) {
				if(users.get(j).getId()==tenantID) {
					tenantInfo+= "\n name: "+users.get(j).getName();
					tenantInfo+= "\n phone number: ";
					tenantInfo+=users.get(j).getPhoneNumber();
				}
			}//for
		}
	}
	
	logger.info( tenantInfo+ "\n there are " + apartmentObj.numberOfBathrooms +" bathrooms and " + apartmentObj.numberOfRoom +" rooms and " +apartmentObj.numberOfBalconies +" Balcony");
	logger.info( "\n");

}
public static int getIndexByApartmentID(int apartmentId,int housigID, List<apartment> apartments) {
	int index = -1;

	for (int i = 0; i < apartments.size(); i++) {

		if ((apartments.get(i).getApartmentID()==apartmentId) && (apartments.get(i).getHousingID() == housigID)) {
			return i;
		}
	}

	return index;
}
public  boolean doesExist(int id, List<apartment> apartments,int housingID) {
	for (int i = 0; i < apartments.size(); i++) {

		if (apartments.get(i).getApartmentID()==id && apartments.get(i).getHousingID() == housingID) {

			return true;
		}
		
	}

	return false;
}
public void setFamilyHousing() {
	this.setType("family") ;
	
}
public void setStudentHousing() {
	this.setType("students"); 
	
}
}
