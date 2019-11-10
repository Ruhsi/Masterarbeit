package at.fh.se.master.docsis.rest.controller;

import at.fh.se.master.docsis.service.model.Company;
import at.fh.se.master.docsis.service.model.Partner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
public interface PartnerControllerApi {


    @RequestMapping(value = "partners", method = RequestMethod.OPTIONS)
    String getAllPartnersPreflight();

    @GetMapping(value = "partners",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Partner>> getAllPartners();

    @RequestMapping(value = "partner", method = RequestMethod.OPTIONS)
    String addPartnerPreflight();

    @PostMapping(value = "company/{id}/partner",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Company> addPartner(@PathVariable("id") Long companyId, @RequestBody Partner partner);

    @RequestMapping(value = "partner/{id}", method = RequestMethod.OPTIONS)
    String deletePartnerPreflight(@PathVariable Long id);

    @DeleteMapping(value = "partner/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Partner> deletePartner(@PathVariable Long id);
}
