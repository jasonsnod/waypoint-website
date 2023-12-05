package com.techelevator.model;

import java.util.List;

public class Landmark {

    private int landmarkId;
    private String landmarkName;
    private String landmarkAddress;
    private String landmarkDetails;
    List<Image> landmarkImages = null;
    List<Review> landmarkReviews = null;

    // Constructors
    public Landmark() {

    }

    public Landmark(int landmarkId, String landmarkName, String landmarkAddress, String landmarkDetails) {
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

    public List<Image> getLandmarkImages() {
        return landmarkImages;
    }

    // Used in conjunction with ImageDao, gets sent results of a SQL query
    public void setLandmarkImages(List<Image> landmarkImages) {
        this.landmarkImages = landmarkImages;
    }

    public List<Review> getLandmarkReviews() {
        return landmarkReviews;
    }

    // Used in conjunction with ReviewDao, gets sent results of a SQL query
    public void setLandmarkReviews(List<Review> landmarkReviews) {
        this.landmarkReviews = landmarkReviews;
    }
}
