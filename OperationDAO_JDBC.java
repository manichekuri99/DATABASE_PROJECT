import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class OperationDAO_JDBC implements OperationDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public OperationDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public ArrayList<Operation> getOperationByDoc(int DocID) {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		// Operation o = new Operation();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select ope_id, sur_id, pat_id, bill from operation";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
        int opeID = rs.getInt("ope_id");
        int surid  = rs.getInt("sur_id");
				int patID  = rs.getInt("pat_id");
        int b = rs.getInt("bill");

				if(DocID == surid){
					Operation o = new Operation();
          o.setOperationID(opeID);
          o.setSurgeonID(surid);
					o.setpatientID(patID);
					o.setbill(b);
					operations.add(o);
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
		return operations;
	}

}
