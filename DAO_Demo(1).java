//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
// import DAO_Factory;
// import Student;
// import StudentDAO_JDBC;
// import StudentDAO;

public class DAO_Demo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tmp1 = 0,tmp2 = 0,tmp3 = 0;
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();

			while(true){
				System.out.println("======================================================================" );
				System.out.println("press 1 to get records about Patients treated by specific Doctor" );
				System.out.println("press 2 to get Reports and Bills of Patients treated by specific Doctor" );

				tmp1 = scan.nextInt();
				if (tmp1 == 1) {

					//Use Case 1
					DoctorDAO ddao = daoFactory.getDoctorDAO();

					System.out.println("To search by Doctor ID, press 1" );
					System.out.println("To search by Doctor Name, press 2" );
					tmp2 = scan.nextInt();
					//getDoctorByID
					if (tmp2 == 1) {
						System.out.println("Enter Docter ID" );
						int tmp_id = scan.nextInt();
						Doctor d = ddao.getDoctorByID(tmp_id);
						System.out.println("Patient ID || Patient Name || Patient Age" );
						//Physician---Consultation
						if (d.getType().equals("Physician")) {
							ConsultationDAO cdao = daoFactory.getConsultationDAO();
							// Consultation c = cdao.getConsultationByDoc(d1.getDoctorID());
							ArrayList<Consultation> consultations = cdao.getConsultationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							for (int i = 0;i < consultations.size() ; i++) {
								Patient p = pdao.getPatientByID(consultations.get(i).getpatientID());
								p.print();
							}
							// System.out.println("length = " + );
						}
						//Surgeon---Operation
						else if (d.getType().equals("Surgeon")) {
							OperationDAO odao = daoFactory.getOperationDAO();
							ArrayList<Operation> operations = odao.getOperationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							for (int i = 0;i < operations.size() ; i++) {
								Patient p = pdao.getPatientByID(operations.get(i).getpatientID());
								p.print();
							}
						}
					}
					else if (tmp2 == 2) {
						System.out.println("Enter Docter Name" );
						String s = scan.next();

						System.out.println("Patient ID || Patient Name || Patient Age" );
						//getDoctorByname
						Doctor d = ddao.getDoctorByname(s);
						//Physician---Consultation
						if (d.getType().equals("Physician")) {
							ConsultationDAO cdao = daoFactory.getConsultationDAO();
							// Consultation c = cdao.getConsultationByDoc(d1.getDoctorID());
							ArrayList<Consultation> consultations = cdao.getConsultationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							for (int i = 0;i < consultations.size() ; i++) {
								Patient p = pdao.getPatientByID(consultations.get(i).getpatientID());
								p.print();
							}
							// System.out.println("length = " + );
						}
						//Surgeon---Operation
						else if (d.getType().equals("Surgeon")) {
							OperationDAO odao = daoFactory.getOperationDAO();
							ArrayList<Operation> operations = odao.getOperationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							for (int i = 0;i < operations.size() ; i++) {
								Patient p = pdao.getPatientByID(operations.get(i).getpatientID());
								p.print();
							}
						}
					}
					else {
						System.out.println("Please Enter Valid Key" );
					}
				}
				//Use Case2
				else if (tmp1 == 2) {

					DoctorDAO ddao = daoFactory.getDoctorDAO();

					System.out.println("To search by ID, press 1" );
					System.out.println("To search by Name, press 2" );
					tmp2 = scan.nextInt();

					if (tmp2 == 1) {

					//getDoctorByID
						System.out.println("Enter Docter ID" );
						int tmp_id = scan.nextInt();
						Doctor d = ddao.getDoctorByID(tmp_id);
						//Physician---Consultation
						if (d.getType().equals("Physician")) {
							ConsultationDAO cdao = daoFactory.getConsultationDAO();
							// Consultation c = cdao.getConsultationByDoc(d1.getDoctorID());
							ArrayList<Consultation> consultations = cdao.getConsultationByDoc(d.getDoctorID());

							PatientDAO pdao = daoFactory.getPatientDAO();
							System.out.println("Bill No. || Patient ID || Patient Name || Patient Age || Amount || Date" );
							for (int i = 0;i < consultations.size() ; i++) {
								Patient p = pdao.getPatientByID(consultations.get(i).getpatientID());
								// p.print();
								BillsDAO bdao = daoFactory.getBillsDAO();
								ArrayList<Bills> bills = bdao.getBillByPatientID(p.getPatientID());
								for (int j = 0;j <  bills.size(); j++) {
										// bills.get(j).print();
										System.out.println( bills.get(j).getBillNo() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + bills.get(j).getAmount() + " || " + bills.get(j).getDate());
								}
							}
							System.out.println("Report ID || Patient ID || Patient Name || Patient Age || Doctor ID || Doctor Name || Report" );
							for (int i = 0;i < consultations.size() ; i++) {
								Patient p = pdao.getPatientByID(consultations.get(i).getpatientID());
								ReportsDAO rdao = daoFactory.getReportsDAO();
								ArrayList<Reports> reports = rdao.getReportByPatientID(p.getPatientID());
								for (int j = 0;j <  reports.size(); j++) {
										// reports.get(j).print();
										System.out.println( reports.get(j).getReportID() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + d.getDoctorID() + " || " + d.getName() + " || " + reports.get(j).getReport());
								}
							}
							// System.out.println("length = " + );
						}
						//Surgeon---Operation
						else if (d.getType().equals("Surgeon")) {
							OperationDAO odao = daoFactory.getOperationDAO();
							ArrayList<Operation> operations = odao.getOperationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							System.out.println("Bill No. || Patient ID || Patient Name || Patient Age || Amount || Date" );
							for (int i = 0;i < operations.size() ; i++) {
								Patient p = pdao.getPatientByID(operations.get(i).getpatientID());
								// p.print();
								BillsDAO bdao = daoFactory.getBillsDAO();
								ArrayList<Bills> bills = bdao.getBillByPatientID(p.getPatientID());
								for (int j = 0;j <  bills.size(); j++) {
										// bills.get(j).print();
										System.out.println( bills.get(j).getBillNo() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + bills.get(j).getAmount() + " || " + bills.get(j).getDate());
								}
							}
							System.out.println("Report ID || Patient ID || Patient Name || Patient Age || Doctor ID || Doctor Name || Report" );
							for (int i = 0;i < operations.size() ; i++) {
								Patient p = pdao.getPatientByID(operations.get(i).getpatientID());
								ReportsDAO rdao = daoFactory.getReportsDAO();
								ArrayList<Reports> reports = rdao.getReportByPatientID(p.getPatientID());
								for (int j = 0;j <  reports.size(); j++) {
										// reports.get(j).print();
										System.out.println( reports.get(j).getReportID() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + d.getDoctorID() + " || " + d.getName() + " || " + reports.get(j).getReport());
								}
							}
						}
					}
					else if (tmp2 == 2) {
						System.out.println("Enter Docter Name" );
						String s = scan.next();
						//getDoctorByname
						Doctor d = ddao.getDoctorByname(s);
						//Physician---Consultation
						if (d.getType().equals("Physician")) {
							ConsultationDAO cdao = daoFactory.getConsultationDAO();
							// Consultation c = cdao.getConsultationByDoc(d1.getDoctorID());
							ArrayList<Consultation> consultations = cdao.getConsultationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							System.out.println("Bill No. || Patient ID || Patient Name || Patient Age || Amount || Date" );
							for (int i = 0;i < consultations.size() ; i++) {
								Patient p = pdao.getPatientByID(consultations.get(i).getpatientID());
								// p.print();
								BillsDAO bdao = daoFactory.getBillsDAO();
								ArrayList<Bills> bills = bdao.getBillByPatientID(p.getPatientID());
								for (int j = 0;j <  bills.size(); j++) {
										// bills.get(j).print();
										System.out.println( bills.get(j).getBillNo() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + bills.get(j).getAmount() + " || " + bills.get(j).getDate());
								}
							}
							System.out.println("Report ID || Patient ID || Patient Name || Patient Age || Doctor ID || Doctor Name || Report" );
							for (int i = 0;i < consultations.size() ; i++) {
								Patient p = pdao.getPatientByID(consultations.get(i).getpatientID());
								ReportsDAO rdao = daoFactory.getReportsDAO();
								ArrayList<Reports> reports = rdao.getReportByPatientID(p.getPatientID());
								for (int j = 0;j <  reports.size(); j++) {
										// reports.get(j).print();
										System.out.println( reports.get(j).getReportID() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + d.getDoctorID() + " || " + d.getName() + " || " + reports.get(j).getReport());
								}
							}
							// System.out.println("length = " + );
						}
						//Surgeon---Operation
						else if (d.getType().equals("Surgeon")) {
							OperationDAO odao = daoFactory.getOperationDAO();
							ArrayList<Operation> operations = odao.getOperationByDoc(d.getDoctorID());
							PatientDAO pdao = daoFactory.getPatientDAO();
							System.out.println("Bill No. || Patient ID || Patient Name || Patient Age || Amount || Date" );
							for (int i = 0;i < operations.size() ; i++) {
								Patient p = pdao.getPatientByID(operations.get(i).getpatientID());
								// p.print();
								BillsDAO bdao = daoFactory.getBillsDAO();
								ArrayList<Bills> bills = bdao.getBillByPatientID(p.getPatientID());
								for (int j = 0;j <  bills.size(); j++) {
										// bills.get(j).print();
										System.out.println( bills.get(j).getBillNo() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + bills.get(j).getAmount() + " || " + bills.get(j).getDate());
								}
							}
							System.out.println("Report ID || Patient ID || Patient Name || Patient Age || Doctor ID || Doctor Name || Report" );
							for (int i = 0;i < operations.size() ; i++) {
								Patient p = pdao.getPatientByID(operations.get(i).getpatientID());
								ReportsDAO rdao = daoFactory.getReportsDAO();
								ArrayList<Reports> reports = rdao.getReportByPatientID(p.getPatientID());
								for (int j = 0;j <  reports.size(); j++) {
										// reports.get(j).print();
										System.out.println( reports.get(j).getReportID() + " || " + p.getPatientID() + " || " + p.getName() + " || " + p.getAge() + " || " + d.getDoctorID() + " || " + d.getName() + " || " + reports.get(j).getReport());
								}
							}
						}
					}
				}
				else {
					System.out.println("Please Enter Valid Key" );
				}
				System.out.println("======================================================================" );
				System.out.println("To search again, press 1" );
				System.out.println("To exit, press any other number" );
				tmp3 = scan.nextInt();
				if (tmp3 == 1) {
					continue;
				}
				else{
					break;
				}
			}

			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
