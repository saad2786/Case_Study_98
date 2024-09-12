package serviceDAOImps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import main.InitConnection;
import main.PrintTable;
import model.Client;
import serviceDAO.ClientDAO;

public class ClientDAOImps implements ClientDAO {
	public void registerClient(Client client) {
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			System.out.println(client);
			String sql = "INSERT INTO client (name, email, phone, address) VALUES('"+client.getName()+"', '"+client.getEmail()+"', '"+ client.getPhone_number()+"', '"+client.getAddress()+"')";
			int result = stmt.executeUpdate(sql);
			if( result > 0) {
				 System.out.println("Successully registerd");			
			}
			else {
				System.out.println("Something went wrong");
			}
			con.close();
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
	}
	public void viewClient() {
		try {
			Connection con = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM client;";
			ResultSet result = stmt.executeQuery(sql);
            
//            while(result.next()) {
//            	Client client = new Client(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
//            	System.out.println(client);
//            }
			ArrayList<ArrayList<String>> data = new ArrayList<>();

			while(result.next()) {
				ArrayList<String> row = new ArrayList<>();
				row.add(result.getString(1));
				row.add(result.getString(2));
				row.add(result.getString(3));
				row.add(result.getString(4));

				data.add(row);
			}
			ArrayList<String> headings = new ArrayList<>();
			headings.add("ClientId");
			headings.add("Name");
			headings.add("Phone");
			headings.add("Address");
			System.out.println("Table: Client");
			PrintTable.printTable(headings,data);
			System.out.println();
            con.close();
		} 
		catch (Exception e) {

			System.err.println(e.getMessage());
		}
	}
	
	public void updateClient(int id) {
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			
			 Scanner sc = new Scanner(System.in);
			 Client client = new Client();
			 
			  System.out.println("Enter Client Name: ");
			  String name = sc.nextLine();
			  client.setName(name);

			  System.out.println("Enter Client Email Id: ");
			  String email = sc.nextLine();
			  client.setEmail(email);
			  

			  System.out.println("Enter Phone Number: ");
			  String phone = sc.nextLine();
			  client.setPhone_number(phone);;
		 

			  System.out.println("Enter Client Address: ");
			  String address = sc.nextLine();
			  client.setAddress(address);
			    
			  String sql = "UPDATE client SET name='"+ client.getName()+"', email='"+ client.getEmail()+"',  phone='"+client.getPhone_number()+"', address= '"+ client.getAddress()+"' WHERE client_id="+ id+";";
			  int result = stmt.executeUpdate(sql);
              
			  if(result > 0) {
				  System.out.println("Successfully Updated");
			  }
			  else {
				  System.out.println("You have given invalid Id");
			  }
			  con.close();
		} 
		catch (Exception e) {

			System.err.println(e.getMessage());
		}
		
	}
	
	public void deleteClient(int id) {
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			String sql = "DELETE FROM client WHERE client_id="+ id+";";
			
		    int result = stmt.executeUpdate(sql);
            if(result > 0 ) {
            	System.out.println("Client Deleted Successfully");
            }
            else {
            	System.out.println("You have given invalid Id");
            }
            con.close();
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
		
		
	}
}
