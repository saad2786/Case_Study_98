package serviceDAO;


import model.Claim;

public interface ClaimDAO {
	 void submitClaim(Claim claim);
	 void viewClaim();
	 void updateClaim(int id);
	 void deleteClaim(int id);
	 void updateClaimStatus(int id);

}
