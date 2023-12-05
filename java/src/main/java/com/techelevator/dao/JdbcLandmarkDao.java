package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDto;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    // Constructors

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Methods
    @Override
    public List<Landmark> getAllLandmarks() {
        List<Landmark> listOfAllLandmarks = null;
        String sqlSelectQuery = (
                "SELECT landmark_id, landmark_name, landmark_address, landmark_details \n" +
                "FROM landmarks;"
        );
        try {
            SqlRowSet resultsFromQuery = jdbcTemplate.queryForRowSet(sqlSelectQuery);
            while(resultsFromQuery.next()) {
                listOfAllLandmarks.add(mapRowToLandmark(resultsFromQuery));
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return listOfAllLandmarks;
    }

    @Override
    public Landmark getLandmarkById(int landmarkId) {
        return null;
    }

    @Override
    public Landmark addLandmark(LandmarkDto landmarkToBeAdded) {
        return null;
    }

    // Helper Methods

    /**
     *
     * @param resultsToMap
     * @return
     */
    private Landmark mapRowToLandmark(SqlRowSet resultsToMap) {
        Landmark landmarkToCreate = new Landmark();

        landmarkToCreate.setLandmarkId(resultsToMap.getInt("landmark_id"));
        landmarkToCreate.setLandmarkName(resultsToMap.getString("landmark_name"));
        landmarkToCreate.setLandmarkAddress(resultsToMap.getString("landmark_address"));
        landmarkToCreate.setLandmarkDetails(resultsToMap.getString("landmark_details"));

        //TODO: Need to create methods to fill list of Images and Reviews, for now they are null
        return landmarkToCreate;
    }
}
