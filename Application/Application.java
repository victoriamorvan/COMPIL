package Application;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import OMIM.OMIM_csv;
import OMIM.OMIM_csv_Parser;
import OMIM.OMIM_txt;
import OMIM.OMIM_txt_Parser;
import Sider.BDDSider;
import Sider.Medra_Result;
import Stitch.Stitch;
import Stitch.Stitch_Parser;
import ATC.ATC;
import ATC.ATC_Parser;
import HPO.BDDHpo_anno;
import HPO.HPO_obo;
import HPO.HPO_obo_Parser;
		
public class Application {
	public static void main(String[] args) throws IOException, SQLException {
	    
		/*ATC
	     String dbPathATC = "/home/depot/2A/gmd/projet_2016-17/atc/br08303.keg";
	     final File dbFileATC = new File(dbPathATC);
	     if (!dbFileATC.exists()) {
	       System.out.println("the db file '" +dbPathATC+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    ATC_Parser atc= new ATC_Parser();  
	    LinkedList<ATC>listATC=atc.ATC_Parser_remp(dbFileATC);
	    //Stitch
	     String dbPathStitch = "/home/depot/2A/gmd/projet_2016-17/stitch/chemical.sources.v5.0.tsv";
	     final File dbFileStitch = new File(dbPathStitch);
	     if (!dbFileATC.exists()) {
	       System.out.println("the db file '" +dbPathStitch+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    Stitch_Parser stitch= new Stitch_Parser();  
	    LinkedList<Stitch>listStich=stitch.Stitch_remp(dbFileStitch);
	    /*HPO_obo
	     String dbPathHPO_obo = "/home/depot/2A/gmd/projet_2016-17/hpo/hp.obo";
	     final File dbFileHPO_obo = new File(dbPathHPO_obo);
	     if (!dbFileHPO_obo.exists()) {
	       System.out.println("the db file '" +dbPathHPO_obo+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    HPO_obo_Parser HPO_obo= new HPO_obo_Parser();  
	    LinkedList<HPO_obo>listHPO_obo=HPO_obo.HPO_obo_remp(dbFileHPO_obo);
	    // HPO 
	    BDDHpo_anno bd =new BDDHpo_anno();
	    ArrayList<String> liste = new ArrayList<String>();
	    
	    /*OMIM_csv
	     String dbPathOMIM_csv = "/home/depot/2A/gmd/projet_2016-17/omim/omim_onto.csv";
	     final File dbFileOMIM_csv = new File(dbPathOMIM_csv);
	     if (!dbFileOMIM_csv.exists()) {
	       System.out.println("the db file '" +dbPathOMIM_csv+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	    OMIM_csv_Parser OMIM_csv= new OMIM_csv_Parser();  
	    LinkedList<OMIM_csv>listOMIM_csv=OMIM_csv.OMIM_csv_Parser_remp(dbFileOMIM_csv);*/
	    //OMIM_txt
	     /*String dbPathOMIM_txt = "/home/depot/2A/gmd/projet_2016-17/omim/omim.txt";
	     final File dbFileOMIM_txt = new File(dbPathOMIM_txt);
	     if (!dbFileOMIM_txt.exists()) {
	       System.out.println("the db file '" +dbPathOMIM_txt+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	 	OMIM_txt_Parser OMIM_txt= new OMIM_txt_Parser();  
	    LinkedList<OMIM_txt>listOMIM_txt=OMIM_txt.OMIM_txt_Parser_remp(dbFileOMIM_txt);
	     
	    /* Sider
	     BDDSider bdd = new BDDSider();
	     ArrayList<Medra_Result> Liste = new ArrayList<Medra_Result>();
	    */
		 	String dbPathStitch = "/home/depot/2A/gmd/projet_2016-17/stitch/chemical.sources.v5.0.tsv";
		 	Scanner sc = new Scanner(System.in);
			/*System.out.println("Veuillez entrer un composant:");
			String str1 = sc.nextLine();
			System.out.println("et un 2eme ");
			String str2 = sc.nextLine();
			System.out.println("Vous avez saisi : " + str1 + "et "+str2);*/
			Stitch_Parser stitch= new Stitch_Parser("CIDm00017676","CIDs00017676",dbPathStitch);
			LinkedList<Stitch> list=stitch.getList();
			if (list.size()==0){
				 System.out.println("No dease corresponds to this symptom");
			 }
			else {
				 int i =0;
				 for (Stitch st: list){
					 String dbPathATC = "/home/depot/2A/gmd/projet_2016-17/atc/br08303.keg";
					 ATC_Parser pars = new ATC_Parser(st.id_atc,dbPathATC);
				 	 System.out.println("1"+pars.getList().get(0).getName());
					 
			 }
			}
				
	    
	    //Liste =bdd.getSiderCUIinMedraSe(str);
}
}
