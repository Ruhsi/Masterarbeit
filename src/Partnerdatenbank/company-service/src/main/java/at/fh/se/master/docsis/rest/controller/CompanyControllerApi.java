package at.fh.se.master.docsis.rest.controller;

import at.fh.se.master.docsis.service.model.Company;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
public interface CompanyControllerApi {


    @RequestMapping(value = "companies", method = RequestMethod.OPTIONS)
    String getAllCompaniesPreflight();

    @GetMapping(value = "companies",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Company>> getAllCompanies();

    @RequestMapping(value = "company", method = RequestMethod.OPTIONS)
    String addCompanyPreflight();

    @PostMapping(value = "company",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Company> addCompany(@RequestBody Company company);

    @RequestMapping(value = "company/{id}", method = RequestMethod.OPTIONS)
    String deleteCompanyPreflight(@PathVariable Long id);

    @DeleteMapping(value = "company/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Company> deleteCompany(@PathVariable Long id);
}
