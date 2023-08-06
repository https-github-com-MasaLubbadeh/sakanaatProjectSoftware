package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ViewFurnitureFeatureSteps {
	User obj;

	public ViewFurnitureFeatureSteps() {
		super();
		obj=new User();

	}
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<String> furnitureArray=new ArrayList<String>();

	boolean actual=false;
	boolean expected=false;
	void prepareinfo() {
		User admin=new User("Masa","IamAdmin","Admin",1);
		User Owner=new User("Tamara","12346","Owner",3);
		User tenant=new User("Raya","12345","tenant",2);
		Furniture f1=new Furniture("chair", "Masa","0594050064", 100, "one year");
		Furniture f2=new Furniture("table", "Raya","0594050064", 100, "one year");
		Furniture f3=new Furniture("couch", "raghad","0594050064", 100, "one year");
		
		
		furnitureArray.add(f1.toString());
		furnitureArray.add(f2.toString());
		furnitureArray.add(f3.toString());

		users.add(tenant);		
		users.add(admin);
		users.add(Owner);


	}
	@Given("the user type is {string}")
	public void theUserTypeIs(String string) {
		prepareinfo();
		//if() {
			actual=!users.get(User.getIndex("Masa", users)).getType().equalsIgnoreCase(string);
			//}

	}
	@Then("user can view furniture")
	public void userCanViewFurniture() {
		expected=true;
		assertEquals(expected,actual);
		for(String element:furnitureArray) {
			System.out.println(element);
		}
		
	}


	@Given("the user type is not {string}")
	public void theUserTypeIsNot(String string) {
		prepareinfo();
		if(!users.get(User.getIndex("Raya", users)).getType().equals(string)) {
			actual=false;}
	}
	@Then("user can't view furniture")
	public void userCanTViewFurniture() {
		expected=false;
		assertEquals(expected,actual);
	}




}
