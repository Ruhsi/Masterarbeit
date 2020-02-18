package at.fh.se.master.company.rest.controller;

import at.fh.se.master.company.service.model.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
public interface LinkControllerApi {


    @RequestMapping(value = "links/partner/{id}", method = RequestMethod.OPTIONS)
    String getAllLinksOfPartnerPreflight(@PathVariable("id") Long id);

    @GetMapping(value = "links/partner/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Link>> getAllLinksOfPartner(@PathVariable("id") Long partnerId);

    @RequestMapping(value = "link", method = RequestMethod.OPTIONS)
    String addLinkPreflight();

    @PostMapping(value = "link",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Link> addLink(@RequestBody Link link);

    @RequestMapping(value = "link/{id}", method = RequestMethod.OPTIONS)
    String deleteLinkPreflight(@PathVariable Long id);

    @DeleteMapping(value = "link/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Link> deleteLink(@PathVariable Long id);
}
