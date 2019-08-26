package at.fh.se.master.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(@RequestParam final String name){
        System.out.println("Starting...");
        return "Hello, " + name + "\n";
    }
}
