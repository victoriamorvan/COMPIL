package HPO;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import ATC.ATC;
import ATC.ATC_Parser;

public class Test_HPO {
	public static void main(String[] args) throws IOException, SQLException {
	    
	     /*
	     String dbPath = "/home/depot/2A/gmd/projet_2016-17/hpo/hp.obo";//"./drugbank.txt";

	    
	 
	     final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    HPO_obo_Parser hpo= new HPO_obo_Parser();
	    
	    LinkedList<HPO_obo>list=hpo.HPO_obo_remp(dbFile);
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Veuillez saisir un mot :");
	    String str = sc.nextLine();
	    System.out.println("Vous avez saisi : " + str);
	    hpo.search(list,str);
	    */
		
	    BDDHpo_anno bd =new BDDHpo_anno();
	    ArrayList<String> liste = new ArrayList<String>();
	    
	    liste =bd.getHPODiseaseId("HP:0000739");
	    
}
}
