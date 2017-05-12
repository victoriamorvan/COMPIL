package HPO;

import java.util.LinkedList;

public class HPO_obo {
	
	public String id;
	public String nom;
	public String xref;
	public LinkedList<String> listeNoms;
	
	public HPO_obo(String id,String nom,String xref){
		this.id=id;
		this.nom=nom;
		this.xref=xref;
		
	}
	
	public HPO_obo(){
		this.listeNoms=new LinkedList<String>();
	}
	
	public LinkedList<String> getListeNoms() {
		return listeNoms;
	}

	public void setListeNoms(LinkedList<String> listeNoms) {
		this.listeNoms = listeNoms;
	}

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
