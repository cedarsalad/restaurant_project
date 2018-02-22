package models;

import java.util.ArrayList;

public class DeliveryManBean {
	
	protected String id; 
	protected String name;
	protected String telephone;
	protected String area;
	
	static int counter = 0;
	
	public DeliveryManBean(String name, String telephone, String area) {
		this.id = counter+"";
		this.name = name;
		this.telephone = telephone;
		this.area = area;
		
		counter++;
	}
	
	/** Constructor to for all know variables
	 * @param id
	 * @param name
	 * @param telephone
	 * @param area
	 */
	public DeliveryManBean(String id, String name, String telephone, String area) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.area = area;
	}
	
	/* Method to convert constructor to string
	 */
	public String toString() {
		return "[name= " + this.name + ", telephone= " + this.telephone +  ", area= " + this.area + "]";
	}
	
	
	/** Constructor to convert constructor to ArrayList
	 * @return
	 */
	/*public ArrayList<Object> toArrayList(){
		ArrayList<Object> DeliveryManArrayList = new ArrayList<Object>();
		DeliveryManArrayList.add(this.name);
		DeliveryManArrayList.add(this.telephone);
		DeliveryManArrayList.add(this.area);
		return DeliveryManArrayList;
	}*/


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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String[] toArray() {
		// TODO Auto-generated method stub
		
		return new String[] { this.id, this.name, this.telephone, this.area};
	}
	
}
