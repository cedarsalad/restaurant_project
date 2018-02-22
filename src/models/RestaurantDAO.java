package models;
import java.util.ArrayList;

public class RestaurantDAO {
	
	private static RestaurantDAO instance = null;

	//constructor
	private RestaurantDAO() {}

	public static RestaurantDAO getIntance() {
		if (instance == null)
			instance = new RestaurantDAO();

		return instance;
	}
     
    public void addRestaurant(RestaurantBean restaurant) {
        int id = MainDTO.id;
        MainDTO.id ++;
        restaurant.setId(Integer.toString(id));
        MainDTO.restaurantList.add(restaurant);
        System.out.println("New Restaurant added: " + restaurant);
    }
     
    public void editRestaurant(RestaurantBean restaurant) {
		int index;
		for (RestaurantBean existingRestaurant : MainDTO.restaurantList) {
			if (existingRestaurant.getId().equals(restaurant.getId())) {
				index = MainDTO.restaurantList.indexOf(existingRestaurant);
				MainDTO.restaurantList.set(index, restaurant);
				System.out.println("Restaurant edited: " + restaurant);
				break;
			}
		}
    }
     
    public void deleteRestaurant(RestaurantBean restaurant) {
		MainDTO.restaurantList.remove(restaurant);
        System.out.println("Restaurant deleted: " + restaurant);
    }
     
    public RestaurantBean getSingleRestaurant(String id) {
    	for (RestaurantBean restaurant : MainDTO.restaurantList) {
			if (restaurant.getId().equals(id))
				return restaurant;
		}
		
		return null; 
	}
     
    public ArrayList<RestaurantBean> getAllRestaurants(){
        return MainDTO.restaurantList;
    }

}
