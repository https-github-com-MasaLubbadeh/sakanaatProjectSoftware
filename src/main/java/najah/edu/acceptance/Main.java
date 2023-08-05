package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
	private static ArrayList <Reservations> reservationsArray= new ArrayList<Reservations>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Apartment> apartmentsArray = new ArrayList<Apartment>();
	private static ArrayList<Housing> housingsArray = new ArrayList<Housing>();
	private static ArrayList<String> furnitureArray=new ArrayList<String>();
	private static ArrayList<String> pictures=new ArrayList<String>();
    static Logger logger = LogManager.getLogger(Main.class);
	 static Scanner input = new Scanner(System.in);
	 static int x;
	 static String s;
	 static String format;
	 



public static void prepareInfo() {
	final String airCondition = "air-conditioning";
	final String pass = "12345";
	final String owner = "owner";
	final String tenant = "tenant";

		String ss="picture for test";
		pictures.add(ss);
		pictures.add(ss);

		Housing house1= new Housing(1,"jafarHindi","Nablus-Rafedia",3,3);
		Apartment apartment1= new Apartment(1,airCondition,"family",1,550,1,false);//first foor
		Apartment apartment2= new Apartment(2,airCondition,"family",1,600,1,true);//first foor
		apartment1.setPeopleCapacity(7);
		apartment1.setCurrentNumberOfRoommates(5);
		apartment1.setPictures(pictures);
		apartment2.setNumberOfBalconies(2);
		apartment2.setNumberOfBathrooms(2);
		apartment2.setNumberOfRoom(3);
		apartment2.setPictures(pictures);
		apartment2.setPeopleCapacity(5);
		apartment2.setCurrentNumberOfRoommates(0);

		User ownerr=new User("masaMasri",pass,owner,9,"0594050064");
		User owner1=new User("jafarHindi",pass,owner,1,"0555898745");
		User tenant1=new User("Raya",pass,tenant,2,"0564879532");
		Reservations reservation1=new Reservations(tenant1.getId(),apartment1.getApartmentID(),house1.getHousingID());
		
		Housing house2= new Housing(2,"masaMasri","Nablus-beitWazan",3,3);
		Apartment apartment3= new Apartment(1,airCondition,"students",2,400,1,false);
		Apartment apartment4= new Apartment(2,airCondition,"students",2,450,1,true);
		
		apartment3.setPictures(pictures);
		apartment3.setPeopleCapacity(3);
		apartment3.setCurrentNumberOfRoommates(3);
		
		apartment4.setPictures(pictures);
		apartment4.setPeopleCapacity(3);
		apartment4.setCurrentNumberOfRoommates(2);
		
		User tenant2=new User("Masa",pass,tenant,3,"0599344589");
		Reservations reservation2=new Reservations(tenant2.getId(),apartment3.getApartmentID(),house2.getHousingID());

		User tenant3=new User("Hiba",pass,tenant,4,"0599344589");
		Reservations reservation3=new Reservations(tenant3.getId(),apartment3.getApartmentID(),house2.getHousingID());
		
		User admin=new User("Haya",pass,"Admin",1);
		
		users.add(admin);
        users.add(owner1);
        users.add(tenant1);
        users.add(tenant2);
        users.add(tenant3);
        users.add(ownerr);
        reservationsArray.add(reservation1);
        reservationsArray.add(reservation2);
        reservationsArray.add(reservation3);

        
        apartmentsArray.add(apartment1);
        apartmentsArray.add(apartment2);
        apartmentsArray.add(apartment3);
        apartmentsArray.add(apartment4);
        
        housingsArray.add(house1);
        housingsArray.add(house2);
        
	}


public static void tenantHandle(String name,User obj) {
	TenantProfile tenant=new TenantProfile();
	tenant.setTenantName(name);
	Reservations newReservation;
	Furniture fur;
	String furType;
	int price;
	String usageTime;
	Housing tenantProfile=new Housing();
	User sentObj=new User();
	int id;
	String student;
	Apartment apart=new Apartment();
	Housing house=new Housing();
	int logged=1;
	while(logged==1) {
		tenant.setPhoneNumber(users.get(User.getIndex(name, users)).getPhoneNumber());
		logger.info( "press 1. To view available housing ");
		logger.info( "      2. To view pictures of housing and know their prices, location, and services available in them ");
		logger.info( "      3. To book housing ");
		logger.info( "      4. To sell furniture  ");
		logger.info( "      5. To view control panel  ");
		logger.info( "      0. log out ");
		x = input.nextInt();
		if(x==1) {
			MainFunc.tenantView(apartmentsArray, housingsArray);
		}
		else if(x==2) {	
			MainFunc.printDetails(apartmentsArray, housingsArray);
		}
		else if(x==3) {				
			id=users.get(User.getIndex(name, users)).getId();					
			logger.info( "Are you a student? (yer or no) ");
			s=input.nextLine();
			s=input.nextLine();

			student=s;
			logger.info( "Enter on what building the apartment you want to book (id) ");
			x=input.nextInt();
			house.setHousingID(x);
			logger.info( "Enter on what apartment you want to book (id)");
			s=input.nextLine();
			x=input.nextInt();
			apart.setApartmentID(x);
	    	x=Apartment.getApartmentIndex(apart.getApartmentID(),house.getHousingID(),apartmentsArray);
	    	if(x<0) {
				logger.info( "It appears that the house you requested is not in our system,make sure you have the right id and try again");

	    	}else {
				if((apartmentsArray.get(x).isStudentHousing())&&student.equalsIgnoreCase("yes")) {
					if(apartmentsArray.get(x).thereIsSpace()&&apartmentsArray.get(x).isAvailabe()) {
						tenant.setType("Student");
						tenantProfile.setOwnerName(housingsArray.get(Housing.getIndex(house.getHousingID(), housingsArray)).getOwnerName());
						sentObj.setName(tenantProfile.getOwnerName());
						sentObj.setPhoneNumber(users.get(User.getIndex(tenantProfile.getOwnerName(), users)).getPhoneNumber());
						tenant.setOwner(sentObj);
						tenant.setRent(apartmentsArray.get(x).getRent());
						
				    	newReservation =new Reservations(id,apart.getApartmentID());
				    	reservationsArray.add(newReservation);
				    	int d=apart.getCurrentNumberOfRoommates()+1;
				    	apart.setCurrentNumberOfRoommates(d);
				    	if(apartmentsArray.get(x).getCurrentNumberOfRoommates()==apartmentsArray.get(x).getPeopleCapacity())apartmentsArray.get(x).setAvailabe(false);
				    	logger.info( "Booked succefully");
					}else logger.info( "Sorry, this student housing is full");					
				}
				else if((apartmentsArray.get(x).isStudentHousing())&&student.equalsIgnoreCase("no")) {
					logger.info( "Sorry, you can't book a student housing unless you are a student");
				}
				else if(apartmentsArray.get(x).isFamilyHousing()&&student.equalsIgnoreCase("no")) {
					if(apartmentsArray.get(x).isAvailabe()) {
						tenant.setType("Family");
						tenantProfile.setOwnerName(housingsArray.get(Housing.getIndex(house.getHousingID(), housingsArray)).getOwnerName());
						sentObj.setName(tenantProfile.getOwnerName());
						sentObj.setPhoneNumber(users.get(User.getIndex(sentObj.getName(), users)).getPhoneNumber());
						tenant.setOwner(sentObj);
						tenant.setRent(apartmentsArray.get(x).getRent());

				    	newReservation =new Reservations(id,apart.getApartmentID());
				    	reservationsArray.add(newReservation);
				    	apartmentsArray.get(x).setAvailabe(false);
				    	logger.info( "Booked succefully");
					}


				}else logger.info( "Sorry, house is already booked");
	    	}



		}
		else if(x==4) {
			s=input.nextLine();
			logger.info("What type is your furniture?");
			furType=input.nextLine();
			logger.info("Enter the price for sale");
			price=input.nextInt();
			s=input.nextLine();
			logger.info("How long have you had your furniture?");
			usageTime=input.nextLine();
			fur =new Furniture(furType,name,users.get(User.getIndex(name, users)).getPhoneNumber(),price,usageTime);
			furnitureArray.add(fur.toString());
			logger.info("This is how your Advertisement looks like");
			
			if(fur != null) {
				format=fur.toString();
				logger.info(format);
			}
			
		}
		else if(x==5) {
			MainFunc.printControlPanel(tenant);
			
		}
		else if(x==0) {
			logged=0;
			obj.setLogged(0);
			break;
		}
		
	}
	

}

public static void adminHandle( List<Housing> housingsWaitingForApproval,List<Apartment> apartmentsWaitingForApproval,User obj) {
	final String modifyString1="Modify Housing";
	final String modifyString2="Modify Apartment";
	int logged=1;

	while(logged==1) {
	logger.info( "   press 1. to approve added housings \n     "
            + "       2.  modify the housing data \n     "
            + "       3.  watch reservations \n     "
            + "       0.  log out  \n     "
            );

 logger.info( "\n");
 x = input.nextInt();
 input.nextLine();
 if(x==1) {
	 MainFunc.printWaitingList(housingsWaitingForApproval, apartmentsWaitingForApproval);
	 if(!housingsWaitingForApproval.isEmpty()) {
	 while(true) {
		 logger.info( "Enter ID of housings which you approve and they'll be added :");
		 logger.info( "\n");
		 logger.info( "Enter 0 when you are finished :");
		 logger.info( "\n");
		 x = input.nextInt();
         input.nextLine();
         if(x==0) break;
         
         else if(  MainFunc.checkEnteredHousingID(housingsWaitingForApproval, x)) {
		  int index= Housing.getIndexByHousingID(x, housingsWaitingForApproval);
		  housingsArray.add(housingsWaitingForApproval.get(index));
		  apartmentsArray.add(apartmentsWaitingForApproval.get(index));
		  format=String.format("housing %d added successfuly with its apartment", x);
		  logger.info(format);

		  logger.info( "\n");
         }
         else {
        	 logger.info( "housing doesn't exists");
			 logger.info( "\n");
         }
	 }
	 }    
 } 
 else if(x==2) { 
	 logger.info( "Modify Housing : Enter ID of the housing : ");
	 logger.info( "\n");
	int housingID = input.nextInt();
     input.nextLine();
    while(! Housing.doesExist(housingID, housingsArray)) {
    	 logger.info( "wrong input.No such housing exist \n Enter ID of existing housing :  ");
		 logger.info( "\n");
		 housingID = input.nextInt();
         input.nextLine();
    }
    logger.info( "   press 1. to modify housing owner name \n     "
            + "         2.  modify housing location \n     "
            + "         3.  modify housing numbersOfFloors \n     "
            + "         4.  modify an apartmentin this housing \n     "
            );
    logger.info( "\n");
    x = input.nextInt();
    input.nextLine();

    if(x==1) {
    	format=String.format("%s %d : Enter the new owner name : ",modifyString1,housingID) ;
    	 logger.info(format);
		 logger.info( "\n");
		 s=input.nextLine();
		 MainFunc.modifyOwnerName(housingsArray, housingID, s);
	}
    else if (x==2) {
    	format=String.format("%s %d : Enter the new location : ",modifyString1,housingID);
    	 logger.info( format );
		 logger.info( "\n");
		 s=input.nextLine();
		 MainFunc.modifyLocation(housingsArray, housingID, s);
	}
    else if (x==3) {
    	format=String.format("%s %d : Enter the new numbersOfFloors : ",modifyString1,housingID);
    	 logger.info( format);
		 logger.info( "\n");
		 x=input.nextInt();
		 input.nextLine();
		 MainFunc.modifyNumOfFloors(housingsArray, housingID, x);
    }
    else if (x==4) {
    	format=String.format("%s %d : Enter ID of an apartment in housing : ",modifyString1,housingID);

    	 logger.info(format);
		 logger.info( "\n");
		 int apartmentID = input.nextInt();
         input.nextLine();
			while( !(Apartment.doesExist(apartmentID, apartmentsArray, housingID)) ) {
				logger.info( "wrong input. Enter apartment id that exists :");
			    logger.info( "\n"); 
			    apartmentID=input.nextInt();
				input.nextLine();
			    } 
		int chosenApartmentIndex=Apartment.getIndexByApartmentID(apartmentID,housingID, apartmentsArray);	  
    	logger.info( "   press 1. to modify apartment's availableServices \n     "
	            + "         2.  modify apartment's rent \n     "
	            + "         3.  modify apartment's peopleCapacity \n     "
	            + "         4.  modify apartment's extraInfo  \n     "
	            + "         5.  modify apartment's type  \n     "
	            );
	     logger.info( "\n");
	      x = input.nextInt();
          input.nextLine();
          if(x==1) { 
        	    format=String.format("%s %d : Enter the new availableServices : ",modifyString2,apartmentID);
	        	 logger.info( format );
	        	 logger.info( "\n");
				 s=input.nextLine();
				 MainFunc.modifyAvailableServices(apartmentsArray, chosenApartmentIndex, s);
			}
	        else if (x==2) {
	        	format=String.format("%s %d : Enter the new rent : ",modifyString2,apartmentID);
	        	 logger.info( format );
				 logger.info( "\n");
				 x=input.nextInt();
				 input.nextLine();
				 MainFunc.modifyRent(apartmentsArray, chosenApartmentIndex, x);
			}
	        else if (x==3) {
	        	format=String.format("%s %d : Enter the new peopleCapacity : ",modifyString2,apartmentID) ;
	        	 logger.info(format);
				 logger.info( "\n");
				 x=input.nextInt();
				 input.nextLine();
				 MainFunc.modifyPeopleCapacity(apartmentsArray, chosenApartmentIndex, x);
			}
	        else if (x==4) {
	        	format=String.format("%s %d : Enter extraInfo : ",modifyString2,apartmentID) ;
	        	 logger.info(format );
				 logger.info( "\n");
				 s=input.nextLine();
				 MainFunc.modifyExtraInfo(apartmentsArray, chosenApartmentIndex, s);
			}
	        else if (x==5) {
	        	format=String.format("%s %d : Enter new type(s / f) : ",modifyString2,apartmentID);
	        	 logger.info(format);
				 logger.info( "\n");
				 s=input.nextLine();
				 while(!(s.equalsIgnoreCase("f")) && !(s.equalsIgnoreCase("s")) ) {
		        	 logger.info( "wrong input. Enter (s / f) :  ");
					 logger.info( "\n");
			         s=input.nextLine();
		        }
				 MainFunc.modifyApartmentType(apartmentsArray, chosenApartmentIndex, s);
			}
        
        
    	
    }
	 
 }
 else if(x==3) {
	 MainFunc.printReservations(reservationsArray);
 }
	else if(x==0) {
		logged=0;
		obj.setLogged(0);
		break;
	}
	
}




	
}

public static void ownerHandle(List<Housing> housingsWaitingForApproval ,List<Apartment> apartmentsWaitingForApproval,User obj,String name) {
	int logged=1;
while(logged==1) {
	logger.info( "   press 1. To add new residence \n     "
            + "       2. To view control panel \n     "
            + "       3. To add communication way \n     "
            + "       0. log out   ");
logger.info( "\n");
x = input.nextInt();
input.nextLine();

if (x == 1) { /*add new housing*/

ArrayList <String> pics= new ArrayList<String>();
Housing newHousing=new Housing();
logger.info( " Enter Information of the new housing :\n ID:");
logger.info( "\n");
int housingID = input.nextInt();
input.nextLine();


while(Housing.doesExist(housingID, housingsArray)) {
logger.info( " this ID already exists Enter another one :\n ID:");
logger.info( "\n");
housingID = input.nextInt();
input.nextLine();

}
newHousing.setHousingID(housingID);


logger.info( " Enter housing Information : numbersOfFloors:");
logger.info( "\n");
x = input.nextInt();
input.nextLine();

newHousing.setNumbersOfFloors(x);

logger.info( " Enter housing Information : numbersOfApartmentInEachFloor:");
logger.info( "\n");
x = input.nextInt();
input.nextLine();

newHousing.setNumbersOfApartmentInEachFloor(x);
newHousing.setOwnerName(name);

logger.info( " Enter housing Information : location:");
logger.info( "\n");
s = input.nextLine();	

newHousing.setLocation(s);
logger.info("the new housing is: ");
if(newHousing != null) {
format=newHousing.toString();
logger.info(format);
}


logger.info("\n housings in thy system: ");
for(int i=0;i<housingsArray.size();i++) {
format=String.format("arr %d = %s",i, housingsArray.get(i).toString() );
if(format != null) {
logger.info(format);
}
}
housingsWaitingForApproval.add(newHousing);


Apartment newApartment=new Apartment();
logger.info( " Enter Information of the an apartment in this housing :\n ID:");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
while(Apartment.doesExist(x, apartmentsArray,housingID)) {
logger.info( " this ID already exists enter another one :\n ID:");
logger.info( "\n");
x = input.nextInt();
input.nextLine();

}
newApartment.setApartmentID(x);
logger.info( " Enter apartment Information : available servieces:");
logger.info( "\n");
s = input.nextLine();
newApartment.setAvailableServices(s);

logger.info( " Enter apartment Information : apartment TYPE (Enter s or f):");
logger.info( "\n");
s = input.nextLine();
while(!(s.equalsIgnoreCase("s")) && !(s.equalsIgnoreCase("f")) ) {
logger.info( "wrong input. Enter f or s : ");
s = input.nextLine();
}
if(s.equalsIgnoreCase("s")) newApartment.setStudentHousing();
else newApartment.setFamilyHousing();


logger.info( " Enter apartment Information :  monthly rent:");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
newApartment.setRent(x);

logger.info( " Enter apartment Information : floor number :");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
while(x>newHousing.getNumbersOfFloors()) {
logger.info( "wrong input. there's no such floor in this housing : ");
x = input.nextInt();
input.nextLine();
}
newApartment.setFloorNum(x);

logger.info( " Enter apartment Information : people capacity :");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
newApartment.setPeopleCapacity(x);

logger.info( " Enter apartment Information : number of rooms  :");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
newApartment.setNumberOfRoom(x);

logger.info( " Enter apartment Information : number of bathrooms :");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
newApartment.setNumberOfBathrooms(x);

logger.info( " Enter apartment Information : number of balconies :");
logger.info( "\n");
x = input.nextInt();
input.nextLine();
newApartment.setNumberOfBalconies(x);

logger.info( " Enter any extra Information :");
logger.info( "\n");
s=input.nextLine();
newApartment.setExtraInfo(s);

logger.info( " Enter apartment Information : add pictures of this apartment :");
logger.info( "\n");
logger.info( " Enter number of pictures you want to add :");
logger.info( "\n");
x=input.nextInt();
input.nextLine();
for(int i=0; i<x; i++) {
logger.info( " Enter the link :");
s=input.nextLine();
pics.add(s);
logger.info( "\n");

}
newApartment.setPictures(pics);
newApartment.setHousingID(housingID);
newApartment.setAvailabe(true);
newApartment.setCurrentNumberOfRoommates(0);
apartmentsWaitingForApproval.add(newApartment);
}

else if (x == 2) { 
List <Housing> returnedArray= new  ArrayList <Housing>();
logger.info( " here are your housings:");
returnedArray=MainFunc.returnHousingsToSpecificOwner(housingsArray, name);
MainFunc.printHousingArray(returnedArray);
logger.info( "Enter id of one of your housings to view its apartments:");
logger.info( "\n");

int chosenHousingID=input.nextInt();
input.nextLine();
while( !(MainFunc.checkEnteredHousingID(returnedArray, chosenHousingID)) ) {
   logger.info( "wrong input. Enter ID of one of your housings shown above :");
   logger.info( "\n");
   chosenHousingID=input.nextInt();
   input.nextLine();
}

Housing.printTenantsCount(apartmentsArray,housingsArray,name);
Housing.printNumberOfFloors(housingsArray, chosenHousingID);

logger.info( "Enter floor number :");
logger.info( "\n");

int floorNum=input.nextInt();
input.nextLine();

while( !(MainFunc.checkEnteredFloorIfExists(returnedArray, chosenHousingID,floorNum)) ) {
	   logger.info( "wrong input. Enter floor that exists :");
	   logger.info( "\n");
	   floorNum=input.nextInt();
	   input.nextLine();
   }

Apartment.printApartmentsOnFloor(apartmentsArray,floorNum,chosenHousingID);

logger.info( "Enter apartment id :");
logger.info( "\n");
x=input.nextInt();
input.nextLine();
while(!(Apartment.doesExist(x, apartmentsArray, chosenHousingID))) {
	logger.info( "wrong input. Enter apartment id that exists :");
    logger.info( "\n"); 
    x=input.nextInt();
	input.nextLine();
    } 
    int chosenApartmentIndex=Apartment.getIndexByApartmentID(x,chosenHousingID, apartmentsArray);
    Apartment.printApartmentInfo(apartmentsArray.get(chosenApartmentIndex), reservationsArray,users);



}
else if (x == 3) {
if( obj.getPhoneNumber() ==null ){
logger.info( " Enter contact Information : your phone number :");
logger.info( "\n"); 
s=input.nextLine();
obj.setPhoneNumber(s); }
else {
  logger.info( " you already entered a phone number, do you want to modify it? y/n");
  logger.info( "\n"); 
  s=input.nextLine();
  while (!(s.equalsIgnoreCase("y")) && !(s.equalsIgnoreCase("n")) ) {
	   logger.info( " wring input. enter y/n :");
	   logger.info( "\n"); 
	   s=input.nextLine();
	  }
  if(s.equalsIgnoreCase("y")) {
	   logger.info( " Enter contact Information : your phone number :");
	   logger.info( "\n"); 
	   s=input.nextLine();
	   obj.setPhoneNumber(s);
	   logger.info( " phone number modified successfuly ");
	   logger.info( "\n");
	  
	  }
  else if(s.equalsIgnoreCase("n")){
	  logger.info( "okay.");
	  logger.info( "\n");
  }
  
  
}

}
else if(x==0) {
logged=0;
obj.setLogged(0);
break;
}
}	
}
public static void main(String[] args) {
	String name;
	String type="";

	String password;
	int logged = 0;

	boolean success=false;
	User obj=new User();
	

	Main.prepareInfo();
    List<Housing> housingsWaitingForApproval = new ArrayList<Housing>();
    List<Apartment> apartmentsWaitingForApproval = new ArrayList<Apartment>();
    logger.info("\n");

    logger.info("|                   Welcome to  Sakankom                   |");

	logger.info( "\n");

	while (logged == 0) {
		logger.info( "");
		logger.info( "|                   Enter you username                   |");
		logger.info("|_______________________________________________________________________________________________________________________________|");
		name = input.nextLine();
		logger.info( "|                   Enter you password                   |");
		password = input.nextLine();
		success=MainFunc.loginSuccess(name, password, users);
		if (!success) {
			obj.setLogged(0);
			logged = 0;
			logger.info(
					"|!!!!!!!!!!!!!!!!!!!!!!!!!!!!Login faild!!!!!!!!!!!!!!!!!!!!!!!!!!!!|");
		} else {
			logged = 1;
			obj.setLogged(1);

			type=MainFunc.getTypeFromName(name, users);
			obj.setType(type);
			logger.info(type);

			logger.info("|______________________________________________________________________________________________________________________________|");
			String string=String.format("Welcome Back %s", name);
			logger.info(string);
		}
		while(logged==1) {
			if(logged==1&&obj.getType().equalsIgnoreCase("tenant")) {
				tenantHandle(name,obj);

			}
			else if(logged==1&&obj.getType().equalsIgnoreCase("owner")) {
				ownerHandle(housingsWaitingForApproval,apartmentsWaitingForApproval,obj,name);

			}
			else if(logged==1&&obj.getType().equalsIgnoreCase("Admin")){
				adminHandle(housingsWaitingForApproval,apartmentsWaitingForApproval,obj);
			}
			logged=obj.getLogged();

		}

	}
	
}}
