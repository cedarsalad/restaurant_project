package models;

import java.util.ArrayList;

public class DeliveryManDAO {
	
	private static DeliveryManDAO instance = null;
	ArrayList<String> test = new ArrayList<String>();
	
	private DeliveryManDAO() {
	}
	
	/** Method to return the instance of DeliveryManDao
	 * @return
	 */
	public static DeliveryManDAO getInstance(){
		if (instance == null)
			instance = new DeliveryManDAO();
		return instance;
	}
	
	/** Method to add Delivery Man
	 * @param DeliveryMan
	 */
	public void addDeliveryMan(DeliveryManBean DeliveryMan) {
		int id = MainDTO.id;
		MainDTO.id ++;
		DeliveryMan.setId(id+"");
		MainDTO.deliveryManList.add(DeliveryMan);
		System.out.println("New DeliveryMan added: " + DeliveryMan);
	}
	
	/** Method to edit Delivery Man
	 * @param DeliveryMan
	 */
	public void editDeliveryMan(DeliveryManBean DeliveryMan) {
		MainDTO.deliveryManList.set(Integer.valueOf(DeliveryMan.id), DeliveryMan);
		System.out.println("New DeliveryMan edited: " + DeliveryMan);
	}
	
	/** Method to delete Delivery Man
	 * @param DeliveryMan
	 */
	public void deleteDeliveryMan(DeliveryManBean DeliveryMan) {
		int id = Integer.valueOf(DeliveryMan.id);
		MainDTO.deliveryManList.remove(id);
		System.out.println("Delivery Man deleted: " + DeliveryMan);	
	}
	
	/** Method to return a single Delivery Man
	 * @param id
	 * @return
	 */
	public DeliveryManBean getSingleDeliveryMan(String id) {
		for (DeliveryManBean deliveryMan : MainDTO.deliveryManList) {
			if (deliveryMan.getId().equals(id))
				return deliveryMan;
		}
		
		return null;	
	}
	
	/** Method to return all the Delivery Men
	 * @return
	 */
	public ArrayList<DeliveryManBean> getAllDeliveryMan() {
		return MainDTO.deliveryManList;
	}
	
}
