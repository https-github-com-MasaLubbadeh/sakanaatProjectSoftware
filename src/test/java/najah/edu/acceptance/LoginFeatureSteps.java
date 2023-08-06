package najah.edu.acceptance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.sql.*;

import org.junit.Test;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureSteps {
	User obj;
	boolean actual=false;
	boolean expected=false;
	int indexactual=0;
	int indexExpected=0;


	public LoginFeatureSteps() {
		super();
		obj=new User();
	}
	private static ArrayList<User> users = new ArrayList<User>();

	///@Before
	void prepareinfo() {
		User admin=new User("Masa","IamAdmin","Admin",1);
		User tenant=new User("Raya","12345","tenant",2);
		User Owner=new User("Tamara","12346","Owner",3);
		users.add(admin);
		users.add(Owner);
		users.add(tenant);		
	}
	//@Test
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
		//actual=(users.get(User.getIndex(obj.getName(), users)).getPass().toString().equals(string));
		actual=MainFunc.loginSuccess(obj.getName(), string, users);
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
		obj.setPass(pass);
		obj.setType("not necesssary");
		obj.setPhoneNumber("not specified");
		actual=users.get(User.getIndex(obj.getName(), users)).getPass().equals(pass);
		
	}

	@When("username is {string} not found")
	public void usernameIsNotFound(String name) {
	
			obj.setLogged(0);
			obj.setName(name);
			obj.getName();
			indexactual=User.getIndex(obj.getName(), users);
			indexExpected=-1;
		
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
