package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TenantControlPanel {
	private static ArrayList<User> users = new ArrayList<User>();
	private static TenantProfile tenantPro =new TenantProfile();

	boolean expected=true;
	boolean actual=true;
	 @BeforeAll
		public static void prepareInfo() {
	    	final String pass = "12345";
	    	final String owner = "owner";
	    	final String tenant = "tenant";
	    	
	    		

	    		User ownerr=new User("masaMasri",pass,owner,9,"0594050064");
	    		User owner1=new User("jafarHindi",pass,owner,1,"0555898745");
	    		User tenant1=new User("Raya",pass,tenant,2,"0564879532");
	    		
	    		User tenant2=new User("Masa",pass,tenant,3,"0599344589");

	    		User tenant3=new User("Hiba",pass,tenant,4,"0599344589");
	    		
	    		User admin=new User("Haya",pass,"Admin",1);
	    		tenantPro.setOwner(owner1);
	    		tenantPro.setPhoneNumber("0599312452");
	    		tenantPro.setRent(500);
	    		tenantPro.setTenantName("anas");
	    		tenantPro.setType("family");
	    		users.add(admin);
	            users.add(owner1);
	            users.add(tenant1);
	            users.add(tenant2);
	            users.add(tenant3);
	            users.add(ownerr);
	           
		}

	@Given("user with id {int} type is {string}")
	public void userWithIdTypeIs(Integer int1, String string) {
	    for(int i=0; i<users.size();i++) {
	    	if(users.get(i).getId()==int1) {
	    		actual=(users.get(i).getType().equalsIgnoreCase("tenant"));
	    	}
	    }
	}
	@Then("owener control panel printed successfuly")
	public void owenerControlPanelPrintedSuccessfuly() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		MainFunc.printControlPanel(tenantPro);
		assertEquals(expected,actual);
		
	}


	@Given("user has id {int} type is {string}")
	public void userHasIdTypeIs(Integer int1, String string) {
		 for(int i=0; i<users.size();i++) {
		    	if(users.get(i).getId()==int1) {
		    		actual=(users.get(i).getType().equalsIgnoreCase("tenant"));
		    	}
		    }
	}
	@Then("owener control panel not printed")
	public void owenerControlPanelNotPrinted() {
	    expected=false;
	    assertEquals(expected,actual);
	}





}
