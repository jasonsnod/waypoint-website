package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {
    List<Itinerary> getItinerariesByUser(int userId);
    Itinerary createItinerary(Itinerary newItinerary);
    Itinerary updateItinerary(Itinerary itineraryToBeChanged);
    void deleteItinerary(int itineraryId);

}
