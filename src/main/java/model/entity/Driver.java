package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static model.entity.Driver.driverTable;

@Entity
@Table(name =  driverTable)
public class Driver implements Serializable {

    public static final String driverTable = "driver";
    public static final String nameColumnName = "name";
    public static final String birthdateColumnName = "birthdate";
    public static final String experienceColumnName = "experience";
    public static final String carIdColumnName = "AUTO_id";


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = nameColumnName)
    private String name;

    @Column(name = birthdateColumnName)
    private Date birthDate;

    @Column(name = experienceColumnName)
    private Integer experience;

    @OneToOne
    @JoinColumn(name = carIdColumnName)
    private Car car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", experience=" + experience +
                '}';
    }
}
