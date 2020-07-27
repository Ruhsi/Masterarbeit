package at.fh.se.master.partner.rest.controller;

import at.fh.se.master.partner.BackendApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Principal;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = BackendApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerTest {

    @Autowired
    private UserControllerApi userControllerApi;

    @Test
    public void login() {
        // when
        ResponseEntity entity = userControllerApi.login(null);

        // then
        assertNotNull(entity);
    }

    @Test
    public void currentUser() {
        // given
        Principal user = () -> "Christoph Ruhsam";

        // when
        Principal u = userControllerApi.currentUser(user);

        // then
        assertNotNull(u);
    }
}