package najah.edu.acceptance;

public class TenantProfile {
	private String tenantName;
	private String phoneNumber;
	private String type;
	private User owner;
	private int rent;
	public TenantProfile() {		
		this.owner=new User();
		owner.setLogged(1);
		rent=0;
		type="Not Specified yet";
}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}

}
