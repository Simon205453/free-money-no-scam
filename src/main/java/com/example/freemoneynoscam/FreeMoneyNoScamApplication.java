package com.example.freemoneynoscam;

import com.example.freemoneynoscam.model.Email;
import com.example.freemoneynoscam.services.DBService;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

import static com.example.freemoneynoscam.services.DBService.connectDB;

@SpringBootApplication
public class FreeMoneyNoScamApplication {

    public static Statement statement;
    public static Connection connection;
    public static String sqlString;
    static ResultSet resultSet;

    public static void main(String[] args) {
        SpringApplication.run(FreeMoneyNoScamApplication.class, args);
        connectDB();

    }

    public static void selectData(){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sqlString = "SELECT `user_emails`" +
                    "FROM iduser_emails, user_emails" +
                    "WHERE user_emails.user_emails";
            resultSet = statement.executeQuery(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
