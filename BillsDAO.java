import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public interface BillsDAO{
	public ArrayList<Bills> getBillByPatientID(int patientID);
	// public void addBill(Bills bill);

}
