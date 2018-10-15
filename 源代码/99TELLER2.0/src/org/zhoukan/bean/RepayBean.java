package org.zhoukan.bean;

public class RepayBean {
	private String DD_NO = null;//发放对应的顺序号
	private String CCY = null;//币种
	private String PRI_REPAY_FREQ = null;//还款周期
	private String PRI_REPAY_DAY = null;//还款日
	private String REPAY_DATE = null;//还款日期
	private String END_DATE = null;//到期日期
	private String TRAN_DATE = null;//交易日期
	private String DD_AMT = null;//发放金额
	private String LAST_DN_DUE = null;//上一结息日期
	private String USER_ID = null;//最后修改交易用户ID
	private String LAST_CHANGE_DATE = null;//最后变更日期
	private String SCH_NO = null;//顺序号
	private String LOAN_KEY = null;//贷款key
	private String LOAN_NO = null;//贷款号
	private String DD_DATE = null;//发放日期
	private String INT_RATE = null;//利率
	private String recieveMess = null;
	
	
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	public String getDD_NO() {
		return DD_NO;
	}
	public void setDD_NO(String dDKEY) {
		DD_NO = dDKEY;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getPRI_REPAY_FREQ() {
		return PRI_REPAY_FREQ;
	}
	public void setPRI_REPAY_FREQ(String pRIREPAYFREQ) {
		PRI_REPAY_FREQ = pRIREPAYFREQ;
	}
	public String getPRI_REPAY_DAY() {
		return PRI_REPAY_DAY;
	}
	public void setPRI_REPAY_DAY(String pRIREPAYDAY) {
		PRI_REPAY_DAY = pRIREPAYDAY;
	}
	public String getREPAY_DATE() {
		return REPAY_DATE;
	}
	public void setREPAY_DATE(String rEPAYDATE) {
		REPAY_DATE = rEPAYDATE;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eNDDATE) {
		END_DATE = eNDDATE;
	}
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRANDATE) {
		TRAN_DATE = tRANDATE;
	}
	public String getDD_AMT() {
		return DD_AMT;
	}
	public void setDD_AMT(String dDAMT) {
		DD_AMT = dDAMT;
	}
	public String getLAST_DN_DUE() {
		return LAST_DN_DUE;
	}
	public void setLAST_DN_DUE(String lASTDNDUE) {
		LAST_DN_DUE = lASTDNDUE;
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
	public String getSCH_NO() {
		return SCH_NO;
	}
	public void setSCH_NO(String sCHNO) {
		SCH_NO = sCHNO;
	}
	public String getLOAN_KEY() {
		return LOAN_KEY;
	}
	public void setLOAN_KEY(String lOANKEY) {
		LOAN_KEY = lOANKEY;
	}
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getDD_DATE() {
		return DD_DATE;
	}
	public void setDD_DATE(String dDDATE) {
		DD_DATE = dDDATE;
	}
	public String getINT_RATE() {
		return INT_RATE;
	}
	public void setINT_RATE(String iNTRATE) {
		INT_RATE = iNTRATE;
	}
	
}
