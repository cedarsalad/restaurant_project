package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class OrderModel extends Observable {
	private OrderBean order;
	private OrderDAO dao;
	private ArrayList<OrderBean> data;
	
	public OrderModel() {
		this.dao = OrderDAO.getInstance();
	}
	
	public void addNewOrder(String address, String deliveryDate, String deliveryTime, String postalCode, String client, String restaurant, String[][] order) {
		this.order = new OrderBean(address, deliveryDate, deliveryTime, postalCode, client, restaurant, order);
		dao.addOrder(this.order);
	}
	
	public void editOrder(String id, String address, String deliveryDate, String deliveryTime, String postalCode, String client, String deliveryMan, String restaurant, String[][] order, String status) {
		this.order = new OrderBean(id, address, deliveryDate, deliveryTime, postalCode, client, deliveryMan, restaurant, order, status);
		dao.editOrder(this.order);
	}
	
	public void deleteOrder(String id) {
		order = dao.getSingleOrder(id);
		dao.deleteOrder(order);
	}
	
	public OrderBean getSingleOrder(String id) {
		order = dao.getSingleOrder(id);
		return order;
	}
	
	public ArrayList<OrderBean> getAllOrders() {
		data = dao.getAllOrders();
		
		setChanged();
		notifyObservers();
		
		return data;
	}
}
