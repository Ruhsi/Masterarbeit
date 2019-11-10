package at.fh.se.master.docsis.service.repository;

import at.fh.se.master.docsis.service.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findByPartnerId(Long partnerId);
}
