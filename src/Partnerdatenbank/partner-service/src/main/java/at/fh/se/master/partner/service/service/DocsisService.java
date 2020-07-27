package at.fh.se.master.partner.service.service;

import at.fh.se.master.partner.service.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.WebApplicationException;
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

    @Retryable(value = {RestClientException.class, WebApplicationException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000)
    )
    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
        List<Link> links = restTemplate.getForObject(restBaseServiceDocsis + "links/partner/" + partnerId,
                ArrayList.class);
        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    @Retryable(value = {RestClientException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000)
    )
    public ResponseEntity addLink(Link link) {
        restTemplate.postForObject(restBaseServiceDocsis + "link", link, Link.class);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Retryable(value = {RestClientException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000)
    )
    public ResponseEntity deleteLink(Long id) {
        restTemplate.delete(restBaseServiceDocsis + "link/" + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Recover
    public void recoverRestClientException(RestClientException ex){
         // ...
    }

}
