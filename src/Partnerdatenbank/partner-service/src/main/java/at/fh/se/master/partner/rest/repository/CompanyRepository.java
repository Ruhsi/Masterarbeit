package at.fh.se.master.partner.rest.repository;

import at.fh.se.master.partner.service.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
