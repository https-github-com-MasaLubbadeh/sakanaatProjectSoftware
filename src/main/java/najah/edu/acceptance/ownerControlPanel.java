package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.Scanner;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ownerControlPanel {
	private static ArrayList <reservations> reservationsArray= new ArrayList<reservations>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<apartment> apartmentsArray = new ArrayList<apartment>();
	private static ArrayList<housing> housingsArray = new ArrayList<housing>();

    int ownerIndex=-1;
    int ownerID=-1;
    int chosenHousingIndex=-1;    
    int chosenApartmentIndex=-1;
    int chosenFloor;
    int chosenHousingID;
    String chosenOwnerName;
    
	@BeforeAll
	public static void prepareInfo() {
		
		housing house1= new housing(1,"jafarHindi","Nablus-Rafedia",3,3);
		apartment apartment1= new apartment(1,"air-conditioning","family",1,550,1,false,7,5);//first foor
		apartment apartment2= new apartment(2,"air-conditioning","family",1,600,1,true,5,0);//first foor

		apartment2.setNumberOfBalconies(2);
		apartment2.setNumberOfBathrooms(2);
		apartment2.setNumberOfRoom(3);
		
		User owner1=new User("jafarHindi","12345","owner",1,"0555898745");
		User tenant1=new User("Raya","12345","tenant",2,"0564879532");
		reservations reservation1=new reservations(tenant1.getId(),apartment1.getApartmentID());
		
		housing house2= new housing(2,"masaMasri","Nablus-beitWazan",3,3);
		apartment apartment3= new apartment(1,"air-conditioning","students",2,400,1,false,3,3);
		apartment apartment4= new apartment(2,"air-conditioning","students",2,450,1,true,3,0);

			
		User tenant2=new User("masa","12345","tenant",3,"0599344589");
		reservations reservation2=new reservations(tenant2.getId(),apartment3.getApartmentID());

		//user admin=new user("Masa","IamAdmin","Admin",1);
		//user tenant2=new user("Tamara","12346","Owner",3);
		
        users.add(owner1);
        users.add(tenant1);
        users.add(tenant2);
        reservationsArray.add(reservation1);
        reservationsArray.add(reservation2);
        
        apartmentsArray.add(apartment1);
        apartmentsArray.add(apartment2);
        apartmentsArray.add(apartment3);
        apartmentsArray.add(apartment4);
        
        housingsArray.add(house1);
        housingsArray.add(house2);
        

	}

	
	@Given("the owner with id {int} has housings")
	public void theOwnerWithIdHasManyHousings(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		ownerIndex=User.getIndexByUserID(int1, users);
	}
	@When("the owner with id {int} enters one of his housing id {int}")
	public void theOwnerWithIdEntersOneOfHisHousingId(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 //System.out.println("enter the id of the wanted housing: ");
		 //input = new Scanner(System.in);
		chosenHousingID=int2;
		chosenHousingIndex= housing.getIndexByHousingID(chosenHousingID, housingsArray);
	    chosenOwnerName=housingsArray.get(chosenHousingIndex).getOwnerName();
		
	}
	
	@Then("number of floors and tenants in this housing will be given")
	public void numberOfFloorsAndTenantsInThisHousingWillBeGiven() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	//
		if(chosenHousingIndex==-1) System.out.println("housing not found");
		housing.printNumberOfFloors(housingsArray, chosenHousingID);
		housing.printTenantsCount(apartmentsArray,housingsArray,chosenOwnerName);
		
		
	}
	
	@When("the owner with id {int} enters floor number {int}")
	public void theOwnerWithIdEntersFloorNumber(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		chosenFloor=int2;
	}
	
	 @Then("the apartments in this floor will be given")
	public void theApartmentsInThisFloorWillBeGiven() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 apartment.printApartmentsOnFloor(apartmentsArray,chosenFloor,chosenHousingID);
	}
	
	@When("the owner with id {int} enters apartment id {int}")
	public void theOwnerWithIdEntersApartmentId(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		int chosenApartmentID=int2;
		chosenApartmentIndex=apartment.getIndexByApartmentID(chosenApartmentID, apartmentsArray);
	}
	
	@Then("name of the tenant ,communication way,number of bathrooms,number of bedrooms,of this apartment will be given,and if it has a balcony")
	public void nameOfTheTenantCommunicationWayNumberOfBathroomsNumberOfBedroomsOfThisApartmentWillBeGivenAndIfItHasABalcony() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		if(chosenApartmentIndex==-1) System.out.println("apartment not found");
		else apartment.printApartmentInfo(apartmentsArray.get(chosenHousingIndex), reservationsArray,users);
		
	}



	///////////////////////////

	
	
	



	////////////////////////////

}
