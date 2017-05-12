package ATC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ATC_Parser {
	
	public ATC atc;
	public String id;
	public String dbPath;
	
	public ATC_Parser( String id) throws IOException{
		this.id=id;
		this.dbPath="/home/depot/2A/gmd/projet_2016-17/atc/br08303.keg";
		final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	     this.atc= ATC_Parser_remp(dbFile,id);
	     
		
	}
	

	public ATC getAtc() {
		return atc;
	}


	public void setAtc(ATC atc) {
		this.atc = atc;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDbPath() {
		return dbPath;
	}
	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}
	public ATC_Parser(){}
	

public static ATC ATC_Parser_remp(File file,String idATC) throws IOException {
		 ATC res= new ATC();
	     try{    		 
	    	
			FileReader lecteurDeFichier = new FileReader(file);
			BufferedReader br = new BufferedReader(lecteurDeFichier);
			String line;    
			line = br.readLine();

	    	while((line=br.readLine())!=null){
	    		
	    		if(line.startsWith("E")){
	    			String id = "";
	    			String name="";
	    			String parts [] =line.split(" ");
	    			id=parts[8];
	    			name=line.substring(16);
	    			if (idATC.equals(id)){
	    				System.out.println("ATC "+id + " "+name+"\n");
	    				res.setId(id);
	    				res.setName(name);
	    			}
	    		}
	    		
	    		
	    	}
	    	br.close();
	    	
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
		return res;
	     
	   }
		
}
