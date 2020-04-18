package model.dao;

import model.entity.Car;
import model.entity.CarStatusEnum;
import model.entity.Car_;
import model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.util.List;

public class AutoDAO extends DAO implements IAutoDAO {

    public AutoDAO() {
        super();
    }


    public List<Car> getCarsByStatus(CarStatusEnum status) throws DAOException {
        EntityManager entityManager = null;
        List<Car> cars;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> rootCar = criteriaQuery.from(Car.class);

            Predicate condition = criteriaBuilder.equal(rootCar.get(Car_.carStatusEnum), status);
            criteriaQuery.where(condition);

            cars = entityManager.createQuery(criteriaQuery).getResultList();

        } catch (Exception e) {
            throw new DAOException("failed to read cars by status", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return cars;
    }

    public void setCarStatus(Integer carId, CarStatusEnum carStatus) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Car> update = criteriaBuilder.createCriteriaUpdate(Car.class);
            Root<Car> carStatusInfo = update.from(Car.class);
            update.set(carStatusInfo.get(Car_.carStatusEnum), carStatus);
            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(carStatusInfo.get(Car_.id), carId));
            update.where(condition);

            transaction.begin();
            entityManager.createQuery(update)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to set car status", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
}
