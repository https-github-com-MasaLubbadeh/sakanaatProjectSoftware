package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
///import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFunc {

	
	 ///static Logger logger = Logger.getLogger(Main.class.getSimpleName());
	static Logger logger = LogManager.getLogger(MainFunc.class);

	
	
	public static boolean loginSuccess(String Name,String Password ,ArrayList<User> users) {
		boolean success=false;
		if(User.getIndex(Name, users)>=0) {
			success=(users.get(User.getIndex(Name, users)).getPass().toString().equals(Password));
			return success;
		}else return success=false;
		
	}
	public static String getTypeFromName(String Name,ArrayList<User> users) {
		String type="";
		type=users.get(User.getIndex(Name, users)).getType();
		return type;
	}
	public static void tenantView(ArrayList <Apartment>apartmentsArray , ArrayList <housing>housingsArray) {
		for(int i = 0; i < apartmentsArray.size(); i++) { 
			if(apartmentsArray.get(i).isAvailabe()==true) {
				logger.info(apartmentsArray.get(i).toString());
				//System.out.print(apartmentsArray.get(i));
				//System.out.println("\n");
				logger.info( "in");

				for(int j=0;j<housingsArray.size();j++) {
					if(housingsArray.get(j).getHousingID() == apartmentsArray.get(i).getHousingID()) {
						//System.out.println(housingsArray.get(j));
						logger.info(housingsArray.get(j).toString());

					}
				}
				logger.info("\n");

				//System.out.println("\n");
			}
		///	else System.out.println("no available housees");

		} 
	}
	public static Apartment viewApartment(int id,int id2,ArrayList <Apartment>apartmentsArray){
		int indexactual;
		Apartment a=new Apartment();
		indexactual=a.getIndexByApartmentID(id,id2,apartmentsArray);
		return apartmentsArray.get(indexactual);
		
	}

	public static void printControlPanel(TenantProfile obj) {
		logger.info("|______________________________________________________________________________________________________________________________|");
		logger.info("Hello"+ obj.getTenantName() +".Welcome Back");
		logger.info("Name: "+obj.getTenantName()+"                "+"Phone Number: "+obj.getPhoneNumber());
		logger.info("Status: "+obj.getType());
		logger.info("|______________________________________________________________________________________________________________________________|");
		logger.info("                  Owner information            ");
		logger.info("Owner Name: "+obj.getOwner().getName()+"  Phone Number: "+obj.getOwner().getPhoneNumber());
		logger.info("Rent: "+obj.getRent());
		
	}
	public static void printDetails(ArrayList <Apartment>apartmentsArray , ArrayList <housing>housingsArray) {
		for(int i = 0; i < housingsArray.size(); i++) { 
	
				logger.info("Housing with id "+housingsArray.get(i).getHousingID()+" is on this location "+housingsArray.get(i).getLocation()+" and have these apartments:");
			//	logger.info( "\n");
				for(int j=0;j<apartmentsArray.size();j++) {
					if(housingsArray.get(i).getHousingID() == apartmentsArray.get(j).getHousingID()) {
						logger.info("Apartment with this id "+apartmentsArray.get(j).getApartmentID()+" have these information");
						logger.info("pictures:");
						printArrayList(apartmentsArray.get(j).getPictures());
						logger.info("Price: "+apartmentsArray.get(j).getRent());
						logger.info("Available Services:: "+apartmentsArray.get(j).getAvailableServices());
						logger.info("\n");

					}
				}


		} 
		
	}
	public static void printArrayList(List<String> list) {
		for(String element:list) {
			logger.info(element);
		}
	}
	////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList <housing> returnHousingsToSpecificOwner(ArrayList <housing> housingsArray,String ownerName) {
		ArrayList <housing> ownerHousings =new ArrayList <housing>(); 
		for(int i=0; i<housingsArray.size();i++) {
			if(housingsArray.get(i).getOwnerName().equalsIgnoreCase(ownerName)) {
				ownerHousings.add(housingsArray.get(i));
			}
		}
		return ownerHousings;
	}
	public static void printHousingArray(ArrayList <housing> housingsArray) {
		for(int i=0; i<housingsArray.size();i++) {
				logger.info( housingsArray.get(i).toString());
				logger.info( "\n");
			}
	}
	
	public static boolean checkEnteredHousingID(ArrayList <housing> housingsArray,int id ) {
		boolean exists=false;
		for(int i=0; i<housingsArray.size();i++) {
			if(housingsArray.get(i).getHousingID()==id) {
				exists=true;
			}
		}
		return exists;
	}
	
	public static boolean checkEnteredFloorIfExists(ArrayList <housing> housingsArray,int housingID, int floor ) {
		int index=housing.getIndexByHousingID(housingID, housingsArray);
		if(housingsArray.get(index).getNumbersOfFloors()< floor) {
				return false;
			}
		return true;
	}
	
	//////////////////administrator///////////
	/* 
	 * modify housing methods
	 * */
	public static void modifyOwnerName(ArrayList <housing> housingsArray, int housingID,String ownerName) {
		int index=housing.getIndexByHousingID(housingID, housingsArray);
		housingsArray.get(index).setOwnerName(ownerName);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void modifyLocation(ArrayList <housing> housingsArray, int housingID,String location) {
		int index=housing.getIndexByHousingID(housingID, housingsArray);
		housingsArray.get(index).setLocation(location);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void modifyNumOfFloors(ArrayList <housing> housingsArray, int housingID,int fNum) {
		int index=housing.getIndexByHousingID(housingID, housingsArray);
		housingsArray.get(index).setNumbersOfFloors(fNum);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void printReservations(ArrayList <Reservations> reservationsArray) {
		for(int i=0; i<reservationsArray.size();i++) {
			logger.info(reservationsArray.get(i).toString());
			logger.info("\n");
		}
	}
	
	/* 
	 * modify apartment methods
	 * */
	public static void printWaitingList(ArrayList <housing> housingsArray,ArrayList <Apartment> apartmentsArray) {
		 for(int i=0;i<housingsArray.size();i++) {
			 logger.info( "here are the housings(with apartment) in the waithing List : ");
			 logger.info( housingsArray.get(i).toString());
			 logger.info( "\n");
			 logger.info("with this apartment :"+ apartmentsArray.get(i).toString());
			 logger.info( "\n");
			
		 }
		 if(housingsArray.isEmpty()) {
			 logger.info("there are no housings in the Waiting List ");
			 logger.info( "\n");
		 }
	}
	public static void modifyAvailableServices(ArrayList <Apartment> apartmentsArray, int apartmentIndex,String services) {
		 apartmentsArray.get(apartmentIndex).setAvailableServices(services);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void modifyRent(ArrayList <Apartment> apartmentsArray, int apartmentIndex,int rent) {
		 apartmentsArray.get(apartmentIndex).setRent(rent);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void modifyPeopleCapacity(ArrayList <Apartment> apartmentsArray, int apartmentIndex,int number) {
		 apartmentsArray.get(apartmentIndex).setPeopleCapacity(number);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void modifyExtraInfo(ArrayList <Apartment> apartmentsArray, int apartmentIndex,String info) {
		 apartmentsArray.get(apartmentIndex).setExtraInfo(info);
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	public static void modifyApartmentType(ArrayList <Apartment> apartmentsArray, int apartmentIndex,String type) {
		 if(type.equalsIgnoreCase("s")) apartmentsArray.get(apartmentIndex).setStudentHousing();
		 else if (type.equalsIgnoreCase("f")) apartmentsArray.get(apartmentIndex).setFamilyHousing();
		logger.info( "updated successfuly");
		logger.info( "\n");
	}
	
	
}
