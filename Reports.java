import java.lang.*;

public class Reports
{
	int reportID;
	int patientID;
	int doctorID;
	String rep;
	public Reports() {}
	public Reports(int repID, int patID, int docID)
	{
		reportID = repID;
		patientID = patID;
		doctorID = docID;
	}
	public void setReportID(int repID)
	{
		reportID = repID;
	}
	public int getReportID()
	{
		return reportID;
	}
	public void setPatientID(int patID)
	{
		patientID = patID;
	}
	public int getPatientID()
	{
		return patientID;
	}
	public void setDoctorID(int docID)
	{
		doctorID = docID;
	}
	public int getDoctorID()
	{
		return doctorID;
	}
	public void setReport(String r)
	{
		rep = r;
	}
	public String getReport()
	{
		return rep;
	}
	public void print()
	{
		if (reportID == 0 && patientID == 0) {
			System.out.println("No record of Reports to display for the patient.");
		}
		else{
			System.out.println("ReportID = " + reportID);
			System.out.println("PatientID = " + patientID);
			System.out.println("DoctorID = " + doctorID);
			System.out.println("Report = " + rep);
		}
	}
};
