package Stitch;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import ATC.ATC;
import ATC.ATC_Parser;

public class Test_Stitch {
	public static void main(String[] args) throws IOException {
	    
	     
	     String dbPath = "/home/depot/2A/gmd/projet_2016-17/stitch/chemical.sources.v5.0.tsv";//"./drugbank.txt";

	    
	 
	     final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbPath+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    Stitch_Parser stitch= new Stitch_Parser();
	    
	    LinkedList<Stitch>list=stitch.Stitch_remp(dbFile);
	   /* Scanner sc = new Scanner(System.in);
	    System.out.println("Veuillez saisir un mot :");
	    String str = sc.nextLine();
	    System.out.println("Vous avez saisi : " + str);
	    stitch.search(list,str);*/
}

}