package common;

import java.sql.Date;

public class CmnPayDTO {
	private String PAY_Code;//PK
	private String PAY_Type;
	private Date PAY_Date;
	//FK
	private String MEMSHIPSCHE_Code;
	private String RES_Code;
	private String PRMSCHE_Code;
	
	public CmnPayDTO() {
		// TODO Auto-generated constructor stub
	}
	public CmnPayDTO(CmnPayDTO DTO) {
		PAY_Code = DTO.getPAY_Code();
		PAY_Type = DTO.getPAY_Type();
		PAY_Date = DTO.getPAY_Date();
		MEMSHIPSCHE_Code = DTO.getMEMSHIPSCHE_Code();
		RES_Code = DTO.getRES_Code();
		PRMSCHE_Code = DTO.getPRMSCHE_Code();
	}
	public CmnPayDTO(String pAY_Code, String pAY_Type, 
			Date pAY_Date, String mEMSHIPSCHE_Code, 
			String rES_Code, String pRMSCHE_Code) {
		super();
		PAY_Code = pAY_Code;
		PAY_Type = pAY_Type;
		PAY_Date = pAY_Date;
		MEMSHIPSCHE_Code = mEMSHIPSCHE_Code;
		RES_Code = rES_Code;
		PRMSCHE_Code = pRMSCHE_Code;
	}

	public String getPAY_Code() {
		return PAY_Code;
	}

	public void setPAY_Code(String pAY_Code) {
		PAY_Code = pAY_Code;
	}

	public String getPAY_Type() {
		return PAY_Type;
	}

	public void setPAY_Type(String pAY_Type) {
		PAY_Type = pAY_Type;
	}

	public Date getPAY_Date() {
		return PAY_Date;
	}

	public void setPAY_Date(Date pAY_Date) {
		PAY_Date = pAY_Date;
	}

	public String getMEMSHIPSCHE_Code() {
		return MEMSHIPSCHE_Code;
	}

	public void setMEMSHIPSCHE_Code(String mEMSHIPSCHE_Code) {
		MEMSHIPSCHE_Code = mEMSHIPSCHE_Code;
	}

	public String getRES_Code() {
		return RES_Code;
	}

	public void setRES_Code(String rES_Code) {
		RES_Code = rES_Code;
	}
	public String getPRMSCHE_Code() {
		return PRMSCHE_Code;
	}
	public void setPRMSCHE_Code(String pRMSCHE_Code) {
		PRMSCHE_Code = pRMSCHE_Code;
	}
	
	
}
