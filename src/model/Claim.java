package model;

import java.util.Date;

public class Claim {
	private int claim_id;
	private	int policy_id  ;
	private	int client_id  ;
	private	String claim_date;
	private	String status  ;
	
	public Claim() {
		super();
	}
	
	public Claim(int policy_id, int client_id, String date, String status) {
		super();
		this.policy_id = policy_id;
		this.client_id = client_id;
		this.claim_date = claim_date;
		this.status = status;
	}
	
	public Claim(int claim_id, int policy_id, int client_id, String claim_date, String status) {
		super();
		this.claim_id = claim_id;
		this.policy_id = policy_id;
		this.client_id = client_id;
		this.claim_date = claim_date;
		this.status = status;
	}
	
	public int getPolicy_id() {
		return policy_id;
	}
	
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	
	public int getClient_id() {
		return client_id;
	}
	
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	
	public String getClaim_date() {
		return claim_date;
	}
	
	public void setClaim_date(String claim_date) {
		this.claim_date = claim_date;
	}
	
	public String isStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "{ claim_id=" + claim_id + ", policy_id=" + policy_id + ", client_id=" + client_id + ", claim_date="
				+ claim_date + ", status=" + status + " }";
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
