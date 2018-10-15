package org.zhoukan.bean;

public class DrawDrowBean {
	private String LOAN_NO=null;
	private String LOAN_CCY=null;
	private int LOAN_AMT=0;
	private int  AV_AMT=0;
	private String OFFICER_NAME=null;
	private String BORROWER=null;
	private float INT_SPREAD=0;
	private float PENALTY_ODI_RATE_TYPE1=0;
	private float INT_PLTY_SPREAD=0;
	private String DD_NO = null;
	private String LENDER = null;
	private String DD_DATE = null;
	private String MATURITY = null;
	private String CCY = null;
	private int DD_AMT = 0;
	private String MONTH_BASIS_PEN = null;
	private String MONTH_BASIS_INT = null;
	private int YEAR_BASIS_PEN = 0;
	private int YEAR_BASIS_INT = 0;
	private String INT_BASIS = null;
	private float INT_BASIS_RATE = 0;
	private float INT_RATE = 0;
	private float INT_PLTY_RATE = 0;
	private String PRI_PLTY_BASIS = null;
	private float PRI_PLTY_SPREAD = 0;
	private float PRI_PLTY_ABS = 0;
	private float PENALTY_ODI_RATE_TYPE = 0;
	private int YEAR_BASIS_PLTY = 0;
	private String MONTH_BASIS_PLTY = null;
	private String OFFICER_ID=null;
	private String INT_PLTY_BASIS=null;
	private float INT_PLTY_ABS=(float)0.05;
	private String  LAST_PRI_PEP_DATE=null;
	private float PRI_PLTY_RATE=(float)0.05;
	private String recieveMess = null;
	
	public float getINT_PLTY_ABS() {
		return INT_PLTY_ABS;
	}
	public void setINT_PLTY_ABS(float iNTPLTYABS) {
		INT_PLTY_ABS = iNTPLTYABS;
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
	public String getLOAN_NO() {
		return LOAN_NO;
	}
	public void setLOAN_NO(String lOANNO) {
		LOAN_NO = lOANNO;
	}
	public String getLOAN_CCY() {
		return LOAN_CCY;
	}
	public void setLOAN_CCY(String lOANCCY) {
		LOAN_CCY = lOANCCY;
	}
	public int getLOAN_AMT() {
		return LOAN_AMT;
	}
	public void setLOAN_AMT(int lOANAMT) {
		LOAN_AMT = lOANAMT;
	}
	public int getAV_AMT() {
		return AV_AMT;
	}
	public void setAV_AMT(int aVAMT) {
		AV_AMT = aVAMT;
	}
	public String getOFFICER_NAME() {
		return OFFICER_NAME;
	}
	public void setOFFICER_NAME(String oFFICERNAME) {
		OFFICER_NAME = oFFICERNAME;
	}
	public String getBORROWER() {
		return BORROWER;
	}
	public void setBORROWER(String bORROWER) {
		BORROWER = bORROWER;
	}
	public float getINT_SPREAD() {
		return INT_SPREAD;
	}
	public void setINT_SPREAD(float iNTSPREAD) {
		INT_SPREAD = iNTSPREAD;
	}
	public float getPENALTY_ODI_RATE_TYPE1() {
		return PENALTY_ODI_RATE_TYPE1;
	}
	public void setPENALTY_ODI_RATE_TYPE1(float pENALTYODIRATETYPE1) {
		PENALTY_ODI_RATE_TYPE1 = pENALTYODIRATETYPE1;
	}
	public float getINT_PLTY_SPREAD() {
		return INT_PLTY_SPREAD;
	}
	public void setINT_PLTY_SPREAD(float iNTPLTYSPREAD) {
		INT_PLTY_SPREAD = iNTPLTYSPREAD;
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
	public String getPRI_PLTY_BASIS() {
		return PRI_PLTY_BASIS;
	}
	public void setPRI_PLTY_BASIS(String pRIPLTYBASIS) {
		PRI_PLTY_BASIS = pRIPLTYBASIS;
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
	public float getPENALTY_ODI_RATE_TYPE() {
		return PENALTY_ODI_RATE_TYPE;
	}
	public void setPENALTY_ODI_RATE_TYPE(float pENALTYODIRATETYPE) {
		PENALTY_ODI_RATE_TYPE = pENALTYODIRATETYPE;
	}
	public int getYEAR_BASIS_PLTY() {
		return YEAR_BASIS_PLTY;
	}
	public void setYEAR_BASIS_PLTY(int yEARBASISPLTY) {
		YEAR_BASIS_PLTY = yEARBASISPLTY;
	}
	public String getMONTH_BASIS_PLTY() {
		return MONTH_BASIS_PLTY;
	}
	public void setMONTH_BASIS_PLTY(String mONTHBASISPLTY) {
		MONTH_BASIS_PLTY = mONTHBASISPLTY;
	}
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	public void setOFFICER_ID(String oFFICER_ID) {
		OFFICER_ID = oFFICER_ID;
	}
	public String getOFFICER_ID() {
		return OFFICER_ID;
	}
	public void setINT_PLTY_BASIS(String iNT_PLTY_BASIS) {
		INT_PLTY_BASIS = iNT_PLTY_BASIS;
	}
	public String getINT_PLTY_BASIS() {
		return INT_PLTY_BASIS;
	}
	
}
