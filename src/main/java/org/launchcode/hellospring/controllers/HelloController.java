package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//annotate with @Controller and import the above statement (org.springframework.stereotype)
//@ResponseBody
////if every method is to have this annotation you can put it above the HelloController class
////@ResponseBody is now inherited
//
//@RequestMapping(value = "hello")
////says every method within this class should begin with /hello -- all information that follows this route will
////live at /hello/whateverParam

public class HelloController {

////    //Handle request at localhost:8080/hello -- updated code
////    @GetMapping("hello")
////    //specifies to SpringBoot that this method should handle GET requests
////    @ResponseBody
////    public String hello() {
////        return  "Hello, Spring!";
////    }
//
//        //@GetMapping("pathname") if pathname is null then the path used is the index path
//        // or /.
//    @GetMapping("goodbye")
//    //now lives @ /hello/goodbye
//    //specifies to SpringBoot that this method should handle GET requests
//    //localhost:8080/goodbye
//
////    @ResponseBody
//    //a common annotation used in the Spring controller context to return plain text from
//    //a controller method.
//    public String goodbye() {
//        return  "Goodbye, Spring!";
//    }
//
//    //Handles requests of the form /hello?name=LaunchCode
////    @GetMapping("hello")
//    @RequestMapping (method = {RequestMethod.GET, RequestMethod.POST})
//    //instead of specifying get/post Mapping - use this
//    //will only return plain text
//    public String helloWithQueryParam(@RequestParam String name) {
//
//        //@RequestParam tells Spring to expect a queryparameter called name
//        // - must match up with the name in the URL and match it up with the method parameter
//
//        return "Hello, " + name + "!";
//
//        //a dynamic request handler that responds based on the data that it is given
//    }
//
//    //another way to create a dynamic request handler
//    //handlers requests of the form /hello/LaunchCode
//    //now the piece of data is a part of the path itself
//
//    @GetMapping("{name}")
//    //since variable is a part of the path it won't conflict with methods above
//    public String helloWithPathParam(@PathVariable String name){
//        //use @PathVariable - this particular handler method is looking for a request
//        //to hello/{name} which the variable can be any value
//
//        return "Hello, " + name + "!!";
//    }
//
//    //Create a form in order for user to type in their name to greet them
////    @GetMapping("form")
////    @ResponseBody
////    public String helloForm() {
////        return "<html>" +
////                "<body>" +
////                "<form method = 'get' action = '/hello'>" + //tells to submit request to /hello
////                //already have a handler method that can create requests with a query parameter called name
////                //"helloWithQueryParam
////                "<input type = 'text' name = 'name'>" +
////                "<input type = 'submit' value = 'Greet Me!' />" +
////                "</form>" +
////                "</body>" +
////                "</html>";
////    }

    //Controller-Exercises
//
//
//    @RequestMapping (value = "hello", method = RequestMethod.POST)
//    @ResponseBody
//    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        if (name == null) {
//            name = "World";
//        }
//        return createMessage(name, language);
//    }
//
//    public static String createMessage(String n, String l) {
//        String greeting = "";
//
//        if (l.equals("english")) {
//            greeting = "Hello";
//        } else if (l.equals("french")) {
//            greeting = "Bonjour";
//        } else if (l.equals("italian")) {
//            greeting = "Bonjourno";
//        } else if (l.equals("spanish")) {
//            greeting = "Hola";
//        } else if (l.equals("german")) {
//            greeting = "Hallo";
//        }
//        return greeting + " " + n;
//    }
//    //Post Request in form
//
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action = '/hello' method = 'post' >" +
//                "<input type = 'text' name = 'name'>" +
//                "<select name = 'language' id = 'language-select'>" +
//                "<option value=''> Please choose an option </option>" +
//                "<option value='French'>French</option>" +
//                "<option value='English'>English</option>" +
//                "<option value='Italian'>Italian</option>" +
//                "<option value='Spanish'>Spanish</option>" +
//                "<option value='German'>German</option>" +
//                "</select>" +
//                "<input type = 'submit' value = 'Greet Me!' />" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    // Copy and Pasted from hello-spring-demo git page to continue for chapter 11

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        //theGreeting -the local variable - must match up with the second value of the .addAttribute()
        //The first argument in .addAttribute must match up w/ the variable name in the template "greeting"

        //this method creates a String and adds that string as a variable to the model
        //the model is then passed into the view when we render the template when we return the templates name
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode

    //can use the same template
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greetings = "hello, " + name + "!!!!";
        model.addAttribute("greeting", greetings);
        //could also do just
        //model.addAttribute("greeting", "hello, " + name + "!!!!");

        return "hello";
    }


    @GetMapping("form")
    public String helloForm() {
        return "formTemplate";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> namesList = new ArrayList<>();
        namesList.add("Chris");
        namesList.add("Kelsey");
        namesList.add("Bobby");
        namesList.add("Megan");
        model.addAttribute("names", namesList);

        return "hello-list";
    }

}
