package najah.edu.acceptance;

public class reservations {
	int tenantID;
	int apartmentID;
	int housingID;
	
	
	public reservations(int tenantID, int apartmentID) {
		super();
		this.tenantID = tenantID;
		this.apartmentID = apartmentID;
	}
	public int getTenantID() {
		return tenantID;
	}
	public void setTenantID(int tenantID) {
		this.tenantID = tenantID;
	}
	public int getApartmentID() {
		return apartmentID;
	}
	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}
	public int getHousingID() {
		return housingID;
	}
	public void setHousingID(int housingID) {
		this.housingID = housingID;
	}
	public reservations(int tenantID, int apartmentID, int housingID) {
		super();
		this.tenantID = tenantID;
		this.apartmentID = apartmentID;
		this.housingID = housingID;
	}

}
