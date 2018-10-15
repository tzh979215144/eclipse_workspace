package org.zhoukan.bean;

public class SettlePayBean_TE {
	  //贷款号
      private String LOAN_NO;
      //发放号
      private String DD_NO;
      //贷款人编号
      private String CLIENT;
      //贷款人姓名
      private String LENDER;
      //贷款管理银行
      private String LOAN_MANAGER;
      //贷款类型
      private String LOAN_TYPE;
      //贷款子类型
      private String LOAN_SUB_TYPE;
      //客户经理
      private String ACCT_EXEC;
      //发放币种
      private String CCY;
      //发放金额
      private String DD_AMT;
      //贷款利率
      private String INT_RATE;
      //合同金额
      private String LOAN_AMT;
      //已发放的总金额
      private String DRAWN_AMT;  
      //结算账户
      private String ACCT_NO;
      private String receiveMess;
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
	public String getLENDER() {
		return LENDER;
	}
	public void setLENDER(String lENDER) {
		LENDER = lENDER;
	}
	public String getLOAN_MANAGER() {
		return LOAN_MANAGER;
	}
	public void setLOAN_MANAGER(String lOANMANAGER) {
		LOAN_MANAGER = lOANMANAGER;
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
	public String getACCT_EXEC() {
		return ACCT_EXEC;
	}
	public void setACCT_EXEC(String aCCTEXEC) {
		ACCT_EXEC = aCCTEXEC;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String ccy) {
		this.CCY = ccy;
	}
	public String getDD_AMT() {
		return DD_AMT;
	}
	public void setDD_AMT(String dDAMT) {
		DD_AMT = dDAMT;
	}
	public String getINT_RATE() {
		return INT_RATE;
	}
	public void setINT_RATE(String iNTRATE) {
		INT_RATE = iNTRATE;
	}
	public String getReceiveMess() {
		return receiveMess;
	}
	public void setReceiveMess(String receiveMess) {
		this.receiveMess = receiveMess;
	}
	public void setACCT_NO(String aCCT_NO) {
		ACCT_NO = aCCT_NO;
	}
	public String getACCT_NO() {
		return ACCT_NO;
	}
	public void setLOAN_AMT(String lOAN_AMT) {
		LOAN_AMT = lOAN_AMT;
	}
	public String getLOAN_AMT() {
		return LOAN_AMT;
	}
	public void setDRAWN_AMT(String dRAWN_AMT) {
		DRAWN_AMT = dRAWN_AMT;
	}
	public String getDRAWN_AMT() {
		return DRAWN_AMT;
	}
	public void setCLIENT(String cLIENT) {
		CLIENT = cLIENT;
	}
	public String getCLIENT() {
		return CLIENT;
	}
      
}
