//STEP 1. Import required packages
import java.sql.*;
// import DAO_Factory;
// import Student;
// import StudentDAO_JDBC;
// import StudentDAO;

public class DAO_Demo {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();

			BillsDAO bdao = daoFactory.getBillsDAO();
			Bills b = bdao.getBillByPatientID(6);
			b.print();

      ReportsDAO rdao = daoFactory.getReportsDAO();
			Reports r = rdao.getReportByPatientID(4);
			r.print();

			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
