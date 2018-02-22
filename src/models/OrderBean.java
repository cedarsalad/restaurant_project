package models;

public class OrderBean {
		
	protected String id;
	protected String address;
	protected String deliveryDate;
	protected String deliveryTime;
	protected String postalCode;
	protected String client;
	protected String deliveryMan;
	protected String restaurant;
	protected String[][] order;
	protected String status; 
	// STATUS LIST
	// 1 = order created
	// 2 = order accepted
	// 3 = order ready
	// 4 = order assigned
	// 5 = order completed
	
	public OrderBean(String id, String address, String deliveryDate, String deliveryTime, String postalCode, String client, String deliveryMan, String restaurant, String[][] order, String status) {
		this.id = id;
		this.address = address;
		this.deliveryDate = deliveryDate;
		this.deliveryTime = deliveryTime;
		this.postalCode = postalCode;
		this.client = client;
		this.deliveryMan = deliveryMan;
		this.restaurant = restaurant;	
		this.order = order;
		this.status = status;
	}

	public OrderBean(String address, String deliveryDate, String deliveryTime, String postalCode, String client, String restaurant, String[][] order) {
		this.id = "";
		this.address = address;
		this.deliveryDate = deliveryDate;
		this.deliveryTime = deliveryTime;
		this.postalCode = postalCode;
		this.deliveryMan = null;
		this.client = client;
		this.restaurant = restaurant;	
		this.order = order;
		this.status = "1";
	}
	
	public String toString() {
		return this.getClass().getSimpleName() 
											+ " [id=" + this.id 
											+ ", deliveryDate =" + this.deliveryDate 
											+ ", deliveryTime =" + this.deliveryTime 
											+ ", postalCode=" + this.postalCode 
											+ ", restaurant=" + this.restaurant 
											+ ", order =" + this.order.toString() + "]";
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String[][] getOrder() {
		return order;
	}

	public void setOrder(String[][] order) {
		this.order = order;
	}

	public String getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	
}
