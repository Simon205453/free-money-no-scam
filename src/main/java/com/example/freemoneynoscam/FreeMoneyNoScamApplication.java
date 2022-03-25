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
    public static Connection connection = DBService.connectDB();
    public static String sqlString;
    public static ResultSet rs;

    public static void main(String[] args) {
        SpringApplication.run(FreeMoneyNoScamApplication.class, args);
        connectDB();

    }


}
