package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {
    List<Itinerary> getItinerariesByUser(int userId);
    Itinerary getItineraryById(int itineraryId);
    Itinerary createItinerary(Itinerary newItinerary);
    Itinerary updateItinerary(Itinerary dataItinerary, Itinerary itineraryToBeChanged);
    void deleteItinerary(int itineraryId);



}
