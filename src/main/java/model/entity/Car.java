package model.entity;

import javax.persistence.*;
import java.io.Serializable;

import static model.entity.Car.carTable;


@Entity
@Table(name = carTable)
public class Car implements Serializable {

    public static final String carTable = "auto";
    public static final String firmColumnName = "firm";
    public static final String modelColumnName = "model";
    public static final String gearboxTypeColumnName = "gearbox_type";
    public static final String yearColumnName = "year";
    public static final String carStatusColumnName = "status";


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = firmColumnName)
    private String firm;

    @Column(name = modelColumnName)
    private String model;

    @Column(name = gearboxTypeColumnName)
    @Enumerated(EnumType.STRING)
    private GearboxType gearboxType;

    @Column(name = yearColumnName)
    private String year;

    @Column(name = carStatusColumnName)
    @Enumerated(EnumType.STRING)
    private CarStatusEnum carStatusEnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public CarStatusEnum getCarStatusEnum() {
        return carStatusEnum;
    }

    public void setCarStatusEnum(CarStatusEnum carStatusEnum) {
        this.carStatusEnum = carStatusEnum;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", model='" + model + '\'' +
                ", gearboxType=" + gearboxType +
                ", year='" + year + '\'' +
                ", carStatusEnum=" + carStatusEnum +
                '}';
    }
}
