import java.lang.*;
import java.util.List;

public interface ReportsDAO{
	public Bills getRportByPatientID(int patientID);
	public void addReport(Reports report);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	
}

