package Stitch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import OMIM.OMIM_csv;

public class Stitch_Parser {
	
	public String coumpound_id_s;
	public String coumpound_id_m;
	public String dbPath;
	public LinkedList<Stitch> list;
	
	
	public Stitch_Parser( String coumpound_id_m, String coumpound_id_s, String dbPath) throws IOException{
		this.coumpound_id_s=coumpound_id_s;
		this.coumpound_id_m=coumpound_id_m;
		this.dbPath=dbPath;
		final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	     this.list= Stitch_remp(dbFile,coumpound_id_m,coumpound_id_s);  
		
	}
	public String getCoumpound_id_s() {
		return coumpound_id_s;
	}
	public void setCoumpound_id_s(String coumpound_id_s) {
		this.coumpound_id_s = coumpound_id_s;
	}
	public String getCoumpound_id_m() {
		return coumpound_id_m;
	}
	public void setCoumpound_id_m(String coumpound_id_m) {
		this.coumpound_id_m = coumpound_id_m;
	}
	public String getDbPath() {
		return dbPath;
	}
	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}
	public LinkedList<Stitch> getList() {
		return list;
	}
	public void setList(LinkedList<Stitch> list) {
		this.list = list;
	}
	public Stitch_Parser(){
	}
	
	
	
	public static LinkedList<Stitch> Stitch_remp(File file,String coumpound_id_m,String coumpound_id_s) throws IOException {
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
			int i =0;
	    	while((line=br.readLine())!=null && i<4000){
	    		String [] parts = line.split("\t");
	    		i++;
	    		if (parts[2].contains("ATC")){
	    			String cp_id_m = parts [0];
	    			String cp_id_s = parts [1];
	    			String id_atc = parts [3];
	    			if (cp_id_s.contains(coumpound_id_s)){
	    				stitch = new Stitch (cp_id_m,cp_id_s,id_atc);
	    				list.add(stitch);
	    			}
	    		}
	    		
	    	}
	    	
	    	br.close();
	    	
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
		return list;
	     
	   }
}
