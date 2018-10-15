package org.zhoukan.bean;

public class settlePayBean {
	private String LOAN_NO=null;
	private String BRANCH=null;
	private String CLIENT=null;
	private String NAME=null;
	private int SETTLE_AMT=0;
	private String BASE_ACCT_NO=null;
	private int DD_NO=0;
	private String LOAN_TYPE=null;
	private String LOAN_SUB_TYPE=null;
	private String USER_ID=null;
	private float INT_RATE=0;
	private String CCY=null;
	private int DD_AMT=0;
	private String recieveMess = null;
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getCLIENT() {
		return CLIENT;
	}
	public void setCLIENT(String cLIENT) {
		CLIENT = cLIENT;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getSETTLE_AMT() {
		return SETTLE_AMT;
	}
	public void setSETTLE_AMT(int sETTLEAMT) {
		SETTLE_AMT = sETTLEAMT;
	}
	public String getBASE_ACCT_NO() {
		return BASE_ACCT_NO;
	}
	public void setBASE_ACCT_NO(String bASEACCTNO) {
		BASE_ACCT_NO = bASEACCTNO;
	}
	public int getDD_NO() {
		return DD_NO;
	}
	public void setDD_NO(int dDNO) {
		DD_NO = dDNO;
	}
	public String getLOAN_TYPE() {
		return LOAN_TYPE;
	}
	public void setLOAN_TYPE(String lOANTYPE) {
		LOAN_TYPE = lOANTYPE;
	}
	public String getLOAN_SUB_TYPE() {
		return LOAN_SUB_TYPE;
	}
	public void setLOAN_SUB_TYPE(String lOANSUBTYPE) {
		LOAN_SUB_TYPE = lOANSUBTYPE;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}
	public float getINT_RATE() {
		return INT_RATE;
	}
	public void setINT_RATE(float iNTRATE) {
		INT_RATE = iNTRATE;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getCCY() {
		return CCY;
	}
	public void setDD_AMT(int dD_AMT) {
		DD_AMT = dD_AMT;
	}
	public int getDD_AMT() {
		return DD_AMT;
	}

	
}
