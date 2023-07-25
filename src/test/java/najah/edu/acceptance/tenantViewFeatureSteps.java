package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class tenantViewFeatureSteps {
	
	User obj;
	housing house;
	apartment apart;
	boolean actual=false;
	boolean expected=false;
	int indexactual=0;
	int indexExpected=0;
	int id=1;
	public tenantViewFeatureSteps() {
		super();
		//this.tenant=new user("Raya","12345","tenant",2);
		this.obj=new User();
		this.house=new housing();
		this.apart=new apartment();		
	}
	private static ArrayList<apartment> aprtment = new ArrayList<apartment>();
	private static ArrayList<housing> hous = new ArrayList<housing>();


	public void prepareInfo() {
		apartment p1=new apartment(1,"test","student",10,250,5,true);	
		apartment p2=new apartment(11,"test","family",11,150,6,true);	
		apartment p3=new apartment(12,"test","student",13,251,5,false);	
		aprtment.add(p1);
		aprtment.add(p2);
		aprtment.add(p3);
		housing h1=new housing(10,"raya","nablus",3,3);
		housing h2=new housing(13,"masa","ramallah",3,3);
		housing h3=new housing(11,"raya","nablus",3,3);

		hous.add(h1);
		hous.add(h2);
		hous.add(h3);

	}
	
	@Given("that the tenant is logged in now {int}")
	public void thatTheTenantIsLoggedInNow(Integer int1) {
		prepareInfo();
		obj.setLogged(int1);
		indexactual=obj.getLogged();
		indexExpected=1;
		
		if(indexExpected==0)expected=false;
		else expected=true;
		if(indexactual==0)actual=false;
		else actual=true;
		assertEquals(actual,expected);
		

		
	}
	@Then("the tenant can view the available houses")
	public void theTenantCanViewTheAvailableHouses() {
		int id=0;
		for(int i = 0; i < aprtment.size(); i++) { 
			if(aprtment.get(i).isAvailabe()==true) {

				System.out.print(aprtment.get(i));
				System.out.println("\n");
				for(int j=0;j<hous.size();j++) {
					house.setHousingID(id);
					if(hous.get(j).getHousingID() == aprtment.get(i).getHousingID()) {
						System.out.println(hous.get(j));	

					}
				}
				System.out.println("\n");
				



			}
		///	else System.out.println("no available housees");

		} 

		
	}

////////////////////////////////////////////
	@Given("that the tenant is not logged in now {int}")
	public void thatTheTenantIsNotLoggedInNow(Integer int1) {
		prepareInfo();
		obj.setLogged(int1);
		indexactual=obj.getLogged();
		indexExpected=0;
		
		if(indexExpected==0)expected=false;
		else expected=true;
		if(indexactual==0)actual=false;
		else actual=true;
		assertEquals(actual,expected);
		

	}
	@Then("the tenant cannot view the available houses")
	public void theTenantCannotViewTheAvailableHouses() {
		System.out.println("tenant is not logged in");
	}

	///////////////////////////////////////////////////////////////////////////
	
	@Given("that the tenant selected the apartment with id {int}")
	public void thatTheTenantSelectedTheApartmentWithId(Integer int1) {
		prepareInfo();
		id=int1;
		indexactual=apart.getIndex(int1,aprtment);
		//System.out.println("arrayIndex : "+indexactual);
	//	System.out.println(aprtment.get(indexactual));	

	}
	@Given("their exist an apartment with this id")
	public void theirExistAnApartmentWithThisId() {
		int indexExpected=1;
		if(indexExpected<0)expected=false;
		else expected=true;
		if(indexactual<0)actual=false;
		else actual=true;
		assertEquals(actual,expected);
		
	}
	@Then("the tenant can view information about the apartment")
	public void theTenantCanViewInformationAboutTheApartment() {
	//	apart.setApartmentID(id);
		System.out.println(aprtment.get(indexactual));	



		
	}





}
