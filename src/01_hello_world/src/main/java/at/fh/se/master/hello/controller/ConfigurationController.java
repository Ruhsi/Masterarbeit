package at.fh.se.master.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

    @Value("${example.servers[0].name: n/a}")
    private String serverName;

    @Value("${example.servers[0].url: n/a}")
    private String serverUrl;


    @GetMapping("/configuration")
    public String getConfiguration(){
        test();
        return serverName + ": " + serverUrl;
    }

    private void test(){
        System.out.println("test");
    }
}
