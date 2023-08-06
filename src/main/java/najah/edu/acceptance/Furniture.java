package najah.edu.acceptance;

public class Furniture {

	private TenantProfile tenant;
	private int price;
	private String usageTime;
	private String typee;

	public Furniture(String type, String tenantName,String phoneNumber, int price, String usageTime) {
		super();
		tenant=new TenantProfile();

		
		tenant.setTenantName(tenantName);
		tenant.setPhoneNumber(phoneNumber);
		this.typee=type;
		this.price = price;
		this.usageTime = usageTime;
	}

	@Override
	public String toString() {
		return " My name is "+tenant.getTenantName() +" and i am selling a ("+ typee + ") for this price ("+  price+"), i used it for " + usageTime
				+ " if you are intrested, you can contact me on this number "+tenant.getPhoneNumber();
	}
}
