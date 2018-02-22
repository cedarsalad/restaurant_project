package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class ClientModel extends Observable{
	private ClientBean client;
	private ClientDAO dao;
	private ArrayList<ClientBean> data;
	
	public ClientModel() {
		this.dao = ClientDAO.getIntance();
	}
	
	public void addNewClient(String firstName, String lastName, String address, String email, String phone) {
		client = new ClientBean(firstName, lastName, address, email, phone);
		dao.addClient(client);
	}
	
	public void editClient(String id, String firstName, String lastName, String address, String email, String phone) {
		client = new ClientBean(id, firstName, lastName, address, email, phone);
		dao.editClient(client);
	}
	
	public void deleteClient(String id) {
		client = dao.getSingleClient(id);
		dao.deleteClient(client);
	}
	
	public ClientBean getSingleClient(String id) {
		client = dao.getSingleClient(id);
		return client;
	}
	
	public ArrayList<ClientBean> getAllClients() {
		data = dao.getAllClients();
				
		setChanged();
		notifyObservers();
		
		return data;
	}
	
}
