package at.fh.se.master.company.rest.controller;


import at.fh.se.master.company.service.model.Company;
import at.fh.se.master.company.service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController implements CompanyControllerApi {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(final CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public String getAllCompaniesPreflight() {
        return "ok";
    }

    @Override
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public String addCompanyPreflight() {
        return "ok";
    }

    @Override
    public ResponseEntity<Company> addCompany(Company company) {
        return new ResponseEntity<>(companyRepository.save(company), HttpStatus.OK);
    }

    @Override
    public String deleteCompanyPreflight(Long id) {
        return "ok";
    }

    @Override
    public ResponseEntity<Company> deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
