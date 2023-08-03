package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateFeatureSteps {
	User obj;
	Housing ob;
	public UpdateFeatureSteps() {
		super();
		obj=new User();
		ob=new Housing();
	}


	boolean actual=false;
	boolean expected=false;
	int indexactual=0;
	int indexExpected=0;
	int id=0;

	Housing h3=new Housing(5,"makkfsa","ramakfkllah",53,83);

	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Housing> house = new ArrayList<Housing>();

	///@Before
	void prepareinfo() {
		User admin=new User("Masa","IamAdmin","Admin",1);
		User Owner=new User("Tamara","12346","Owner",3);
		User tenant=new User("Raya","12345","tenant",2);
		users.add(tenant);		
		users.add(admin);
		users.add(Owner);
		Housing h1=new Housing(10,"raya","nablus",3,3);
		Housing h2=new Housing(1,"masa","ramallah",3,3);
		house.add(h1);
		house.add(h2);

	}
	
	@Given("selected house already exists where its id is {int}")
	public void selectedHouseAlreadyExistsWhereItsIdIs(Integer int1) {
		prepareinfo();
		actual=ob.doesExist(int1, house);
		ob.setHousingID(int1);

	}

	@When("user id is {int}")
	public void userIdIs(Integer int1) {
         obj.setId(int1);
         obj.getId();
     ////  String name=
        obj.setName(obj.getUserName(int1, users)) ;
         
	}
	@When("the user type is either an {string} or an {string}")
	public void theUserTypeIsEitherAnOrAn(String string, String string2) {
		if(users.get(User.getIndex(obj.getName(), users)).getType().equals(string))actual=true;
		else if(users.get(User.getIndex(obj.getName(), users)).getType().equals(string2))actual=true;
		else actual=false;
	}
	@Then("house is updated successfully")
	public void houseIsUpdatedSuccessfully() {
		expected=true;
		assertEquals(actual,expected);
		house.set(ob.getIndex(ob.getHousingID(), house), h3);
	/*	for(int i = 0; i < house.size(); i++) {   
			///System.out.print(house.get(i));
		}*/ 
	
	}


///////////////////////////////////////////////////////////

	@Given("selected house does not exist where its id is {int}")
	public void selectedHouseDoesNotExistWhereItsIdIs(Integer int1) {
		actual=ob.doesExist(int1, house);
		expected=false;
	}
	@Then("house is not updated because of its id")
	public void houseIsNotUpdatedBecauseOfItsId() {
		assertEquals(actual,expected);
	}
	////////////////////////////////////////////////////////////


	@Given("selected house already exists")
	public void selectedHouseAlreadyExists() {
		actual=false;
		expected=false;

	}
	@When("id is {int}")
	public void idIs(Integer int1) {
		actual=ob.doesExist(int1, house);
		ob.setHousingID(int1);
	}
	@When("the user id is {int}")
	public void theUserIdIs(Integer int1) {
        obj.setId(int1);
        obj.getId();
    ////  String name=
       obj.setName(User.getUserName(int1, users)) ;
	}
	@When("the user is neither an {string} nor an {string}")
	public void theUserIsNeitherAnNorAn(String string, String string2) {
		if(users.get(User.getIndex(obj.getName(), users)).getType().equals(string))actual=true;
		else if(users.get(User.getIndex(obj.getName(), users)).getType().equals(string2))actual=true;
		else actual=false;
	}
	@Then("house is not updated because of the user type")
	public void houseIsNotUpdatedBecauseOfTheUserType() {
		expected=false;
		assertEquals(actual,expected);
	}







}
