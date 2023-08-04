package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bookHousing {
	Apartment apartmentObj;
	Reservations newReservation;
	int wantedHousingID;
	boolean actual=false;
	boolean actual1=false;
	boolean expected=false;
	boolean expected1=false;
	int apartmentIndex;

	
	private static ArrayList <Reservations> reservationsArray= new ArrayList<Reservations>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Apartment> apartmantsArray = new ArrayList<Apartment>();

    
    @Before
	public static void prepareInfo() {
		
    	final String airCondition = "air-conditioning";
		Housing house1= new Housing(1,"jafarHindi","Nablus-Rafedia",3,3);
		Apartment apartment1= new Apartment(1,airCondition,"family",1,550,1,false);//first foor
		Apartment apartment2= new Apartment(2,airCondition,"family",1,600,1,true);//first foor
		apartment1.setPeopleCapacity(7);
		apartment1.setCurrentNumberOfRoommates(5);
		apartment2.setNumberOfBalconies(2);
		apartment2.setNumberOfBathrooms(2);
		apartment2.setNumberOfRoom(3);
		apartment2.setPeopleCapacity(5);
		apartment2.setCurrentNumberOfRoommates(0);

		User ownerr=new User("masaMasri","12345","owner",9,"0594050064");
		User owner1=new User("jafarHindi","12345","owner",1,"0555898745");
		User tenant1=new User("Raya","12345","tenant",2,"0564879532");
		Reservations reservation1=new Reservations(tenant1.getId(),apartment1.getApartmentID(),house1.getHousingID());
		
		Housing house2= new Housing(2,"masaMasri","Nablus-beitWazan",3,3);
		Apartment apartment3= new Apartment(1,airCondition,"students",2,400,1,false);
		Apartment apartment4= new Apartment(2,airCondition,"students",2,450,1,true);
		
		apartment3.setPeopleCapacity(3);
		apartment3.setCurrentNumberOfRoommates(3);
		
		apartment4.setPeopleCapacity(3);
		apartment4.setCurrentNumberOfRoommates(2);
		
		User tenant2=new User("Masa","12345","tenant",3,"0599344589");
		Reservations reservation2=new Reservations(tenant2.getId(),apartment3.getApartmentID(),house2.getHousingID());

		User tenant3=new User("Hiba","12345","tenant",4,"0599344589");
		Reservations reservation3=new Reservations(tenant3.getId(),apartment3.getApartmentID(),house2.getHousingID());
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

        
        apartmantsArray.add(apartment1);
        apartmantsArray.add(apartment2);
        apartmantsArray.add(apartment3);
        apartmantsArray.add(apartment4);
       
        

	}


@Given("the tenant with id {int} wants to book a family apartment in housing id {int}, floor {int}, apartment id {int} ,capacity {int}")
public void theTenantWithIdWantsToBookAFamilyApartmentInHousingIdFloorApartmentIdCapacity(Integer tenantID, Integer housingID, Integer floor, Integer apartmentID, Integer int5) {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	apartmentIndex=Apartment.getApartmentIndex(apartmentID,housingID,apartmantsArray); //static
    }

    @When("it's family housing")
    public void itSFamilyHousing() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	actual=apartmantsArray.get(apartmentIndex).isFamilyHousing();
    }
    @When("housing id {int}, floor {int} ,apartment id {int} is available")
    public void housingIdFloorApartmentIdIsAvailable(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    	actual1=apartmantsArray.get(apartmentIndex).isAvailabe();
    }
  
    @Then("housing id {int}, floor {int} ,apartment id {int} booked succesfully by tenant with id {int}")
    public void housingIdFloorApartmentIdBookedSuccesfullyByTenantWithId(Integer int1, Integer int2, Integer apartmentID, Integer tenantID) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	newReservation =new Reservations(tenantID,apartmentID);
    	expected= true;//available
    	assertEquals(expected,actual);
    	reservationsArray.add(newReservation);
    	apartmantsArray.get(apartmentIndex).setAvailabe(false);
    	assertEquals(expected,actual1);  	
   }

/// 
   
    @Given("the tenant with id {int} wants to book a student apartment in housing id {int}, floor {int}, apartment id {int}, capacity {int}")
    public void theTenantWithIdWantsToBookAStudentApartmentInHousingIdFloorApartmentIdCapacity(Integer tenantID, Integer housingID, Integer floor, Integer apartmentID ,Integer int5) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	
    	apartmentIndex=Apartment.getApartmentIndex(apartmentID,housingID,apartmantsArray); //static
    	//System.out.println(apartmantsArray.size());

    	//for(int i=0;i<apartmantsArray.size();i++) {
    	//	System.out.println(apartmantsArray.get(i).toString()+"\n");
    	//}
   

    }

    @When("it's student housing")
    public void itSStudentHousing() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	actual=apartmantsArray.get(apartmentIndex).isStudentHousing();

    }
    @When("there's a room in housing id {int}, floor {int},apartment id {int}")
    public void thereSARoomInHousingIdFloorApartmentId(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    	actual1= (apartmantsArray.get(apartmentIndex).thereIsSpace()&&apartmantsArray.get(apartmentIndex).isAvailabe());
    	
    }
  
    @Then("housing id {int}, floor {int}, apartment id {int} is booked succesfully by tenant with id {int}")
    public void housingIdFloorApartmentIdIsBookedSuccesfullyByTenantWithId(Integer int1, Integer int2, Integer apartmentID, Integer tenantID) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	newReservation =new Reservations(tenantID,apartmentID);
    	expected= true;//available
    	assertEquals(expected,actual);
    	assertEquals(expected,actual1);
    	reservationsArray.add(newReservation);
    	/*
    	if(apartmantsArray.get(apartmentIndex).getCurrentNumberOfRoommates()== apartmantsArray.get(apartmentIndex).getPeopleCapacity()) {
    		apartmantsArray.get(apartmentIndex).setAvailabe(false);
    	}*/
    }





////////////////////////////////////////////////////////
  
  
    @Given("the tenant with id {int} wants to book an apartment in housing id {int}, floor {int},apartment id {int}, capacity {int}")
    public void theTenantWithIdWantsToBookAnApartmentInHousingIdFloorApartmentIdCapacity(Integer tenantID, Integer housingID, Integer floor, Integer apartmentID ,Integer int5) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    	apartmentIndex=Apartment.getApartmentIndex(apartmentID,housingID,apartmantsArray);
		//System.out.println(apartmantsArray.size());

    	/*for(int i=0;i<apartmantsArray.size();i++) {
    		System.out.println(apartmantsArray.get(i).toString()+"\n");
    	} */
    }


    @When("the housing is family housing")
    public void theHousingIsFamilyHousing() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	//apartmentObj.setType("family");
    	actual=apartmantsArray.get(apartmentIndex).isFamilyHousing();

    }
    @When("housing id {int}, floor {int}, apartment id {int} is not available")
    public void housingIdFloorApartmentIdIsNotAvailable(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	actual1=apartmantsArray.get(apartmentIndex).isAvailabe();
    	
    }
    @Then("failed to book housing id {int}, floor {int}, apartment id {int}")
    public void failedToBookHousingIdFloorApartmentId(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	expected=true;
    	expected1=false;
    	assertEquals(expected,actual);
    	assertEquals(expected1,actual1);
    }


////
   
    @Given("the tenant with id {int} requests to book an apartment in housing id {int}, floor {int},apartment id {int}, capacity {int}")
    public void theTenantWithIdRequestsToBookAnApartmentInHousingIdFloorApartmentIdCapacity(Integer tenantID, Integer housingID, Integer floor, Integer apartmentID ,Integer int5) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	apartmentIndex=Apartment.getApartmentIndex(apartmentID,housingID,apartmantsArray);
    }
	@When("the housing is student housing")
    	public void theHousingIsStudentHousing() {
    	    // Write code here that turns the phrase above into concrete actions
    	    //throw new io.cucumber.java.PendingException();
		actual=apartmantsArray.get(apartmentIndex).isStudentHousing();
    	}
    	@When("there is no spacing a room in housing id {int}, floor {int} ,apartment id {int}")
    	public void thereIsNoSpacingARoomInHousingIdFloorApartmentId(Integer int1, Integer int2, Integer int3) {
    	    // Write code here that turns the phrase above into concrete actions
    	    //throw new io.cucumber.java.PendingException();
        	actual1= (apartmantsArray.get(apartmentIndex).thereIsSpace()&&apartmantsArray.get(apartmentIndex).isAvailabe());
    	}
    	@Then("can't book housing id {int}, floor {int}, apartment id {int}")
    	public void canTBookHousingIdFloorApartmentId(Integer int1, Integer int2, Integer int3) {
    	    // Write code here that turns the phrase above into concrete actions
    	    //throw new io.cucumber.java.PendingException();
    		expected=true;
        	expected1=false;
        	assertEquals(expected1,actual1);
        	assertEquals(expected,actual);
    	}


///
    
  


}