/**
 * 作者：郝晓婷
 * 日期：2012-03-07
 * 功能：Teller端计提Bean
 */
package org.zhoukan.bean;

public class AccrualsBean {
	private String LOAN_NO;//贷款编号***计提
	private int DD_KEY;//发放对应KEY值
	private String DD_NO;//每笔发放号***计提(发放号)
	
	private int LOAN_KEY;//贷款对应KEY值
	private String FROM_DATE;//利息计算分段的起息日
	private String TO_DATE;//利息分段的截止日期，这个字段在每个发放的最后一条的记录为空
	
	private int OS_LESS_PAST_DUE;//未逾期本金利息
	private int INT_COMPUNDED;//利息复利金额
	private int PRINCRPAL_BALANCE;//未逾期本金
	private String INT_BASISRATE;//正常利息利率基准的对应利率
	private String INT_RATE;//生效利率
	private String PRI_PLTI_RATE;//本金罚息率
	private String PRI_PLTY_ABS;//本金固定罚息率
	private String INT_PITY_RATE;//利息罚息率
	private String INT_PITY_ABS;//利息固定罚息率
	private String PRI_PAST_DUE;//逾期本金
	private String INT_PAST_DUE;//逾期利息
	private String ODI_PAST_DUE;//逾期利息复利
	private String ODP_PAST_UDE;//逾期罚息
	private String INT_CALCULATED;//累计利息
	private String OD_INT_CALCULATED;//累积复利
	private String OD_PRI_CALCULATED;//累积罚息
	
	private String INTEREST_AMT;//本次计提利息(应计)
	private String PENALTY_AMT_INT;//本次计提复利(应计)
	private String PENALTY_AMT_PRI;//本次计提罚息(应计)
	
	private int LAST_CHANGE_DATE;//最后一个记录修改日
	
	
	private String LENDER;//贷款人
	private String STATUS = null;//贷款状态
	private int ORIG_LOAN_AMT;//合同金额
	private int DD_AMT;//发放金额(发放表)
	
	private int OUTSTANDING;//发放当前余额
	
	private int NOT_FOND; //未发放金额
	
	private String LOAN_TYPE = null;//贷款类型
	private String LOAN_SUB_TYPE  = null;//贷款子类型
	private String BOOK_BRANCH   = null;//贷款经办机构
	private String DD_DATE = null;//发放日期
	private String INT_OUTSTANDING; //应收利息
	private String DOP_OUTSTANDING; //应收罚息
	private String ODI_OUTSTANDING; //应收罚息

	
	private String recieveMess = null;
	
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}

	public String getLOAN_NO() {
		return LOAN_NO;
	}

	public void setLOAN_NO(String lOAN_NO) {
		LOAN_NO = lOAN_NO;
	}

	public int getDD_KEY() {
		return DD_KEY;
	}

	public void setDD_KEY(int dD_KEY) {
		DD_KEY = dD_KEY;
	}

	public String getDD_NO() {
		return DD_NO;
	}

	public void setDD_NO(String dD_NO) {
		DD_NO = dD_NO;
	}

	public int getLOAN_KEY() {
		return LOAN_KEY;
	}

	public void setLOAN_KEY(int lOAN_KEY) {
		LOAN_KEY = lOAN_KEY;
	}

	public String getFROM_DATE() {
		return FROM_DATE;
	}

	public void setFROM_DATE(String fROM_DATE) {
		FROM_DATE = fROM_DATE;
	}

	public String getTO_DATE() {
		return TO_DATE;
	}

	public void setTO_DATE(String tO_DATE) {
		TO_DATE = tO_DATE;
	}

	public int getDD_AMT() {
		return DD_AMT;
	}

	public void setDD_AMT(int dD_AMT) {
		DD_AMT = dD_AMT;
	}

	public int getOS_LESS_PAST_DUE() {
		return OS_LESS_PAST_DUE;
	}

	public void setOS_LESS_PAST_DUE(int oS_LESS_PAST_DUE) {
		OS_LESS_PAST_DUE = oS_LESS_PAST_DUE;
	}

	public int getINT_COMPUNDED() {
		return INT_COMPUNDED;
	}

	public void setINT_COMPUNDED(int iNT_COMPUNDED) {
		INT_COMPUNDED = iNT_COMPUNDED;
	}

	public int getPRINCRPAL_BALANCE() {
		return PRINCRPAL_BALANCE;
	}

	public void setPRINCRPAL_BALANCE(int pRINCRPAL_BALANCE) {
		PRINCRPAL_BALANCE = pRINCRPAL_BALANCE;
	}

	public String getINT_BASISRATE() {
		return INT_BASISRATE;
	}

	public void setINT_BASISRATE(String iNT_BASISRATE) {
		INT_BASISRATE = iNT_BASISRATE;
	}
	public String getINT_RATE() {
		return INT_RATE;
	}

	public void setINT_RATE(String iNT_RATE) {
		INT_RATE = iNT_RATE;
	}

	public String getPRI_PLTI_RATE() {
		return PRI_PLTI_RATE;
	}

	public void setPRI_PLTI_RATE(String pRI_PLTI_RATE) {
		PRI_PLTI_RATE = pRI_PLTI_RATE;
	}

	public String getPRI_PLTY_ABS() {
		return PRI_PLTY_ABS;
	}

	public void setPRI_PLTY_ABS(String pRI_PLTY_ABS) {
		PRI_PLTY_ABS = pRI_PLTY_ABS;
	}

	public String getINT_PITY_RATE() {
		return INT_PITY_RATE;
	}

	public void setINT_PITY_RATE(String iNT_PITY_RATE) {
		INT_PITY_RATE = iNT_PITY_RATE;
	}

	public String getINT_PITY_ABS() {
		return INT_PITY_ABS;
	}

	public void setINT_PITY_ABS(String iNT_PITY_ABS) {
		INT_PITY_ABS = iNT_PITY_ABS;
	}

	public String getPRI_PAST_DUE() {
		return PRI_PAST_DUE;
	}

	public void setPRI_PAST_DUE(String pRI_PAST_DUE) {
		PRI_PAST_DUE = pRI_PAST_DUE;
	}

	public String getINT_PAST_DUE() {
		return INT_PAST_DUE;
	}

	public void setINT_PAST_DUE(String iNT_PAST_DUE) {
		INT_PAST_DUE = iNT_PAST_DUE;
	}

	public String getODI_PAST_DUE() {
		return ODI_PAST_DUE;
	}

	public void setODI_PAST_DUE(String oDI_PAST_DUE) {
		ODI_PAST_DUE = oDI_PAST_DUE;
	}

	public String getODP_PAST_UDE() {
		return ODP_PAST_UDE;
	}

	public void setODP_PAST_UDE(String oDP_PAST_UDE) {
		ODP_PAST_UDE = oDP_PAST_UDE;
	}

	public String getINT_CALCULATED() {
		return INT_CALCULATED;
	}

	public void setINT_CALCULATED(String iNT_CALCULATED) {
		INT_CALCULATED = iNT_CALCULATED;
	}

	public String getOD_INT_CALCULATED() {
		return OD_INT_CALCULATED;
	}

	public void setOD_INT_CALCULATED(String oD_INT_CALCULATED) {
		OD_INT_CALCULATED = oD_INT_CALCULATED;
	}

	public String getOD_PRI_CALCULATED() {
		return OD_PRI_CALCULATED;
	}

	public void setOD_PRI_CALCULATED(String oD_PRI_CALCULATED) {
		OD_PRI_CALCULATED = oD_PRI_CALCULATED;
	}

	public String getINTEREST_AMT() {
		return INTEREST_AMT;
	}

	public void setINTEREST_AMT(String iNTEREST_AMT) {
		INTEREST_AMT = iNTEREST_AMT;
	}

	public String getPENALTY_AMT_INT() {
		return PENALTY_AMT_INT;
	}

	public void setPENALTY_AMT_INT(String pENALTY_AMT_INT) {
		PENALTY_AMT_INT = pENALTY_AMT_INT;
	}

	public String getPENALTY_AMT_PRI() {
		return PENALTY_AMT_PRI;
	}

	public void setPENALTY_AMT_PRI(String pENALTY_AMT_PRI) {
		PENALTY_AMT_PRI = pENALTY_AMT_PRI;
	}

	public int getLAST_CHANGE_DATE() {
		return LAST_CHANGE_DATE;
	}

	public void setLAST_CHANGE_DATE(int lAST_CHANGE_DATE) {
		LAST_CHANGE_DATE = lAST_CHANGE_DATE;
	}

	public String getLENDER() {
		return LENDER;
	}

	public void setLENDER(String lENDER) {
		LENDER = lENDER;
	}
	
	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	public int getORIG_LOAN_AMT() {
		return ORIG_LOAN_AMT;
	}

	public void setORIG_LOAN_AMT(int oRIG_LOAN_AMT) {
		ORIG_LOAN_AMT = oRIG_LOAN_AMT;
	}
	
	public int getNOT_FOND() {
		return NOT_FOND;
	}

	public void setNOT_FOND(int nOT_FOND) {
		NOT_FOND = nOT_FOND;
	}
	
	public String getINT_OUTSTANDING() {
		return INT_OUTSTANDING;
	}

	public void setINT_OUTSTANDING(String iNT_OUTSTANDING) {
		INT_OUTSTANDING = iNT_OUTSTANDING;
	}
	
	public String getDOP_OUTSTANDING() {
		return DOP_OUTSTANDING;
	}

	public void setDOP_OUTSTANDING(String dOP_OUTSTANDING) {
		DOP_OUTSTANDING = dOP_OUTSTANDING;
	}
	
	public String getODI_OUTSTANDING() {
		return ODI_OUTSTANDING;
	}

	public void setODI_OUTSTANDING(String oDI_OUTSTANDING) {
		ODI_OUTSTANDING = oDI_OUTSTANDING;
	}
	
	public int getOUTSTANDING() {
		return OUTSTANDING;
	}

	public void setOUTSTANDING(int oUTSTANDING) {
		OUTSTANDING = oUTSTANDING;
	}
	
	public String getLOAN_TYPE() {
		return LOAN_TYPE;
	}
	public void setLOAN_TYPE(String lOAN_TYPE) {
		LOAN_TYPE = lOAN_TYPE;
	}
	
	public String getLOAN_SUB_TYPE() {
		return LOAN_SUB_TYPE;
	}
	public void setLOAN_SUB_TYPE(String lOAN_SUB_TYPE) {
		LOAN_SUB_TYPE = lOAN_SUB_TYPE;
	}
	
	public String getBOOK_BRANCH() {
		return BOOK_BRANCH;
	}
	public void setBOOK_BRANCH(String bOOK_BRANCH) {
		BOOK_BRANCH = bOOK_BRANCH;
	}
	
	public String getDD_DATE() {
		return DD_DATE;
	}
	public void setDD_DATE(String dD_DATE) {
		DD_DATE = dD_DATE;
	}
}
