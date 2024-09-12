package serviceDAO;


import model.Policy;

public interface PolicyDAO {
	void addPolicy(Policy policy) ;
	void viewPolicy();
	void updatePolicy(int id) ;
	void deletePolicy(int id);
}
