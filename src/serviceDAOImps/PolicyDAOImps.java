package serviceDAOImps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import main.InitConnection;
import main.PrintTable;
import model.Policy;
import serviceDAO.PolicyDAO;

public class PolicyDAOImps implements PolicyDAO {
	public void addPolicy(Policy policy) {
		
		try {
			Connection con  = InitConnection.createConnection();
            assert con != null;
            Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO policy (policy_number, type, coverage_amount, premium_amount) VALUES("+policy.getPolicy_number()+", '"+policy.getType()+"', "+ policy.getCoverage_amount()+", "+policy.getPremium_amount()+")";
			int result = stmt.executeUpdate(sql);
            System.out.println("Successful: "+ result);			
            con.close();
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
		}
		
		public void viewPolicy() {
			try {
				Connection con = InitConnection.createConnection();
                assert con != null;
                Statement stmt = con.createStatement();

				String sql = "SELECT * FROM policy";
				ResultSet result = stmt.executeQuery(sql);

//	            while(result.next()) {
//	            	Policy policy = new Policy(result.getInt(1), result.getInt(2), result.getString(3), result.getInt(4), result.getInt(5));
//					System.out.println(policy);
//				}

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
				headings.add("PolicyId");
				headings.add("PolicyNo");
				headings.add("Type");
				headings.add("CovgAmt");
				headings.add("PremAmt");
				System.out.println("Table: Policy");
				PrintTable.printTable(headings,data);
				System.out.println();
	            con.close();
			} 
			catch (Exception e) {

				System.err.println(e.getMessage());
			}
			
		}
		
		public void updatePolicy(int id) {
			try {
				Connection con  = InitConnection.createConnection();
                assert con != null;
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

				System.err.println(e.getMessage());
			}
		}
		
		public void deletePolicy(int id) {
			
			try {
				Connection con  = InitConnection.createConnection();
                assert con != null;
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

				System.err.println(e.getMessage());
			}
			
		}
		
}
