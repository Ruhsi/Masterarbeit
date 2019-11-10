package at.fh.se.master.docsis.rest.controller;


import at.fh.se.master.docsis.service.model.Link;
import at.fh.se.master.docsis.service.service.DocsisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController implements LinkControllerApi {

    private final DocsisService docsisService;

    @Autowired
    public LinkController(final DocsisService docsisService) {
        this.docsisService = docsisService;
    }


    @Override
    public String getAllLinksOfPartnerPreflight(Long id) {
        return "OK";
    }

    @Override
    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
       ResponseEntity<List<Link>> links = docsisService.getAllLinksOfPartner(partnerId);
        return new ResponseEntity<>(links.getBody(), links.getStatusCode());
    }

    @Override
    public String addLinkPreflight() {
        return "OK";
    }

    @Override
    public ResponseEntity addLink(Link link) {
        docsisService.addLink(link);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public String deleteLinkPreflight(Long id) {
        return "OK";
    }

    @Override
    public ResponseEntity deleteLink(Long id) {
        docsisService.deleteLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
