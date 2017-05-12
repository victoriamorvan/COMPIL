package HPO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BDDHpo_anno {

		static Connection con;
		
		public BDDHpo_anno() throws SQLException {
			try {
				Class.forName("org.sqlite.JDBC");
				System.out.println("Driver O.K.");
				System.out.println("connexion en cours");
				this.con = DriverManager.getConnection("jdbc:sqlite:/home/etudiants/martin441u/Bureau/GMD/ProjetGMD/hpo/hpo_annotations.sqlite");
				System.out.println("connexion établie");
			}
			catch(ClassNotFoundException e){
				System.err.println("connexion echec");
				e.printStackTrace();
			}
		}
		
		
		
		public ArrayList<String> getHPODiseaseId(String hp) throws SQLException{
			ArrayList<String> Id = new ArrayList<String>();
			int i=0;
			Statement stmt = con.createStatement();
			String sql="SELECT disease_id FROM phenotype_annotation WHERE sign_id="+'"'+hp+'"'+"";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			Id.add(i,rs.getString("disease_id"));
			i=i++;
			}

			rs.close();
			stmt.close();
			return Id;
		}
		
		
		public void CloseBDDSiderConnection() throws SQLException {
			this.con.close();
			
		}
		
		

	}
