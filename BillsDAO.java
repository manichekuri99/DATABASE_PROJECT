import java.lang.*;
import java.util.List;

public interface BillsDAO{
	public Bills getBillByPatientID(int patientID);
	public void addBill(Bills bill);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	
}
