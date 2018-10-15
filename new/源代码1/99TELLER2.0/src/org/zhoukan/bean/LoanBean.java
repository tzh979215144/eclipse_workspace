package org.zhoukan.bean;

public class LoanBean {
	private String NAME_56 = null;
	private String LENDER=null;
	private String LOAN_NO= null;
	private	String BORROWER=null;
	private String CONTRACT_NO = null;
	private String BOOK_BRANCH =null;
	private String LOAN_TYPE = null;
	private String LOAN_SUB_TYPE= null;	
	private String CCY = null;
	private String START_DATE = null;
	private String MATURE_DATE= null;
	private int LOAN_AMT= 0;
	private int DRAWN_AMT= 0;
	private int OUTSTANDING=0;
	private double INT_RATE = 0;
	private double MIN_INT_RATE = 0;
	private double MAX_INT_RATE = 0;
	private int BILLING_DAYS = 0;
	private String ROCESS_TYPE=null;
	private String MONTH_BASIS = null;
	private String YEAR_BASIS= null;
	private String ACCT_59=null;
	private String BJ_ACCT_59=null;
	private String BJ_LENDER=null;
	private String LX_ACCT_59=null;
	private String LX_LENDER=null;
	private String FX_ACCT_59=null;
	private String FX_LENDER=null;
	private String FL_ACCT_59=null;
	private String FL_LENDER=null;
	private String FY_ACCT_59=null;
	private String FY_LENDER=null;
	private String BY_ACCT_NO=null;
	private String BY_LENDER=null;
	private double FL_INT_RATE=0;
	private double FX_INT_RATE=0;
	private double BY_INT_RATE=0;
	
	private String recieveMess = null;

	public String getNAME_56() {
		return NAME_56;
	}

	public void setNAME_56(String lENDER) {
		NAME_56 = lENDER;
	}

	public String getLOAN_NO() {
		return LOAN_NO;
	}

	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getLENDER() {
		return LENDER;
	}

	public void setLENDER(String lENDER) {
		LENDER = lENDER;
	}

	public String getBORROWER() {
		return BORROWER;
	}

	public void setBORROWER(String bORROWER) {
		BORROWER = bORROWER;
	}

	public String getCONTRACT_NO() {
		return CONTRACT_NO;
	}

	public void setCONTRACT_NO(String cONTRACTNO) {
		CONTRACT_NO = cONTRACTNO;
	}

	public String getBOOK_BRANCH() {
		return BOOK_BRANCH;
	}

	public void setBOOK_BRANCH(String bOOKBRANCH) {
		BOOK_BRANCH = bOOKBRANCH;
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

	public String getCCY() {
		return CCY;
	}

	public void setCCY(String cCY) {
		CCY = cCY;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTARTDATE) {
		START_DATE = sTARTDATE;
	}

	public String getMATURE_DATE() {
		return MATURE_DATE;
	}

	public void setMATURE_DATE(String mATUREDATE) {
		MATURE_DATE = mATUREDATE;
	}

	public int getLOAN_AMT() {
		return LOAN_AMT;
	}

	public void setLOAN_AMT(int lOANAMT) {
		LOAN_AMT = lOANAMT;
	}

	public int getDRAWN_AMT() {
		return DRAWN_AMT;
	}

	public void setDRAWN_AMT(int dRAWNAMT) {
		DRAWN_AMT = dRAWNAMT;
	}

	public int getOUTSTANDING() {
		return OUTSTANDING;
	}

	public void setOUTSTANDING(int oUTSTANDING) {
		OUTSTANDING = oUTSTANDING;
	}

	public double getINT_RATE() {
		return INT_RATE;
	}

	public void setINT_RATE(double iNTRATE) {
		INT_RATE = iNTRATE;
	}

	public double getMIN_INT_RATE() {
		return MIN_INT_RATE;
	}

	public void setMIN_INT_RATE(double mININTRATE) {
		MIN_INT_RATE = mININTRATE;
	}

	public double getMAX_INT_RATE() {
		return MAX_INT_RATE;
	}

	public void setMAX_INT_RATE(double mAXINTRATE) {
		MAX_INT_RATE = mAXINTRATE;
	}

	public int getBILLING_DAYS() {
		return BILLING_DAYS;
	}

	public void setBILLING_DAYS(int bILLINGDAYS) {
		BILLING_DAYS = bILLINGDAYS;
	}
	public String getROCESS_TYPE(){
		return ROCESS_TYPE;
	}
	public void setROCESS_TYPE(String aROCESS_TYPE){
		ROCESS_TYPE=aROCESS_TYPE;
	}
	public String getMONTH_BASIS() {
		return MONTH_BASIS;
	}

	public void setMONTH_BASIS(String mONTHBASIS) {
		MONTH_BASIS = mONTHBASIS;
	}

	public String getYEAR_BASIS() {
		return YEAR_BASIS;
	}

	public void setYEAR_BASIS(String yEARBASIS) {
		YEAR_BASIS = yEARBASIS;
	}

	public String getACCT_59() {
		return ACCT_59;
	}

	public void setACCT_59(String aCCT_59) {
		ACCT_59 = aCCT_59;
	}

	public String getBJ_ACCT_59() {
		return BJ_ACCT_59;
	}

	public void setBJ_ACCT_59(String bJACCT_59) {
		BJ_ACCT_59 = bJACCT_59;
	}

	public String getBJ_LENDER() {
		return BJ_LENDER;
	}

	public void setBJ_LENDER(String bJLENDER) {
		BJ_LENDER = bJLENDER;
	}

	public String getLX_ACCT_59() {
		return LX_ACCT_59;
	}

	public void setLX_ACCT_59(String lX_ACCT_59) {
		LX_ACCT_59 = lX_ACCT_59;
	}

	public String getLX_LENDER() {
		return LX_LENDER;
	}

	public void setLX_LENDER(String lXLENDER) {
		LX_LENDER = lXLENDER;
	}

	public String getFX_ACCT_59() {
		return FX_ACCT_59;
	}

	public void setFX_ACCT_59(String fX_ACCT_59) {
		FX_ACCT_59 = fX_ACCT_59;
	}

	public String getFX_LENDER() {
		return FX_LENDER;
	}

	public void setFX_LENDER(String fXLENDER) {
		FX_LENDER = fXLENDER;
	}

	public String getFL_ACCT_59() {
		return FL_ACCT_59;
	}

	public void setFL_ACCT_59(String fL_ACCT_59) {
		FL_ACCT_59 = fL_ACCT_59;
	}

	public String getFL_LENDER() {
		return FL_LENDER;
	}

	public void setFL_LENDER(String fLLENDER) {
		FL_LENDER = fLLENDER;
	}

	public String getFY_ACCT_59() {
		return FY_ACCT_59;
	}

	public void setFY_ACCT_59(String fY_ACCT_59) {
		FY_ACCT_59 = fY_ACCT_59;
	}

	public String getFY_LENDER() {
		return FY_LENDER;
	}

	public void setFY_LENDER(String fYLENDER) {
		FY_LENDER = fYLENDER;
	}

	public String getBY_ACCT_NO() {
		return BY_ACCT_NO;
	}

	public void setBY_ACCT_NO(String bY_ACCT_NO) {
		BY_ACCT_NO= bY_ACCT_NO;
	}

	public String getBY_LENDER() {
		return BY_LENDER;
	}

	public void setBY_LENDER(String bYLENDER) {
		BY_LENDER = bYLENDER;
	}

	public String getRecieveMess() {
		return recieveMess;
	}

	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	public double getFX_INT_RATE() {
		return FX_INT_RATE;
	}

	public void setFX_INT_RATE(double FXNTRATE) {
		FX_INT_RATE = FXNTRATE;
	}
	public double getFL_INT_RATE() {
		return FL_INT_RATE;
	}

	public void setFL_INT_RATE(double FLNTRATE) {
		FL_INT_RATE =FLNTRATE;
	}
	public double getBY_INT_RATE() {
		return BY_INT_RATE;
	}

	public void setBY_INT_RATE(double BYiNTRATE) {
		BY_INT_RATE = BYiNTRATE;
	}
}
