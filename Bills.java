import java.lang.*;

public class Bills
{
	int billNo;
	int patientID;
	int amount;
	String date;
	public Bills() {}
	public Bills(int billNo, int patientID, int amount, String date)
	{
		billNo = rollNo;
		patientID = patientID;
		amount = amount;
		date = date;
	}
	public void setBillNo(int billNo)
	{
		billNo = billNo;
	}
	public int getBillNo()
	{
		return billNo;
	}
	public void setPatientID(int patientID)
	{
		patientID = patientID;
	}
	public int getRollNo()
	{
		return patientID;
	} 
	public void setAmount(int amount)
	{
		amount = amount;
	}
	public int getAmount()
	{
		return amount;
	}
	public void setDate(String date)
	{
		date = date;
	}
	public String getDate()
	{
		return date;
	}
}
