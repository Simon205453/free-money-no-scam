package com.example.freemoneynoscam.repo;

import com.example.freemoneynoscam.model.Email;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.freemoneynoscam.FreeMoneyNoScamApplication.*;
import static com.example.freemoneynoscam.FreeMoneyNoScamApplication.rs;

public class NewsRepo {

    public ArrayList<String> getNews() {
        ArrayList<String> newsFeed = new ArrayList<>();

        try {
            URL url = new URL("https://ekstrabladet.dk/rssfeed/nyheder/");
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                String newsString = "";

                newsString = sc.next();

                if (newsString.contains("title")) {
                    newsFeed.add(newsString);
                    System.out.println("item has been added");
                }


            }

        } catch (Exception e) {
        }
        return newsFeed;
    }


}
