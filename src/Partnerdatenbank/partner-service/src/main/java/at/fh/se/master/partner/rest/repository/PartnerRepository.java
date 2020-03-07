package at.fh.se.master.partner.rest.repository;

import at.fh.se.master.partner.service.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
