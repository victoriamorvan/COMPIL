package HPO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import OMIM.OMIM_txt;

public class HPO_obo_Parser {
	
	public void search(LinkedList<HPO_obo> list,String hp)
	 {
		
		
	 String ret="";
	 for(HPO_obo hpo:list )
	     {
	    	 		if(hpo.getId().equals(hp)){
	    	 			
	    	 			ret=hpo.getXref();
	    	 		}    
	     }
	 	if(!ret.equals("")){
	 		System.out.println("This id corresponds to "+ret+"\n");
	 	}
	 	else 
	 		System.out.println("No corresponding xref for this id \n ");
	 
	 }
	public static LinkedList<HPO_obo> HPO_obo_remp(File file) throws IOException {
			 LinkedList<HPO_obo> list = new LinkedList<HPO_obo>();
		     try{    		 
		    	
				FileReader lecteurDeFichier = new FileReader(file);
				BufferedReader br = new BufferedReader(lecteurDeFichier);
				String line;    
				HPO_obo hpo=null;
				int i=0;

		    	while((line=br.readLine())!=null){
		    		
		    		
		    		if(line.startsWith("[Term]")){
		    			hpo=new HPO_obo();
		    			i++;
		    		}
		    		
		    		if (line.startsWith("id")){
		    			String id=line.substring(7);
		    			hpo.setId(id);
		    			
		    			
		    		}
		    		if (line.startsWith("xref: UMLS:")){
		    			String xref= line.substring(11);
		    			hpo.setXref(xref);
		    			list.add(hpo);
		    		}
		    		if(line.startsWith("name")){
		    			String name=line.substring(6);
		    			hpo.setNom(name);
		    			
		    		}
		    		
		    		
		    		
		    	}
		    	br.close();
		    	
		     }catch(Exception e){
		    	 e.printStackTrace();
		     }
			return list;
		     
		   }
			


}
