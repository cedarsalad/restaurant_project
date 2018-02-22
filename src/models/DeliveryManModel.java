package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class DeliveryManModel extends Observable{
	
	private DeliveryManBean deliveryMan;
	private DeliveryManDAO dao;
	private String[] columns = {"ID", "Name", "Telephone", "Area"};
	private ArrayList<DeliveryManBean> data;
	private String[] deliveryManNames;
	private Object[][] dataArray;

	
	public DeliveryManModel() {
		this.dao = DeliveryManDAO.getInstance();
	}
	
	public void addNewDeliveryMan(String name, String telephone, String area) {
		deliveryMan = new DeliveryManBean(name, telephone, area);
		dao.addDeliveryMan(deliveryMan);
	}
	
	public void editDeliveryMan(String id, String name, String telephone, String area) {
		deliveryMan = new DeliveryManBean(id, name, telephone, area);
		dao.editDeliveryMan(deliveryMan);
	}
	
	public void deleteDeliveryMan(String id) {
		deliveryMan = dao.getSingleDeliveryMan(id);
		dao.deleteDeliveryMan(deliveryMan);
	}
	
	public DeliveryManBean getSingleDeliveryMan(String id) {
		return dao.getSingleDeliveryMan(id);
	}
	
	public ArrayList<DeliveryManBean> getAllDeliveryMan(){
		data = dao.getAllDeliveryMan();
		return data;
	}
	
	public Object[][] getData() {
		return dataArray;
	}
	
	public Object[] getDeliveryManNames() {
		return deliveryManNames;
	}
	
	public String[] getColumns() {
		return columns;
	}

    public ArrayList<Object> getAllNames() {
    	
		data = dao.getAllDeliveryMan();
    	deliveryManNames = new String[dao.getAllDeliveryMan().size()];
    	
        for(int i=0; i<data.size(); i++) {
        	DeliveryManBean tempDeliveryMan = data.get(i);
        	deliveryManNames[i] = (Object) tempDeliveryMan.getId() + " - " + tempDeliveryMan.getName(); 
        }
        
        ArrayList<Object> ListRestaurantNames = new ArrayList<Object>(Arrays.asList(deliveryManNames));
        setChanged();
        notifyObservers();
         
        return ListRestaurantNames;
    }
    
    public Object[][] getAllDeliveryManArray() {
    	
		data = dao.getAllDeliveryMan();
        
        for(int i=0; i<data.size(); i++) {
            dataArray[i] =  data.get(i).toArray();   
        }

        setChanged();
        notifyObservers();
         
        return dataArray;
    }
}
	
	
	
	
