package at.fh.se.master.docsis.rest.controller;


import at.fh.se.master.docsis.service.model.Company;
import at.fh.se.master.docsis.service.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PartnerController implements PartnerControllerApi {

    private final CompanyRepository companyRepository;
    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerController(final PartnerRepository partnerRepository, final CompanyRepository companyRepository) {
        this.partnerRepository = partnerRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public ResponseEntity<List<Partner>> getAllPartners() {
        return new ResponseEntity<>(partnerRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> addPartner(Long companyId, Partner partner) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            Company c = company.get();
            if (c.getPartners() == null) {
                c.setPartners(new ArrayList<>());
            }
            c.getPartners().add(partner);
            return new ResponseEntity<>(companyRepository.save(c), HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Company with id " + companyId + " not found!");
        }
    }

    @Override
    public ResponseEntity deletePartner(Long id) {
        partnerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
