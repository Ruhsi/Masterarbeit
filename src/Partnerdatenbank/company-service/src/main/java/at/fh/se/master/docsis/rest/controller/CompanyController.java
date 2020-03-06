package at.fh.se.master.docsis.rest.controller;


import at.fh.se.master.docsis.service.model.Company;
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
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> addCompany(Company company) {
        return new ResponseEntity<>(companyRepository.save(company), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
