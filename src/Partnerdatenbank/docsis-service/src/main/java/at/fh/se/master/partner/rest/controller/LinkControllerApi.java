package at.fh.se.master.partner.rest.controller;

import at.fh.se.master.partner.service.model.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/")
public interface LinkControllerApi {

    @CrossOrigin
    @GetMapping(value = "links/partner/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Link>> getAllLinksOfPartner(@PathVariable("id") Long partnerId);

    @CrossOrigin
    @PostMapping(value = "link",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Link> addLink(@RequestBody @NotNull @Valid Link link);

    @CrossOrigin
    @DeleteMapping(value = "link/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Link> deleteLink(@PathVariable Long id);
}
