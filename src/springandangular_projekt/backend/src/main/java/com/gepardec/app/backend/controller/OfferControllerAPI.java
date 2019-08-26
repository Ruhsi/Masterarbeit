package com.gepardec.app.backend.controller;

import com.gepardec.app.backend.offer.Offer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface OfferControllerAPI {

    @CrossOrigin
    @GetMapping(value = "/offers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<List<Offer>> getAllOffers ();

    // pre flight request for cross origin options request
    @CrossOrigin
    @RequestMapping(method = RequestMethod.OPTIONS ,value = "/offer/{offerid}/article/{articleid}/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<String> addArticleToOfferPreFlightRequest (@PathVariable(name = "offerid") final int offerId, @PathVariable(name = "articleid") final int articleId);

    @CrossOrigin
    @PostMapping(value = "/offer/{offerid}/article/{articleid}/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<String> addArticleToOffer (@PathVariable(name = "offerid") final int offerId, @PathVariable(name = "articleid") final int articleId);

    // pre flight request for cross origin options request
    @CrossOrigin
    @RequestMapping(method = RequestMethod.OPTIONS, value = "/offer/{offerid}/article/{articleid}/qty/{quantity}/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<String> updateArticleQuantityInOfferPreFlightRequest (@PathVariable(name = "offerid") final int offerId, @PathVariable(name = "articleid") final int articleId, @PathVariable(name = "quantity") final int quantity);

    @CrossOrigin
    @PutMapping(value = "/offer/{offerid}/article/{articleid}/qty/{quantity}/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<String> updateArticleQuantityInOffer (@PathVariable(name = "offerid") final int offerId, @PathVariable(name = "articleid") final int articleId, @PathVariable(name = "quantity") final int quantity);

    // pre flight request for cross origin options request
    @CrossOrigin
    @RequestMapping(method = RequestMethod.OPTIONS, value = "/offer/{offerid}/article/{articleid}/price/{price}/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<String> updateArticlePriceInOfferPreFlightRequest (@PathVariable(name = "offerid") final int offerId, @PathVariable(name = "articleid") final int articleId, @PathVariable(name = "price") final double price);

    @CrossOrigin
    @PutMapping(value = "/offer/{offerid}/article/{articleid}/price/{price}/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<String> updateArticlePriceInOffer (@PathVariable(name = "offerid") final int offerId, @PathVariable(name = "articleid") final int articleId, @PathVariable(name = "price") final double price);
}
