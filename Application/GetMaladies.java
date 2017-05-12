package Application;

import java.io.IOException;
import java.util.LinkedList;

import OMIM.OMIM_txt;
import OMIM.OMIM_txt_Parser;

public class GetMaladies {
	
	public static 	LinkedList<Disease> getMaladieName(String symptome,String id, String base,LinkedList<Disease> diseases) throws IOException{
		OMIM_txt_Parser omim= new OMIM_txt_Parser(symptome,id);
		if (omim.getList()!=null){
		LinkedList<OMIM_txt> list = omim.getList();
		String name="" ;
		for (OMIM_txt o:list ){
			name=o.fieldTi.toLowerCase() ;
			String db =base;
			Disease disease = new Disease(name,db);
			boolean b=false;
			for (Disease d:diseases){
				if (d.getName().equals(name)){
					b=true;
				}
			}
			if(b==false){
				diseases.add(disease);
			}
		
		}
	 }
	 return diseases;
  }
}
