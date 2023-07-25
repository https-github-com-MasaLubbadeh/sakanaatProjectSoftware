package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;

public class apartment {


	private int apartmentID;	
	private String availableServices;
	private String type;
	private int housingID;
	private int rent;
	private int floorNum;
	private boolean isAvailabe;
	private int peopleCapacity;	
	private int currentNumberOfRoommates;
	
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
	
	public apartment() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "apartment [apartmentID=" + apartmentID + ", availableServices=" + availableServices + ", type=" + type
				+ ", housingID=" + housingID + ", rent=" + rent + ", floorNum=" + floorNum + ", isAvailabe="
				+ isAvailabe + "]";
	}
	public static int getHouseID(apartment apart) {
		int hid = apart.getHousingID();
		return hid;
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
	
public static int getApartmentID(int apartmentID,int housingID ,ArrayList <apartment> apartments) {
	//apartment apartmentNull= new apartment();
		
		for (int i = 0; i < apartments.size(); i++) {

			if ((apartments.get(i).getApartmentID()==apartmentID) && (apartments.get(i).getHousingID()==housingID)) 

				return i;	
		}
		return -1;

	
}

public  int getIndex(int id,ArrayList <apartment> apartments) {
	int index=-1;
	for(int i=0;i<apartments.size();i++) {
		if(apartments.get(i).getApartmentID()==id) {
			return i;
		}
			
	}
	return index;
}
	

}