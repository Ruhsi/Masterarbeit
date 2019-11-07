package at.fh.se.master.company.service.repository;

import at.fh.se.master.company.service.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
