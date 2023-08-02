package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;
import java.util.logging.Level;
//import java.util.logging.Logger;
//@SpringBootApplication

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
	private static ArrayList <reservations> reservationsArray= new ArrayList<reservations>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<apartment> apartmentsArray = new ArrayList<apartment>();
	private static ArrayList<housing> housingsArray = new ArrayList<housing>();
	private static ArrayList<String> furnitureArray=new ArrayList<String>();
	private static ArrayList<String> pictures=new ArrayList<String>();



public static void prepareInfo() {
		String ss="picture for test";
		pictures.add(ss);
		pictures.add(ss);

		housing house1= new housing(1,"jafarHindi","Nablus-Rafedia",3,3);
		apartment apartment1= new apartment(1,"air-conditioning","family",1,550,1,false,7,5);//first foor
		apartment apartment2= new apartment(2,"air-conditioning","family",1,600,1,true,5,0);//first foor
		apartment1.setPictures(pictures);
		apartment2.setNumberOfBalconies(2);
		apartment2.setNumberOfBathrooms(2);
		apartment2.setNumberOfRoom(3);
		apartment2.setPictures(pictures);

		User ownerr=new User("masaMasri","12345","owner",9,"0594050064");
		User owner1=new User("jafarHindi","12345","owner",1,"0555898745");
		User tenant1=new User("Raya","12345","tenant",2,"0564879532");
		reservations reservation1=new reservations(tenant1.getId(),apartment1.getApartmentID(),house1.getHousingID());
		
		housing house2= new housing(2,"masaMasri","Nablus-beitWazan",3,3);
		apartment apartment3= new apartment(1,"air-conditioning","students",2,400,1,false,3,3);
		apartment apartment4= new apartment(2,"air-conditioning","students",2,450,1,true,3,2);
		
		apartment3.setPictures(pictures);
		apartment4.setPictures(pictures);

		User tenant2=new User("Masa","12345","tenant",3,"0599344589");
		reservations reservation2=new reservations(tenant2.getId(),apartment3.getApartmentID(),house2.getHousingID());

		User tenant3=new User("Hiba","12345","tenant",4,"0599344589");
		reservations reservation3=new reservations(tenant3.getId(),apartment3.getApartmentID(),house2.getHousingID());
		User admin=new User("Haya","12345","Admin",1);
		//user tenant2=new user("Tamara","12346","Owner",3);
		users.add(admin);
        users.add(owner1);
        users.add(tenant1);
        users.add(tenant2);
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
public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	String name;
	String password;
	int logged = 0;
	int x;
	int id;
	String s;
	String Student;
	String type="";
	boolean success=false;
	User obj=new User();
	apartment apart=new apartment();
	housing house=new housing();
	reservations newReservation;
	Furniture fur;
	String furType;
	int price;
	String usageTime;
	TenantProfile tenant=new TenantProfile();
	housing tenantProfile=new housing();
	User sentObj=new User();
	Main.prepareInfo();
	//Logger logger = Logger.getLogger(Main.class.getSimpleName());
    Logger logger = LogManager.getLogger(Main.class);
    ArrayList<housing> housingsWaitingForApproval = new ArrayList<housing>();
    ArrayList<apartment> apartmentsWaitingForApproval = new ArrayList<apartment>();
	/*for(Handler iHandler:logger.getParent().getHandlers())
    {
    logger.getParent().removeHandler(iHandler);
    }*/
	//logger.log(Level.INFO, "\n");
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
		if (success==false) {
			logged = 0;
			logger.info(
					"|!!!!!!!!!!!!!!!!!!!!!!!!!!!!Login faild!!!!!!!!!!!!!!!!!!!!!!!!!!!!|");
////break;
		} else {
			logged = 1;
			type=MainFunc.getTypeFromName(name, users);
			obj.setType(type);
			logger.info(type);
					/////////////////////////////////////////////////////////////////////////
			logger.info("|______________________________________________________________________________________________________________________________|");
			//logger.info("|                   Welcome Back ");	
			//logger.info(name);
			logger.info("Welcome Back "+ name);
		}
		if(logged==1&&obj.getType().equalsIgnoreCase("tenant")) {
			while(logged==1) {
				tenant.setTenantName(name);
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
					/*logger.info( "Enter the apartment id you want to view ");
					s=input.nextLine();
					x=input.nextInt();
					logger.info( "Enter the house id the apartment is in ");
					s=input.nextLine();
					id=input.nextInt();
					apart=MainFunc.viewApartment(x, id,apartmentsArray);
					logger.info("|Apartment:"+apart.toString()+"        |");*/
					//logger.info();		
					MainFunc.printDetails(apartmentsArray, housingsArray);
				}
				else if(x==3) {				
					id=users.get(User.getIndex(name, users)).getId();					
					logger.info( "Are you a student? (yer or no) ");
					s=input.nextLine();
					s=input.nextLine();

					Student=s;
					logger.info( "Enter on what building the apartment you want to book (id) ");
					//s=input.nextLine();
					x=input.nextInt();
					house.setHousingID(x);
					logger.info( "Enter on what apartment you want to book (id)");
					s=input.nextLine();
					x=input.nextInt();
					apart.setApartmentID(x);
			    	x=apartment.getApartmentIndex(apart.getApartmentID(),house.getHousingID(),apartmentsArray);
			    	if(x<0) {
						logger.info( "It appears that the house you requested is not in our system,make sure you have the right id and try again");

			    	}else {
						if((apartmentsArray.get(x).isStudentHousing())&&Student.equalsIgnoreCase("yes")) {
							if(apartmentsArray.get(x).thereIsSpace()&&apartmentsArray.get(x).isAvailabe()) {
								tenant.setType("Student");
								tenantProfile.setOwnerName(housingsArray.get(house.getIndex(house.getHousingID(), housingsArray)).getOwnerName());
								//logger.info("namamamammm"+tenantProfile.getOwnerName());
								sentObj.setName(tenantProfile.getOwnerName());
								sentObj.setPhoneNumber(users.get(User.getIndex(tenantProfile.getOwnerName(), users)).getPhoneNumber());
								tenant.setOwner(sentObj);
								tenant.setRent(apartmentsArray.get(x).getRent());
								//tenant.setOwner(tenantProfile.getOwnerName());
								
						    	newReservation =new reservations(id,apart.getApartmentID());
						    	reservationsArray.add(newReservation);
						    	int d=apart.getCurrentNumberOfRoommates()+1;
						    	apart.setCurrentNumberOfRoommates(d);
						    	if(apartmentsArray.get(x).getCurrentNumberOfRoommates()==apartmentsArray.get(x).getPeopleCapacity())apartmentsArray.get(x).setAvailabe(false);
						    	logger.info( "Booked succefully");
							}else logger.info( "Sorry, this student housing is full");					
						}
						else if((apartmentsArray.get(x).isStudentHousing())&&Student.equalsIgnoreCase("no")) {
							logger.info( "Sorry, you can't book a student housing unless you are a student");
						}
						else if(apartmentsArray.get(x).isFamilyHousing()&&Student.equalsIgnoreCase("no")) {
							if(apartmentsArray.get(x).isAvailabe()) {
								tenant.setType("Family");
								tenantProfile.setOwnerName(housingsArray.get(house.getIndex(house.getHousingID(), housingsArray)).getOwnerName());
								sentObj.setName(tenantProfile.getOwnerName());
								sentObj.setPhoneNumber(users.get(User.getIndex(sentObj.getName(), users)).getPhoneNumber());
								tenant.setOwner(sentObj);
								tenant.setRent(apartmentsArray.get(x).getRent());

						    	newReservation =new reservations(id,apart.getApartmentID());
						    	reservationsArray.add(newReservation);
						    	apartmentsArray.get(x).setAvailabe(false);
						    	//apart.setAvailabe(false);
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
					logger.info(fur.toString());					
				}
				else if(x==5) {
					MainFunc.printControlPanel(tenant);
					
				}
				else if(x==0) {
					logged=0;
					break;
				}
			}
		}
		else if(logged==1&&obj.getType().equalsIgnoreCase("owner")) {
			while(logged==1) {
			logger.info( "   press 1. To add new residence \n     "
		            + "       2. To view control panel \n     "
		            + "       3. To add communication way \n     "
		            + "       0. log out   ");
logger.info( "\n");
//logger.log(Level.INFO, "      0. log out ");
x = input.nextInt();
input.nextLine();

if (x == 1) { //add new housing

	ArrayList <String> pics= new ArrayList<String>();
	housing newHousing=new housing();
	logger.info( " Enter Information of the new housing :\n ID:");
	logger.info( "\n");
	int housingID = input.nextInt();
	input.nextLine();
	

	while(newHousing.doesExist(housingID, housingsArray)) {
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
	
	System.out.println(newHousing.toString());
	//housingsArray.add(newHousing);
	for(int i=0;i<housingsArray.size();i++) {
		System.out.println("arr"+i+"= "+housingsArray.get(i).toString());
	}
	/*
	logger.info( " housing added successfuly");
	logger.info( "\n");
	*/
	housingsWaitingForApproval.add(newHousing);
	

	apartment newApartment=new apartment();
	logger.info( " Enter Information of the an apartment in this housing :\n ID:");
	logger.info( "\n");
	x = input.nextInt();
	input.nextLine();
	while(newApartment.doesExist(x, apartmentsArray,housingID)) {
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
	///newApartment.setAvailabe(true);
	
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
	//apartmentsArray.add(newApartment);
	/*
	logger.info( " apartment added successfuly ");
	logger.info( "\n");
	*/
	apartmentsWaitingForApproval.add(newApartment);
	}

 else if (x == 2) { //show owner control panel
	 ArrayList <housing> returnedArray= new  ArrayList <housing>();
	    logger.info( " here are your housings:");
	    //MainFunc.printHousingsToSpecificOwner(housingsArray,loggedinUser.getName());
	    returnedArray=MainFunc.returnHousingsToSpecificOwner(housingsArray, name);
		MainFunc.printHousingArray(returnedArray);
	    logger.info( "Enter id of one of your housings to view its apartments:");
		logger.info( "\n");
		//while()
		
		int chosenHousingID=input.nextInt();
		input.nextLine();
       while( !(MainFunc.checkEnteredHousingID(returnedArray, chosenHousingID)) ) {
    	   logger.info( "wrong input. Enter ID of one of your housings shown above :");
		   logger.info( "\n");
		   chosenHousingID=input.nextInt();
		   input.nextLine();
       }
		
		housing.printTenantsCount(apartmentsArray,housingsArray,name);
		housing.printNumberOfFloors(housingsArray, chosenHousingID);
		
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
		
		int chosenHousingIndex= housing.getIndexByHousingID(chosenHousingID, housingsArray);

		apartment.printApartmentsOnFloor(apartmentsArray,floorNum,chosenHousingID);
		
		logger.info( "Enter apartment id :");
		logger.info( "\n");
		x=input.nextInt();
		input.nextLine();
		while(!(apartment.doesExist(x, apartmentsArray, chosenHousingID))) {
			logger.info( "wrong input. Enter apartment id that exists :");
		    logger.info( "\n"); 
		    x=input.nextInt();
			input.nextLine();
			//chosenApartmentIndex=apartment.getIndexByApartmentID(x,chosenHousingID, apartmentsArray);
		    } 
		    int chosenApartmentIndex=apartment.getIndexByApartmentID(x,chosenHousingID, apartmentsArray);
		    apartment.printApartmentInfo(apartmentsArray.get(chosenApartmentIndex), reservationsArray,users);
		
	
	
}//x==2
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
			  }//while
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
	 
 }//x==3
	else if(x==0) {
		logged=0;
		break;
	}
			}
		}
		else if(logged==1&&obj.getType().equalsIgnoreCase("Admin")){
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
				  int index= housing.getIndexByHousingID(x, housingsWaitingForApproval);
				  housingsArray.add(housingsWaitingForApproval.get(index));
				  apartmentsArray.add(apartmentsWaitingForApproval.get(index));
				  logger.info( "housing "+x+" added successfuly with its apartment");
				  logger.info( "\n");
		         }
		         else {
		        	 logger.info( "housing doesn't exists");
					 logger.info( "\n");
		         }
			 }//whie
        	 }//if
         }
         else if(x==2) { /////////////////////modifyyyy////////////////////////////////
        	 logger.info( "Modify Housing : Enter ID of the housing : ");
			 logger.info( "\n");
			int housingID = input.nextInt();
	         input.nextLine();
	        while(! housing.doesExist(housingID, housingsArray)) {
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
	        
	        if(x==1) { // owner name
	        	 logger.info( "Modify Housing " +housingID+ " : Enter the new owner name : ");
				 logger.info( "\n");
				 s=input.nextLine();
				 MainFunc.modifyOwnerName(housingsArray, housingID, s);
			}
	        else if (x==2) {// location
	        	 logger.info( "Modify Housing " +housingID+ " : Enter the new location : ");
				 logger.info( "\n");
				 s=input.nextLine();
				 MainFunc.modifyLocation(housingsArray, housingID, s);
			}
	        else if (x==3) {// numbersOfFloors
	        	 logger.info( "Modify Housing " +housingID+ " : Enter the new numbersOfFloors : ");
				 logger.info( "\n");
				 x=input.nextInt();
				 input.nextLine();
				 MainFunc.modifyNumOfFloors(housingsArray, housingID, x);
	        }
	        else if (x==4) {//modify apartment
	        	 logger.info( "Modify apartment : Enter ID of an apartment in housing" +housingID+ " : ");
				 logger.info( "\n");
				 int apartmentID = input.nextInt();
		         input.nextLine();
					while( !(apartment.doesExist(apartmentID, apartmentsArray, housingID)) ) {
						logger.info( "wrong input. Enter apartment id that exists :");
					    logger.info( "\n"); 
					    apartmentID=input.nextInt();
						input.nextLine();
					    } 
				int chosenApartmentIndex=apartment.getIndexByApartmentID(apartmentID,housingID, apartmentsArray);	  
	        	logger.info( "   press 1. to modify apartment's availableServices \n     "
			            + "         2.  modify apartment's rent \n     "
			            + "         3.  modify apartment's peopleCapacity \n     "
			            + "         4.  modify apartment's extraInfo  \n     "
			            + "         5.  modify apartment's type  \n     "
			            );
			     logger.info( "\n");
			      x = input.nextInt();
		          input.nextLine();
		          if(x==1) { // availableServices
			        	 logger.info( "Modify apartment  " +apartmentID+ " : Enter the new availableServices : ");
						 logger.info( "\n");
						 s=input.nextLine();
						 MainFunc.modifyAvailableServices(apartmentsArray, chosenApartmentIndex, s);
					}
			        else if (x==2) {// rent
			        	 logger.info( "Modify apartment  " +apartmentID+ " : Enter the new rent : ");
						 logger.info( "\n");
						 x=input.nextInt();
						 input.nextLine();
						 MainFunc.modifyRent(apartmentsArray, chosenApartmentIndex, x);
					}
			        else if (x==3) {// peopleCapacity
			        	 logger.info( "Modify apartment  " +apartmentID+ " : Enter the new peopleCapacity : ");
						 logger.info( "\n");
						 x=input.nextInt();
						 input.nextLine();
						 MainFunc.modifyPeopleCapacity(apartmentsArray, chosenApartmentIndex, x);
					}
			        else if (x==4) {// extraInfo
			        	 logger.info( "Modify apartment  " +apartmentID+ " : Enter extraInfo : ");
						 logger.info( "\n");
						 s=input.nextLine();
						 MainFunc.modifyExtraInfo(apartmentsArray, chosenApartmentIndex, s);
					}
			        else if (x==5) {// type
			        	 logger.info( "Modify apartment  " +apartmentID+ " : Enter new type(s / f) : ");
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
			 
         }//modify
         else if(x==3) {// reservationss
        	 MainFunc.printReservations(reservationsArray);
         }
			else if(x==0) {
				logged=0;
				break;
			}
			
		}

	
	
}
	}
	
}}
