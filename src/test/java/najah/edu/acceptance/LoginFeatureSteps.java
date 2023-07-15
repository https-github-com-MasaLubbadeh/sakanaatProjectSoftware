package najah.edu.acceptance;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureSteps {
	user obj;
	boolean actual=false;
	boolean expected=false;
	int indexactual=0;
	int indexExpected=0;


	public LoginFeatureSteps(user obj) {
		super();
		this.obj = obj;
	}
	private static ArrayList<user> users = new ArrayList<user>();

	@Before
	void prepareinfo() {
		user admin=new user("Masa","IamAdmin","Admin",1);
		user tenant=new user("Raya","12345","tenant",2);
		user Owner=new user("Tamara","12346","Owner",3);
		users.add(admin);
		users.add(Owner);
		users.add(tenant);
		
	}
	@Given("that user is not logged in")
	public void thatUserIsNotLoggedIn() {
		obj.setLogged(0);
		}

	@When("username is {string}")
	public void username(String name) {
		obj.setName(name);
		obj.getName();
	}

	@When("password is correct {string}")
	public void passwordIsCorrect(String string) {
		prepareinfo();
		System.out.println(users.size());
		actual=(users.get(user.getIndex(obj.getName(), users)).getPass().toString().equals(string));
		
	}

	@Then("logged in successfully")
	public void loggedInSuccessfully() {
		expected=true;
		assertEquals(actual,expected);
		obj.setLogged(1);

	}
	@When("password is false {string}")
	public void passwordIsFalse(String pass) {
		prepareinfo();

		actual=users.get(user.getIndex(obj.getName(), users)).getPass().equals(pass);

		
	}

	@When("username is {string} not found")
	public void usernameIsNotFound(String name) {
		obj.setLogged(0);
		obj.setName(name);
		obj.getName();
		indexactual=user.getIndex(obj.getName(), users);
		
		

	}

	@Then("log in faild")
	public void logInFaild() {
		expected=false;
		assertEquals(actual,expected);
		obj.setLogged(0);	
		
		if(indexExpected<0)		expected=false;
		if(indexactual<0)actual=false;
		assertEquals(actual,expected);

		obj.setLogged(0);		
	}

}
