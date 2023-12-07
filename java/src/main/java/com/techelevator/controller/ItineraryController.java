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

    @RequestMapping(method= RequestMethod.GET)
    public List<Itinerary> getItineraries(int userId) {
        return itineraryDao.getItinerariesByUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Itinerary addNewItinerary(@Valid @RequestBody Itinerary newItinerary) {
        try {
            return itineraryDao.createItinerary(newItinerary);
        } catch(DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{itineraryId}", method = RequestMethod.PUT)
    public Itinerary editItinerary(@PathVariable int itineraryId, @RequestBody Itinerary dataItinerary) {
        Itinerary updatedItinerary;
        try {
            updatedItinerary = itineraryDao.getItineraryById(itineraryId);
            return itineraryDao.updateItinerary(dataItinerary, updatedItinerary);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{itineraryId}", method = RequestMethod.DELETE)
    public void deleteItinerary(@PathVariable int itineraryId) {
        itineraryDao.deleteItinerary(itineraryId);
    }
}
