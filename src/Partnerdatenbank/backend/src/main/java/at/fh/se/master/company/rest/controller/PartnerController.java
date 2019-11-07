package at.fh.se.master.company.rest.controller;


import at.fh.se.master.company.service.model.Partner;
import at.fh.se.master.company.service.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartnerController implements PartnerControllerApi {

    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerController(final PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public String getAllPartnersPreflight() {
        return "ok";
    }

    @Override
    public ResponseEntity<List<Partner>> getAllPartners() {
        return new ResponseEntity<>(partnerRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public String addPartnerPreflight() {
        return "ok";
    }

    @Override
    public ResponseEntity<Partner> addPartner(Partner partner) {
        return new ResponseEntity<>(partnerRepository.save(partner), HttpStatus.OK);
    }

    @Override
    public String deletePartnerPreflight(Long id) {
        return "ok";
    }

    @Override
    public ResponseEntity deletePartner(Long id) {
        partnerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
