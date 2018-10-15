package org.zhoukan.bean;

public class CL_PAID_INVOICEBEAN {
	private String  INTERNAL_KEY;
	private int DD_KEY;
	private String DD_NO;
	private int LOAN_KEY;
	private String LOAN_NO;
	private String BORROWER;
	private String INVOICE_TYPE;
	private String CCY;
	private String  RECEIPT_NO;
	private String   PAID_AMT;
	public String getINTERNAL_KEY() {
		return INTERNAL_KEY;
	}
	public void setINTERNAL_KEY(String iNTERNALKEY) {
		INTERNAL_KEY = iNTERNALKEY;
	}
	public int getDD_KEY() {
		return DD_KEY;
	}
	public void setDD_KEY(int dDKEY) {
		DD_KEY = dDKEY;
	}
	public String getDD_NO() {
		return DD_NO;
	}
	public void setDD_NO(String dDNO) {
		DD_NO = dDNO;
	}
	public int getLOAN_KEY() {
		return LOAN_KEY;
	}
	public void setLOAN_KEY(int lOANKEY) {
		LOAN_KEY = lOANKEY;
	}
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getBORROWER() {
		return BORROWER;
	}
	public void setBORROWER(String bORROWER) {
		BORROWER = bORROWER;
	}
	public String getINVOICE_TYPE() {
		return INVOICE_TYPE;
	}
	public void setINVOICE_TYPE(String iNVOICETYPE) {
		INVOICE_TYPE = iNVOICETYPE;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getRECEIPT_NO() {
		return RECEIPT_NO;
	}
	public void setRECEIPT_NO(String rECEIPTNO) {
		RECEIPT_NO = rECEIPTNO;
	}
	public String getPAID_AMT() {
		return PAID_AMT;
	}
	public void setPAID_AMT(String pAIDAMT) {
		PAID_AMT = pAIDAMT;
	}
	
	
}
