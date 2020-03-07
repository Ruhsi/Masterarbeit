package at.fh.se.master.partner.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class UserController implements UserControllerApi {

    @Override
    public ResponseEntity<String> login(HttpServletResponse res) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
