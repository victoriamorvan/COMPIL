package Stitch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import OMIM.OMIM_csv;

public class Stitch_Parser {
	public static LinkedList<Stitch> Stitch_remp(File file) throws IOException {
		 LinkedList<Stitch> list = new LinkedList<Stitch>();
	     try{    		 
	    	
			FileReader lecteurDeFichier = new FileReader(file);
			BufferedReader br = new BufferedReader(lecteurDeFichier);
			String line;    
			Stitch stitch=null;

	    	while((line=br.readLine())!=null){

	    		
	    		String [] parts = line.split("\t");
	    		if (parts[2].equals("ATC")){
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
