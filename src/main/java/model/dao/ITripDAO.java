package model.dao;

import model.entity.Trip;
import model.exception.DAOException;

import java.util.List;

public interface ITripDAO {

    void setDriverForTrip(Integer driverId, Integer tripId) throws DAOException;

    List<Trip> readTripsByDriverId(Integer driverId) throws DAOException;

    List<Trip> readAllTrips() throws DAOException;
}
