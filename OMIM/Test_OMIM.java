package OMIM;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Test_OMIM {

	public static void main(String[] args) throws IOException {
		    
	     
	     String dbPath = "C:/Users/Victoria/Documents/test_omim.txt";//"./drugbank.txt";

	    
	 
	     final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    OMIM_txt_Parser omim= new OMIM_txt_Parser();
	    LinkedList<OMIM_txt>list=omim.OMIM_txt_Parser_remp(dbFile);
	    System.out.println("length "+ list.size() );
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Veuillez saisir un mot :");
	    String str = sc.nextLine();
	    System.out.println("Vous avez saisi : " + str);
	    omim.search(list,str);
 }
}

