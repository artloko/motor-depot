package model.dao;

import model.entity.Car;
import model.entity.CarStatusEnum;
import model.exception.DAOException;

import java.util.List;

public interface IAutoDAO {

    List<Car> getCarsByStatus(CarStatusEnum status) throws DAOException;

    void setCarStatus(Integer carId, CarStatusEnum carStatus) throws DAOException;
}
