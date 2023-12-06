package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/landmark")
public class LandmarkController {

    // Instance Variables
    private LandmarkDao landmarkDao;

    // Constructors
    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    // Handler Methods
    @RequestMapping(method= RequestMethod.GET)
    public List<LandmarkDto> getLandmarks() {
        return landmarkDao.getAllLandmarks();
    }

    @RequestMapping(path = "/{landmarkId}", method = RequestMethod.GET)
    public LandmarkDto getLandmarkById(@PathVariable int landmarkId) {
        LandmarkDto landmarkToBeTransferred = null;

        try {
            Landmark resultingLandmark = landmarkDao.getLandmarkById(landmarkId);
            landmarkToBeTransferred = new LandmarkDto(
                    resultingLandmark.getLandmarkId(),
                    resultingLandmark.getLandmarkName(),
                    resultingLandmark.getLandmarkAddress(),
                    resultingLandmark.getLandmarkDetails()
            );
        }
        catch(DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Landmark not found");
        }

        return landmarkToBeTransferred;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Landmark addNewLandmark(@RequestBody Landmark newLandmark) {
        try {
            return landmarkDao.addLandmark(newLandmark);
        } catch(DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
