package com.gepardec.app.backend.controller;

import com.gepardec.app.backend.offer.Offer;
import com.gepardec.app.backend.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class  OfferController implements OfferControllerAPI {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferController (final OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public ResponseEntity<List<Offer>> getAllOffers () { return new ResponseEntity<>(offerRepository.findAll(), HttpStatus.OK); }

    @Override
    public ResponseEntity<String> addArticleToOfferPreFlightRequest (final int offerId, final int articleId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addArticleToOffer (final int offerId, final int articleId) {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateArticleQuantityInOfferPreFlightRequest (final int offerId, final int articleId, final int quantity) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateArticleQuantityInOffer (final int offerId, final int articleId, final int quantity) {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateArticlePriceInOfferPreFlightRequest (final int offerId, final int articleId, final double price) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateArticlePriceInOffer (final int offerId, final int articleId, final double price) {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
