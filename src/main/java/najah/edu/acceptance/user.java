package najah.edu.acceptance;

import java.util.List;

public class User {
private String name;
private String pass;
private String type;
private int id;
private String phoneNumber;/////////////////////////
private int logged;

	public User() {
		this.logged=0;
		}

	public User(String name, String pass, String typee,int id) {
		this.name = name;
		this.pass = pass;
		this.type=typee;
		this.id=id;
	}
	public User(String name, String pass, String type, int id, String phoneNumber) {
		super();
		this.name = name;
		this.pass = pass;
		this.type = type;
		this.id = id;
		this.phoneNumber = phoneNumber;
	}
	
	 public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	 public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getLogged() {
			return logged;
		}

		public void setLogged(int logged) {
			this.logged = logged;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public static int getIndex(String name, List<User> users) {
			int index = -1;

			for (int i = 0; i < users.size(); i++) {

				if (users.get(i).getName().equals(name)) {

					return i;
				}
			}

			return index;
		}
		public static int getIndexByUserID(int id, List<User> users) {
			int index = -1;

			for (int i = 0; i < users.size(); i++) {

				if (users.get(i).getId()==id) {

					return i;
				}
			}

			return index;
		}
		
		public static String getUserName(int id, List<User> users) {
			String s="";

			for (int i = 0; i < users.size(); i++) {

				if (users.get(i).getId()==id) {

					return users.get(i).getName();
				}
			}

			return s;
		}
		
	/*	public static int getTenantsCount(int ownerID, List<user> users, List<housing> housings) {
			int ownerIndex=user.getIndexByUserID(ownerID, users);
			String ownerName=users.get(ownerIndex).getName();
			int count=0;
			for(int i=0; i<housings.size();i++) {
				if (housings.get(i).getOwnerName().equalsIgnoreCase(ownerName)) {
					if(housings.get(i).getT)
				}
			}
			return -1;
			
		} */

}
