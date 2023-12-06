package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    // Constructors

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Methods
    @Override
    public List<Landmark> getAllLandmarks() {
        List<Landmark> listOfAllLandmarks = new ArrayList<>();

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
        Landmark resultingLandmark = null;

        String sqlSelectQuery = (
                "SELECT landmark_id, landmark_name, landmark_address, landmark_details \n" +
                "FROM landmarks \n" +
                "WHERE landmark_id = ?;"
        );

        try {
            SqlRowSet resultsFromQuery = jdbcTemplate.queryForRowSet(sqlSelectQuery, landmarkId);
            if(resultsFromQuery.next()) {
                resultingLandmark = mapRowToLandmark(resultsFromQuery);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return resultingLandmark;
    }

    @Override
    public Landmark addLandmark(LandmarkDto landmarkToBeAdded) {
        Landmark landmarkCreated = null;

        String sqlAddQuery = (
                "INSERT INTO landmarks (landmark_name, landmark_address, landmark_details) \n" +
                "VALUES (?, ?, ?) \n" +
                "RETURNING landmark_id;"
        );

        try {
            int createdLandmarkId = jdbcTemplate.queryForObject(
                    sqlAddQuery,
                    int.class,
                    landmarkToBeAdded.getLandmarkName(),
                    landmarkToBeAdded.getLandmarkAddress(),
                    landmarkToBeAdded.getLandmarkDetails()
            );
            landmarkCreated = getLandmarkById(createdLandmarkId);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch(DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return landmarkCreated;
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
