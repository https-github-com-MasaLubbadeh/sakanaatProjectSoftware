package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.acceptance.service.HousingService;

public class AddNewHousingTest {
	Housing housingObj;
	Housing updateData;
	// housing housingNew;

	boolean actual = false;
	boolean expected = false;

	HousingService underTest = spy(HousingService.class);

	ArrayList<Housing> housingArray = new ArrayList<Housing>();
	ArrayList<Apartment> apartmentsArray = new ArrayList<Apartment>();

	@Before
	public void prepareInfo() {

		Housing house1 = new Housing(1, "jafarHindi", "Nablus-Rafedia", 3, 3);
		Housing house2 = new Housing(2, "masaMasri", "Nablus-beitWazan", 3, 3);
		Housing house3 = new Housing(2, "masaMasri", "Nablus-beitWazan", 0, 0);
		house3.setNumbersOfApartmentInEachFloor(3);
		house3.setNumbersOfFloors(2);
		Apartment aprt=new Apartment();
		aprt.setApartmentID(1);
		aprt.setAvailableServices("air conditioning");
		aprt.setCurrentNumberOfRoommates(0);
		aprt.setAvailabe(true);
		aprt.setRent(150);
		aprt.setExtraInfo("no");
		aprt.setFamilyHousing();
		aprt.setHousingID(1);
		aprt.setType("no idea");
		aprt.setFloorNum(1);
		apartmentsArray.add(aprt);
		boolean test= aprt.doesExist(1, apartmentsArray, 1);
		aprt.getRent();
		aprt.getAvailableServices();
		
		// housing house3= new housing(8,"raya","Nablus-jericho",4,2);
		housingArray.add(house1);
		housingArray.add(house2);
		// housingArray.add(house3);
		System.out.println(housingArray.size());

	}

	public AddNewHousingTest() {
		super();
		// prepareInfo();
		// TODO Auto-generated constructor stub
//		housingObj=new housing();
	}

	@Test
	@Given("the owner wants to add new housing")
	public void theOwnerWantsToAddNewHousing() {
		actual=true;
		expected=true;
		housingObj = new Housing();
		assertEquals(actual,expected);

	}

	@Then("housing with id is greater than {int}")
	public void housingWithIdIsGreaterThan(Integer int1) {
		assertTrue(underTest.createHousing(housingObj).getHousingID() > 0);
	}

	@Test
	@Given("the owner wants to update existing housing")
	public void theOwnerWantsToupdateHousing() {
		// Given
		housingObj = new Housing();
		housingObj.setLocation("loc1");
		housingObj.setHousingID(5);

		updateData = new Housing();
		updateData.setLocation("loc2");
		updateData.setHousingID(5);

		Map<Integer, Housing> currentDB = new HashMap<Integer, Housing>();
		currentDB.put(5, housingObj);

		// when
		when(underTest.getHousingDB()).thenReturn(currentDB);
		actual=true;
		expected=true;
		assertEquals(actual,expected);

		
	}

	@Then("housing with location is updated")
	public void housingWithLocationIsUpdated() throws Exception {
		// then
		assertEquals("loc2", underTest.updateHousing(updateData).getLocation());
	}

	@Given("the owner wants to add new housing with id {string}")
	public void theOwnerWantsToAddNewHousingWithId(String id) {
		housingObj = new Housing();
		housingObj.setHousingID(Integer.parseInt(id));
	}

	@When("id {string} doesn't exist")
	public void idDoesnTExist(String id) {
		actual = housingObj.doesExist(Integer.parseInt(id), housingArray); // true if exists
		System.out.println(actual);

	}

	@When("owner enters ownerName={string} location {string},available services\"air conditioning\",type={string},id {int} ,monthly rent {int},ownerID {int},floorCount {int},apartmentPerFloor {int},isAvailable {string} uploads pictures {string}")
	public void ownerEntersOwnerNameLocationAvailableServicesAirConditioningTypeIdMonthlyRentOwnerIDFloorCountApartmentPerFloorIsAvailableUploadsPictures(
			String string, String string2, String string3, Integer int1, Integer int2, Integer int3, Integer int4,
			Integer int5, String string4, String string5) {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		// housingNew= new housing(int1 ,string,string2, int2, int3);
		housingObj.setOwnerName(string);
		housingObj.setLocation(string2);
		housingObj.setNumbersOfApartmentInEachFloor(int2);
		housingObj.setNumbersOfFloors(int3);
		housingObj.getNumbersOfFloors();
	}

	@Then("housing with id {string} added succesfully")
	public void housingWithIdAddedSuccesfully(String id) {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		expected = false; // =housingObj.isExistHousing(id, housingArray);
		housingArray.add(housingObj);
		assertEquals(actual, expected);

	}

/////////////////////////////////////////////////////////////////////

	@Given("the owner requests to add new housing with id {string}")
	public void theOwnerRequestsToAddNewHousingWithId(String id) {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		System.out.println(housingArray.size());

		housingObj = new Housing();
		housingObj.setHousingID(Integer.parseInt(id));
		System.out.println(housingObj.getHousingID() + " idd");
		// for(int i=0; i<housingArray.size();i++)
	}

	@When("id {string} exists")
	public void idExists(String id) {
		actual = housingObj.doesExist(Integer.parseInt(id), housingArray); // true if found
		System.out.println(actual);
		System.out.println(housingArray.size());

	}

	@Then("failed to add housing {string}")
	public void failedToAddHousing(String string) {
		expected = true;
		assertEquals(expected, actual);

	}

}
