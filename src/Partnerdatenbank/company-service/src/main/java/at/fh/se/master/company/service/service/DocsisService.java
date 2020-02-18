package at.fh.se.master.company.service.service;

import at.fh.se.master.company.service.model.Link;
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

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${base.service.docsis}")
    private String restBaseServiceDocsis;

    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
        List<Link> links = restTemplate.getForObject(restBaseServiceDocsis + "links/partner/"+partnerId,
                ArrayList.class);
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