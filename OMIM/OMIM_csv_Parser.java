package OMIM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class OMIM_csv_Parser {
	public void search(LinkedList<OMIM_csv> list,String cui)
	 {
		
		
	 String ret="";
	 for(OMIM_csv omim:list )
	     {
	    	
	    	 if(cui.equals(omim.getCui())){
	    	 			ret=omim.cui;
	    	 	}
	    	 }   
	    	
	    
	 	if(!ret.equals("")){
	 		System.out.println("This CS corresponds to "+ret+"\n");
	 	}
	 	else 
	 		System.out.println("No  corresponds to this CS \n ");
	 }
		public static LinkedList<OMIM_csv> OMIM_txt_Parser_remp(File file) throws IOException {
			 LinkedList<OMIM_csv> list = new LinkedList<OMIM_csv>();
		     try{    		 
		    	
				FileReader lecteurDeFichier = new FileReader(file);
				BufferedReader br = new BufferedReader(lecteurDeFichier);
				String line;    
				OMIM_csv omim=null;

		    	while((line=br.readLine())!=null){
		    		
		    		String [] parts = line.split(",");
		    		String preferedLabel = parts [1];
		    		String synonyms =parts[2];
		    		String cui = parts [5];
		    		omim = new OMIM_csv(preferedLabel,synonyms,cui);
		    		
		    		list.add(omim);
		    	}
		    	br.close();
		    	
		     }catch(Exception e){
		    	 e.printStackTrace();
		     }
			return list;
		     
		   }
			

}
