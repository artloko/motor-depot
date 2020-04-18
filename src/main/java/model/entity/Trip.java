package model.entity;

import javax.persistence.*;
import java.io.Serializable;

import static model.entity.Trip.tripTable;


@Entity
@Table(name = tripTable)
public class Trip implements Serializable {

    public static final String tripTable = "trip";
    public static final String fromColumnName = "from";
    public static final String toColumnName = "to";
    public static final String statusColumnName = "status";
    public static final String driverIdColumnName = "DRIVER_id";


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = fromColumnName)
    private String from;

    @Column(name = toColumnName)
    private String to;

    @Column(name = statusColumnName)
    @Enumerated(EnumType.STRING)
    private TripStatusEnum tripStatus;


    @ManyToOne
    @JoinColumn(name = driverIdColumnName)
    private Driver driver;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public TripStatusEnum getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatusEnum tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", tripStatus=" + tripStatus +
                ", driver=" + driver +
                '}';
    }
}
