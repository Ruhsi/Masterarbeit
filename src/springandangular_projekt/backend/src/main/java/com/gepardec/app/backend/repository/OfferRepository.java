package com.gepardec.app.backend.repository;

import com.gepardec.app.backend.offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
