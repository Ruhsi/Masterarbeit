package at.fh.se.master.partner.service.service;

import at.fh.se.master.partner.service.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocsisService {

    private final RestTemplate restTemplate;

    @Value(value = "${base.service.docsis}")
    private String restBaseServiceDocsis;

    @Autowired
    public DocsisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
        List<Link> links = restTemplate.getForObject(restBaseServiceDocsis + "links/partner/"+partnerId,
                ArrayList.class);
        System.out.println(restBaseServiceDocsis);
        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    public ResponseEntity addLink(Link link) {
        restTemplate.postForObject(restBaseServiceDocsis + "link", link, Link.class);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity deleteLink(Long id) {
        restTemplate.delete(restBaseServiceDocsis + "link/" + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
