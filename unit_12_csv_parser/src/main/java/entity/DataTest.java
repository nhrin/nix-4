package entity;

import annotation.SetFromCSV;

public class DataTest {
    @SetFromCSV("id")
    public int id;

    @SetFromCSV("model")
    public String model;

    @SetFromCSV("color")
    public String color;

    @SetFromCSV("isAvailable")
    public boolean isAvailable;

    public String madeBy;

    @Override
    public String toString() {
        return '\n' +
                "Info about smartphone:" + '\n' +
                "id = " + id + '\n' +
                "model = " + model + '\n' +
                "color = " + color + '\n' +
                (madeBy == null ? "no info about origin" : madeBy) + '\n' +
                (isAvailable ? "available" : "not available") + '\n' +
                "***********************";
    }
}
