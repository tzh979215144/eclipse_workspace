package org.zhoukan.bean;

public class ESBServiceBean {
	private String TELLER_TRAN_NO = null;
	private String SYMBOLS_TRAN_NO = null;
	private String SUB_SERVICE_CLASS = null;
	private String xml = null;
	
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getTELLER_TRAN_NO() {
		return TELLER_TRAN_NO;
	}
	public void setTELLER_TRAN_NO(String tELLERTRANNO) {
		TELLER_TRAN_NO = tELLERTRANNO;
	}
	public String getSYMBOLS_TRAN_NO() {
		return SYMBOLS_TRAN_NO;
	}
	public void setSYMBOLS_TRAN_NO(String sYMBOLSTRANNO) {
		SYMBOLS_TRAN_NO = sYMBOLSTRANNO;
	}
	public String getSUB_SERVICE_CLASS() {
		return SUB_SERVICE_CLASS;
	}
	public void setSUB_SERVICE_CLASS(String sUBSERVICECLASS) {
		SUB_SERVICE_CLASS = sUBSERVICECLASS;
	}
}
