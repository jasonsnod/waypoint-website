package com.techelevator.model;

public class Itinerary {

    private int itineraryId;
    private int creatorId;
    private String itineraryName;
    private String startingAddress;

    public Itinerary(){

    }

    public Itinerary(int itineraryId, int creatorId, String itineraryName, String startingAddress) {
        this.itineraryId = itineraryId;
        this.creatorId = creatorId;
        this.itineraryName = itineraryName;
        this.startingAddress = startingAddress;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getItineraryName() {
        return itineraryName;
    }

    public void setItineraryName(String itineraryName) {
        this.itineraryName = itineraryName;
    }

    public String getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(String startingAddress) {
        this.startingAddress = startingAddress;
    }
}
