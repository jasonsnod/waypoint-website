package com.techelevator.model;

import java.util.List;


public class LandmarkDto {

    // Instance Variables
    private int landmarkId;
    private String landmarkName;
    private String landmarkAddress;
    private String landmarkDetails;

    // Constructors
    public LandmarkDto(int landmarkId, String landmarkName, String landmarkAddress, String landmarkDetails) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.landmarkAddress = landmarkAddress;
        this.landmarkDetails = landmarkDetails;
    }

    // Getters and Setters

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getLandmarkAddress() {
        return landmarkAddress;
    }

    public void setLandmarkAddress(String landmarkAddress) {
        this.landmarkAddress = landmarkAddress;
    }

    public String getLandmarkDetails() {
        return landmarkDetails;
    }

    public void setLandmarkDetails(String landmarkDetails) {
        this.landmarkDetails = landmarkDetails;
    }
}
