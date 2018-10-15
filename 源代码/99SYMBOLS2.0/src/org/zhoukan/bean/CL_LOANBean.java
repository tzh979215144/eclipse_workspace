package org.zhoukan.bean;

public class CL_LOANBean {

	private int LOAN_KEY = 0;
	private String LOAN_NO = null;
	private String STATUS = null;
	private String CONTRACT_NO = null;
	private String LOAN_TYPE = null;
	private String LOAN_SUB_TYPE = null;
	private String BORROWER = null;
	private String ORIG_BORRPWER = null;
	private String BORROWER_TYPE = null;
	private String LOAN_MANAGER = null;
	private String BOOK_BRANCH = null;
	private String ORIG_BOOK_BRANCH = null;
	private String LENDER = null;
	private String CCY = null;
	private String REVOLVE_YN = null;
	private String START_DATE = null;
	private String MATURE_DATE = null;
	private int ORIG_LOAN_AMT = 0;
	private int LOAN_AMT = 0;
	private int DRAWN_AMT = 0;
	private int OUTSTANDING = 0;
	private float INT_RATE = 0;
	private float MIN_INT_RATE = 0;
	private float MAX_INT_RATE = 0;
	private String ROCESS_TYPE = null;
	private int PRI_BILLING_DAYS = 0;
	private int BILLING_DAYS = 0;
	private String HUNTING_STATUS = null;
	private String MONTH_BASIS = null;
	private int YEAR_BASIS = 0;
	private int REC_SEQ=0;
	private String PAY_REC_IND=null;
	private String ACCT_59=null; 
	private String SETTLE_CCY=null; 
	private String AMT_TYPE=null; 
	private String BASE_CCT_NO=null; 
	private String CLIENT_56=null; 
	private String NAME_56=null; 
	private String TRAN_DATE=null; 
	private String USER_ID=null; 
	private String LAST_CHANGE_DATE=null; 
	private int PRORITY=0; 
	private String ACCT_NO=null; 
	private String CLIENT_NO=null; 
	private String ACCT_TYPE=null;
	private String INTERNAL_KEY=null; 
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
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCONTRACT_NO() {
		return CONTRACT_NO;
	}
	public void setCONTRACT_NO(String cONTRACTNO) {
		CONTRACT_NO = cONTRACTNO;
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
	public String getBORROWER() {
		return BORROWER;
	}
	public void setBORROWER(String bORROWER) {
		BORROWER = bORROWER;
	}
	public String getORIG_BORRPWER() {
		return ORIG_BORRPWER;
	}
	public void setORIG_BORRPWER(String oRIGBORRPWER) {
		ORIG_BORRPWER = oRIGBORRPWER;
	}
	public String getBORROWER_TYPE() {
		return BORROWER_TYPE;
	}
	public void setBORROWER_TYPE(String bORROWERTYPE) {
		BORROWER_TYPE = bORROWERTYPE;
	}
	public String getLOAN_MANAGER() {
		return LOAN_MANAGER;
	}
	public void setLOAN_MANAGER(String lOANMANAGER) {
		LOAN_MANAGER = lOANMANAGER;
	}
	public String getBOOK_BRANCH() {
		return BOOK_BRANCH;
	}
	public void setBOOK_BRANCH(String bOOKBRANCH) {
		BOOK_BRANCH = bOOKBRANCH;
	}
	public String getORIG_BOOK_BRANCH() {
		return ORIG_BOOK_BRANCH;
	}
	public void setORIG_BOOK_BRANCH(String oRIGBOOKBRANCH) {
		ORIG_BOOK_BRANCH = oRIGBOOKBRANCH;
	}
	public String getLENDER() {
		return LENDER;
	}
	public void setLENDER(String lENDER) {
		LENDER = lENDER;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getREVOLVE_YN() {
		return REVOLVE_YN;
	}
	public void setREVOLVE_YN(String rEVOLVEYN) {
		REVOLVE_YN = rEVOLVEYN;
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
	public int getORIG_LOAN_AMT() {
		return ORIG_LOAN_AMT;
	}
	public void setORIG_LOAN_AMT(int oRIGLOANAMT) {
		ORIG_LOAN_AMT = oRIGLOANAMT;
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
	public float getINT_RATE() {
		return INT_RATE;
	}
	public void setINT_RATE(float iNTRATE) {
		INT_RATE = iNTRATE;
	}
	public float getMIN_INT_RATE() {
		return MIN_INT_RATE;
	}
	public void setMIN_INT_RATE(float mININTRATE) {
		MIN_INT_RATE = mININTRATE;
	}
	public float getMAX_INT_RATE() {
		return MAX_INT_RATE;
	}
	public void setMAX_INT_RATE(float mAXINTRATE) {
		MAX_INT_RATE = mAXINTRATE;
	}
	public String getROCESS_TYPE() {
		return ROCESS_TYPE;
	}
	public void setROCESS_TYPE(String rOCESSTYPE) {
		ROCESS_TYPE = rOCESSTYPE;
	}
	public int getPRI_BILLING_DAYS() {
		return PRI_BILLING_DAYS;
	}
	public void setPRI_BILLING_DAYS(int pRIBILLINGDAYS) {
		PRI_BILLING_DAYS = pRIBILLINGDAYS;
	}
	public int getBILLING_DAYS() {
		return BILLING_DAYS;
	}
	public void setBILLING_DAYS(int bILLINGDAYS) {
		BILLING_DAYS = bILLINGDAYS;
	}
	public String getHUNTING_STATUS() {
		return HUNTING_STATUS;
	}
	public void setHUNTING_STATUS(String hUNTINGSTATUS) {
		HUNTING_STATUS = hUNTINGSTATUS;
	}
	public String getMONTH_BASIS() {
		return MONTH_BASIS;
	}
	public void setMONTH_BASIS(String mONTHBASIS) {
		MONTH_BASIS = mONTHBASIS;
	}
	public int getYEAR_BASIS() {
		return YEAR_BASIS;
	}
	public void setYEAR_BASIS(int yEARBASIS) {
		YEAR_BASIS = yEARBASIS;
	}
	
	public int getREC_SEQ() {
		return REC_SEQ;
	}
	public void setREC_SEQ(int rECSEQ) {
		REC_SEQ = rECSEQ;
	}
	public String getPAY_REC_IND() {
		return PAY_REC_IND;
	}
	public void setPAY_REC_IND(String pAYRECIND) {
		PAY_REC_IND = pAYRECIND;
	}
	public String getACCT_59() {
		return ACCT_59;
	}
	public void setACCT_59(String aCCT_59) {
		ACCT_59 = aCCT_59;
	}
	public String getSETTLE_CCY() {
		return SETTLE_CCY;
	}
	public void setSETTLE_CCY(String sETTLECCY) {
		SETTLE_CCY = sETTLECCY;
	}
	public String getAMT_TYPE() {
		return AMT_TYPE;
	}
	public void setAMT_TYPE(String aMTTYPE) {
		AMT_TYPE = aMTTYPE;
	}
	public String getBASE_CCT_NO() {
		return BASE_CCT_NO;
	}
	public void setBASE_CCT_NO(String bASECCTNO) {
		BASE_CCT_NO = bASECCTNO;
	}
	public String getCLIENT_56() {
		return CLIENT_56;
	}
	public void setCLIENT_56(String cLIENT_56) {
		CLIENT_56 = cLIENT_56;
	}
	public String getNAME_56() {
		return NAME_56;
	}
	public void setNAME_56(String nAME_56) {
		NAME_56 = nAME_56;
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
	public int getPRORITY() {
		return PRORITY;
	}
	public void setPRORITY(int pRORITY) {
		PRORITY = pRORITY;
	}
	public String getACCT_NO() {
		return ACCT_NO;
	}
	public void setACCT_NO(String aCCTNO) {
		ACCT_NO = aCCTNO;
	}
	public String getCLIENT_NO() {
		return CLIENT_NO;
	}
	public void setCLIENT_NO(String cLIENTNO) {
		CLIENT_NO = cLIENTNO;
	}
	public String getACCT_TYPE() {
		return ACCT_TYPE;
	}
	public void setACCT_TYPE(String aCCTTYPE) {
		ACCT_TYPE = aCCTTYPE;
	}
	public String getINTERNAL_KEY() {
		return INTERNAL_KEY;
	}
	public void setINTERNAL_KEY(String iNTERNALKEY) {
		INTERNAL_KEY = iNTERNALKEY;
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
	public void setBY_ACCT_59(String bY_ACCT_NO) {
		BY_ACCT_NO = bY_ACCT_NO;
	}
	public String getBY_LENDER() {
		return BY_LENDER;
	}
	public void setBY_LENDER(String bYLENDER) {
		BY_LENDER = bYLENDER;
	}
	
	
}
