package Application;

import java.io.IOException;
import java.util.LinkedList;

import HPO.HPO_obo;
import HPO.HPO_obo_Parser;

public class GetId_HP {
	public static String getId_HP(String symptome) throws IOException{
		
		HPO_obo_Parser hpo = new HPO_obo_Parser(symptome);
		LinkedList<HPO_obo> list=hpo.getList();
		String id="";
		if (hpo.getList()!=null){
			 for (HPO_obo hp: list)
				 id=hp.getId();
		}
		return id;
    }
}
