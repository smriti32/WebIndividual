package com.obm.onlinebookmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("Learn_More")
    public String LearnMore(){
        return "LearnMore";
    }
    @GetMapping("Our_Work")
    public String OurWork(){
        return "OurWork";
    }
    @GetMapping("Our_Objective")
    public String OurObjective(){
        return "OurObjective";
    }
    public String OurGoal(){
        return "OurGoal";
    }
    public String Contact(){
        return "OurContact";
    }
    public String Careers(){
        return "OurCareers";
    }
    public String News(){
        return "News";
    }
    public String PrivacyPolicy(){
        return "privacyPolicy";
    }
    public String TOS(){
        return "termsOfService";
    }
    public String TPS(){
        return "thirdPartyServices";
    }
}
