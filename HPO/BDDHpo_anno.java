import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BDDHpo_anno {

		static Connection con;
		
		public BDDHpo_anno() throws SQLException {
			try {
				Class.forName("org.sqlite.JDBC");
				System.out.println("Driver O.K.");
				System.out.println("connexion en cours");
				this.con = DriverManager.getConnection("jdbc:sqlite:/home/bonardot/Desktop/GMD/projet/GMD/bdd/hpo_annotations.sqlite");
				System.out.println("connexion établie");
			}
			catch(ClassNotFoundException e){
				System.err.println("connexion echec");
				e.printStackTrace();
			}
		}
		
		
		public String getSiderCUI(String sideeffect) throws SQLException{
			String CUI = null;
			Statement stmt = con.createStatement();

			String sql="";
			stmt.close();

			return CUI;
		}
		
		
		public void CloseBDDSiderConnection() throws SQLException {
			this.con.close();
			
		}

	}
