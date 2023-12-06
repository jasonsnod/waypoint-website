package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;

public interface LandmarkDao {

    List<LandmarkDto> getAllLandmarks();
    Landmark getLandmarkById(int landmarkId);
    Landmark addLandmark(Landmark landmarkToBeAdded);
}
