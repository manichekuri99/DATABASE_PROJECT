import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ConsultationDAO_JDBC implements ConsultationDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public ConsultationDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public ArrayList<Consultation>  getConsultationByDoc(int DocID) {
		ArrayList<Consultation> consultations = new ArrayList<Consultation>();
		// Consultation c = new Consultation();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select con_id, phy_id, pat_id, symptoms from consultation";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Consultation c = new Consultation();
        int conID = rs.getInt("con_id");
        int phyid  = rs.getInt("phy_id");
				int patID  = rs.getInt("pat_id");
        String s = rs.getString("symptoms");

				if(DocID == phyid){
          c.setConsultationID(conID);
          c.setphysicianID(phyid);
					c.setpatientID(patID);
					c.setSymptome(s);
					consultations.add(c);
				}
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return consultations;
	}

}
