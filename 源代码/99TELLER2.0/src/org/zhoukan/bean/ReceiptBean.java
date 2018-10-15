/*
 * 功能:RECEIPT页面Bean
 * 作者：LBH
 * 时间：2012-03-09
 */
package org.zhoukan.bean;

public class ReceiptBean {
	private String DEBIT_NOTE_NO=null;//通知单号 X
	private String LOAN_KEY=null;//		贷款号 X
	private String DD_KEY=null;//		发放号 X
	private String RECEIPT_KEY=null;// 	回收号 -(系统产生,不可编辑)
	private String BORROWER=null;//		借款人编号
	private String STATUS=null;//		贷款状态
	private String BOOK_BRANCH=null;//	贷款经办机构
	private String LENDER=null;//		借款人姓名
	private String CCY=null;//			币种
	private String LOAN_MANAGER=null;//	贷款管理行
	private String BORROWER_TYPE=null;//贷款类型
	private String LOAN_SUB_TYPE=null;//贷款子类型
	private String RECEIPT=null;//		还款类型
	private String REVOLVE_VN=null;//	是否循环贷款
	private String PAYER=null;//		付款人
	private String RECEIPT_DATE=null;//	还款日期
	private String NARRATIVE=null;//	描述
	private String REPAY_AMT=null;//	还款金额
	private String OUTSTANDING=null;//	贷款余额
	private String recieveMess = null;
	public String getRecieveMess() {
		return recieveMess;
	}
	public void setRecieveMess(String recieveMess) {
		this.recieveMess = recieveMess;
	}
	public String getDEBIT_NOTE_NO() {
		return DEBIT_NOTE_NO;
	}
	public void setDEBIT_NOTE_NO(String dEBITNOTENO) {
		DEBIT_NOTE_NO = dEBITNOTENO;
	}
	public String getLOAN_KEY() {
		return LOAN_KEY;
	}
	public void setLOAN_KEY(String lOANKEY) {
		LOAN_KEY = lOANKEY;
	}
	public String getDD_KEY() {
		return DD_KEY;
	}
	public void setDD_KEY(String dDKEY) {
		DD_KEY = dDKEY;
	}
	public String getRECEIPT_KEY() {
		return RECEIPT_KEY;
	}
	public void setRECEIPT_KEY(String rECEIPTKEY) {
		RECEIPT_KEY = rECEIPTKEY;
	}
	public String getBORROWER() {
		return BORROWER;
	}
	public void setBORROWER(String bORROWER) {
		BORROWER = bORROWER;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getBOOK_BRANCH() {
		return BOOK_BRANCH;
	}
	public void setBOOK_BRANCH(String bOOKBRANCH) {
		BOOK_BRANCH = bOOKBRANCH;
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
	public String getLOAN_MANAGER() {
		return LOAN_MANAGER;
	}
	public void setLOAN_MANAGER(String lOANMANAGER) {
		LOAN_MANAGER = lOANMANAGER;
	}
	public String getBORROWER_TYPE() {
		return BORROWER_TYPE;
	}
	public void setBORROWER_TYPE(String bORROWERTYPE) {
		BORROWER_TYPE = bORROWERTYPE;
	}
	public String getLOAN_SUB_TYPE() {
		return LOAN_SUB_TYPE;
	}
	public void setLOAN_SUB_TYPE(String lOANSUBTYPE) {
		LOAN_SUB_TYPE = lOANSUBTYPE;
	}
	public String getRECEIPT() {
		return RECEIPT;
	}
	public void setRECEIPT(String rECEIPT) {
		RECEIPT = rECEIPT;
	}
	public String getREVOLVE_VN() {
		return REVOLVE_VN;
	}
	public void setREVOLVE_VN(String rEVOLVEVN) {
		REVOLVE_VN = rEVOLVEVN;
	}
	public String getPAYER() {
		return PAYER;
	}
	public void setPAYER(String pAYER) {
		PAYER = pAYER;
	}
	public String getRECEIPT_DATE() {
		return RECEIPT_DATE;
	}
	public void setRECEIPT_DATE(String rECEIPTDATE) {
		RECEIPT_DATE = rECEIPTDATE;
	}
	public String getNARRATIVE() {
		return NARRATIVE;
	}
	public void setNARRATIVE(String nARRATIVE) {
		NARRATIVE = nARRATIVE;
	}
	public String getREPAY_AMT() {
		return REPAY_AMT;
	}
	public void setREPAY_AMT(String rEPAYAMT) {
		REPAY_AMT = rEPAYAMT;
	}
	public String getOUTSTANDING() {
		return OUTSTANDING;
	}
	public void setOUTSTANDING(String oUTSTANDING) {
		OUTSTANDING = oUTSTANDING;
	}
	
}
