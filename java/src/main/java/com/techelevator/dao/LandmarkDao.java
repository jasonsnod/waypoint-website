package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;

public interface LandmarkDao {

    List<Landmark> getAllLandmarks();
    Landmark getLandmarkById(int landmarkId);
    Landmark addLandmark(Landmark landmarkToBeAdded);
}
