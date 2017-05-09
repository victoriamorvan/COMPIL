package ATC;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Test_ATC {
	public static void main(String[] args) throws IOException {
		    
	     
	     String dbPath = "C:/Users/Victoria/Documents/test.keg";//"./drugbank.txt";

	    
	 
	     final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    ATC_Parser atc= new ATC_Parser();
	    
	    LinkedList<ATC>list=atc.ATC_Parser_remp(dbFile);
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Veuillez saisir un mot :");
	    String str = sc.nextLine();
	    System.out.println("Vous avez saisi : " + str);
	    atc.search(list,str);
 }
}
