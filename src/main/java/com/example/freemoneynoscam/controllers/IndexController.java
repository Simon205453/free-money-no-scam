package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.model.Email;
import com.example.freemoneynoscam.repo.MailRepo;
import com.example.freemoneynoscam.repo.NewsRepo;
import com.example.freemoneynoscam.services.DBService;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;

@Controller
public class IndexController {

    private final MailRepo mailRepo = new MailRepo();
    private DBService dbs = new DBService();

    @GetMapping("/" + "/index")
    public String index(Model fetchDataToView) {
        ArrayList<Email> allEmails = mailRepo.getAllMails();
        fetchDataToView.addAttribute("allMails", allEmails);
        return "index";
    }
    
    @GetMapping("/showmemymails")
    public String testmail(Model fetchDataToView) {
        ArrayList<Email> allEmails = mailRepo.getAllMails();
        fetchDataToView.addAttribute("allMails", allEmails);
        return "showmemymails";
    }


    @GetMapping("/invalidEmailFace")
    public String invalidEmailFace() {
        return "invalidEmailFace";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @PostMapping("/fetchmails")
    public String fetchmails(){
        return "redirect:/showmemymails";
    }

    @PostMapping("/submit")
    public String submit(WebRequest dataFromForm) {
        Email email = new Email(dataFromForm.getParameter("email"));
        ValidateEmailService vms = new ValidateEmailService();
        if (vms.isEmailValid(email.getEmailString())){
            dbs.addEmailToDB(email);
            System.out.println(email.getEmailString() + " - is added to database");
            return "redirect:/success";
        } else {
            System.out.println(email.getEmailString() + " - not added to database");
            return "redirect:/invalidEmailFace";
        }
    }

    @PostMapping("/sessionEmail")
    public String sessionTest(HttpSession session){
        session.setAttribute("thisEmail", "hello");
        return "redirect:/";
    }

    @GetMapping("/newssite")
    public String newssite(Model fetchDataToView){
        NewsRepo nr = new NewsRepo();
        ArrayList<String> newsFeedArr = new ArrayList<>(nr.getNews());
        fetchDataToView.addAttribute("newsFeed", newsFeedArr);
        return "news";
    }

    @PostMapping("/newsfetch")
    public String newsfetch(){
        return "redirect:/newssite";
    }
}
