package org.zhoukan.bean;

public class Fm_acctBean {
	private int INTERNAL_KEY = -1;
	private String BRANCH = null;
	private String CCY = null;
	private String CLIENT_NO = null;
	private String GLOBAL_ID_TYPE = null;
	private String GLOBAL_ID = null;
	private String CERTIFICATE_NO = null;
	private String CLIENT_SHORT = null;
	private String PROFIT_CENTRE = null;
	private String ACCT_OPEN_DATE = null;
	private String OPEN_TRAN_DATE = null;
	private String ACCT_STATUS = null;
	private String ACCT_TYPE = null;
	private String ACCT_DECS = null;
	private String DEPOSIT_TYPE = null;
	private String ACTUAL_OR_LEDGER_BAL = null;
	private String STMT_PBK = null;
	private String DEL_FLAG = null;
	private String RESTRAINT_PRESENT = null;
	private int LEDGER_BAL = 0;
	private int ACUAL_BAL = 0;
	private int PREV_DAY_LEDGER_BAL = 0;
	private int PREV_DAY_ACUAL_BAL = 0;
	private int TOLERANCE_AMT = 0;
	private int TOTAL_AUTH_OD = 0;
	private String USER_ID = null;
	private String OFFICER_ID = null;
	private String LAST_CHANGE_OFFICER = null;
	private String TRAN_DATE = null;
	private String LAST_TRAN_DATE = null;
	private String ACCT_CLOSE_DAYE = null;
	private String ACCT_CLOSE_REASON = null;
	private String CATEGORY_TYPE = null;
	private String CLIENT_TYPE = null;
	private String ACCT_CLOSE_OFFICE = null;
	private String LAST_ATT_STATUS = null;
	private String TRAN_ALLOWED = null;
	private int AGG_BAL = 0;
	private int PREV_DAY_AGG_BAL = 0;
	private String BASE_ACCT_NO = null;
	private String BASE_INTERNAL_KEY = null;
	private String CH_ACCT_NAME = null;
	private String ALT_ACCT_NAME = null;
	private String ACCT_NATURE = null;
	private String ISLOCKED = null;
	
	public String getWITHDRAWING_AMT() {
		return WITHDRAWING_AMT;
	}
	public void setWITHDRAWING_AMT(String wITHDRAWING_AMT) {
		WITHDRAWING_AMT = wITHDRAWING_AMT;
	}
	//※※※※※※※※※※※※※※※※※※※※新增变量※※※※※※※※※※※※※※※※※※※※※※
	//取款需要
	private String WITHDRAWING_AMT = null;
	
	private String SAVE_AMT = null;
	//修改利息需要
	private String CUR_INT = null;
	//※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
	public String getCUR_INT() {
		return CUR_INT;
	}
	public void setCUR_INT(String cUR_INT) {
		CUR_INT = cUR_INT;
	}
	public String getACC_INT() {
		return ACC_INT;
	}
	public void setACC_INT(String aCC_INT) {
		ACC_INT = aCC_INT;
	}
	private String ACC_INT = null;

	public String getSAVE_AMT() {
		return SAVE_AMT;
	}
	public void setSAVE_AMT(String sAVE_AMT) {
		SAVE_AMT = sAVE_AMT;
	}
	
	
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getCLIENT_NO() {
		return CLIENT_NO;
	}
	public void setCLIENT_NO(String cLIENTNO) {
		CLIENT_NO = cLIENTNO;
	}
	public String getGLOBAL_ID_TYPE() {
		return GLOBAL_ID_TYPE;
	}
	public void setGLOBAL_ID_TYPE(String gLOBALIDTYPE) {
		GLOBAL_ID_TYPE = gLOBALIDTYPE;
	}
	public String getGLOBAL_ID() {
		return GLOBAL_ID;
	}
	public void setGLOBAL_ID(String gLOBALID) {
		GLOBAL_ID = gLOBALID;
	}
	public String getCERTIFICATE_NO() {
		return CERTIFICATE_NO;
	}
	public void setCERTIFICATE_NO(String cERTIFICATENO) {
		CERTIFICATE_NO = cERTIFICATENO;
	}
	public String getCLIENT_SHORT() {
		return CLIENT_SHORT;
	}
	public void setCLIENT_SHORT(String cLIENTSHORT) {
		CLIENT_SHORT = cLIENTSHORT;
	}
	public String getPROFIT_CENTRE() {
		return PROFIT_CENTRE;
	}
	public void setPROFIT_CENTRE(String pROFITCENTRE) {
		PROFIT_CENTRE = pROFITCENTRE;
	}
	public String getACCT_OPEN_DATE() {
		return ACCT_OPEN_DATE;
	}
	public void setACCT_OPEN_DATE(String aCCTOPENDATE) {
		ACCT_OPEN_DATE = aCCTOPENDATE;
	}
	public String getOPEN_TRAN_DATE() {
		return OPEN_TRAN_DATE;
	}
	public void setOPEN_TRAN_DATE(String oPENTRANDATE) {
		OPEN_TRAN_DATE = oPENTRANDATE;
	}
	public String getACCT_STATUS() {
		return ACCT_STATUS;
	}
	public void setACCT_STATUS(String aCCTSTATUS) {
		ACCT_STATUS = aCCTSTATUS;
	}
	public String getACCT_TYPE() {
		return ACCT_TYPE;
	}
	public void setACCT_TYPE(String aCCTTYPE) {
		ACCT_TYPE = aCCTTYPE;
	}
	public String getACCT_DECS() {
		return ACCT_DECS;
	}
	public void setACCT_DECS(String aCCTDECS) {
		ACCT_DECS = aCCTDECS;
	}
	public String getDEPOSIT_TYPE() {
		return DEPOSIT_TYPE;
	}
	public void setDEPOSIT_TYPE(String dEPOSITTYPE) {
		DEPOSIT_TYPE = dEPOSITTYPE;
	}
	public String getACTUAL_OR_LEDGER_BAL() {
		return ACTUAL_OR_LEDGER_BAL;
	}
	public void setACTUAL_OR_LEDGER_BAL(String aCTUALORLEDGERBAL) {
		ACTUAL_OR_LEDGER_BAL = aCTUALORLEDGERBAL;
	}
	public String getSTMT_PBK() {
		return STMT_PBK;
	}
	public void setSTMT_PBK(String sTMTPBK) {
		STMT_PBK = sTMTPBK;
	}
	public String getDEL_FLAG() {
		return DEL_FLAG;
	}
	public void setDEL_FLAG(String dELFLAG) {
		DEL_FLAG = dELFLAG;
	}
	public String getRESTRAINT_PRESENT() {
		return RESTRAINT_PRESENT;
	}
	public void setRESTRAINT_PRESENT(String rESTRAINTPRESENT) {
		RESTRAINT_PRESENT = rESTRAINTPRESENT;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}
	public String getOFFICER_ID() {
		return OFFICER_ID;
	}
	public void setOFFICER_ID(String oFFICERID) {
		OFFICER_ID = oFFICERID;
	}
	public String getLAST_CHANGE_OFFICER() {
		return LAST_CHANGE_OFFICER;
	}
	public void setLAST_CHANGE_OFFICER(String lASTCHANGEOFFICER) {
		LAST_CHANGE_OFFICER = lASTCHANGEOFFICER;
	}
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRANDATE) {
		TRAN_DATE = tRANDATE;
	}
	public String getLAST_TRAN_DATE() {
		return LAST_TRAN_DATE;
	}
	public void setLAST_TRAN_DATE(String lASTTRANDATE) {
		LAST_TRAN_DATE = lASTTRANDATE;
	}
	public String getACCT_CLOSE_DAYE() {
		return ACCT_CLOSE_DAYE;
	}
	public void setACCT_CLOSE_DAYE(String aCCTCLOSEDAYE) {
		ACCT_CLOSE_DAYE = aCCTCLOSEDAYE;
	}
	public String getACCT_CLOSE_REASON() {
		return ACCT_CLOSE_REASON;
	}
	public void setACCT_CLOSE_REASON(String aCCTCLOSEREASON) {
		ACCT_CLOSE_REASON = aCCTCLOSEREASON;
	}
	public String getCATEGORY_TYPE() {
		return CATEGORY_TYPE;
	}
	public void setCATEGORY_TYPE(String cATEGORYTYPE) {
		CATEGORY_TYPE = cATEGORYTYPE;
	}
	public String getCLIENT_TYPE() {
		return CLIENT_TYPE;
	}
	public void setCLIENT_TYPE(String cLIENTTYPE) {
		CLIENT_TYPE = cLIENTTYPE;
	}
	public String getACCT_CLOSE_OFFICE() {
		return ACCT_CLOSE_OFFICE;
	}
	public void setACCT_CLOSE_OFFICE(String aCCTCLOSEOFFICE) {
		ACCT_CLOSE_OFFICE = aCCTCLOSEOFFICE;
	}
	public String getLAST_ATT_STATUS() {
		return LAST_ATT_STATUS;
	}
	public void setLAST_ATT_STATUS(String lASTATTSTATUS) {
		LAST_ATT_STATUS = lASTATTSTATUS;
	}
	public String getTRAN_ALLOWED() {
		return TRAN_ALLOWED;
	}
	public void setTRAN_ALLOWED(String tRANALLOWED) {
		TRAN_ALLOWED = tRANALLOWED;
	}
	
	public String getBASE_ACCT_NO() {
		return BASE_ACCT_NO;
	}
	public void setBASE_ACCT_NO(String bASEACCTNO) {
		BASE_ACCT_NO = bASEACCTNO;
	}
	public String getBASE_INTERNAL_KEY() {
		return BASE_INTERNAL_KEY;
	}
	public void setBASE_INTERNAL_KEY(String bASEINTERNALKEY) {
		BASE_INTERNAL_KEY = bASEINTERNALKEY;
	}
	public String getCH_ACCT_NAME() {
		return CH_ACCT_NAME;
	}
	public void setCH_ACCT_NAME(String cHACCTNAME) {
		CH_ACCT_NAME = cHACCTNAME;
	}
	public String getALT_ACCT_NAME() {
		return ALT_ACCT_NAME;
	}
	public void setALT_ACCT_NAME(String aLTACCTNAME) {
		ALT_ACCT_NAME = aLTACCTNAME;
	}
	public String getACCT_NATURE() {
		return ACCT_NATURE;
	}
	public void setACCT_NATURE(String aCCTNATURE) {
		ACCT_NATURE = aCCTNATURE;
	}
	public String getISLOCKED() {
		return ISLOCKED;
	}
	public void setISLOCKED(String iSLOCKED) {
		ISLOCKED = iSLOCKED;
	}
	public int getINTERNAL_KEY() {
		return INTERNAL_KEY;
	}
	public void setINTERNAL_KEY(int iNTERNALKEY) {
		INTERNAL_KEY = iNTERNALKEY;
	}
	public int getLEDGER_BAL() {
		return LEDGER_BAL;
	}
	public void setLEDGER_BAL(int lEDGERBAL) {
		LEDGER_BAL = lEDGERBAL;
	}
	public int getACUAL_BAL() {
		return ACUAL_BAL;
	}
	public void setACUAL_BAL(int aCUALBAL) {
		ACUAL_BAL = aCUALBAL;
	}
	public int getPREV_DAY_LEDGER_BAL() {
		return PREV_DAY_LEDGER_BAL;
	}
	public void setPREV_DAY_LEDGER_BAL(int pREVDAYLEDGERBAL) {
		PREV_DAY_LEDGER_BAL = pREVDAYLEDGERBAL;
	}
	public int getPREV_DAY_ACUAL_BAL() {
		return PREV_DAY_ACUAL_BAL;
	}
	public void setPREV_DAY_ACUAL_BAL(int pREVDAYACUALBAL) {
		PREV_DAY_ACUAL_BAL = pREVDAYACUALBAL;
	}
	public int getTOLERANCE_AMT() {
		return TOLERANCE_AMT;
	}
	public void setTOLERANCE_AMT(int tOLERANCEAMT) {
		TOLERANCE_AMT = tOLERANCEAMT;
	}
	public int getTOTAL_AUTH_OD() {
		return TOTAL_AUTH_OD;
	}
	public void setTOTAL_AUTH_OD(int tOTALAUTHOD) {
		TOTAL_AUTH_OD = tOTALAUTHOD;
	}
	public int getAGG_BAL() {
		return AGG_BAL;
	}
	public void setAGG_BAL(int aGGBAL) {
		AGG_BAL = aGGBAL;
	}
	public int getPREV_DAY_AGG_BAL() {
		return PREV_DAY_AGG_BAL;
	}
	public void setPREV_DAY_AGG_BAL(int pREVDAYAGGBAL) {
		PREV_DAY_AGG_BAL = pREVDAYAGGBAL;
	}
	
}
