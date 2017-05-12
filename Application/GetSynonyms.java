package Application;

import java.io.IOException;
import java.util.LinkedList;

import HPO.HPO_obo;
import HPO.HPO_obo_Parser;

public class GetSynonyms {
	
    public static LinkedList<String> getSynonymsList(String symptome) throws IOException{
		HPO_obo_Parser hpo = new HPO_obo_Parser(symptome);
		LinkedList<String> listeNom=new LinkedList<String>();
		if (hpo.getList()!=null){
			LinkedList<HPO_obo> list=hpo.getList();
			
			for (HPO_obo hp: list){
				listeNom=hp.getListeNoms();
			}
		}
		return listeNom;
    }
}
