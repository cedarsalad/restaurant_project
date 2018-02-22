package models;

import java.util.ArrayList;

public class OrderDAO {
	private static OrderDAO instance = null;
	
	private OrderDAO() {
		
	}
	
	public static OrderDAO getInstance() {
		if (instance == null)
			instance = new OrderDAO();
		
		return instance;
	}
	
	public void addOrder(OrderBean order) {
		int id = MainDTO.id;
		MainDTO.id ++;
		order.setId(id+"");
		MainDTO.orderList.add(order);
		System.out.println("New Order added: " + order);
	}
	
	public void editOrder(OrderBean order) {
		int index;
		for (OrderBean existingOrder: MainDTO.orderList) {
			if (existingOrder.getId().equals(order.getId())) {
				index = MainDTO.orderList.indexOf(existingOrder);
				MainDTO.orderList.set(index, order);
				System.out.println("Order edited: " + order);
				break;
			}
		} 
	}
	
	public void deleteOrder(OrderBean order) {
		MainDTO.orderList.remove(order);
		System.out.println("Order Deleted: " + order.toString());
	}
	
	//get order based on the order id#
	public OrderBean getSingleOrder(String id) {
		for (OrderBean order : MainDTO.orderList) {
			if (order.getId().equals(id))
				return order;
		}
		
		return null;
	}
	
	public ArrayList<OrderBean> getAllOrders() {
		return MainDTO.orderList;
	}
	
	
}
