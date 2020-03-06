package at.fh.se.master.company.rest.controller;


import at.fh.se.master.company.service.model.Link;
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
    public ResponseEntity<List<Link>> getAllLinksOfPartner(Long partnerId) {
        return new ResponseEntity<>(linkRepository.findByPartnerId(partnerId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Link> addLink(Link link) {
        return new ResponseEntity<>(linkRepository.save(link), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Link> deleteLink(Long id) {
        linkRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
