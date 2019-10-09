package at.fh.se.master.backend.rest.controller;

import at.fh.se.master.backend.service.model.Partner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PartnerControllerApi {

    @CrossOrigin
    @GetMapping(value = "partners",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    ResponseEntity<List<Partner>> getAllPartners();

    @CrossOrigin
    @PostMapping(value = "partner",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Partner> addPartner(@RequestBody Partner partner);
}
