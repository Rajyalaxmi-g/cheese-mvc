package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("leasing")
public class LeasingController {

    @RequestMapping(value="contact")
    public String displayContactForm(Model model){

        model.addAttribute("title","Contact Information");
        return "leasing/contact";
    }
}
