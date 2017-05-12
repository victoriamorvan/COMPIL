package OMIM;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Test_OMIM {

	public static void main(String[] args) throws IOException {
		    
	     
	   /*  String dbPath = "/home/etudiants/martin441u/Bureau/omim.txt";//"./drugbank.txt";
		 Scanner sc = new Scanner(System.in);
		/* System.out.println("Veuillez entrer un symptome :");
		 String str = sc.nextLine();
		 System.out.println("Vous avez saisi : " + str);*/
		
		OMIM_txt_Parser omim= new OMIM_txt_Parser("NOOOOOOOOOOOOOOOO","100050");
		 LinkedList<OMIM_txt> list=omim.getList();
		 System.out.println("taille "+list.size());
		 if (list.size()==0){
			 System.out.println("No dease corresponds to this symptom");
		 }
		 else {
			 int i =0;
			 for (OMIM_txt om: list){
				 i++;
				 System.out.println(i +". "+om.getFieldTi()+ " "+ om.getFieldNo()+"\n" );
			 }
		 }

 }
}

