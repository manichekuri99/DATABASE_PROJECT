//STEP 1. Import required packages
import java.sql.*;

public class DAO_Demo {
	public static void main(String[] args) {
		try{
			// DAO_Factory daoFactory = new DAO_Factory();

			// daoFactory.activateConnection();

			// StudentDAO sdao = daoFactory.getStudentDAO();
			// Student s = sdao.getStudentByKey(1);
			// s.print();

			BillsDAO_Factory billsDAOfactory = new BillsDAO_Factory();

			billsDAOfactory.activateConnection();

			BillsDAO bdao = billsDAOfactory.getBillsDAO();
			Bills b = bdao.getBillByPatientByID(1);
			b.print(); 

			System.out.println();

			ReportsDAO_Factory reportsDAOfactory = new ReportsDAO_Factory();

			reportsDAOfactory.activateConnection();

			ReportsDAO rdao = reportsDAOfactory.getReportsDAO();
			Reports r = rdao.getReportByPatientByID(1);
			r.print();			

			//daoFactory.deactivateConnection();
			billsDAOfactory.deactivateConnection();
			reportsDAOfactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
