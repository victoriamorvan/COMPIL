package Stitch;

public class Stitch {
	public String coumpound_id_m;
	public String coumpound_id_s;
	public String id_atc;
	
	public Stitch (String coumpound_id_m,String coummound_id_s,String id_atc){
		this.coumpound_id_m=coumpound_id_m;
		this.coumpound_id_s=coumpound_id_s;
		this.id_atc=id_atc;
	}

	public String getCoumpound_id_s() {
		return coumpound_id_s;
	}

	public void setCoumpound_id_s(String coumpound_id_s) {
		this.coumpound_id_s = coumpound_id_s;
	}

	public String getCoumpound_id_m() {
		return coumpound_id_m;
	}

	public void setCoumpound_id_m(String coumpound_id_m) {
		this.coumpound_id_m = coumpound_id_m;
	}

	public String getId_atc() {
		return id_atc;
	}

	public void setId_atc(String id_atc) {
		this.id_atc = id_atc;
	}
}
