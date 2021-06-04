package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//annotate with @Controller and import the above statement (org.springframework.stereotype)
public class HelloController {

//    //Handle request at localhost:8080/hello -- updated code
//    @GetMapping("hello")
//    //specifies to SpringBoot that this method should handle GET requests
//    @ResponseBody
//    public String hello() {
//        return  "Hello, Spring!";
//    }

        //@GetMapping("pathname") if pathname is null then the path used is the index path
        // or /.
    @GetMapping("goodbye")
    //specifies to SpringBoot that this method should handle GET requests
    //localhost:8080/goodbye
    @ResponseBody
    //a common annotation used in the Spring controller context to return plain text from
    //a controller method.
    public String goodbye() {
        return  "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode
    @GetMapping("hello")
    @ResponseBody
    //will only return plain text
    public String helloWithQueryParam(@RequestParam String name) {
        //@RequestParam tells Spring to expect a queryparameter called name
        // - must match up with the name in the URL and match it up with the method parameter

        return "Hello, " + name + "!";

        //a dynamic request handler that responds based on the data that it is given
    }

    //another way to create a dynamic request handler
    //handlers requests of the form /hello/LaunchCode
    //now the piece of data is a part of the path itself

    @GetMapping("hello/{name}")
    //since variale is a part of the path it won't conflict with methods above
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        //use @PathVariable - this particular handler method is looking for a request
        //to hello/{name} which the variable can be any value

        return "Hello, " + name + "!!";
    }
}
