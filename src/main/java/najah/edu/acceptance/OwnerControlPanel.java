package najah.edu.acceptance;

import java.util.ArrayList;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OwnerControlPanel {
	private static ArrayList <Reservations> reservationsArray= new ArrayList<Reservations>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Apartment> apartmentsArray = new ArrayList<Apartment>();
	private static ArrayList<Housing> housingsArray = new ArrayList<Housing>();

    int ownerIndex=-1;
    int ownerID=-1;
    int chosenHousingIndex=-1;    
    int chosenApartmentIndex=-1;
    int chosenFloor;
    int chosenHousingID;
    String chosenOwnerName;
    
    @BeforeAll
	public static void prepareInfo() {
		final String airCondition = "air-conditioning";
		final String pass = "12345";

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

		User ownerr=new User("masaMasri",pass,"owner",9,"0594050064");
		User owner1=new User("jafarHindi",pass,"owner",1,"0555898745");
		User tenant1=new User("Raya",pass,"tenant",2,"0564879532");
		Reservations reservation1=new Reservations(tenant1.getId(),apartment1.getApartmentID(),house1.getHousingID());
		
		Housing house2= new Housing(2,"masaMasri","Nablus-beitWazan",3,3);
		Apartment apartment3= new Apartment(1,airCondition,"students",2,400,1,false);
		Apartment apartment4= new Apartment(2,airCondition,"students",2,450,1,true);
		
		apartment3.setPeopleCapacity(3);
		apartment3.setCurrentNumberOfRoommates(3);
		
		apartment4.setPeopleCapacity(3);
		apartment4.setCurrentNumberOfRoommates(2);
		
		User tenant2=new User("Masa",pass,"tenant",3,"0599344589");
		Reservations reservation2=new Reservations(tenant2.getId(),apartment3.getApartmentID(),house2.getHousingID());

		User tenant3=new User("Hiba",pass,"tenant",4,"0599344589");
		Reservations reservation3=new Reservations(tenant3.getId(),apartment3.getApartmentID(),house2.getHousingID());
		User admin=new User("Haya",pass,"Admin",1);
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

	
	@Given("the owner with id {int} has housings")
	public void theOwnerWithIdHasManyHousings(Integer int1) {
	   ownerIndex=User.getIndexByUserID(int1, users);
	}
	@When("the owner with id {int} enters one of his housing id {int}")
	public void theOwnerWithIdEntersOneOfHisHousingId(Integer int1, Integer int2) {
	    chosenHousingID=int2;
		chosenHousingIndex= Housing.getIndexByHousingID(chosenHousingID, housingsArray);
	    chosenOwnerName=housingsArray.get(chosenHousingIndex).getOwnerName();
		
	}
	
	@Then("number of floors and tenants in this housing will be given")
	public void numberOfFloorsAndTenantsInThisHousingWillBeGiven() {
		Housing.printNumberOfFloors(housingsArray, chosenHousingID);
		Housing.printTenantsCount(apartmentsArray,housingsArray,chosenOwnerName);
		
		
	}
	
	@When("the owner with id {int} enters floor number {int}")
	public void theOwnerWithIdEntersFloorNumber(Integer int1, Integer int2) {
		chosenFloor=int2;
	}
	
	 @Then("the apartments in this floor will be given")
	public void theApartmentsInThisFloorWillBeGiven() {
	    Apartment.printApartmentsOnFloor(apartmentsArray,chosenFloor,chosenHousingID);
	}
	
	@When("the owner with id {int} enters apartment id {int}")
	public void theOwnerWithIdEntersApartmentId(Integer int1, Integer int2) {
	   int chosenApartmentID=int2;
		chosenApartmentIndex=Apartment.getIndexByApartmentID(chosenApartmentID,chosenHousingID ,apartmentsArray);
	}
	
	@Then("name of the tenant ,communication way,number of bathrooms,number of bedrooms,of this apartment will be given,and if it has a balcony")
	public void nameOfTheTenantCommunicationWayNumberOfBathroomsNumberOfBedroomsOfThisApartmentWillBeGivenAndIfItHasABalcony() {
		 Apartment.printApartmentInfo(apartmentsArray.get(chosenHousingIndex), reservationsArray,users);
		
	}


}
