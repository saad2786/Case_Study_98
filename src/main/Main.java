package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Services services = new Services();
		
			try {
	      int opt;
	      boolean iteration = true;
	      Scanner sc = new Scanner(System.in);
	     
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

					  services.addPolicy(policy);
					  	
				      break;
				  }
				
			     case 2: {
					services.viewPolicy();
					break;
				  }
				  case 3: {
					  services.viewPolicy();
					  System.out.println("Enter Policy Id to be updated:");
					  int id = sc.nextInt();
					  services.updatePolicy(id);
						break;
					  }
				  case 4: {
					  services.viewPolicy();
					  System.out.println("Enter Policy Id to be deleted:");
					  int id = sc.nextInt();
					  services.deletePolicy(id);
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
					  client.setPhone_number(phone);;
				 

					  System.out.println("Enter Client Address: ");
					  String address = sc.nextLine();
					  client.setAddress(address);
					    

					  services.registerClient(client);
					  	
						break;
					  }
				  case 6: {
					  services.viewClient();
						break;
					  }
				  case 7: {
					  services.viewClient();
					  System.out.println("Enter Client Id to be updated:");
					  int id = sc.nextInt();
					  services.updateClient(id);
						break;
					  }
				  case 8: {
					  services.viewClient();
					  System.out.println("Enter Client Id to be deleted:");
					   int id = sc.nextInt();
					   services.deleteClient(id);
						break;
					  }
				  case 9: {
					  
					  Claim claim = new Claim();
					  sc.nextLine();  
					  services.viewPolicy();
					  System.out.println("Enter Policy Id (Only available policies are allowed): ");
					  int policy_id = sc.nextInt();
					  claim.setPolicy_id(policy_id);

					  services.viewClient();
					  System.out.println("Enter Client Id(Only available policies are allowed): ");
					  int client_id = sc.nextInt();
					  claim.setClient_id(client_id);
					  
					
					  String pattern = "yyyy-MM-dd";
					  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					  claim.setClaim_date( simpleDateFormat.format(new Date()));;
					  sc.nextLine();

					  System.out.println("Enter Claim Status ( submitted / processed): ");
					  String status = sc.nextLine();
					  claim.setStatus(status);	
					    

					  services.submitClaim(claim);
					  	
						break;
					  }
				  case 10: {
					  services.viewClaim();
						break;
					  }
				  case 11: {
					  services.viewClaim();
					  System.out.println("Enter Claim Id to be updated:");
					  int id = sc.nextInt();
					  services.updateClaim(id);
						break;
					  }
				  case 12: {
					  services.viewClaim();
					  System.out.println("Enter Claim Id to be deleted:");
					   int id = sc.nextInt();
					   services.deleteClaim(id);
						break;
					  }
				  case 13: {
					  services.viewClaim();
					  System.out.println("Enter Claim Id to be updated:");
					  int id = sc.nextInt();
					  services.updateClaimStatus(id);
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
			
				  e.printStackTrace();
			  }

			
	}

}
