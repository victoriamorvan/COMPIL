package OMIM;

public class OMIM_csv {
	public String preferedLabel;
	public String synonyms;
	public String cui;

	
	public OMIM_csv (String preferedLabel, String synonyms, String cui){
		this.preferedLabel=preferedLabel;
		this.synonyms=synonyms;
		this.cui=cui;
	
	}

	@Override
	public String toString() {
		return "OMIM_csv [preferedLabel=" + preferedLabel + ", synonyms=" + synonyms + ", cui=" + cui + "]";
	}

	public String getPreferedLabel() {
		return preferedLabel;
	}

	public void setPreferedLabel(String preferedLabel) {
		this.preferedLabel = preferedLabel;
	}

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public String getCui() {
		return cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	

}
