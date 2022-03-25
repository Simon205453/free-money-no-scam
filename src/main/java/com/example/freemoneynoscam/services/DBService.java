package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.model.Email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.example.freemoneynoscam.FreeMoneyNoScamApplication.*;

public class DBService {



    public void addEmailToDB(Email email){
        String emailString = email.getEmailString();
        try {
            statement = connection.createStatement();
            sqlString = "INSERT INTO user_emails (`user_emails`)" + "VALUES('"+emailString+"')";
            statement.executeUpdate(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connectDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/free_money";
            connection = DriverManager.getConnection(url, "root", "Need2breed#");
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
