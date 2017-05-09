package HPO;

public class HPO_obo {
	
	public String id;
	public String nom;
	public String xref;
	public String synonyms;
	public HPO_obo(String id,String nom,String xref){//,String synonyms){
		this.id=id;
		this.nom=nom;
		this.xref=xref;
		//this.synonyms=synonyms;
	}
	
	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public HPO_obo(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getXref() {
		return xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	@Override
	public String toString() {
		return "HPO_obo [id=" + id + ", nom=" + nom + ", xref=" + xref + "]";
	}
	

}
