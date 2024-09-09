package model;

public class Policy {
	private int policy_id;
	private int	policy_number;
    private String type;
	private int coverage_amount;
	private int	premium_amount;

	public Policy() {
		super();
	}
	
	public Policy(int policy_id, int policy_number, String type, int coverage_amount, int premium_amount) {
		super();
		this.policy_id = policy_id;
		this.policy_number = policy_number;
		this.type = type;
		this.coverage_amount = coverage_amount;
		this.premium_amount = premium_amount;
	}
	
	public Policy( int policy_number, String type, int coverage_amount, int premium_amount) {
		super();
		this.policy_number = policy_number;
		this.type = type;
		this.coverage_amount = coverage_amount;
		this.premium_amount = premium_amount;
	}
	
	public int getPolicy_number() {
		return policy_number;
	}
	
	public void setPolicy_number(int policy_number) {
		this.policy_number = policy_number;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "{ policy_id=" + policy_id + ", policy_number=" + policy_number + ", type=" + type
				+ ", coverage_amount=" + coverage_amount + ", premium_amount=" + premium_amount + " }";
	}

	public int getCoverage_amount() {
		return coverage_amount;
	}
	
	public void setCoverage_amount(int coverage_amount) {
		this.coverage_amount = coverage_amount;
	}
	
	public int getPremium_amount() {
		return premium_amount;
	}
	
	public void setPremium_amount(int premium_amount) {
		this.premium_amount = premium_amount;
	}


}
