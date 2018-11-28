import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public interface ConsultationDAO {
	public ArrayList<Consultation> getConsultationByDoc(int DocID);
}
