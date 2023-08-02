package najah.edu.acceptance;

public class Furniture {


	private String type;
	private String tenantName;
	private int price;
	private String usageTime;
	private String phoneNumber;
	public Furniture(String type, String tenantName,String phoneNumber, int price, String usageTime) {
		super();
		this.type = type;
		this.tenantName = tenantName;
		this.price = price;
		this.usageTime = usageTime;
		this.phoneNumber=phoneNumber;
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

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUsageTime() {
		return usageTime;
	}
	public void setUsageTime(String usageTime) {
		this.usageTime = usageTime;
	}

	@Override
	public String toString() {
		return " My name is "+tenantName +" and i am selling a ("+ type + ") for this price ("+  price+"), i used it for " + usageTime
				+ " if you are intrested, you can contact me on this number "+phoneNumber;
	}
}
