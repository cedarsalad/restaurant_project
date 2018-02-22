package models;
import java.util.ArrayList;

public class RestaurantBean {

	protected String id;
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String openingHours;
	protected String deliveryAreas;
	protected String[][] menu;
	
	RestaurantBean(String name, String address, String phoneNumber, String openingHours, String deliveryAreas) {
		this.id = "";
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.openingHours = openingHours;
		this.deliveryAreas = deliveryAreas;

	}
	
	RestaurantBean(String id, String name, String address, String phoneNumber, String openingHours, String deliveryAreas) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.openingHours = openingHours;
		this.deliveryAreas = deliveryAreas;

	}

	public String toString() {
		return this.getClass().getSimpleName() 
											+ " [id=" + this.id 
											+ ", name =" + this.name 
											+ ", address =" + this.address 
											+ ", phoneNumber=" + this.phoneNumber 
											+ ", openingHours=" + this.openingHours 
											+ ", deliveryAreas =" + this.deliveryAreas + "]";
	}
	
	public String[] toArray() {
		// TODO Auto-generated method stub
		return new String[] { this.id, this.name, this.address, this.phoneNumber,
				this.deliveryAreas, this.openingHours };
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getDeliveryAreas() {
		return deliveryAreas;
	}

	public void setDeliveryAreas(String deliveryAreas) {
		this.deliveryAreas = deliveryAreas;
	}

	public String[][] getMenu() {
		return menu;
	}

	public void setMenu(String[][] menu) {
		this.menu = menu;
	}
	
	public void setMenu(ArrayList<String> menuList) {
		
		if(menuList.size() > 0){
			String[][] tempMenu = new String[menuList.size()][];
			// item | price
			
			for(int i=0 ; i<menuList.size(); i++){
				String tempString = new String(menuList.get(i));
				System.out.println("\n"+ i + " " + tempString);
				tempMenu[i] = tempString.split("\\|");

			}
			
			menu = tempMenu;
			System.out.println("success");
			
		}else{
			
			menu = null;
			System.out.println("success -> menu is null");
			
		}

	}

}
