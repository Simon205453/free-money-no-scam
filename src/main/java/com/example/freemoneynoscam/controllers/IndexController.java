package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.model.Email;
import com.example.freemoneynoscam.services.DBService;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {
    @GetMapping("/" + "/index")
    public String index() {
        return "index";
    }

    @GetMapping("/invalidEmailFace")
    public String invalidEmailFace() {
        return "invalidEmailFace";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }


    @PostMapping("/submit")
    public String submit(WebRequest dataFromForm) {
        DBService dbs = new DBService();
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
}
