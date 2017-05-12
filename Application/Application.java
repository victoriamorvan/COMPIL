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
	
	/**  Collect diseases from Orphadata or OMIM **/
	LinkedList<Disease> diseases=new LinkedList<Disease>();
	String name="floppy ears";
	diseases = GetMaladies.getMaladieName(name,"NOOOOOOOOOOOJDSKFJSDKJFS","OMIM.txt",diseases);
	
	LinkedList<String> synonyms= GetSynonyms.getSynonymsList(name);
	
	for(String nom:synonyms){
		 GetMaladies.getMaladieName(nom,"NULL","OMIM.txt +HPO.obo",diseases);
				 
	} 
	String id_HP = GetId_HP.getId_HP(name);
	///////////////////////HPO.anno///////////////////////////////////////////////:::
	BDDHpo_anno bddhpo = new BDDHpo_anno();
	ArrayList<String> id_list = new ArrayList<String>();
	id_list =bddhpo.getHPODiseaseId(id_HP);
	
	for (String id:id_list){
		System.out.println(id);
		GetMaladies.getMaladieName("Nhzejkzehtkjz hetkjzehtlkjze", id, "OMIM.txt +HPO_annotation.sqlite", diseases);
	}
	
	for (Disease d: diseases){
		System.out.println(d.getName()+" "+d.getDb());
	}
}
}
