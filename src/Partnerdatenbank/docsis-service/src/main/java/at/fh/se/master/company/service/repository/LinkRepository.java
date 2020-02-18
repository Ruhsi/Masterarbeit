package at.fh.se.master.company.service.repository;

import at.fh.se.master.company.service.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findByPartnerId(Long partnerId);
}
