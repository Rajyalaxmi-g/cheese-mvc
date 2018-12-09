package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="add")
    public String Add(Model model){

        model.addAttribute("title","Add User");

        return "user/add";
    }
    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processadd(Model model, @ModelAttribute User user, String verify){

        model.addAttribute("title","Add User");

        if (user.getPassword().equals(verify)){
            model.addAttribute("user", user);
            return "user/index";
        }
        return "user/add";
    }
}
