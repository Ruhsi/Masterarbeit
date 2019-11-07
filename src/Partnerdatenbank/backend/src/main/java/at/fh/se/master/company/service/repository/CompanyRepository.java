package at.fh.se.master.company.service.repository;

import at.fh.se.master.company.service.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
