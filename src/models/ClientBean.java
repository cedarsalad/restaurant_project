package models;

public class ClientBean {
	
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String email;
	protected String phone;

	/**
	 * Constructor for known ID and everything else
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param phone
	 */
	public ClientBean(String id, String firstName, String lastName, String address, String email, String phone) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	/**
	 * Constructor for unknown ID and everything else
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param phone
	 */
	public ClientBean(String firstName, String lastName, String address, String email, String phone) {
		this.id = "";
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() 
											+ " [id=" + this.id 
											+ ", first name=" + this.firstName 
											+ ", last name=" + this.lastName 
											+ ", address=" + this.address 
											+ ", email=" + this.email 
											+ ", phone=" + this.phone + "]";
	}
	
	public String[] toArray() {
		return new String[]{this.id, this.firstName, this.lastName, this.address, this.email,this.phone};
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
