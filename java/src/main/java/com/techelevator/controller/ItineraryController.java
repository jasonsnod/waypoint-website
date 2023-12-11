package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.JdbcItineraryDao;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/itinerary")
// @PreAuthorize("isAuthenticated")
public class ItineraryController {

    private ItineraryDao itineraryDao;
    private LandmarkDao landmarkDao;

    public ItineraryController(ItineraryDao itineraryDao, LandmarkDao landmarkDao) {
        this.itineraryDao = itineraryDao;
        this.landmarkDao = landmarkDao;
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public List<Itinerary> getItineraries(@PathVariable int userId) {
        return itineraryDao.getItinerariesByUser(userId);
    }

    @RequestMapping(path = "/{itineraryId}/landmark", method = RequestMethod.GET)
    public List<LandmarkDto> getLandmarksByItinerary(@PathVariable int itineraryId) {
        List<LandmarkDto> itineraryLandmarks = new ArrayList<>();

        List<Integer> landmarkIds = itineraryDao.getItineraryLandmarks(itineraryId);
        for(int landmarkId : landmarkIds) {
            itineraryLandmarks.add(landmarkDao.getLandmarkById(landmarkId));
        }

        return itineraryLandmarks;
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
        dataItinerary.setItineraryId(itineraryId);
        try {
            return itineraryDao.updateItinerary(dataItinerary);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{itineraryId}", method = RequestMethod.DELETE)
    public void deleteItinerary(@PathVariable int itineraryId) {
        itineraryDao.dropItineraryLandmarks(itineraryId);
        itineraryDao.deleteItinerary(itineraryId);
    }

    //TODO: V V V Change Return Type? V V V
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{itineraryId}/landmark", method = RequestMethod.POST)
    public Itinerary createItineraryLandmarks(@PathVariable int itineraryId, List<Integer> landmarkIds) {
        return itineraryDao.addItineraryLandmarks(itineraryId, landmarkIds);
    }

    //TODO: V V V Change Return Type? V V V
    @RequestMapping(path = "/{itineraryId}/landmark", method = RequestMethod.PUT)
    public Itinerary editItineraryLandmarks(@PathVariable int itineraryId, List<Integer> landmarkIds) {
        itineraryDao.dropItineraryLandmarks(itineraryId);
        return itineraryDao.addItineraryLandmarks(itineraryId, landmarkIds);
    }
}
