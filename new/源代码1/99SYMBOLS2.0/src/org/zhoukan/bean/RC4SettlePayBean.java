package org.zhoukan.bean;

public class RC4SettlePayBean {

	private String ACCT_TYPE ;
	private String SELLE_METHOD; 
	private String BASE_ACCT_NO ;
	private String CCY ;
	private String FREEZE;
	private String NAME;
	public String getACCT_TYPE() {
		return ACCT_TYPE;
	}
	public void setACCT_TYPE(String aCCTTYPE) {
		ACCT_TYPE = aCCTTYPE;
	}
	public String getSELLE_METHOD() {
		return SELLE_METHOD;
	}
	public void setSELLE_METHOD(String sELLEMETHOD) {
		SELLE_METHOD = sELLEMETHOD;
	}
	public String getBASE_ACCT_NO() {
		return BASE_ACCT_NO;
	}
	public void setBASE_ACCT_NO(String bASEACCTNO) {
		BASE_ACCT_NO = bASEACCTNO;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getFREEZE() {
		return FREEZE;
	}
	public void setFREEZE(String fREEZE) {
		FREEZE = fREEZE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
}
