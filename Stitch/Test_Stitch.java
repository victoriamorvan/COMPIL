package Stitch;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import ATC.ATC;
import ATC.ATC_Parser;
import OMIM.OMIM_txt;
import OMIM.OMIM_txt_Parser;

public class Test_Stitch {
	public static void main(String[] args) throws IOException {
	    
	     
	     String dbPath = "/home/depot/2A/gmd/projet_2016-17/stitch/chemical.sources.v5.0.tsv";//"./drugbank.txt";

	    
		 Scanner sc = new Scanner(System.in);
		/* System.out.println("Veuillez entrer un composant:");
		 String str1 = sc.nextLine();
		 System.out.println("et un 2eme ");
		 String str2 = sc.nextLine();
		 System.out.println("Vous avez saisi : " + str1 + "et "+str2);*/
		 Stitch_Parser stitch= new Stitch_Parser("CIDm00017676","CIDs00017676");
		 LinkedList<Stitch> list=stitch.getList();
		 if (list.size()==0){
			 System.out.println("No dease corresponds to this symptom");
		 }
		else {
			 int i =0;
			 for (Stitch st: list)
				 System.out.println(i +". "+st.id_atc+"\n" );
		 }
			
	}
		 
}