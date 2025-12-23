package HospitalManagementSystem;

import com.mysql.cj.protocol.ProtocolEntityReader;

import javax.print.Doc;
import java.sql.*;
import java.util.*;

public class HospitalManagement {

    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String Username = "root";
    private static final String password = "x47eDJRZ";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,Username,password);
            Scanner sc = new Scanner(System.in);
            Patients patients = new Patients(connection,sc);
            Doctors doctors = new Doctors(connection);
            while(true){
                System.out.println("----HOSPITAL MANAGEMENT SYSTEM----");
                System.out.println("1). Add patient: ");
                System.out.println("2). View Patient: ");
                System.out.println("3). View Doctors: ");
                System.out.println("4). Book Appointment: ");
                System.out.println("5). EXIT ");
                System.out.print("Enter your choice : 1/2/3/4/5 ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        //add patient
                        patients.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        //view patient
                        patients.viewPatientsbyId();
                        System.out.println();
                        break;
                    case 3:
                        //view doctors
                        doctors.viewDoctorsbyId();
                        System.out.println();
                        break;
                    case 4:
                        //Book appointment
                        bookAppointment(connection,sc,patients,doctors);
                        break;

                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public static void bookAppointment(Connection connection , Scanner sc , Patients Patient , Doctors doctors){
        System.out.print("Enter Patient id: ");
        int patient_id = sc.nextInt();
        System.out.print("Enter doctor id: ");
        int doctor_id = sc.nextInt();
        System.out.print("Enter Appointment date (YYYY-MM-DD): ");
        String Appointmentdate = sc.next();
        if(Patient.checkPatients(patient_id) && doctors.checkDoctors(doctor_id)){
            if(isDoctorAvailable(connection,doctor_id,Appointmentdate)){
                String appointmentquery = "INSERT INTO appointments(patients_id , doctors_id , appointment_date) VALUES (?,?,?)";
                try{
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentquery);
                    preparedStatement.setInt(1,patient_id);
                    preparedStatement.setInt(2,doctor_id);
                    preparedStatement.setString(3,Appointmentdate);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected > 0){
                        System.out.println("Appointment booked Successfully");
                    }else{
                        System.out.println("Couldn't place your appointment");
                    }
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("OOPS:( Doctor is not available as per Mentioned date");
            }
        }else{
            System.out.println("Invalid Id! Please provide the correct Id");
        }
    }

    public static boolean isDoctorAvailable(Connection connection,int doctor_id,String appointmentdate){
        String query = "SELECT COUNT(*) FROM appointments WHERE doctors_id = ? and appointment_date = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doctor_id);
            preparedStatement.setString(2,appointmentdate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                if(count == 0){
                    return true;
                }else{
                    return false;
                }

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
