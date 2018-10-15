package org.zhoukan.bean;

import java.util.Date;

public class CL_RECEIPT_TBLBean {
	public String getRECEIPT_KEY() {
		return RECEIPT_KEY;
	}

	public void setRECEIPT_KEY(String rECEIPT_KEY) {
		RECEIPT_KEY = rECEIPT_KEY;
	}

	public String getRECEIPT_NO() {
		return RECEIPT_NO;
	}

	public void setRECEIPT_NO(String rECEIPT_NO) {
		RECEIPT_NO = rECEIPT_NO;
	}

	public String getLOAN_KEY() {
		return LOAN_KEY;
	}

	public void setLOAN_KEY(String lOAN_KEY) {
		LOAN_KEY = lOAN_KEY;
	}

	private String RECEIPT_KEY;
	private String RECEIPT_NO;
	private String LOAN_KEY;
	private String PAYER;
	private String RECEIPT;
	private String CCY;
	private String RECEIPT_DATE;
	private String DEBIT_NOTE_NO;
	public String getDEBIT_NOTE_NO() {
		return DEBIT_NOTE_NO;
	}

	public void setDEBIT_NOTE_NO(String dEBITNOTENO) {
		DEBIT_NOTE_NO = dEBITNOTENO;
	}

	public String getRECEIPT_DATE() {
		return RECEIPT_DATE;
	}

	public void setRECEIPT_DATE(String rECEIPT_DATE) {
		RECEIPT_DATE = rECEIPT_DATE;
	}

	public String getTRAN_DATE() {
		return TRAN_DATE;
	}

	public void setTRAN_DATE(String tRAN_DATE) {
		TRAN_DATE = tRAN_DATE;
	}

	private String TRAN_DATE;
	private String RECEIPT_AMT;
	private String NARRATIVE;
	private String CLEARED;
	private String PRINT_YN;
	private String ADVICE_SENT;
	private String GL_POSTED;
	private String USER_ID;
	private String LAST_CHANGE_DATE;
	private String VERIFY;
	private String SETTLED;
	private String RECEIPT_CEN_CODE;
	private String REV_REC;
	private Date REV_REC_DATE;
	private String BANK_SEQ_NO;
	private String VERIFY_USER_ID;
	private String SETTLED_USER_ID;
	private String REASON_DESC;

	public String getPAYER() {
		return PAYER;
	}

	public void setPAYER(String pAYER) {
		PAYER = pAYER;
	}

	public String getLAST_CHANGE_DATE() {
		return LAST_CHANGE_DATE;
	}

	public void setLAST_CHANGE_DATE(String lAST_CHANGE_DATE) {
		LAST_CHANGE_DATE = lAST_CHANGE_DATE;
	}

	public String getRECEIPT() {
		return RECEIPT;
	}

	public void setRECEIPT(String rECEIPT) {
		RECEIPT = rECEIPT;
	}

	public String getCCY() {
		return CCY;
	}

	public void setCCY(String cCY) {
		CCY = cCY;
	}

	public String getRECEIPT_AMT() {
		return RECEIPT_AMT;
	}

	public void setRECEIPT_AMT(String rECEIPTAMT) {
		RECEIPT_AMT = rECEIPTAMT;
	}

	public String getNARRATIVE() {
		return NARRATIVE;
	}

	public void setNARRATIVE(String nARRATIVE) {
		NARRATIVE = nARRATIVE;
	}

	public String getCLEARED() {
		return CLEARED;
	}

	public void setCLEARED(String cLEARED) {
		CLEARED = cLEARED;
	}

	public String getPRINT_YN() {
		return PRINT_YN;
	}

	public void setPRINT_YN(String pRINTYN) {
		PRINT_YN = pRINTYN;
	}

	public String getADVICE_SENT() {
		return ADVICE_SENT;
	}

	public void setADVICE_SENT(String aDVICESENT) {
		ADVICE_SENT = aDVICESENT;
	}

	public String getGL_POSTED() {
		return GL_POSTED;
	}

	public void setGL_POSTED(String gLPOSTED) {
		GL_POSTED = gLPOSTED;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}

	public String getVERIFY() {
		return VERIFY;
	}

	public void setVERIFY(String vERIFY) {
		VERIFY = vERIFY;
	}

	public String getSETTLED() {
		return SETTLED;
	}

	public void setSETTLED(String sETTLED) {
		SETTLED = sETTLED;
	}

	public String getRECEIPT_CEN_CODE() {
		return RECEIPT_CEN_CODE;
	}

	public void setRECEIPT_CEN_CODE(String rECEIPTCENCODE) {
		RECEIPT_CEN_CODE = rECEIPTCENCODE;
	}

	public String getREV_REC() {
		return REV_REC;
	}

	public void setREV_REC(String rEVREC) {
		REV_REC = rEVREC;
	}

	public Date getREV_REC_DATE() {
		return REV_REC_DATE;
	}

	public void setREV_REC_DATE(Date rEVRECDATE) {
		REV_REC_DATE = rEVRECDATE;
	}

	public String getBANK_SEQ_NO() {
		return BANK_SEQ_NO;
	}

	public void setBANK_SEQ_NO(String bANKSEQNO) {
		BANK_SEQ_NO = bANKSEQNO;
	}

	public String getVERIFY_USER_ID() {
		return VERIFY_USER_ID;
	}

	public void setVERIFY_USER_ID(String vERIFYUSERID) {
		VERIFY_USER_ID = vERIFYUSERID;
	}

	public String getSETTLED_USER_ID() {
		return SETTLED_USER_ID;
	}

	public void setSETTLED_USER_ID(String sETTLEDUSERID) {
		SETTLED_USER_ID = sETTLEDUSERID;
	}

	public String getREASON_DESC() {
		return REASON_DESC;
	}

	public void setREASON_DESC(String rEASONDESC) {
		REASON_DESC = rEASONDESC;
	}

}
