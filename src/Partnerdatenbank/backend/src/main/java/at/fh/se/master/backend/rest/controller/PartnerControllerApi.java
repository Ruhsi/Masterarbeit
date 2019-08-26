package at.fh.se.master.backend.rest.controller;

import at.fh.se.master.backend.rest.model.PartnerDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface PartnerControllerApi {

    @CrossOrigin
    @GetMapping(value = "partners", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<PartnerDto>> getAllPartners();
}
