package hu.meiit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Czinke Csaba on 2017.01.15..
 */
public class Car {

    private int id;
    private String type;
    private int numberOfWheels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
