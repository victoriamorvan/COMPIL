import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class BDDSider {

		static String HOST = "neptune.telecomnancy.univ-lorraine.fr";
		static String DB = "gmd";	
		static String DRIVER = "com.mysql.jdbc.Driver";
		static String USER_NAME = "gmd-read";
		static String USER_PSWD = "esial";
		static Connection con;
		
		public BDDSider() throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver O.K.");
				System.out.println("connexion en cours");
				this.con = DriverManager.getConnection(HOST+DB, USER_NAME, USER_PSWD);
				System.out.println("connexion établie");
			}
			catch(ClassNotFoundException e){
				System.err.println("connexion echec");
				e.printStackTrace();
			}
		}
		
		
		public ArrayList<String> getSiderCUIinMedraSe( String sideeffect) throws SQLException{
			ArrayList<String> CUIList = new ArrayList<String>();
			Statement stmt = con.createStatement();
			String sql="SELECT cui FROM medra_all_se WHERE side_effect_name='"+sideeffect+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				CUIList.add(rs.getString(2));
			}
			
			rs.close();
			stmt.close();

			return CUIList;
		}
		
		public String getSiderStichIDinMedraSeBySideAffect( String sideeffect) throws SQLException{
			String StitchID ;
			Statement stmt = con.createStatement();
			String sql="SELECT  FROM medra_all_se WHERE side_effect_name='"+sideeffect+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			StitchID = rs.getString(2);
			rs.close();
			stmt.close();

			return StitchID; //Forme :CID000010917
			//Il faut remplacer le 1er zero par un "s"
		}
		
		public String getSiderStichIDinMedraSeBy( String sideeffect) throws SQLException{
			String StitchID ;
			Statement stmt = con.createStatement();
			String sql="SELECT  FROM medra_all_se WHERE side_effect_name='"+sideeffect+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			StitchID = rs.getString(2);
			rs.close();
			stmt.close();

			return StitchID; //Forme :CID000010917
			//Il faut remplacer le 1er zero par un "s"
		}
		
		
		public void CloseBDDSiderConnection() throws SQLException {
			this.con.close();
			
		}

	}