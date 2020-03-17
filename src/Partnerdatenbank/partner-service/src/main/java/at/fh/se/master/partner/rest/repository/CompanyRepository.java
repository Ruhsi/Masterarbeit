package at.fh.se.master.docsis.rest.repository;

import at.fh.se.master.docsis.service.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
