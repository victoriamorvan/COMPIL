package OMIM;

public class OMIM_txt {
	public String fieldNo;
	public String fieldTi;
	public String description;
	public String symptomes;
	
	public OMIM_txt(){
		
	}
	public OMIM_txt(String fieldNo,String fieldTi,String description, String symptomes){
		this.fieldNo=fieldNo;
		this.fieldTi=fieldTi;
		this.description=description;
		this.symptomes=symptomes;
	}

	@Override
	public String toString() {
		return "OMIM_txt [fieldNo=" + fieldNo + ", fieldTi=" + fieldTi + ", description=" + description + ", symptomes="
				+ symptomes + "]";
	}

	public String getFieldNo() {
		return fieldNo;
	}

	public void setFieldNo(String fieldNo) {
		this.fieldNo = fieldNo;
	}

	public String getFieldTi() {
		return fieldTi;
	}

	public void setFieldTi(String fieldTi) {
		this.fieldTi = fieldTi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSymptomes() {
		return symptomes;
	}

	public void setSymptomes(String symptomes) {
		this.symptomes = symptomes;
	}

}
