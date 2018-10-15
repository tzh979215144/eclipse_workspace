package org.zhoukan.bean;

public class Cl_drawDrowBean {

	private int OD_PRI_POSTED = 0;
	private int DD_KEY = 0;
	private String DD_NO = null;
	private String TRAN_NO = null;
	private String LENDER = null;
	private String SUB_PROJECT_NO = null;
	private String TRAN_DATE = null;
	private String DD_DATE = null;
	private String MATURITY = null;
	private String CCY = null;
	private int DD_AMT = 0;
	private int OUTSTANDING = 0;
	private int OS_LESS_PAST_DUE = 0;
	private String MONTH_BASIS_PEN = null;
	private String MONTH_BASIS_INT = null;
	private int YEAR_BASIS_PEN = 0;
	private int YEAR_BASIS_INT = 0;
	private String INT_BASIS = null;
	private float INT_BASIS_RATE = 0;
	private float INT_RATE = 0;
	private float INT_PLTY_RATE = (float) 0.05;
	private String PRI_PLTY_BASIS = null;
	private float PRI_PLTY_SPREAD = 0;
	private float PRI_PLTY_ABS = (float) 0.05;
	private float PENALTY_ODI_RATE_TYPE=0;
	private String ROLL_DATE = null;
	private String LAST_INT_REP_DATE = null;
	private String NEXT_INT_REP_DATE = null;
	private String INT_REPAY_FREQ = null;
	private int INT_REPAY_DAY = 0;
	private int INT_CALCULATED = 0;
	private int OD_INT_CALCULATED = 0;
	private int OD_PRI_CALCULATED = 0;
	private int INT_POSTED = 0;
	private int OD_INT_POSTED = 0;
	private int INT_ADJ_NOT_POSTED = 0;
	private int INT_ADJ_POSTED = 0;
	private int OD_INT_ADJ_NOT_POSTED = 0;
	private int OD_PRI_ADJ_NOT_POSTEN = 0;
	private int OD_INT_ADJ_POSTED = 0;
	private int OD_PRI_ADJ_POSTED = 0;
	private int PRI_RECD_RECBLE = 0;
	private int PRI_OUTSTANDING = 0;
	private int INT_OUTSTANDING = 0;
	private int ODI_OUTSTANDING = 0;
	private int DOP_OUTSTANDING = 0;
	private int PRI_PAST_DUE = 0;
	private int INT_PAST_DUE = 0;
	private int ODI_PAST_DUE = 0;
	private int ODP_PAST_DUE = 0;
	private String GL_POSTED = null;
	private String ADVICE_SENT = null;
	private String REVERSED_MATURED = null;
	private String LOAN_NO = null;
	private String USER_ID = null;
	private String LAST_CHANGE_DATE = null;
	private String VERIFY = null;
	private String PRI_BILLING_DATE = null;
	private String INT_BILLING_DATE = null;
	private String NEXT_PRI_PEP_DATE = null;
	private String LAST_ACCRUAL_DATE = null;
	private String FINAL_BILLING_DATE = null;
	private int YEAR_BASIS_PLTY = 0;
	private int MONTH_BASIS_PLTY = 0;
	private String INT_PLTY_BASIS;
	private float INT_PLTY_ABS=(float) 0.05;
	private float INT_PLTY_SPREAD=0;
	private float INT_SPREAD=0;
	private String  LAST_PRI_PEP_DATE=null;
	private float PRI_PLTY_RATE=(float)0.05;
	
	public String getINT_PLTY_BASIS() {
		return INT_PLTY_BASIS;
	}
	public void setINT_PLTY_BASIS(String iNTPLTYBASIS) {
		INT_PLTY_BASIS = iNTPLTYBASIS;
	}
	public float getINT_PLTY_ABS() {
		return INT_PLTY_ABS;
	}
	public void setINT_PLTY_ABS(float iNTPLTYABS) {
		INT_PLTY_ABS = iNTPLTYABS;
	}
	public float getINT_PLTY_SPREAD() {
		return INT_PLTY_SPREAD;
	}
	public void setINT_PLTY_SPREAD(float iNTPLTYSPREAD) {
		INT_PLTY_SPREAD = iNTPLTYSPREAD;
	}
	public float getINT_SPREAD() {
		return INT_SPREAD;
	}
	public void setINT_SPREAD(float iNTSPREAD) {
		INT_SPREAD = iNTSPREAD;
	}
	public String getLAST_PRI_PEP_DATE() {
		return LAST_PRI_PEP_DATE;
	}
	public void setLAST_PRI_PEP_DATE(String lASTPRIPEPDATE) {
		LAST_PRI_PEP_DATE = lASTPRIPEPDATE;
	}
	public float getPRI_PLTY_RATE() {
		return PRI_PLTY_RATE;
	}
	public void setPRI_PLTY_RATE(float pRIPLTYRATE) {
		PRI_PLTY_RATE = pRIPLTYRATE;
	}
	public int getOD_PRI_POSTED() {
		return OD_PRI_POSTED;
	}
	public void setOD_PRI_POSTED(int oDPRIPOSTED) {
		OD_PRI_POSTED = oDPRIPOSTED;
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
	public String getTRAN_NO() {
		return TRAN_NO;
	}
	public void setTRAN_NO(String tRANNO) {
		TRAN_NO = tRANNO;
	}
	public String getLENDER() {
		return LENDER;
	}
	public void setLENDER(String lENDER) {
		LENDER = lENDER;
	}
	public String getSUB_PROJECT_NO() {
		return SUB_PROJECT_NO;
	}
	public void setSUB_PROJECT_NO(String sUBPROJECTNO) {
		SUB_PROJECT_NO = sUBPROJECTNO;
	}
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRANDATE) {
		TRAN_DATE = tRANDATE;
	}
	public String getDD_DATE() {
		return DD_DATE;
	}
	public void setDD_DATE(String dDDATE) {
		DD_DATE = dDDATE;
	}
	public String getMATURITY() {
		return MATURITY;
	}
	public void setMATURITY(String mATURITY) {
		MATURITY = mATURITY;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public int getDD_AMT() {
		return DD_AMT;
	}
	public void setDD_AMT(int dDAMT) {
		DD_AMT = dDAMT;
	}
	public int getOUTSTANDING() {
		return OUTSTANDING;
	}
	public void setOUTSTANDING(int oUTSTANDING) {
		OUTSTANDING = oUTSTANDING;
	}
	public int getOS_LESS_PAST_DUE() {
		return OS_LESS_PAST_DUE;
	}
	public void setOS_LESS_PAST_DUE(int oSLESSPASTDUE) {
		OS_LESS_PAST_DUE = oSLESSPASTDUE;
	}
	public String getMONTH_BASIS_PEN() {
		return MONTH_BASIS_PEN;
	}
	public void setMONTH_BASIS_PEN(String mONTHBASISPEN) {
		MONTH_BASIS_PEN = mONTHBASISPEN;
	}
	public String getMONTH_BASIS_INT() {
		return MONTH_BASIS_INT;
	}
	public void setMONTH_BASIS_INT(String mONTHBASISINT) {
		MONTH_BASIS_INT = mONTHBASISINT;
	}
	public int getYEAR_BASIS_PEN() {
		return YEAR_BASIS_PEN;
	}
	public void setYEAR_BASIS_PEN(int yEARBASISPEN) {
		YEAR_BASIS_PEN = yEARBASISPEN;
	}
	public int getYEAR_BASIS_INT() {
		return YEAR_BASIS_INT;
	}
	public void setYEAR_BASIS_INT(int yEARBASISINT) {
		YEAR_BASIS_INT = yEARBASISINT;
	}
	public String getINT_BASIS() {
		return INT_BASIS;
	}
	public void setINT_BASIS(String iNTBASIS) {
		INT_BASIS = iNTBASIS;
	}
	
	public void setINT_BASIS_RATE(int iNTBASISRATE) {
		INT_BASIS_RATE = iNTBASISRATE;
	}
	
	public void setINT_RATE(int iNTRATE) {
		INT_RATE = iNTRATE;
	}
	
	public float getINT_BASIS_RATE() {
		return INT_BASIS_RATE;
	}
	public void setINT_BASIS_RATE(float iNTBASISRATE) {
		INT_BASIS_RATE = iNTBASISRATE;
	}
	public float getINT_RATE() {
		return INT_RATE;
	}
	public void setINT_RATE(float iNTRATE) {
		INT_RATE = iNTRATE;
	}
	public float getINT_PLTY_RATE() {
		return INT_PLTY_RATE;
	}
	public void setINT_PLTY_RATE(float iNTPLTYRATE) {
		INT_PLTY_RATE = iNTPLTYRATE;
	}
	public float getPRI_PLTY_SPREAD() {
		return PRI_PLTY_SPREAD;
	}
	public void setPRI_PLTY_SPREAD(float pRIPLTYSPREAD) {
		PRI_PLTY_SPREAD = pRIPLTYSPREAD;
	}
	public float getPRI_PLTY_ABS() {
		return PRI_PLTY_ABS;
	}
	public void setPRI_PLTY_ABS(float pRIPLTYABS) {
		PRI_PLTY_ABS = pRIPLTYABS;
	}
	public void setINT_PLTY_RATE(int iNTPLTYRATE) {
		INT_PLTY_RATE = iNTPLTYRATE;
	}
	public String getPRI_PLTY_BASIS() {
		return PRI_PLTY_BASIS;
	}
	public void setPRI_PLTY_BASIS(String pRIPLTYBASIS) {
		PRI_PLTY_BASIS = pRIPLTYBASIS;
	}
	
	public void setPRI_PLTY_SPREAD(int pRIPLTYSPREAD) {
		PRI_PLTY_SPREAD = pRIPLTYSPREAD;
	}
	
	public void setPRI_PLTY_ABS(int pRIPLTYABS) {
		PRI_PLTY_ABS = pRIPLTYABS;
	}
	public float getPENALTY_ODI_RATE_TYPE() {
		return PENALTY_ODI_RATE_TYPE;
	}
	public void setPENALTY_ODI_RATE_TYPE(float pENALTYODIRATETYPE) {
		PENALTY_ODI_RATE_TYPE = pENALTYODIRATETYPE;
	}
	public String getROLL_DATE() {
		return ROLL_DATE;
	}
	public void setROLL_DATE(String rOLLDATE) {
		ROLL_DATE = rOLLDATE;
	}
	public String getLAST_INT_REP_DATE() {
		return LAST_INT_REP_DATE;
	}
	public void setLAST_INT_REP_DATE(String lASTINTREPDATE) {
		LAST_INT_REP_DATE = lASTINTREPDATE;
	}
	public String getNEXT_INT_REP_DATE() {
		return NEXT_INT_REP_DATE;
	}
	public void setNEXT_INT_REP_DATE(String nEXTINTREPDATE) {
		NEXT_INT_REP_DATE = nEXTINTREPDATE;
	}
	
	public String getINT_REPAY_FREQ() {
		return INT_REPAY_FREQ;
	}
	public void setINT_REPAY_FREQ(String iNTREPAYFREQ) {
		INT_REPAY_FREQ = iNTREPAYFREQ;
	}
	public int getINT_REPAY_DAY() {
		return INT_REPAY_DAY;
	}
	public void setINT_REPAY_DAY(int iNTREPAYDAY) {
		INT_REPAY_DAY = iNTREPAYDAY;
	}
	public int getINT_CALCULATED() {
		return INT_CALCULATED;
	}
	public void setINT_CALCULATED(int iNTCALCULATED) {
		INT_CALCULATED = iNTCALCULATED;
	}
	public int getOD_INT_CALCULATED() {
		return OD_INT_CALCULATED;
	}
	public void setOD_INT_CALCULATED(int oDINTCALCULATED) {
		OD_INT_CALCULATED = oDINTCALCULATED;
	}
	public int getOD_PRI_CALCULATED() {
		return OD_PRI_CALCULATED;
	}
	public void setOD_PRI_CALCULATED(int oDPRICALCULATED) {
		OD_PRI_CALCULATED = oDPRICALCULATED;
	}
	public int getINT_POSTED() {
		return INT_POSTED;
	}
	public void setINT_POSTED(int iNTPOSTED) {
		INT_POSTED = iNTPOSTED;
	}
	public int getOD_INT_POSTED() {
		return OD_INT_POSTED;
	}
	public void setOD_INT_POSTED(int oDINTPOSTED) {
		OD_INT_POSTED = oDINTPOSTED;
	}
	public int getINT_ADJ_NOT_POSTED() {
		return INT_ADJ_NOT_POSTED;
	}
	public void setINT_ADJ_NOT_POSTED(int iNTADJNOTPOSTED) {
		INT_ADJ_NOT_POSTED = iNTADJNOTPOSTED;
	}
	public int getINT_ADJ_POSTED() {
		return INT_ADJ_POSTED;
	}
	public void setINT_ADJ_POSTED(int iNTADJPOSTED) {
		INT_ADJ_POSTED = iNTADJPOSTED;
	}
	public int getOD_INT_ADJ_NOT_POSTED() {
		return OD_INT_ADJ_NOT_POSTED;
	}
	public void setOD_INT_ADJ_NOT_POSTED(int oDINTADJNOTPOSTED) {
		OD_INT_ADJ_NOT_POSTED = oDINTADJNOTPOSTED;
	}
	public int getOD_PRI_ADJ_NOT_POSTEN() {
		return OD_PRI_ADJ_NOT_POSTEN;
	}
	public void setOD_PRI_ADJ_NOT_POSTEN(int oDPRIADJNOTPOSTEN) {
		OD_PRI_ADJ_NOT_POSTEN = oDPRIADJNOTPOSTEN;
	}
	public int getOD_INT_ADJ_POSTED() {
		return OD_INT_ADJ_POSTED;
	}
	public void setOD_INT_ADJ_POSTED(int oDINTADJPOSTED) {
		OD_INT_ADJ_POSTED = oDINTADJPOSTED;
	}
	public int getOD_PRI_ADJ_POSTED() {
		return OD_PRI_ADJ_POSTED;
	}
	public void setOD_PRI_ADJ_POSTED(int oDPRIADJPOSTED) {
		OD_PRI_ADJ_POSTED = oDPRIADJPOSTED;
	}
	public int getPRI_RECD_RECBLE() {
		return PRI_RECD_RECBLE;
	}
	public void setPRI_RECD_RECBLE(int pRIRECDRECBLE) {
		PRI_RECD_RECBLE = pRIRECDRECBLE;
	}
	public int getPRI_OUTSTANDING() {
		return PRI_OUTSTANDING;
	}
	public void setPRI_OUTSTANDING(int pRIOUTSTANDING) {
		PRI_OUTSTANDING = pRIOUTSTANDING;
	}
	public int getINT_OUTSTANDING() {
		return INT_OUTSTANDING;
	}
	public void setINT_OUTSTANDING(int iNTOUTSTANDING) {
		INT_OUTSTANDING = iNTOUTSTANDING;
	}
	public int getODI_OUTSTANDING() {
		return ODI_OUTSTANDING;
	}
	public void setODI_OUTSTANDING(int oDIOUTSTANDING) {
		ODI_OUTSTANDING = oDIOUTSTANDING;
	}
	public int getDOP_OUTSTANDING() {
		return DOP_OUTSTANDING;
	}
	public void setDOP_OUTSTANDING(int dOPOUTSTANDING) {
		DOP_OUTSTANDING = dOPOUTSTANDING;
	}
	public int getPRI_PAST_DUE() {
		return PRI_PAST_DUE;
	}
	public void setPRI_PAST_DUE(int pRIPASTDUE) {
		PRI_PAST_DUE = pRIPASTDUE;
	}
	public int getINT_PAST_DUE() {
		return INT_PAST_DUE;
	}
	public void setINT_PAST_DUE(int iNTPASTDUE) {
		INT_PAST_DUE = iNTPASTDUE;
	}
	public int getODI_PAST_DUE() {
		return ODI_PAST_DUE;
	}
	public void setODI_PAST_DUE(int oDIPASTDUE) {
		ODI_PAST_DUE = oDIPASTDUE;
	}
	public int getODP_PAST_DUE() {
		return ODP_PAST_DUE;
	}
	public void setODP_PAST_DUE(int oDPPASTDUE) {
		ODP_PAST_DUE = oDPPASTDUE;
	}
	public String getGL_POSTED() {
		return GL_POSTED;
	}
	public void setGL_POSTED(String gLPOSTED) {
		GL_POSTED = gLPOSTED;
	}
	public String getADVICE_SENT() {
		return ADVICE_SENT;
	}
	public void setADVICE_SENT(String aDVICESENT) {
		ADVICE_SENT = aDVICESENT;
	}
	public String getREVERSED_MATURED() {
		return REVERSED_MATURED;
	}
	public void setREVERSED_MATURED(String rEVERSEDMATURED) {
		REVERSED_MATURED = rEVERSEDMATURED;
	}
	
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
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
	public String getVERIFY() {
		return VERIFY;
	}
	public void setVERIFY(String vERIFY) {
		VERIFY = vERIFY;
	}
	public String getPRI_BILLING_DATE() {
		return PRI_BILLING_DATE;
	}
	public void setPRI_BILLING_DATE(String pRIBILLINGDATE) {
		PRI_BILLING_DATE = pRIBILLINGDATE;
	}
	public String getINT_BILLING_DATE() {
		return INT_BILLING_DATE;
	}
	public void setINT_BILLING_DATE(String iNTBILLINGDATE) {
		INT_BILLING_DATE = iNTBILLINGDATE;
	}
	public String getNEXT_PRI_PEP_DATE() {
		return NEXT_PRI_PEP_DATE;
	}
	public void setNEXT_PRI_PEP_DATE(String nEXTPRIPEPDATE) {
		NEXT_PRI_PEP_DATE = nEXTPRIPEPDATE;
	}
	public String getLAST_ACCRUAL_DATE() {
		return LAST_ACCRUAL_DATE;
	}
	public void setLAST_ACCRUAL_DATE(String lASTACCRUALDATE) {
		LAST_ACCRUAL_DATE = lASTACCRUALDATE;
	}
	public String getFINAL_BILLING_DATE() {
		return FINAL_BILLING_DATE;
	}
	public void setFINAL_BILLING_DATE(String fINALBILLINGDATE) {
		FINAL_BILLING_DATE = fINALBILLINGDATE;
	}
	public int getYEAR_BASIS_PLTY() {
		return YEAR_BASIS_PLTY;
	}
	public void setYEAR_BASIS_PLTY(int yEARBASISPLTY) {
		YEAR_BASIS_PLTY = yEARBASISPLTY;
	}
	public int getMONTH_BASIS_PLTY() {
		return MONTH_BASIS_PLTY;
	}
	public void setMONTH_BASIS_PLTY(int mONTHBASISPLTY) {
		MONTH_BASIS_PLTY = mONTHBASISPLTY;
	}
	
	
}
