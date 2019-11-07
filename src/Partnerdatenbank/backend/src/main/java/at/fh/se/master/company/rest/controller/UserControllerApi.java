package at.fh.se.master.company.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RequestMapping("/")
public interface UserControllerApi {

    @RequestMapping(method = RequestMethod.OPTIONS, value = "/login")
    ResponseEntity<String> login(HttpServletResponse res);

    @RequestMapping(value = "/user", method = RequestMethod.OPTIONS)
    ResponseEntity<String> currentUserPreflight();

    @GetMapping(value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Principal currentUser(Principal principal);
}
