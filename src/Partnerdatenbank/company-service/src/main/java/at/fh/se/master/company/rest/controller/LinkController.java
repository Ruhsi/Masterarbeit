package at.fh.se.master.company.rest.controller;


import at.fh.se.master.company.service.model.Link;
import at.fh.se.master.company.service.service.DocsisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController implements LinkControllerApi {

    private final DocsisService docsisService;

    public LinkController(final DocsisService docsisService) {
        this.docsisService = docsisService;
    }

    @Override
    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
        ResponseEntity<List<Link>> links = docsisService.getAllLinksOfPartner(partnerId);
        return new ResponseEntity<>(links.getBody(), links.getStatusCode());
    }

    @Override
    public ResponseEntity addLink(Link link) {
        docsisService.addLink(link);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteLink(Long id) {
        docsisService.deleteLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
