package at.fh.se.master.docsis.rest.controller;

import at.fh.se.master.docsis.service.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
