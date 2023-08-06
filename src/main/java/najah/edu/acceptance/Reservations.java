package najah.edu.acceptance;

public class Reservations {
	public Reservations() {
		super();
	}

	int tenantID;
	int apartmentID;
	int housingID;
	
	
	public Reservations(int tenantID, int apartmentID) {
		super();
		this.tenantID = tenantID;
		this.apartmentID = apartmentID;
	}
	public int getTenantID() {
		return tenantID;
	}

	public int getApartmentID() {
		return apartmentID;
	}

	public int getHousingID() {
		return housingID;
	}

	public Reservations(int tenantID, int apartmentID, int housingID) {
		super();
		this.tenantID = tenantID;
		this.apartmentID = apartmentID;
		this.housingID = housingID;
	}

	@Override
	public String toString() {
		return ("( tenant with ID:"+this.tenantID+ " has a reservation in apartment with ID:" +this.apartmentID+ " in housing with ID: "+this.housingID+" ) \n");
	}
}
