package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    //this statement violates the separation of concerns of MVC pattern
    //the controller should not be responsible for managing model objects
    //static ArrayList<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model)
    {
        //create list of cheeses

//        cheeses.add("cheddar");
//        cheeses.add("parmesan");
//        cheeses.add("munster");
        //pass list of cheeses to view
        //model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title","Cheese");

        return "cheese/index"; //render index template
    }

    //controller method to display a form
    @RequestMapping(value = "add",method= RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "AddCheese");
        model.addAttribute("message","welcome to cheese");



         return "cheese/add";
    }


////this technique is not exclusive to spring, this servletrequest object is part of java servlet API which is a lower level web application
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    public String processAddCheeseForm(HttpServletRequest request){
//        String cheeseName = request.getParameter("cheeseName");
//    }
    //in spring framework we use RequestParam
   /* @RequestMapping(value="add",method=RequestMethod.POST )
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description ){
        //spring should look for Requestparam cheeseName
        Cheese newCheese = new Cheese(cheeseName,description);
       // cheeses.add(newCheese);
        CheeseData.add(newCheese);
         //redirect to /cheese
     return "redirect:";
    }

    */
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese ){

        /*
        springboot will create an object for cheese when it gets POST request from /add
        Cheese newCheese = new Cheese();
        the framework will create objects
        newCheese.setName(Request.getParameter("name"));
        newCheese.setDescription(Request.getParameter("description"));

         */
        CheeseData.add(newCheese);

        return "redirect:";
    }

    @RequestMapping(value="remove")
    public String displayRemoveCheese(Model model){
        //model.addAttribute("cheeses",cheeses);
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title","RemoveCheese");
        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
//    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheese){
//            for (String cheesee : cheese){
//                System.out.println(cheesee);
//                cheeses.remove(cheesee);
//
//        }
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds ){

        for (int cheeseId : cheeseIds){
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

//    @RequestMapping(value="edit/cheeseId", method=RequestMethod.GET)
//    public String displayEditForm(Model model, @PathVariable int cheeseId){
//
//        return form;
//    }
//
//    @RequestMapping(value="edit", method=RequestMethod.POST)
//    public String processEditForm(int cheeseId, String name, String description){
//
//        return ;
//    }

}

