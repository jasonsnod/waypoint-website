package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.JdbcItineraryDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.LandmarkDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/itinerary")
// @PreAuthorize("isAuthenticated")
public class ItineraryController {

    private ItineraryDao itineraryDao;

    public ItineraryController(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }

    @RequestMapping(path = "/get/{userId}", method = RequestMethod.GET)
    public List<Itinerary> getItineraries(@PathVariable int userId) {
        return itineraryDao.getItinerariesByUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Itinerary addNewItinerary(@Valid @RequestBody Itinerary newItinerary) {
        //TODO: Possibly need to Link Itinerary/Landmark Table to add landmarks
        try {
            return itineraryDao.createItinerary(newItinerary);
        } catch(DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{itineraryId}", method = RequestMethod.PUT)
    public Itinerary editItinerary(@PathVariable int itineraryId, @RequestBody Itinerary dataItinerary) {
        //TODO: Decide on and Implement a way to alter landmarks in an itinerary
        dataItinerary.setItineraryId(itineraryId);
        try {
            return itineraryDao.updateItinerary(dataItinerary);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{itineraryId}", method = RequestMethod.DELETE)
    public void deleteItinerary(@PathVariable int itineraryId) {
        itineraryDao.deleteItinerary(itineraryId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{itineraryId}/landmark", method = RequestMethod.POST)
    public Itinerary createItineraryLandmarks(@PathVariable int itineraryId, List<Integer> landmarkIds) {
        return null;
    }

    @RequestMapping(path = "/{itineraryId}/landmark", method = RequestMethod.PUT)
    public Itinerary editItineraryLandmarks(@PathVariable int itineraryId, List<Integer> landmarkIds) {
        return null;
    }
}
