package model.dao;

import model.entity.Driver;
import model.entity.Driver_;
import model.entity.Trip;
import model.entity.Trip_;
import model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.util.List;

public class TripDAO extends DAO implements ITripDAO {


    public TripDAO() {
        super();
    }


    public List<Trip> readAllTrips() throws DAOException {
        EntityManager entityManager = null;
        List<Trip> trips;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Trip> criteriaQuery = criteriaBuilder.createQuery(Trip.class);
            Root<Trip> rootTrip = criteriaQuery.from(Trip.class);

            trips = entityManager.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to read trips by status", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return trips;
    }

    public List<Trip> readTripsByDriverId(Integer driverId) throws DAOException {
        EntityManager entityManager = null;
        List<Trip> trips;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Trip> criteriaQuery = criteriaBuilder.createQuery(Trip.class);
            Root<Trip> rootTrip = criteriaQuery.from(Trip.class);

            Predicate condition = criteriaBuilder.equal(rootTrip.get(Trip_.driver), driverId);
            criteriaQuery.where(condition);

            trips = entityManager.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to read cars by status", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return trips;
    }

    public void setDriverForTrip(Integer driverId, Integer tripId) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Driver> query = criteriaBuilder.createQuery(Driver.class);
            Root<Driver> driverInfo = query.from(Driver.class);
            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(driverInfo.get(Driver_.id), driverId));
            query.where(condition);
            Driver driver = entityManager.createQuery(query).getSingleResult();

            CriteriaUpdate<Trip> update = criteriaBuilder.createCriteriaUpdate(Trip.class);
            Root<Trip> tripInfo = update.from(Trip.class);
            update.set(tripInfo.get(Trip_.driver), driver);
            Predicate conditionUpdate = criteriaBuilder.and(criteriaBuilder.equal(tripInfo.get(Trip_.id), tripId));
            update.where(conditionUpdate);

            transaction.begin();
            entityManager.createQuery(update)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to set driver", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
}
