package com.example.freemoneynoscam.repo;

import com.example.freemoneynoscam.model.Email;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.freemoneynoscam.FreeMoneyNoScamApplication.*;

public class MailRepo {

    public ArrayList<Email> getAllMails(){
        ArrayList<Email> allMails = new ArrayList<>();

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //sqlString = "SELECT `user_emails`" + "FROM `user_emails`" + "WHERE user_emails.user_emails";
            sqlString = "SELECT * FROM user_emails";
            rs = statement.executeQuery(sqlString);

            while(rs.next()){
                Email tempMail = new Email(rs.getString("user_emails"));
                allMails.add(tempMail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allMails;
    }
}
