package najah.edu.acceptance;

public class Furniture {

	private TenantProfile tenant;
	private int price;
	private String usageTime;
	private String typee;
	public TenantProfile getTenant() {
		return tenant;
	}
	public void setTenant(TenantProfile tenant) {
		this.tenant = tenant;
	}
	public String getTypee() {
		return typee;
	}
	public void setTypee(String typee) {
		this.typee = typee;
	}
	public Furniture(String type, String tenantName,String phoneNumber, int price, String usageTime) {
		super();
		tenant=new TenantProfile();
		tenant.setTenantName(tenantName);
		tenant.setPhoneNumber(phoneNumber);
		this.typee=type;
		this.price = price;
		this.usageTime = usageTime;
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
		return " My name is "+tenant.getTenantName() +" and i am selling a ("+ typee + ") for this price ("+  price+"), i used it for " + usageTime
				+ " if you are intrested, you can contact me on this number "+tenant.getPhoneNumber();
	}
}
