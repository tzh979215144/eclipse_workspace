package org.zhoukan.bean;

/**
 * 计提Bean
 * @author 郝晓婷
 *
 */
public class CL_AccrualsBean {
	private String LOAN_NO;//贷款编号***计提
	private int DD_KEY;//发放对应KEY值
	private int SEQ_NO;//每笔发放顺序号***计提
	
	private int LOAN_KEY;//贷款对应KEY值
	private String FROM_DATE;//利息计算分段的起息日
	private String TO_DATE=null;//利息分段的截止日期，这个字段在每个发放的最后一条的记录为空
	private int DD_AMT;//发放当前余额
	private int OS_LESS_PAST_DUE;//未逾期本金利息
	private int INT_COMPUNDED;//利息复利金额
	private int PRINCRPAL_BALANCE;//未逾期本金
	
	private float INT_BASISRATE;//正常利息利率基准的对应利率
	private float INT_RATE;//生效利率
	private float PRI_PLTI_RATE;//本金罚息率
	private float PRI_PLTY_ABS;//本金固定罚息率
	private float INT_PITY_RATE;//利息罚息率
	private float INT_PITY_ABS;//利息固定罚息率
	
	private int PRI_PAST_DUE;//逾期本金
	private int INT_PAST_DUE;//逾期利息
	private int ODI_PAST_DUE;//逾期利息复利
	private int ODP_PAST_UDE;//逾期罚息
	private int INT_CALCULATED;//累计利息
	private int OD_INT_CALCULATED;//累积复利
	private int OD_PRI_CALCULATED;//累积罚息
	
	private int INTEREST_AMT;//本次计提利息
	private int PENALTY_AMT_INT;//本次计提复利
	private int PENALTY_AMT_PRI;//本次计提罚息
	
	private int LAST_CHANGE_DATE;//最后一个记录修改日
	
	private int ODI_COMPUNDED;
	private int ODP_COMPUNDED;
	private int FIXED_INT_RATE;
	private int OD_ODP_CALUCULATED;
	private int OD_ODI_CALUCULATED;
	private String LENDER;//贷款人
	
	private int NOT_FOND; //未发放金额
	
	public int getNOT_FOND() {
		return NOT_FOND;
	}

	public void setNOT_FOND(int nOT_FOND) {
		NOT_FOND = nOT_FOND;
	}

	public String getLENDER() {
		return LENDER;
	}

	public void setLENDER(String lENDER) {
		LENDER = lENDER;
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

	public int getSEQ_NO() {
		return SEQ_NO;
	}

	public void setSEQ_NO(int sEQ_NO) {
		SEQ_NO = sEQ_NO;
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

	public int getODI_COMPUNDED() {
		return ODI_COMPUNDED;
	}

	public void setODI_COMPUNDED(int oDI_COMPUNDED) {
		ODI_COMPUNDED = oDI_COMPUNDED;
	}

	public int getODP_COMPUNDED() {
		return ODP_COMPUNDED;
	}

	public void setODP_COMPUNDED(int oDP_COMPUNDED) {
		ODP_COMPUNDED = oDP_COMPUNDED;
	}

	public int getPRINCRPAL_BALANCE() {
		return PRINCRPAL_BALANCE;
	}

	public void setPRINCRPAL_BALANCE(int pRINCRPAL_BALANCE) {
		PRINCRPAL_BALANCE = pRINCRPAL_BALANCE;
	}

	public float getINT_BASISRATE() {
		return INT_BASISRATE;
	}

	public void setINT_BASISRATE(float iNT_BASISRATE) {
		INT_BASISRATE = iNT_BASISRATE;
	}

	public int getFIXED_INT_RATE() {
		return FIXED_INT_RATE;
	}

	public void setFIXED_INT_RATE(int fIXED_INT_RATE) {
		FIXED_INT_RATE = fIXED_INT_RATE;
	}

	public float getINT_RATE() {
		return INT_RATE;
	}

	public void setINT_RATE(float iNT_RATE) {
		INT_RATE = iNT_RATE;
	}

	public float getPRI_PLTI_RATE() {
		return PRI_PLTI_RATE;
	}

	public void setPRI_PLTI_RATE(float pRI_PLTI_RATE) {
		PRI_PLTI_RATE = pRI_PLTI_RATE;
	}

	public float getPRI_PLTY_ABS() {
		return PRI_PLTY_ABS;
	}

	public void setPRI_PLTY_ABS(float pRI_PLTY_ABS) {
		PRI_PLTY_ABS = pRI_PLTY_ABS;
	}

	public float getINT_PITY_RATE() {
		return INT_PITY_RATE;
	}

	public void setINT_PITY_RATE(float iNT_PITY_RATE) {
		INT_PITY_RATE = iNT_PITY_RATE;
	}

	public float getINT_PITY_ABS() {
		return INT_PITY_ABS;
	}

	public void setINT_PITY_ABS(float iNT_PITY_ABS) {
		INT_PITY_ABS = iNT_PITY_ABS;
	}

	public int getPRI_PAST_DUE() {
		return PRI_PAST_DUE;
	}

	public void setPRI_PAST_DUE(int pRI_PAST_DUE) {
		PRI_PAST_DUE = pRI_PAST_DUE;
	}

	public int getINT_PAST_DUE() {
		return INT_PAST_DUE;
	}

	public void setINT_PAST_DUE(int iNT_PAST_DUE) {
		INT_PAST_DUE = iNT_PAST_DUE;
	}

	public int getODI_PAST_DUE() {
		return ODI_PAST_DUE;
	}

	public void setODI_PAST_DUE(int oDI_PAST_DUE) {
		ODI_PAST_DUE = oDI_PAST_DUE;
	}

	public int getODP_PAST_UDE() {
		return ODP_PAST_UDE;
	}

	public void setODP_PAST_UDE(int oDP_PAST_UDE) {
		ODP_PAST_UDE = oDP_PAST_UDE;
	}

	public int getINT_CALCULATED() {
		return INT_CALCULATED;
	}

	public void setINT_CALCULATED(int iNT_CALCULATED) {
		INT_CALCULATED = iNT_CALCULATED;
	}

	public int getOD_INT_CALCULATED() {
		return OD_INT_CALCULATED;
	}

	public void setOD_INT_CALCULATED(int oD_INT_CALCULATED) {
		OD_INT_CALCULATED = oD_INT_CALCULATED;
	}

	public int getOD_PRI_CALCULATED() {
		return OD_PRI_CALCULATED;
	}

	public void setOD_PRI_CALCULATED(int oD_PRI_CALCULATED) {
		OD_PRI_CALCULATED = oD_PRI_CALCULATED;
	}

	public int getINTEREST_AMT() {
		return INTEREST_AMT;
	}

	public void setINTEREST_AMT(int iNTEREST_AMT) {
		INTEREST_AMT = iNTEREST_AMT;
	}

	public int getPENALTY_AMT_INT() {
		return PENALTY_AMT_INT;
	}

	public void setPENALTY_AMT_INT(int pENALTY_AMT_INT) {
		PENALTY_AMT_INT = pENALTY_AMT_INT;
	}

	public int getPENALTY_AMT_PRI() {
		return PENALTY_AMT_PRI;
	}

	public void setPENALTY_AMT_PRI(int pENALTY_AMT_PRI) {
		PENALTY_AMT_PRI = pENALTY_AMT_PRI;
	}

	public int getOD_ODP_CALUCULATED() {
		return OD_ODP_CALUCULATED;
	}

	public void setOD_ODP_CALUCULATED(int oD_ODP_CALUCULATED) {
		OD_ODP_CALUCULATED = oD_ODP_CALUCULATED;
	}

	public int getOD_ODI_CALUCULATED() {
		return OD_ODI_CALUCULATED;
	}

	public void setOD_ODI_CALUCULATED(int oD_ODI_CALUCULATED) {
		OD_ODI_CALUCULATED = oD_ODI_CALUCULATED;
	}

	public int getLAST_CHANGE_DATE() {
		return LAST_CHANGE_DATE;
	}

	public void setLAST_CHANGE_DATE(int lAST_CHANGE_DATE) {
		LAST_CHANGE_DATE = lAST_CHANGE_DATE;
	}

}
