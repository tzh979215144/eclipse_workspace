package org.zhoukan.bean;

public class Auto_cl_settleSECBean {

	private int INTERNAL_KEY;
	private int LOAN_KEY;
	private int DD_KEY;
	private String LOAN_NO;
	private String DD_NO;
	private String BASE_ACCT_NO;
	private String CLIENT_NO;
	private String FREEZE;
	private String SETTLE_TYPE;
	private String CLIENT_NAME;
	private String TRAN_DATE;
	
	
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getDD_NO() {
		return DD_NO;
	}
	public void setDD_NO(String dDNO) {
		DD_NO = dDNO;
	}
	public int getINTERNAL_KEY() {
		return INTERNAL_KEY;
	}
	public void setINTERNAL_KEY(int iNTERNALKEY) {
		INTERNAL_KEY = iNTERNALKEY;
	}
	public int getLOAN_KEY() {
		return LOAN_KEY;
	}
	public void setLOAN_KEY(int lOANKEY) {
		LOAN_KEY = lOANKEY;
	}
	public int getDD_KEY() {
		return DD_KEY;
	}
	public void setDD_KEY(int dDKEY) {
		DD_KEY = dDKEY;
	}
	public String getBASE_ACCT_NO() {
		return BASE_ACCT_NO;
	}
	public void setBASE_ACCT_NO(String bASEACCTNO) {
		BASE_ACCT_NO = bASEACCTNO;
	}
	public String getCLIENT_NO() {
		return CLIENT_NO;
	}
	public void setCLIENT_NO(String cLIENTNO) {
		CLIENT_NO = cLIENTNO;
	}
	public String getFREEZE() {
		return FREEZE;
	}
	public void setFREEZE(String fREEZE) {
		FREEZE = fREEZE;
	}
	public String getSETTLE_TYPE() {
		return SETTLE_TYPE;
	}
	public void setSETTLE_TYPE(String sETTLETYPE) {
		SETTLE_TYPE = sETTLETYPE;
	}
	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}
	public void setCLIENT_NAME(String cLIENTNAME) {
		CLIENT_NAME = cLIENTNAME;
	}
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRANDATE) {
		TRAN_DATE = tRANDATE;
	}

}
