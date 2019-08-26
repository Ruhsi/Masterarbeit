package at.fh.se.master.backend.rest.controller;


import at.fh.se.master.backend.rest.model.PartnerDto;
import at.fh.se.master.backend.service.repository.PartnerRepository;
import at.fh.se.master.backend.util.DozerHelper;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartnerController implements PartnerControllerApi {

    private final PartnerRepository partnerRepository;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    public PartnerController(final PartnerRepository partnerRepository) { this.partnerRepository = partnerRepository; }

    @Override
    public ResponseEntity<List<PartnerDto>> getAllPartners() {
        List<PartnerDto> partner = DozerHelper.map(mapper, partnerRepository.findAll(), PartnerDto.class);
        return new ResponseEntity<>(partner, HttpStatus.OK);
    }
}
