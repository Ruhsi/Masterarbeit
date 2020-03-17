package at.fh.se.master.docsis.rest.controller;

import at.fh.se.master.docsis.service.model.Company;
import at.fh.se.master.docsis.service.model.Partner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/")
public interface PartnerControllerApi {


    @CrossOrigin
    @GetMapping(value = "partners",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Partner>> getAllPartners();

    @CrossOrigin
    @PostMapping(value = "company/{id}/partner",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Company> addPartner(@PathVariable("id") Long companyId, @RequestBody @NotNull @Valid Partner partner);

    @CrossOrigin
    @DeleteMapping(value = "partner/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity deletePartner(@PathVariable Long id);
}
