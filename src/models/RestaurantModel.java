package models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class RestaurantModel extends Observable {

	private RestaurantBean restaurant;
	private RestaurantDAO dao;
	private ArrayList<RestaurantBean> dataList;
	private String[] columns = {"ID", "Name", "Username", "Password", "Address", "Phone#"};
	private String[] restaurantNames;
	private Object[][] data;
	//private Object[][] menuData;

	// 	constructor
	public RestaurantModel() {
		this.dao = RestaurantDAO.getIntance();
	}

	// add
	public void addNewRestaurant(String name, String address, String phoneNumber, String openingHours,
			String deliveryAreas) {
		restaurant = new RestaurantBean(name, address, phoneNumber, openingHours, deliveryAreas);
		dao.addRestaurant(restaurant);
	}

	// edit
	public void editRestaurant(String id, String name, String address, String phoneNumber, String openingHours,
			String deliveryAreas) {
		restaurant = new RestaurantBean(id, name, address, phoneNumber, openingHours, deliveryAreas);
		dao.editRestaurant(restaurant);
	}

	// delete
	//passes a reference to the target restaurent to the DAO delete method
    public void deleteRestaurant(String id) {
    	restaurant = dao.getSingleRestaurant(id);
        dao.deleteRestaurant(restaurant);
    }
	
    public RestaurantBean getSingleRestaurant(String id) {
    	restaurant = dao.getSingleRestaurant(id);
        return restaurant;
    }
     
    public ArrayList<RestaurantBean> getAllRestaurants() {
    	dataList = dao.getAllRestaurants();
         
        data = new Object[dataList.size()][];
        
        for(int i=0; i<dataList.size(); i++) {
            data[i] =  dataList.get(i).toArray(); 
        }
        
        setChanged();
        notifyObservers();
         
        return dataList;
    }
    
    public Object[] getRestaurantNames() {
        return restaurantNames;
    }
    
    /**
     * @return the columns
     */
    public String[] getColumns() {
        return columns;
    }
 
    /**
     * @return the data
     */
    public Object[][] getData() {
        return data;
    }

    public ArrayList<Object> getAllNames() {
    	
    	restaurantNames = new String[dao.getAllRestaurants().size()];
		dataList = dao.getAllRestaurants();

        for(int i=0; i<dataList.size(); i++) {
        	RestaurantBean tempResto = dataList.get(i);
        	restaurantNames[i] = (Object) tempResto.getId() + " - " + tempResto.getName(); 
        }
        
        ArrayList<Object> ListRestaurantNames = new ArrayList<Object>(Arrays.asList(restaurantNames));
        setChanged();
        notifyObservers();
         
        return ListRestaurantNames;
    }

}
