package at.fh.se.master.partner.rest.controller;

import at.fh.se.master.partner.BackendApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = BackendApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LinkControllerTest {

    @Test
    public void getAllLinksOfPartner() {
    }

    @Test
    public void addLink() {
    }

    @Test
    public void deleteLink() {
    }
}