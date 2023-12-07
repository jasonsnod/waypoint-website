package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.LandmarkDto;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcItineraryDao implements ItineraryDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Itinerary> getItinerariesByUser(int userId) {
        List<Itinerary> listOfUsersItineraries = new ArrayList<>();

        String sqlSelectQuery = (
                "SELECT itinerary_id, user_id, itinerary_name, starting_address \n" +
                        "FROM itineraries " +
                        "WHERE user_id = ?"
        );

        try {
            SqlRowSet resultsFromQuery = jdbcTemplate.queryForRowSet(sqlSelectQuery, userId);
            while(resultsFromQuery.next()) {
                listOfUsersItineraries.add(mapRowToItinerary(resultsFromQuery));
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return listOfUsersItineraries;
    }

    @Override
    public Itinerary getItineraryById(int itineraryId) {
        return null;
    }

    @Override
    public Itinerary createItinerary(Itinerary newItinerary) {
        return null;
    }

    @Override
    public Itinerary updateItinerary(Itinerary dataItinerary, Itinerary itineraryToBeChanged) {
        return null;
    }

    @Override
    public void deleteItinerary(int itineraryId) {

    }

    public Itinerary mapRowToItinerary(SqlRowSet resultsToMap){
        Itinerary itineraryToCreate = new Itinerary();

        itineraryToCreate.setItineraryId(resultsToMap.getInt("itinerary_id"));
        itineraryToCreate.setCreatorId(resultsToMap.getInt("user_id"));
        itineraryToCreate.setItineraryName(resultsToMap.getString("itinerary_name"));
        itineraryToCreate.setStartingAddress(resultsToMap.getString("starting_address"));

        return itineraryToCreate;
    }
}
