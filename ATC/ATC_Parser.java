package ATC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ATC_Parser {
	
	public LinkedList<ATC> list;
	public String id;
	public String dbPath;
	
	public ATC_Parser( String id, String dbPath) throws IOException{
		this.id=id;
		this.dbPath=dbPath;
		final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	     this.list= ATC_Parser_remp(dbFile,id);
	     
		
	}
	
	public LinkedList<ATC> getList() {
		return list;
	}
	public void setList(LinkedList<ATC> list) {
		this.list = list;
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
	

/*public void search(LinkedList<ATC> list,String id)
 {
	String ret="";
 for(ATC atc:list )
     {
     if(id.equals(atc.getId()))
         {
  	   		ret=atc.toString();
         } 
    
    	
     } 
 	if(!ret.equals("")){
 		System.out.println("This ID corresponds to "+ret+"\n");
 	}
 	else 
 		System.out.println("No medecine corresponds to this Id \n ");
 }
*/


public static LinkedList<ATC> ATC_Parser_remp(File file,String idATC) throws IOException {
		 LinkedList<ATC> list = new LinkedList<ATC>();
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
	    				list.add(new ATC(id, name));
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
