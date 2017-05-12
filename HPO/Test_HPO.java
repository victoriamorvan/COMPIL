package HPO;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import ATC.ATC;
import ATC.ATC_Parser;
import OMIM.OMIM_txt;
import OMIM.OMIM_txt_Parser;
import Stitch.Stitch;

public class Test_HPO {
	public static void main(String[] args) throws IOException {
	    
	     
	     String dbPath = "/home/depot/2A/gmd/projet_2016-17/hpo/hp.obo";//"./drugbank.txt";
		 Scanner sc = new Scanner(System.in);
		 /*System.out.println("Veuillez entrer un symptome :");
		 String str = sc.nextLine();
		 System.out.println("Vous avez saisi : " + str);*/
		 HPO_obo_Parser hpo= new HPO_obo_Parser("Floppy ears");
		 LinkedList<HPO_obo> list=hpo.getList();
		 if (list.size()==0){
			 System.out.println("No UMLS corresponding to this id");
		 }
		else {
			 int i =0;
			 for (HPO_obo hp: list){
				 LinkedList<String> listeNom=hp.getListeNoms();
				 hp.getId();
				 for(String nom:listeNom){
					 System.out.println(listeNom+"\n" );
					 i++;
				 }
			 }
		 }
			
	    /*HPO_obo_Parser hpo= new HPO_obo_Parser();
	    
	    LinkedList<HPO_obo>list=hpo.HPO_obo_remp(dbFile);
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Veuillez saisir un mot :");
	    String str = sc.nextLine();
	    System.out.println("Vous avez saisi : " + str);
	    hpo.search(list,str);*/
}
}
