package models;

import java.util.ArrayList;

public abstract class MainDTO { 
	static String currentUser = null;
	public static int id = 1;
	static ArrayList<ClientBean> clientList = new ArrayList<>();
	static ArrayList<OrderBean> orderList = new ArrayList<>();
	static ArrayList<RestaurantBean> restaurantList = new ArrayList<>();
	static ArrayList<UserBean> userList = new ArrayList<>();
	static ArrayList<DeliveryManBean> deliveryManList = new ArrayList<>();
	

}
