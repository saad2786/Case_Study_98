package serviceDAOImps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import main.InitConnection;

import main.PrintTable;
import model.Claim;
import serviceDAO.ClaimDAO;
import serviceDAO.ClientDAO;
import serviceDAO.PolicyDAO;

public class ClaimDAOImps implements ClaimDAO {
	public void submitClaim(Claim claim) {
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			System.out.println(claim);
			String sql = "INSERT INTO claim (policy_id, client_id, claim_date, status) VALUES("+claim.getPolicy_id()+", "+claim.getClient_id()+", '"+ claim.getClaim_date()+"', '"+claim.isStatus()+"')";
			int result = stmt.executeUpdate(sql);
			if( result > 0) {
				 System.out.println("Successully submitted");			
			}
			else {
				System.out.println("Something went wrong");
			}
			con.close();
		} catch (Exception e) {	

			System.out.println(e.getMessage());
			System.out.println("Invalid policy_id or client_id");
		}

		
	}
	public void viewClaim() {
		try {
			Connection con = InitConnection.createConnection();
            assert con != null;
            Statement    stmt = con.createStatement();


            String sql = "SELECT * FROM claim;";
			ResultSet result = stmt.executeQuery(sql);

//            while(result.next()) {
//            	Claim claim= new Claim(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4), result.getString(5));
//            	System.out.println(claim);
//            }
			ArrayList<ArrayList<String>> data = new ArrayList<>();

			while(result.next()) {
				ArrayList<String> row = new ArrayList<>();
				row.add(result.getString(1));
				row.add(result.getString(2));
				row.add(result.getString(3));
				row.add(result.getString(4));
				row.add(result.getString(5));
				data.add(row);
			}
			ArrayList<String> headings = new ArrayList<>();
			headings.add("ClaimId");
			headings.add("PolicyId");
			headings.add("ClientId");
			headings.add("Date");
			headings.add("Status");
			System.out.println("Table: Claim");
			PrintTable.printTable(headings,data);
			System.out.println();
            con.close();
		}
		catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
		
	public void updateClaim(int id) {
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			
		PolicyDAO policydao = new PolicyDAOImps();
		ClientDAO clientdao = new ClientDAOImps();
			 Scanner sc = new Scanner(System.in);
			 Claim claim = new Claim();
			  
			  policydao.viewPolicy();
			  System.out.println("Enter Policy Id (Only available policies are allowed): ");
			  int policy_id = sc.nextInt();
			  claim.setPolicy_id(policy_id);

			  clientdao.viewClient();
			  System.out.println("Enter Client Id(Only available clients are allowed): ");
			  int client_id = sc.nextInt();
			  claim.setClient_id(client_id);
			  sc.nextLine();
			  
			
			  System.out.println("Enter Claim Date(yyyy-MM-dd): ");
			  String claim_date = sc.nextLine();
			  claim.setClaim_date(claim_date);
		 

			  System.out.println("Enter Claim Status (  Submitted /  Processed): ");
			  String status = sc.nextLine();
			  claim.setStatus(status);
			    
			  String sql = "UPDATE claim SET policy_id="+ claim.getPolicy_id()+", client_id="+ claim.getClient_id()+",  claim_date='"+claim.getClaim_date()+"', status= '"+ claim.isStatus()+"' WHERE claim_id="+ id+";";
			  int result = stmt.executeUpdate(sql);
              System.out.println(result);
			  if(result > 0) {
				  System.out.println("Successfully Updated");
			  }
			  else {
				  System.out.println("You have given invalid Id");
			  }
			  con.close();
		} 
		catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
		
	public void deleteClaim(int id) {
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			String sql = "DELETE FROM claim WHERE claim_id="+ id+";";
			
		    int result = stmt.executeUpdate(sql);
            if(result > 0 ) {
            	System.out.println("Claim Deleted Successfully");
            }
            else {
            	System.out.println("You have given invalid Id");
            }
            con.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	public void updateClaimStatus(int id) {
		try {
			  Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			    
			  String sql = "UPDATE claim SET status= 'processed' WHERE claim_id="+ id+";";
			  int result = stmt.executeUpdate(sql);
              System.out.println(result);
			  if(result > 0) {
				  System.out.println("Successfully status Updated");
			  }
			  else {
				  System.out.println("You have given invalid Id");
			  }
              
			  con.close();
		} 
		catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
