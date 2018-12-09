package org.launchcode.hellospring.controllers;



//import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller //tells this class is a controller class
//@RequestMapping("hello") //request mapping at controller level
                        //every request in the controller should be preceded by segment hello
public class HelloController {

    static int  count = 1;
    static int  totalCount =1;

    @RequestMapping(value="")
    @ResponseBody   //return plain text
    //data transfer by  get request and query param
    public String index(HttpServletRequest request)   //get parameters that r passed into the server via query string
    {
        String username = request.getParameter("name"); //name should match with key in query string
        //if we pass nothing to name query parameter in the url then it will take it as null
        //so we r checking here for if name is null
        if(username == null)
        {
            username = "World";
        }
        return "Hello " + username;
    }
    //handle post parameters
    //data transfer via by post and post parameters
    @RequestMapping(value="hello", method=RequestMethod.GET)
    @ResponseBody
    public String helloForm()
    {
        String html = "<form method='post'>"+
                "<input type='text' name='uname' />"+
                "<select name='lang'>" +
                "<option value=''> Select language</option>" +
                "<option value='english'> English </option>" +
                "<option value='spanish'> Spanish</option>" +
                "<option value='hindi'> Hindi</option>" +
                "<option value='french'> French</option>" +
                "<option value='persian'> Persian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value="hello",method= RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("uname");
        String language = request.getParameter("lang");
        String lang = "";
        if (language.equalsIgnoreCase("English")){
            lang = "Hello";

        }
        if (language.equalsIgnoreCase("Spanish"))
        {
            lang = "Hola";

        }
        if (language.equalsIgnoreCase("French")){
            lang = "Bonjour";

        }
        if (language.equalsIgnoreCase("Hindi")){
            lang = "Namaste";

        }
        if (language.equalsIgnoreCase("Persian")){
            lang = "Salaam";

        }
        String c = hello(request,response);


        return lang +" " + name + "\n" + "Visits = " + c;

    }


    public static String hello(HttpServletRequest request,HttpServletResponse response)
    {


        Cookie myCookie = new Cookie("visits",request.getParameter("uname"));

        response.addCookie(myCookie);

        Cookie[] cookies = request.getCookies();




        for(Cookie cc :cookies)
        {
           if( cc.getValue().equals("visits"))
            {
              if(!request.getParameter("uname").equals(cc.getValue()))
              {
                  count++;

              }
            }
        }

        //count = 1+ Integer.parseInt(c);
//        {
//            if (c.getName().equals("o"))
//            {
//               // count = c.getValue();
//            }// for (Cookie c : cookies)
//        }
//        System.out.println("visits = "+ count);

        Integer x= new Integer(count);
        System.out.println(x.toString());
        return  x.toString();




    }

    //handle request tht r submitted from the form
    //handle post method
    /*@RequestMapping(value="hello",method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request)
    {
        String username = request.getParameter("uname");
        return "Hello " + username;
    }*/

    //data tranfer by url segment : access data by url segment
    @RequestMapping(value="hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name)
    {

        return "hello " + name;
    }

    @RequestMapping(value = "goodbye") //Request URI method

    public String goodbye()
    {

        return "redirect:/"; //redirect to root handler ie.,@RequestMapping(value="")
    }
}
