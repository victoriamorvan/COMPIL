package Application;

import java.io.IOException;
import java.util.LinkedList;

import ATC.ATC_Parser;
import Stitch.Stitch;
import Stitch.Stitch_Parser;

public class GetConsequences {

	public static LinkedList<String> getConsequencesName(String cid1,String cid2) throws IOException{  
	 	Stitch_Parser stitch= new Stitch_Parser(cid1,cid2);
	 	LinkedList<String> atc=new LinkedList<String>();
	 	LinkedList<Stitch> list=stitch.getList();
		
	 	for (Stitch st: list){
		     ATC_Parser pars = new ATC_Parser(st.id_atc);
		     String name=pars.getAtc().getName();
		     atc.add(pars.getAtc().getName());
		     //System.out.println(pars.getAtc().getName() +" "+pars.getId());
		   /* if (!atc.contains(name)){
		    	 atc.add(pars.getAtc().getName());
		    	 System.out.println(pars.getAtc().getName() +" "+pars.getId());
		     }*/
		     
	 	}
	 	return atc;
	 }
	
}
