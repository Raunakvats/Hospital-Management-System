package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Doctors {


    private Connection connection;



    public Doctors(Connection connection){
        this.connection = connection;

    }


    public void viewDoctorsbyId(){
        String query = "Select * from doctors";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+--------+-----------+-------------------------+");
            System.out.println("| id     | name      | Specialization          |");
            System.out.println("+--------+-----------+-------------------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String Specialization = resultSet.getString("Specialization");
                System.out.printf("| %-7s | %-10s | %-23s ||\n",id , name , Specialization);
                System.out.println("+--------+-----------+-------------------------+");
            }



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean checkDoctors(int id){
        String query = " Select * from Doctors WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return false;

    }
}


