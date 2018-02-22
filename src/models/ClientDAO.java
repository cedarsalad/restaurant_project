package models;

import java.util.ArrayList;

public class ClientDAO {
	private static ClientDAO instance = null;
	
	private ClientDAO() {
	}
	
	public static ClientDAO getIntance() {
		if(instance == null) 
			instance = new ClientDAO();
		
		return instance;
	}
	
	public void addClient(ClientBean client) {
		int id = MainDTO.id;
		MainDTO.id ++;
		client.setId(id+"");
		MainDTO.clientList.add(client);
		System.out.println("New Client added: " + client);
	}
	
	public void editClient(ClientBean client) {
		int index;
		for (ClientBean existingClient: MainDTO.clientList) {
			if (existingClient.getId().equals(client.getId())) {
				index = MainDTO.clientList.indexOf(existingClient);
				MainDTO.clientList.set(index, client);
				System.out.println("Client edited: " + client);
				break;
			}
		} 
	}
	
	public void deleteClient(ClientBean client) {
		MainDTO.clientList.remove(client);
		System.out.println("Client Deleted: " + client.toString());
	}
	
	public ClientBean getSingleClient(String id) {
		System.out.println("LOOKINGFORCLIENT with id " + id);
		for (ClientBean client : MainDTO.clientList) {
			System.out.println(client.toString());
			if (client.getId().equals(id))
				return client;
		}
		
		return null;	
	}
	
	public ArrayList<ClientBean> getAllClients(){
		return MainDTO.clientList;
	}
	
}
