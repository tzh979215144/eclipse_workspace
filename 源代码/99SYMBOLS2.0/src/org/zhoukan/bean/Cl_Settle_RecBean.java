package org.zhoukan.bean;

import java.util.Date;

public class Cl_Settle_RecBean {
	private int INTERNAL_KEY;
	private int REC_SEQ;                                   
	private String SOURCE_TABLE ;                        
	private String BRANCH;                               
	private String SETTLE_ACCT_TYPE ;                       
	private String SETTLE_METHOD ;                     
	private String CLIENT_NO;  
	private String CLIENT_NAME;
	private String ACCT;                                
	private String TRAN_DATE;                         
    private String USER_ID ;                           
    private Date LAST_CHANGE_DATE;                        
    private int REC_AMT;                           
	private String LOAN_KEY;                        
	private String ACCT_TYPE;                            
	private String BASE_ACCT_NO;
	private int  DD_KEY;
	
	public int getDD_KEY() {
		return DD_KEY;
	}
	public void setDD_KEY(int dDKEY) {
		DD_KEY = dDKEY;
	}
	public int getINTERNAL_KEY() {
		return INTERNAL_KEY;
	}
	public void setINTERNAL_KEY(int iNTERNALKEY) {
		INTERNAL_KEY = iNTERNALKEY;
	}
	public int getREC_SEQ() {
		return REC_SEQ;
	}
	public void setREC_SEQ(int rECSEQ) {
		REC_SEQ = rECSEQ;
	}
	public String getSOURCE_TABLE() {
		return SOURCE_TABLE;
	}
	public void setSOURCE_TABLE(String sOURCETABLE) {
		SOURCE_TABLE = sOURCETABLE;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getSETTLE_ACCT_TYPE() {
		return SETTLE_ACCT_TYPE;
	}
	public void setSETTLE_ACCT_TYPE(String sETTLEACCTTYPE) {
		SETTLE_ACCT_TYPE = sETTLEACCTTYPE;
	}
	public String getSETTLE_METHOD() {
		return SETTLE_METHOD;
	}
	public void setSETTLE_METHOD(String sETTLEMETHOD) {
		SETTLE_METHOD = sETTLEMETHOD;
	}
	public String getCLIENT_NO() {
		return CLIENT_NO;
	}
	public void setCLIENT_NO(String cLIENTNO) {
		CLIENT_NO = cLIENTNO;
	}
	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}
	public void setCLIENT_NAME(String cLIENTNAME) {
		CLIENT_NAME = cLIENTNAME;
	}
	public String getACCT() {
		return ACCT;
	}
	public void setACCT(String aCCT) {
		ACCT = aCCT;
	}
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRANDATE) {
		TRAN_DATE = tRANDATE;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}
	public Date getLAST_CHANGE_DATE() {
		return LAST_CHANGE_DATE;
	}
	public void setLAST_CHANGE_DATE(Date lASTCHANGEDATE) {
		LAST_CHANGE_DATE = lASTCHANGEDATE;
	}
	public int getREC_AMT() {
		return REC_AMT;
	}
	public void setREC_AMT(int rECAMT) {
		REC_AMT = rECAMT;
	}
	public String getLOAN_KEY() {
		return LOAN_KEY;
	}
	public void setLOAN_KEY(String lOANKEY) {
		LOAN_KEY = lOANKEY;
	}
	public String getACCT_TYPE() {
		return ACCT_TYPE;
	}
	public void setACCT_TYPE(String aCCTTYPE) {
		ACCT_TYPE = aCCTTYPE;
	}
	public String getBASE_ACCT_NO() {
		return BASE_ACCT_NO;
	}
	public void setBASE_ACCT_NO(String bASEACCTNO) {
		BASE_ACCT_NO = bASEACCTNO;
	}  

}
