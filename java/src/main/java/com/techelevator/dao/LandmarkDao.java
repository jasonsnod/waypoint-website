package com.techelevator.dao;

import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDto;

import java.util.List;

public interface LandmarkDao {

    List<Landmark> getAllLandmarks();
    Landmark getLandmarkById(int landmarkId);
    Landmark addLandmark(LandmarkDto landmarkToBeAdded);
}
