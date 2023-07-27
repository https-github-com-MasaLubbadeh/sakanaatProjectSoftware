package najah.edu.acceptance;

import java.util.ArrayList;
import java.util.logging.Level;
///import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFunc {

	
	 ///static Logger logger = Logger.getLogger(Main.class.getSimpleName());
	static Logger logger = LogManager.getLogger(MainFunc.class);

	
	
	public static boolean loginSuccess(String Name,String Password ,ArrayList<User> users) {
		boolean success=false;
		if(User.getIndex(Name, users)>=0) {
			success=(users.get(User.getIndex(Name, users)).getPass().toString().equals(Password));
			return success;
		}else return success=false;
		
	}
	public static String getTypeFromName(String Name,ArrayList<User> users) {
		String type="";
		type=users.get(User.getIndex(Name, users)).getType();
		return type;
	}
	public static void tenantView(ArrayList <apartment>apartmentsArray , ArrayList <housing>housingsArray) {
		for(int i = 0; i < apartmentsArray.size(); i++) { 
			if(apartmentsArray.get(i).isAvailabe()==true) {
				logger.info(apartmentsArray.get(i).toString());
				//System.out.print(apartmentsArray.get(i));
				//System.out.println("\n");
				logger.info( "\n");

				for(int j=0;j<housingsArray.size();j++) {
					if(housingsArray.get(j).getHousingID() == apartmentsArray.get(i).getHousingID()) {
						//System.out.println(housingsArray.get(j));
						logger.info(housingsArray.get(j).toString());

					}
				}
				logger.info("\n");

				//System.out.println("\n");
			}
		///	else System.out.println("no available housees");

		} 
	}
	public static apartment viewApartment(int id,int id2,ArrayList <apartment>apartmentsArray){
		int indexactual;
		apartment a=new apartment();
		indexactual=a.getIndexByApartmentID(id,id2,apartmentsArray);
		return apartmentsArray.get(indexactual);
		
	}
	public static void printHousingsToSpecificOwner(ArrayList <housing> housingsArray,String ownerName) {
		for(int i=0; i<housingsArray.size();i++) {
			if(housingsArray.get(i).getOwnerName().equalsIgnoreCase(ownerName)) {
				logger.info( housingsArray.get(i).toString());
				logger.info(  "\n");
			}
		}
	}
	
	
}
