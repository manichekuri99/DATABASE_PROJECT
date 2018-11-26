import java.lang.*;

public class Reports
{
	int reportID;
	int patientID;
	int doctorID; 
	public Reports() {}
	public Reports(int reportID, int patientID, int doctorID)
	{
		reportID = reportID;
		patientID = patientID;
		doctorID = doctorID;
	}
	public void setReportID(int reportID)
	{
		reportID = reportID;
	}
	public int getReportID()
	{
		return reportID;
	}
	public void setPatientID(int patientID)
	{
		patientID = patientID;
	}
	public int getRollNo()
	{
		return patientID;
	} 
	public void setDoctorID(int doctorID)
	{
		doctorID = doctorID;
	}
	public int getDoctorID()
	{
		return doctorID;
	}
}
