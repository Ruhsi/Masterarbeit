package at.fh.se.master.partner.rest.controller;

import at.fh.se.master.partner.service.model.Company;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/")
public interface CompanyControllerApi {

    @CrossOrigin
    @GetMapping(value = "companies",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Company>> getAllCompanies();

    @CrossOrigin
    @PostMapping(value = "company",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Company> addCompany(@RequestBody @NotNull @Valid Company company);

    @CrossOrigin
    @DeleteMapping(value = "company/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Company> deleteCompany(@PathVariable Long id);
}
