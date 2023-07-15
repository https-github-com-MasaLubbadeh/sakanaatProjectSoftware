package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LogoutFeatureSteps {

	user obj1=new user();
	user obj2=new user();
	boolean actual=false;
	boolean expected=false;

	void prepareinfo() {
		obj1.setLogged(1);
		obj2.setLogged(0);

	}
	
	
	@Given("user already logged in succefully")
	public void userAlreadyLoggedInSuccefully() {
		prepareinfo();
		System.out.println(obj1.getLogged());
		if(obj1.getLogged()==1)actual=true;
		else actual=false;
	}
	@Then("logut success")
	public void logutSuccess() {
		expected=true;
		assertEquals(actual,expected);
	}
 	@Given("no user logged in")
	public void noUserLoggedIn() {
		prepareinfo();

		if(obj2.getLogged()==1)actual=true;
		else actual=false;
	}
	@Then("logut failed")
	public void logutFailed() {
		expected=false;
		assertEquals(actual,expected);
	}




}
