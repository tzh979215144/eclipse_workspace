package org.zhoukan.bean;

public class InvoiceBean {
	private String DEBIT_NOTE_NO = null;
	private String DD_NO = null;
	private String INT_FROM=null;
	private String LOAN_NO = null;
	private String INVOICE_TYPE = null;
	private String CCY =null; 
	private String DUE_DATE = null; 
	private String BILLED_AMT =null;
	private String INT_RATE = null;
	private String recieveMess = null;
	public String getDEBIT_NOTE_NO() {
		return DEBIT_NOTE_NO;
	}
	public void setDEBIT_NOTE_NO(String dEBITNOTENO) {
		DEBIT_NOTE_NO = dEBITNOTENO;
	}
	public String getDD_NO() {
		return DD_NO;
	}
	public void setDD_NO(String dDNO) {
		DD_NO = dDNO;
	}
	public String getINT_FROM() {
		return INT_FROM;
	}
	public void setINT_FROM(String iNTFROM) {
		INT_FROM = iNTFROM;
	}
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
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
	public String getDUE_DATE() {
		return DUE_DATE;
	}
	public void setDUE_DATE(String dUEDATE) {
		DUE_DATE = dUEDATE;
	}
	public String getBILLED_AMT() {
		return BILLED_AMT;
	}
	public void setBILLED_AMT(String bILLEDAMT) {
		BILLED_AMT = bILLEDAMT;
	}
	public String getINT_RATE() {
		return INT_RATE;
	}
	public void setINT_RATE(String iNTRATE) {
		INT_RATE = iNTRATE;
	}
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	
}
