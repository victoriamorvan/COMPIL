package Sider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test_BDDSider {
	public static void main(String[] args) throws IOException, SQLException {
		BDDSider bdd = new BDDSider();
		ArrayList<Medra_Result> Liste = new ArrayList<Medra_Result>();
		
		Liste =bdd.getSiderCUIinMedraSe("Anxiety");
		for(int i =0; i<20 ; i++)
		System.out.println(Liste.get(i).getCUI()+" "+Liste.get(i).getStitch_compound_id1()+ " "+ Liste.get(i).getStitch_compound_id2()+"\n");
		
		
	}
}
