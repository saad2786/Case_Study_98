package main;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Services {
	// Policy Services
		public void addPolicy(Policy policy) {
			
		try {
			Connection con  = InitConnection.createConnection();
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO policy (policy_number, type, coverage_amount, premium_amount) VALUES("+policy.getPolicy_number()+", '"+policy.getType()+"', "+ policy.getCoverage_amount()+", "+policy.getPremium_amount()+")";
			int result = stmt.executeUpdate(sql);
            System.out.println("Successful: "+ result);			
            con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		}
		
		public void viewPolicy() {
			try {
				Connection con = InitConnection.createConnection(); 
				Statement stmt = con.createStatement();
				
				String sql = "SELECT * FROM policy";
				ResultSet result = stmt.executeQuery(sql);
	            
	            while(result.next()) {
	            	Policy policy = new Policy(result.getInt(1), result.getInt(2), result.getString(3), result.getInt(4), result.getInt(5));
	            	System.out.println(policy);
	            }
	            con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
		
		public void updatePolicy(int id) {
			try {
				Connection con  = InitConnection.createConnection(); 
				Statement stmt = con.createStatement();
				
				 Scanner sc = new Scanner(System.in);
				 Policy policy = new Policy();
				  System.out.println("Enter Policy Number: ");
				  policy.setPolicy_number(sc.nextInt());
				  sc.nextLine();  

				  System.out.println("Enter Policy Type: ");
				  String type = sc.nextLine();
				  policy.setType(type);

				  System.out.println("Enter Coverage Amount: ");
				  policy.setCoverage_amount(sc.nextInt());
				  sc.nextLine();  

				  System.out.println("Enter Premium Amount: ");
				  policy.setPremium_amount(sc.nextInt());
				  sc.nextLine(); 

				  String sql = "UPDATE policy SET policy_number="+ policy.getPolicy_number()+", type='"+ policy.getType()+"',  coverage_amount="+policy.getCoverage_amount()+", premium_amount= "+ policy.getPremium_amount()+" WHERE policy_id="+ id+";";
				  int result = stmt.executeUpdate(sql);
	              
				  if(result > 0) {
					  System.out.println("Successfully Updated");
				  }
				  else {
					  System.out.println("Not Updated anything");
				  }
				  con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		
		public void deletePolicy(int id) {
			
			try {
				Connection con  = InitConnection.createConnection();
				Statement stmt = con.createStatement();
				String sql = "DELETE FROM policy WHERE policy_id="+ id+";";
				
			    int result = stmt.executeUpdate(sql);
                if(result > 0 ) {
                	System.out.println("Policy Deleted Successfully");
                }
                else {
                	System.out.println("You have given invalid Id");
                }
                con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		// Client Services
		public void registerClient(Client client) {
			try {
				Connection con  = InitConnection.createConnection();
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
				// TODO: handle exception
				System.out.println(e);
			}
		}
		public void viewClient() {
			try {
				Connection con = InitConnection.createConnection(); 
				Statement stmt = con.createStatement();
				
				String sql = "SELECT * FROM client;";
				ResultSet result = stmt.executeQuery(sql);
	            
	            while(result.next()) {
	            	Client client = new Client(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
	            	System.out.println(client);
	            }
	            con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		
		public void updateClient(int id) {
			try {
				Connection con  = InitConnection.createConnection(); 
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
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
		
		public void deleteClient(int id) {
			try {
				Connection con  = InitConnection.createConnection();
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
				// TODO: handle exception
			}
			
			
		}
		
		// Claim Services
		public void submitClaim(Claim claim) {
			try {
				Connection con  = InitConnection.createConnection();
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
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println("Invalid policy_id or client_id");
			}

			
		}
		public void viewClaim() {
			try {
				Connection con = InitConnection.createConnection(); 
				Statement stmt = con.createStatement();
				
				String sql = "SELECT * FROM claim;";
				ResultSet result = stmt.executeQuery(sql);
	            
	            while(result.next()) {
	            	Claim claim= new Claim(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4), result.getString(5));
	            	System.out.println(claim);
	            }
	            con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
			
		public void updateClaim(int id) {
			try {
				Connection con  = InitConnection.createConnection(); 
				Statement stmt = con.createStatement();
				
				Services services = new Services();
				 Scanner sc = new Scanner(System.in);
				 Claim claim = new Claim();
				  
				  services.viewPolicy();
				  System.out.println("Enter Policy Id (Only available policies are allowed): ");
				  int policy_id = sc.nextInt();
				  claim.setPolicy_id(policy_id);

				  services.viewClient();
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
				// TODO: handle exception
				System.out.println(e);
			}
		}
			
		public void deleteClaim(int id) {
			try {
				Connection con  = InitConnection.createConnection();
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
				// TODO: handle exception
				System.out.println(e);
			}
		}
		public void updateClaimStatus(int id) {
			try {
				  Connection con  = InitConnection.createConnection(); 
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
				// TODO: handle exception
				System.out.println(e);
			}
		}
}
