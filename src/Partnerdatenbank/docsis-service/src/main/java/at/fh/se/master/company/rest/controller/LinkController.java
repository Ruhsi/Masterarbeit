package at.fh.se.master.company.rest.controller;


import at.fh.se.master.company.service.model.Link;
import at.fh.se.master.company.service.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController implements LinkControllerApi {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkController(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Override
    public String getAllLinksOfPartnerPreflight(Long id) {
        return "OK";
    }

    @Override
    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
        List<Link> links = linkRepository.findByPartnerId(partnerId);
        return new ResponseEntity<>(linkRepository.findByPartnerId(partnerId), HttpStatus.OK);
    }

    @Override
    public String addLinkPreflight() {
        return "OK";
    }

    @Override
    public ResponseEntity<Link> addLink(Link link) {
        return new ResponseEntity<>(linkRepository.save(link), HttpStatus.OK);
    }

    @Override
    public String deleteLinkPreflight(Long id) {
        return "OK";
    }

    @Override
    public ResponseEntity<Link> deleteLink(Long id) {
        linkRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
