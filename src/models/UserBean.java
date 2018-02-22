package models;

public class UserBean {
	
	protected String id;
	protected String entityId;
	protected String username;
	protected String password;
	protected String userType;

	/**
	 * Constructor for known ID and everything else
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param phone
	 */
	public UserBean(String id, String entityId, String username, String password, String userType) {
		this.id = id;
		this.entityId = entityId;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public UserBean(String entityId, String username, String password, String userType) {
		this.id = "";
		this.entityId = entityId;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public String toString() {
		return this.getClass().getSimpleName() 
											+ " [id=" + this.id 
											+ " [entityId=" + this.entityId
											+ ", username=" + this.username 
											+ ", password=" + this.password 
											+ ", userType=" + this.userType + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
