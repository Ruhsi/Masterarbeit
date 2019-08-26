package at.fh.se.master.backend.service.repository;

import at.fh.se.master.backend.service.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
