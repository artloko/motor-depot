package model.entity;

import java.io.Serializable;

public enum CarStatusEnum implements Serializable {
    Y("Y"),
    N("N");

    private String value;

    CarStatusEnum(String value) {
        this.value = value;
    }

    public static CarStatusEnum getCarStatusByValue(String value) {
        for(CarStatusEnum carStatusEnum : values()) {
            if (carStatusEnum.getValue().contentEquals(value)) {
                return carStatusEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
