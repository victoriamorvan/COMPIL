package ATC;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Date;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class ATC_Parser {
	
	
	public ATC_Parser(){}

		/** Index all text files under a directory.
		 * @throws IOException */
	   public static void main(String[] args) throws IOException {
	    
	     String indexPath = "indexATC";
	     String dbPath = "/home/depot/2A/gmd/projet_2016-17/atc/br08303.keg";//"./drugbank.txt";

	    
	 
	     final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbFile.getCanonicalPath()+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	     
	     Date start = new Date();
	     try {
	       System.out.println("Indexing to directory '" + indexPath + "'...");
	 
	       Directory dir = FSDirectory.open(Paths.get(indexPath));
	       Analyzer analyzer = new StandardAnalyzer();
	       IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
	 
	       iwc.setOpenMode(OpenMode.CREATE);
	 
	       IndexWriter writer = new IndexWriter(dir, iwc);
	       indexDoc(writer, dbFile);

	       writer.close();
	 
	       Date end = new Date();
	       System.out.println(end.getTime() - start.getTime() + " total milliseconds");
	 
	     } catch (IOException e) {
	       System.out.println(" caught a " + e.getClass() +
	        "\n with message: " + e.getMessage());
	     }
	   }

	

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


	   /** Indexes a single document */
	   static void indexDoc(IndexWriter writer, File file) throws IOException {
	     try{            
	        InputStream stream = new FileInputStream(file);
	        InputStreamReader ipsr = new InputStreamReader(stream);
	        BufferedReader br = new BufferedReader(ipsr);
	        
	        String line = "";
	        Document doc = null;
	        


	    	while((line=br.readLine())!=null){
	    		
	    		if(line.startsWith("E")){
	    			doc = new Document();
	    			String id = "";
	    			String name="";
	    			String parts [] =line.split(" ");
	    			id=parts[8];
	    			name=line.substring(16);
	    			doc.add(new StoredField("id",id));
	    			doc.add(new TextField("name",name,Field.Store.YES));
	    			writer.addDocument(doc);
	    		}
	    		
	    		
	    	}
	    	br.close();
	    	
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	
	     
	   }
		
}
