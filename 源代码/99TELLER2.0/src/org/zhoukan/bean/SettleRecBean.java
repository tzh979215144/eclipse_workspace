package org.zhoukan.bean;

public class SettleRecBean {
	private String LOAN_NO=null;
	private String RECEIPT_NO=null;
	private String ORIG_BORRPWER=null;
	private String LENDER=null;
	private String DEBIT_NOTE_NO=null;
	private String recieveMess = null;
	private String INVOICE_TYPE=null;
	private String BILLED_AMT=null;
	private String ACCT_NO=null;
	private int ACCT_AMT;
	private String CLIENT=null;
	private String OTH_ACCT_NO=null;
	private int OTH_ACCT_AMT;
	private String OTH_CLIENT=null;
	private int MONEY;
	private String OUTSTANDING=null;

	public String getOUTSTANDING() {
		return OUTSTANDING;
	}
	public void setOUTSTANDING(String oUTSTANDING) {
		OUTSTANDING = oUTSTANDING;
	}
	public String getACCT_NO() {
		return ACCT_NO;
	}
	public void setACCT_NO(String aCCTNO) {
		ACCT_NO = aCCTNO;
	}
	public int getACCT_AMT() {
		return ACCT_AMT;
	}
	public void setACCT_AMT(int aCCTAMT) {
		ACCT_AMT = aCCTAMT;
	}
	public String getCLIENT() {
		return CLIENT;
	}
	public void setCLIENT(String cLIENT) {
		CLIENT = cLIENT;
	}
	public String getOTH_ACCT_NO() {
		return OTH_ACCT_NO;
	}
	public void setOTH_ACCT_NO(String oTHACCTNO) {
		OTH_ACCT_NO = oTHACCTNO;
	}
	public int getOTH_ACCT_AMT() {
		return OTH_ACCT_AMT;
	}
	public void setOTH_ACCT_AMT(int oTHACCTAMT) {
		OTH_ACCT_AMT = oTHACCTAMT;
	}
	public String getOTH_CLIENT() {
		return OTH_CLIENT;
	}
	public void setOTH_CLIENT(String oTHCLIENT) {
		OTH_CLIENT = oTHCLIENT;
	}
	public int getMONEY() {
		return MONEY;
	}
	public void setMONEY(int mONEY) {
		MONEY = mONEY;
	}
	public int getOTH_MONEY() {
		return OTH_MONEY;
	}
	public void setOTH_MONEY(int oTHMONEY) {
		OTH_MONEY = oTHMONEY;
	}
	private int OTH_MONEY;
	
	public String getORIG_BORRPWER() {
		return ORIG_BORRPWER;
	}
	public void setORIG_BORRPWER(String oRIGBORRPWER) {
		ORIG_BORRPWER = oRIGBORRPWER;
	}
	public String getLENDER() {
		return LENDER;
	}
	public void setLENDER(String lENDER) {
		LENDER = lENDER;
	}
	public String getDEBIT_NOTE_NO() {
		return DEBIT_NOTE_NO;
	}
	public void setDEBIT_NOTE_NO(String dEBITNOTENO) {
		DEBIT_NOTE_NO = dEBITNOTENO;
	}
	public String getINVOICE_TYPE() {
		return INVOICE_TYPE;
	}
	public void setINVOICE_TYPE(String iNVOICETYPE) {
		INVOICE_TYPE = iNVOICETYPE;
	}
	public String getBILLED_AMT() {
		return BILLED_AMT;
	}
	public void setBILLED_AMT(String bILLEDAMT) {
		BILLED_AMT = bILLEDAMT;
	}
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getRECEIPT_NO() {
		return RECEIPT_NO;
	}
	public void setRECEIPT_NO(String rECEIPTNO) {
		RECEIPT_NO = rECEIPTNO;
	}
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	
}
