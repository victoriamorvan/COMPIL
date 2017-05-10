package HPO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import OMIM.OMIM_txt;

public class HPO_obo_Parser {
	
	public String hp;
	public LinkedList<HPO_obo> list;
	public String dbPath;
	
	public HPO_obo_Parser( String hp, String dbPath) throws IOException{
		this.hp=hp;
		this.dbPath=dbPath;
		final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	     this.list= HPO_obo_remp(dbFile,hp);
	     
		
	}
	
	
	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public LinkedList<HPO_obo> getList() {
		return list;
	}


	public void setList(LinkedList<HPO_obo> list) {
		this.list = list;
	}


	public String getDbPath() {
		return dbPath;
	}


	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}


	public static LinkedList<HPO_obo> HPO_obo_remp(File file,String hp) throws IOException {
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
		    		if (line.startsWith("xref: UMLS:")&& hpo.getId().equals(hp)){	
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
