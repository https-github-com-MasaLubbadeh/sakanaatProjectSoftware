package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Apartment {


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
	private String extraInfo;
	private int currentNumberOfRoommates;
	private List<String> pictures=new ArrayList<String>();
    static Logger logger = LogManager.getLogger(Apartment.class);
   

	public Apartment() {
		super();
		this.isAvailabe=true;/*default value is that the apartment is available*/
		this.numberOfBathrooms=2;
		this.numberOfRoom=4;
		
	}
	
	public Apartment(int apartmentID, String availableServices, String type, int housingID, int rent, int floorNum,
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
	
	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
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
		return (this.getType().equalsIgnoreCase("family"));
	}
	public boolean isStudentHousing() {
		return (this.getType().equalsIgnoreCase("students"));
	}
	public boolean thereIsSpace() {
		return (this.getPeopleCapacity()!= this.getCurrentNumberOfRoommates());
	}
	
public static int getApartmentIndex(int apartmentID,int housingID ,List <Apartment> apartments) {
		
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
public static int getHouseID(Apartment apart) {
	return apart.getHousingID();
	
}

public static void printApartmentsOnFloor(List<Apartment> apartments,int floorNum, int housingiD) {
	String format=String.format("%n apartments on floor %d : \n", floorNum);
	logger.info(format);
	logger.info( "\n");
	for(int i=0; i<apartments.size();i++) {
		if(apartments.get(i) != null&&apartments.get(i).getFloorNum()==floorNum && apartments.get(i).getHousingID()==housingiD) {
			
			format=apartments.get(i).toString();
			logger.info(format);
			logger.info( "\n");
			
			
		}
	}
}

public static void printApartmentInfo(Apartment apartmentObj,List<Reservations> reservationObj,List<User>users ) {
	int tenantID=-1;
	String format1;
	StringBuilder tenantInfo = new StringBuilder("info about the tenant and the apartment: \n");
	for(int i=0; i< reservationObj.size();i++) {
		if( (reservationObj.get(i).getApartmentID()==apartmentObj.getApartmentID()) && (reservationObj.get(i).getHousingID()== apartmentObj.getHousingID() ) ) {
			tenantID=reservationObj.get(i).getTenantID();
			for(int j=0; j< users.size();j++) {
				if(users.get(j).getId()==tenantID) {
					tenantInfo.append("\n name: ");
					tenantInfo.append(users.get(j).getName());
					tenantInfo.append("\n phone number: ");
					tenantInfo.append(users.get(j).getPhoneNumber());
				}
			}
		}
	}
	
	String tenantInfoString=tenantInfo.toString();
	format1=String.format( "%s %n there are %d bathrooms and %d rooms and %d Balcony", tenantInfoString,
		apartmentObj.numberOfBathrooms 
		,apartmentObj.numberOfRoom, apartmentObj.numberOfBalconies);
	logger.info(format1);
	logger.info( "\n");

}
public static int getIndexByApartmentID(int apartmentId,int housigID, List<Apartment> apartments) {
	int index = -1;

	for (int i = 0; i < apartments.size(); i++) {

		if ((apartments.get(i).getApartmentID()==apartmentId) && (apartments.get(i).getHousingID() == housigID)) {
			return i;
		}
	}

	return index;
}
public static  boolean doesExist(int id, List<Apartment> apartments,int housingID) {
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
