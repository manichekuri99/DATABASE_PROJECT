import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class BillsDAO_JDBC implements BillsDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public BillsDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public ArrayList<Bills> getBillByPatientID(int patientID) {
		// Bills b = new Bills();
		ArrayList<Bills> bills = new ArrayList<Bills>();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select bil_id, pat_id, amount, bill_date from bills";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int billno  = rs.getInt("bil_id");
				int patID = rs.getInt("pat_id");
				int amount = rs.getInt("amount");
				String date = rs.getString("bill_date");
				if(patientID == patID){
					Bills b = new Bills();
					b.setBillNo(billno);
					b.setPatientID(patID);
					b.setAmount(amount);
					b.setDate(date);
					bills.add(b);
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
		return bills;
	}

	// @Override
	// public void addBill(Bills bill) {
	// 	PreparedStatement preparedStatement = null;
	// 	String sql;
	// 	sql = "insert into bills(billno, patientID, amount, date) values (?, ?, ?, ?)";
	//
	// 	try {
	// 		preparedStatement = dbConnection.prepareStatement(sql);
	//
	// 		preparedStatement.setInt(1, bill.getBillno());
	// 		preparedStatement.setInt(2, bill.getPatientID());
	// 		preparedStatement.setInt(3, bill.getAmount());
	// 		preparedStatement.setString(4, bill.getDate());
	//
	// 		// execute insert SQL stetement
	// 		preparedStatement.executeUpdate();
	//
	// 		System.out.println("Bill: Bill No " + bill.getBillNo()
	// 			+ ", added to the database");
	// 	} catch (SQLException e) {
 	// 		System.out.println(e.getMessage());
 	// 	}
	//
	// 	try{
	// 		if (preparedStatement != null) {
	// 			preparedStatement.close();
	// 		}
	// 	} catch (SQLException e) {
 	// 		System.out.println(e.getMessage());
 	// 	}
	// }
}
