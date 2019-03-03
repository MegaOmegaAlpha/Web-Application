package webservicenc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

    @RequestMapping("/")
    @ResponseBody
    String hello(){
        return "Hello World!";
    }
}
