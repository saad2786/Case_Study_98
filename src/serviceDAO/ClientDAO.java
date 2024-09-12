package serviceDAO;


import model.Client;

public interface ClientDAO {
	 void registerClient(Client client);
	 void viewClient();
	 void updateClient(int id);
	 void deleteClient(int id);
}
