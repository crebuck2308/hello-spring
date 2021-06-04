package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//annotate with @Controller and import the above statement (org.springframework.stereotype)
public class HelloController {

    //Handle request at localhost:8080/hello -- updated code
    @GetMapping("hello")
    //specifies to SpringBoot that this method should handle GET requests
    @ResponseBody
    public String hello() {
        return  "Hello, Spring!";
    }

        //@GetMapping("pathname") if pathname is null then the path used is the index path
        // or /.
    @GetMapping("goodbye")
    //specifies to SpringBoot that this method should handle GET requests
    //localhost:8080/goodbye
    @ResponseBody
    public String goodbye() {
        return  "Goodbye, Spring!";
    }
}
