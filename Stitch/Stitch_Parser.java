package Stitch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import OMIM.OMIM_csv;

public class Stitch_Parser {
	public void search(LinkedList<Stitch> list,String coumpound_id_s )
	 {
		
		
	 String ret="";
	 for(Stitch stitch:list )
	     {
	    	
	    	 if(coumpound_id_s.equals(stitch.getCoumpound_id_s())){
	    	 			ret=stitch.id_atc;
	    	 	}
	    	 }   
	    	
	    
	 	if(!ret.equals("")){
	 		System.out.println("This CS corresponds to "+ret+"\n");
	 	}
	 	else 
	 		System.out.println("No  corresponds to this CS \n ");
	 }
	public static LinkedList<Stitch> Stitch_remp(File file) throws IOException {
		 LinkedList<Stitch> list = new LinkedList<Stitch>();
	     try{    		 
	    	
			FileReader lecteurDeFichier = new FileReader(file);
			BufferedReader br = new BufferedReader(lecteurDeFichier);
			String line;    
			Stitch stitch=null;
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
			line=br.readLine();
		
	    	while((line=br.readLine())!=null){

	    		String [] parts = line.split("\t"); 		
	    		if (parts[2].equals("ATC")){
	    			System.out.println();
	    			String coumpound_id_m = parts [0];
	    			String coumpound_id_s = parts [1];
	    			String id_atc = parts [3];
	    			stitch = new Stitch (coumpound_id_m,coumpound_id_s,id_atc);
	    		}
	    		list.add(stitch);
	    	}
	    	br.close();
	    	
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
		return list;
	     
	   }
}
