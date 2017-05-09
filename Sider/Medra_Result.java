package Sider;

public class Medra_Result {

		String CUI ;
		String stitch_compound_id1;
		String stitch_compound_id2;
	
	public Medra_Result(){
	}
	
	public Medra_Result(String cui, String id1, String id2){
		this.CUI=cui;
		this.stitch_compound_id1=id1;
		this.stitch_compound_id2=id2;
	}

	@Override
	public String toString() {
		return "Medra_Result [CUI=" + CUI + ", stitch_compound_id1=" + stitch_compound_id1 + ", stitch_compound_id2="
				+ stitch_compound_id2 + "]";
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String cUI) {
		CUI = cUI;
	}

	public String getStitch_compound_id1() {
		return stitch_compound_id1;
	}

	public void setStitch_compound_id1(String stitch_compound_id1) {
		this.stitch_compound_id1 = stitch_compound_id1;
	}

	public String getStitch_compound_id2() {
		return stitch_compound_id2;
	}

	public void setStitch_compound_id2(String stitch_compound_id2) {
		this.stitch_compound_id2 = stitch_compound_id2;
	}
	
	
}
