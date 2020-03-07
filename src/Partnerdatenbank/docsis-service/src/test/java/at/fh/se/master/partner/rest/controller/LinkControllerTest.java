package at.fh.se.master.partner.rest.controller;

import at.fh.se.master.partner.BackendApplicationTests;
import at.fh.se.master.partner.service.model.Link;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = BackendApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LinkControllerTest {

    @Autowired
    private LinkControllerApi linkController;

    private Link link;

    @Before
    public void setUp(){
        // given
        link = new Link();
        link.setPartnerId(1);
        link.setLink("www.orf.at");
        link.setLinkDescription("This is the link to orf!");

        linkController.addLink(link);
    }

    @Test
    public void getAllLinksOfPartner_Test() {
        // when
        List<Link> found = linkController.getAllLinksOfPartner(link.getPartnerId()).getBody();

        // then
        assertThat(found.size()).isEqualTo(1);
        assertThat(found.get(0).getLink()).isEqualTo(link.getLink());
    }

    @Test
    public void deleteLink_Test(){
        // when
        linkController.deleteLink(link.getId());
        List<Link> found = linkController.getAllLinksOfPartner(link.getPartnerId()).getBody();

        // then
        assertThat(found.size()).isEqualTo(0);
    }

    @Test
    public void addLink_Test(){
        // given
        Link link2 = new Link();
        link2.setPartnerId(1);
        link2.setLink("www.google.at");
        link2.setLinkDescription("This is the link to google");

        linkController.addLink(link2);

        // when
        List<Link> found = linkController.getAllLinksOfPartner(link2.getPartnerId()).getBody();

        // then
        assertThat(found.size()).isEqualTo(2);
    }
}