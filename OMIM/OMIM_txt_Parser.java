package OMIM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;



public class OMIM_txt_Parser {
public void search(LinkedList<OMIM_txt> list,String symptomes)
 {
	
	
 String ret="";
 for(OMIM_txt omim:list )
     {
    	 	String [] parts = omim.getSymptomes().split(";");
    	 	int i=0;
    	 	
      	 	for (String sympt: parts){
      	 		i++;
    	 		if(sympt.equals(symptomes)){
    	 			
    	 			ret=omim.getFieldTi();
    	 		}
    	 	}
  	   		
         } 
    
    	
 	if(!ret.equals("")){
 		System.out.println("This CS corresponds to "+ret+"\n");
 	}
 	else 
 		System.out.println("No  corresponds to this CS \n ");
 }
	public static LinkedList<OMIM_txt> OMIM_txt_Parser_remp(File file) throws IOException {
		 LinkedList<OMIM_txt> list = new LinkedList<OMIM_txt>();
	     try{    		 
	    	
			FileReader lecteurDeFichier = new FileReader(file);
			BufferedReader br = new BufferedReader(lecteurDeFichier);
			String line;    
			OMIM_txt omim=null;

	    	while((line=br.readLine())!=null){
	    		
	    		
	    		if(line.startsWith("*RECORD*")){
	    			omim= new OMIM_txt();
	    			
	    		}
	    		if (line.startsWith("*FIELD* NO")){
	    			String no="";
	    			
	    			no=br.readLine();
	    			
	    			omim.setFieldNo(no);
   			
	    		}
	    		if(line.startsWith("*FIELD* TI")){
	    			String ti="";
	    			ti=br.readLine();
	    			ti=ti.substring(7);
	    			omim.setFieldTi(ti);
	    		}
	    		if (line.startsWith("DESCRIPTION")){
	    			String description="";
	    			while(!(line=br.readLine()).isEmpty()){
	    				description+=" "+line;
	    				
	    			}
	    			omim.setDescription(description);
	    		}
	    		if(line.startsWith("*FIELD* CS")){
	    			String symptomes="";
	    			while(!(line=br.readLine()).contentEquals("*FIELD*")){
	    				if (line.startsWith(" ") && !line.isEmpty() && !line.endsWith("];")){
	    					if (!line.endsWith(";")){
	    						symptomes+=line.substring(3)+";";
	    					}
	    					else
	    						symptomes+=line.substring(3);
	    				}	
	    				
	    			}
	    			omim.setSymptomes(symptomes);
	    			list.add(omim);
	    			System.out.println("  "+ symptomes +"\n");
	    		}
	    	
	    		
	    	}
	    	br.close();
	    	
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
		return list;
	     
	   }
		


}
