package model.dao;

import model.entity.User;
import model.entity.User_;
import model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserDAO extends DAO implements IUserDAO {


    public UserDAO() {
    }

    /**
     * get user info without password
     *
     * @param login login of user
     */
    @Override
    public User getUserInfo(String login, String password) throws DAOException {
        EntityManager entityManager = null;
        User user;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> rootUser = criteriaQuery.from(User.class);

            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(rootUser.get(User_.login), login), criteriaBuilder.equal(rootUser.get(User_.password), password));
            criteriaQuery.where(condition);

            user = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception e) {
            throw new DAOException("failed to read user", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }

        return user;
    }

    @Override
    public void registerUser(User user) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("Failed to register new user", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
}
