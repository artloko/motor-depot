package model.entity;

import java.io.Serializable;

public enum GearboxType implements Serializable {
    A("A"),
    M("M");

    private String value;

    GearboxType(String value) {
        this.value = value;
    }

    public static GearboxType getGearboxTypeByValue(String value) {
        for(GearboxType gearboxType : values()) {
            if (gearboxType.getValue().contentEquals(value)) {
                return gearboxType;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
