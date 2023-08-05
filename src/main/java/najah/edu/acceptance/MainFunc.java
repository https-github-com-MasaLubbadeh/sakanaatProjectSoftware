package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFunc {

	private MainFunc() {
		super();
	}
	static Logger logger = LogManager.getLogger(MainFunc.class);
	static final  String ST="updated successfuly";
	
	
	public static boolean loginSuccess(String name,String password ,List<User> users) {
		boolean success=false;
		if(User.getIndex(name, users)>=0) {
			success=(users.get(User.getIndex(name, users)).getPass().equals(password));
			return success;
		}else return false;
		
	}
	public static String getTypeFromName(String name,List<User> users) {
		String type="";
		type=users.get(User.getIndex(name, users)).getType();
		return type;
	}
	public static void tenantView(List <Apartment>apartmentsArray , List <Housing>housingsArray) {
		for(int i = 0; i < apartmentsArray.size(); i++) { 
			if(apartmentsArray.get(i).isAvailabe()&&apartmentsArray.get(i)!=null) {
				String message=apartmentsArray.get(i).toString();
				logger.info(message);
				logger.info( "in");

				for(int j=0;j<housingsArray.size();j++) {
					 message=housingsArray.get(j).toString();
					if(housingsArray.get(j).getHousingID()>0&&housingsArray.get(j).getHousingID() == apartmentsArray.get(i).getHousingID())
						logger.info(message);

				}
				logger.info("\n");

			}

		} 
	}
	public static Apartment viewApartment(int id,int id2,List <Apartment>apartmentsArray){
		int indexactual;
		indexactual=Apartment.getIndexByApartmentID(id,id2,apartmentsArray);
		return apartmentsArray.get(indexactual);
		
	}

	public static void printControlPanel(TenantProfile obj) {
		logger.info("|______________________________________________________________________________________________________________________________|");
		String tenantName = obj.getTenantName();
		String phoneNumber=obj.getPhoneNumber();
		String status=obj.getType();
		String ownerName=obj.getOwner().getName();
		String ophoneNumber=obj.getOwner().getPhoneNumber();
		int rent=obj.getRent();
		String message="";
		if (tenantName != null &&phoneNumber!=null&&status!=null&&ownerName!=null&&ophoneNumber!=null&&rent!=-1) {
			
		    message = String.format("Hello %s. Welcome Back", tenantName);
		    logger.info(message);
		    
		    message = String.format("Name: %s                   PhoneNumber: %s",tenantName,obj.getPhoneNumber());
			logger.info(message);

			logger.info("");
			
			message=String.format("Status: %s", status);
			logger.info(message);
			
			logger.info("|______________________________________________________________________________________________________________________________|");
						
			logger.info("                  Owner information            ");
			
			message=String.format("Owner Name: %s                   PhoneNumber: %s",ownerName,ophoneNumber);
			logger.info(message);
			
			message=String.format("Rent: %d",rent );
			logger.info(message);
			
		    
		}

	
	}
	public static void printDetails(List <Apartment>apartmentsArray , List <Housing>housingsArray) {
		for(int i = 0; i < housingsArray.size(); i++) {
			int houseID=housingsArray.get(i).getHousingID();
			String location=housingsArray.get(i).getLocation();
			String message="";
				if(houseID!=-1&&location!=null) {
					message=String.format("Housing with id %d  is on this location %s  and have these apartments:",houseID,location);
					logger.info(message);
					for(int j=0;j<apartmentsArray.size();j++) {
						int apartID=apartmentsArray.get(j).getHousingID();
						int price=apartmentsArray.get(j).getRent();
						String service=apartmentsArray.get(j).getAvailableServices();
						if(apartID!=-1 &&houseID == apartID&&price>0&&service!=null) {
							
								
								message=(String.format("Apartment with this id %d  have these information", apartID));
								logger.info(message);
								
								logger.info("pictures:");
								printArrayList(apartmentsArray.get(j).getPictures());
								
								message=String.format("Price %d",price );
								logger.info(message);
								
								message=String.format("Available Services: %s ", service);
								logger.info(message);
									
								logger.info("\n");

							}
						
						
					}
				}
			


		} 
		
	}
	public static void printArrayList(List <String>pictures) {
		for(String element:pictures) {
			logger.info(element);
		}
	}

	
	
	public static List <Housing> returnHousingsToSpecificOwner(List <Housing> housingsArray,String ownerName) {
		List <Housing> ownerHousings =new ArrayList <Housing>(); 
		for(int i=0; i<housingsArray.size();i++) {
			if(housingsArray.get(i).getOwnerName().equalsIgnoreCase(ownerName)) {
				ownerHousings.add(housingsArray.get(i));
			}
		}
		return ownerHousings;
	}
	public static void printHousingArray(List <Housing> housingsArray) {
		for(int i=0; i<housingsArray.size();i++) {
			if(housingsArray.get(i)!=null) {
				String message=housingsArray.get(i).toString();
				logger.info(message );
				logger.info( "\n");
			}
				
			}
	}
	
	public static boolean checkEnteredHousingID(List <Housing> housingsArray,int id ) {
		boolean exists=false;
		for(int i=0; i<housingsArray.size();i++) {
			if(housingsArray.get(i).getHousingID()==id) {
				exists=true;
			}
		}
		return exists;
	}
	
	public static boolean checkEnteredFloorIfExists(List <Housing> housingsArray,int housingID, int floor ) {
		int index=Housing.getIndexByHousingID(housingID, housingsArray);
		return housingsArray.get(index).getNumbersOfFloors()> floor ;

	}
	

	
	
	
	
	
	
	
	
	
	public static void modifyOwnerName(List <Housing> housingsArray, int housingID,String ownerName) {
		int index=Housing.getIndexByHousingID(housingID, housingsArray);
		housingsArray.get(index).setOwnerName(ownerName);
		logger.info(ST);
		logger.info( "\n");
	}
	public static void modifyLocation(List <Housing> housingsArray, int housingID,String location) {
		int index=Housing.getIndexByHousingID(housingID, housingsArray);
		housingsArray.get(index).setLocation(location);
		logger.info( ST);
		logger.info( "\n");
	}
	public static void modifyNumOfFloors(List <Housing> housingsArray, int housingID,int fNum) {
		int index=Housing.getIndexByHousingID(housingID, housingsArray);
		housingsArray.get(index).setNumbersOfFloors(fNum);
		logger.info(ST);
		logger.info( "\n");
	}
	public static void printReservations(List <Reservations> reservationsArray) {
		String message="";
		for(int i=0; i<reservationsArray.size();i++) {
			message=reservationsArray.get(i).toString();

			if(reservationsArray.get(i)!=null) {
				logger.info(message);
				logger.info("\n");
			}
			
		}
	}


	
	
	
	public static void printWaitingList(List <Housing> housingsArray,List <Apartment> apartmentsArray) {
		String message="";
		 for(int i=0;i<housingsArray.size();i++) {
			 if(housingsArray.get(i)!=null&&apartmentsArray.get(i)!=null) {
				 logger.info( "here are the housings(with apartment) in the waithing List : ");
				 message= housingsArray.get(i).toString();
				 logger.info(message);
				 logger.info( "\n");
				 
				 logger.info("with this apartment : ");
				 message=apartmentsArray.get(i).toString();
				 logger.info(message);

				 logger.info( "\n");
				 
			 }
			
		 }
		 if(housingsArray.isEmpty()) {
			 logger.info("there are no housings in the Waiting List ");
			 logger.info( "\n");
		 }
	}
	public static void modifyAvailableServices(List <Apartment> apartmentsArray, int apartmentIndex,String services) {
		 apartmentsArray.get(apartmentIndex).setAvailableServices(services);
		logger.info( ST);
		logger.info( "\n");
	}
	public static void modifyRent(List <Apartment> apartmentsArray, int apartmentIndex,int rent) {
		 apartmentsArray.get(apartmentIndex).setRent(rent);
		logger.info(ST);
		logger.info( "\n");
	}
	public static void modifyPeopleCapacity(List <Apartment> apartmentsArray, int apartmentIndex,int number) {
		 apartmentsArray.get(apartmentIndex).setPeopleCapacity(number);
		logger.info( ST);
		logger.info( "\n");
	}
	public static void modifyExtraInfo(List <Apartment> apartmentsArray, int apartmentIndex,String info) {
		 apartmentsArray.get(apartmentIndex).setExtraInfo(info);
		logger.info(ST);
		logger.info( "\n");
	}
	public static void modifyApartmentType(List <Apartment> apartmentsArray, int apartmentIndex,String type) {
		 if(type.equalsIgnoreCase("s")) apartmentsArray.get(apartmentIndex).setStudentHousing();
		 else if (type.equalsIgnoreCase("f")) apartmentsArray.get(apartmentIndex).setFamilyHousing();
		logger.info( ST);
		logger.info( "\n");
	}
	
	
}
