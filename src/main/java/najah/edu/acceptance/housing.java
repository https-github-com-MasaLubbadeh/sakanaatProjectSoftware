package najah.edu.acceptance;

import java.util.List;

public class housing {
	private int housingID;
	private String ownerName;
	private String location;
	private int numbersOfFloors;
	private int numbersOfApartmentInEachFloor;
	///private apartment t;

	public housing(int housingID, String ownerName, String location, int numbersOfFloors,int numbersOfApartmentInEachFloor) {
		super();
		//// t =new housing();

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
	public  boolean doesExist(int id, List<housing> housing) {
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
	

}