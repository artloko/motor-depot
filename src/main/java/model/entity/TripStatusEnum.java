package model.entity;

import java.io.Serializable;

public enum TripStatusEnum implements Serializable {
    Y("Y"),
    N("N");

    private String value;

    TripStatusEnum(String value) {
        this.value = value;
    }

    public static TripStatusEnum getTripStatusByValue(String value) {
        for(TripStatusEnum tripStatusEnum : values()) {
            if (tripStatusEnum.getValue().contentEquals(value)) {
                return tripStatusEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
