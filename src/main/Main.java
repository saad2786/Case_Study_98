package main;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Claim;
import model.Client;
import model.Policy;
import serviceDAO.ClaimDAO;
import serviceDAO.ClientDAO;
import serviceDAO.PolicyDAO;
import serviceDAOImps.ClaimDAOImps;
import serviceDAOImps.ClientDAOImps;
import serviceDAOImps.PolicyDAOImps;

public class Main {
	public static void main(String[] args) {
	
		
			try {
	      int opt;
	      boolean iteration = true;
	      Scanner sc = new Scanner(System.in);
	      ClientDAO clientdao = new ClientDAOImps();
	      PolicyDAO policydao = new PolicyDAOImps();
	      ClaimDAO claimdao = new ClaimDAOImps();
			while(iteration) {
				System.out.println("Perform Operations: ");
				System.out.println("1. Create New Policy ");
	            System.out.println("2. Get All Policy Details ");
				System.out.println("3. Update Policy ");
				System.out.println("4. Delete Policy ");
				System.out.println("===================");
				System.out.println("5. Register New Client ");
	            System.out.println("6. Get All Client Details ");
				System.out.println("7. Update Client ");
				System.out.println("8. Delete Client ");
				System.out.println("===================");
				System.out.println("9.  Submit Claim ");
	            System.out.println("10. Get All Claims Details ");
				System.out.println("11. Update Claim ");
				System.out.println("12. Delete Claim ");
				System.out.println("13. Process Claim");
	            System.out.println("0. Exit");
				opt = sc.nextInt();
				switch(opt) {
				
				  case 0:{
					iteration = false;
					System.out.println("Have a good day!");
					System.out.println("----------------- Program terminated -------------");
					break;
				   }
				  case 1: 
				  {
					  
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

					  policydao.addPolicy(policy);
					  	
				      break;
				  }
				
			     case 2: {
					  

					policydao.viewPolicy();
					break;
				  }
				  case 3: {
					
					  policydao.viewPolicy();
					  System.out.println("Enter Policy Id to be updated:");
					  int id = sc.nextInt();
					  policydao.updatePolicy(id);
						break;
					  }
				  case 4: {
				
					  policydao.viewPolicy();
					  System.out.println("Enter Policy Id to be deleted:");
					  int id = sc.nextInt();
					  policydao.deletePolicy(id);
						break;
					  }
				  case 5: {
			
					  Client client = new Client();
					  sc.nextLine();  
					  System.out.println("Enter Client Name: ");
					  String name = sc.nextLine();
					  client.setName(name);

					  System.out.println("Enter Client Email Id: ");
					  String email = sc.nextLine();
					  client.setEmail(email);
					  

					  System.out.println("Enter Phone Number: ");
					  String phone = sc.nextLine();
					  client.setPhone_number(phone);
				 

					  System.out.println("Enter Client Address: ");
					  String address = sc.nextLine();
					  client.setAddress(address);
					    

					  clientdao.registerClient(client);
					  	
						break;
					  }
				  case 6: {
			
					  clientdao.viewClient();
						break;
					  }
				  case 7: {
					
					  clientdao.viewClient();
					  System.out.println("Enter Client Id to be updated:");
					  int id = sc.nextInt();
					  clientdao.updateClient(id);
						break;
					  }
				  case 8: {
			
					  clientdao.viewClient();
					  System.out.println("Enter Client Id to be deleted:");
					   int id = sc.nextInt();
					   clientdao.deleteClient(id);
						break;
					  }
				  case 9: {
					  
					  Claim claim = new Claim();
					  sc.nextLine();  
					  policydao.viewPolicy();
					  System.out.println("Enter Policy Id (Only available policies are allowed): ");
					  int policy_id = sc.nextInt();
					  claim.setPolicy_id(policy_id);

					  clientdao.viewClient();
					  System.out.println("Enter Client Id(Only available policies are allowed): ");
					  int client_id = sc.nextInt();
					  claim.setClient_id(client_id);
					  
					
					  String pattern = "yyyy-MM-dd";
					  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					  claim.setClaim_date( simpleDateFormat.format(new Date()));
					  sc.nextLine();

					  System.out.println("Enter Claim Status ( submitted / processed): ");
					  String status = sc.nextLine();
					  claim.setStatus(status);	
					    

					  claimdao.submitClaim(claim);
					  	
						break;
					  }
				  case 10: {
					  claimdao.viewClaim();
						break;
					  }
				  case 11: {
					  claimdao.viewClaim();
					  System.out.println("Enter Claim Id to be updated:");
					  int id = sc.nextInt();
					  claimdao.updateClaim(id);
						break;
					  }
				  case 12: {
					  claimdao.viewClaim();
					  System.out.println("Enter Claim Id to be deleted:");
					   int id = sc.nextInt();
					   claimdao.deleteClaim(id);
						break;
					  }
				  case 13: {
					  claimdao.viewClaim();
					  System.out.println("Enter Claim Id to be updated:");
					  int id = sc.nextInt();
					  claimdao.updateClaimStatus(id);
						break;
					  }
					  case 14: {
						  ArrayList<String> headings = new ArrayList<>();
						  ArrayList<String> row = new ArrayList<>();
						  headings.add("Id");
						  headings.add("name");
						  headings.add("phone");
						  headings.add("address");

						  row.add("1");
						  row.add("saad");
						  row.add("2342324");
						  row.add("VAddi");

						  ArrayList<ArrayList<String>> data = new ArrayList<>();
						 data.add(row);
						 PrintTable.printTable(headings, data);
						break;
					  }
				  default:{
					System.out.println("Invalid Option, Choose valid option");
					break;
				  }
				}

			}
			sc.close();
			
			  } catch (Exception e) {
				System.err.println(e.getMessage());
			  }

			
	}

}
