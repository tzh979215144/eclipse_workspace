package org.zhoukan.bean;

public class CL_SETTLE_PAYBean {
	
	private int INTERNAL_KEY = -1;				//系统生成的顺序号
	private String PAY_SEQ = null;				//付款流水号
	private String BRANCH = null;				//结算分行号
	private String SELLET_ACCT_TYPE = null;		//结算账户类型
	private String SELLE_METHOD = null;			//结算方式
	private String CLIENT = null;				//客户号
	private String NAME = null;					//客户名称
	private String ACCT = null;					//内部结算账号
	private String TRAN_DATE = null;			//交易日期
	private String USER_ID = null;				//操作号
	private String LAST_CHANGE_DATE = null;		//最后变更日期
	private String RB_SEQ_NO = null;			//存款结算的序列号
	private String PAY_AMT = null;				//付款金额
	private String SETTLE_AMT = null;			//结算金额
	private String LOAN_KEY = null;				//贷款对应的顺序号
	private String BASE_ACCT_NO = null;			//结算账号
	
	
	public int getINTERNAL_KEY() {
		return INTERNAL_KEY;
	}
	public void setINTERNAL_KEY(int iNTERNALKEY) {
		INTERNAL_KEY = iNTERNALKEY;
	}
	public String getPAY_SEQ() {
		return PAY_SEQ;
	}
	public void setPAY_SEQ(String pAYSEQ) {
		PAY_SEQ = pAYSEQ;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getSELLET_ACCT_TYPE() {
		return SELLET_ACCT_TYPE;
	}
	public void setSELLET_ACCT_TYPE(String sELLETACCTTYPE) {
		SELLET_ACCT_TYPE = sELLETACCTTYPE;
	}
	public String getSELLE_METHOD() {
		return SELLE_METHOD;
	}
	public void setSELLE_METHOD(String sELLEMETHOD) {
		SELLE_METHOD = sELLEMETHOD;
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
	public String getLAST_CHANGE_DATE() {
		return LAST_CHANGE_DATE;
	}
	public void setLAST_CHANGE_DATE(String lASTCHANGEDATE) {
		LAST_CHANGE_DATE = lASTCHANGEDATE;
	}
	public String getRB_SEQ_NO() {
		return RB_SEQ_NO;
	}
	public void setRB_SEQ_NO(String rBSEQNO) {
		RB_SEQ_NO = rBSEQNO;
	}
	public String getPAY_AMT() {
		return PAY_AMT;
	}
	public void setPAY_AMT(String pAYAMT) {
		PAY_AMT = pAYAMT;
	}
	public String getSETTLE_AMT() {
		return SETTLE_AMT;
	}
	public void setSETTLE_AMT(String sETTLEAMT) {
		SETTLE_AMT = sETTLEAMT;
	}
	public String getLOAN_KEY() {
		return LOAN_KEY;
	}
	public void setLOAN_KEY(String lOANKEY) {
		LOAN_KEY = lOANKEY;
	}
	public String getBASE_ACCT_NO() {
		return BASE_ACCT_NO;
	}
	public void setBASE_ACCT_NO(String bASEACCTNO) {
		BASE_ACCT_NO = bASEACCTNO;
	}
	
}
