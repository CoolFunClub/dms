package com.coolfunclub.dms.hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/HelloWorld")
    public String helloWorld(){
        return "Hello World!";
    }
}
