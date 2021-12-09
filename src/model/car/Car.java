package model.car;

import java.io.Serializable;

public class Car implements Serializable {
    private String nameCar;
    private  String color;
    private String id;
    private String licensePlate;
    private String type;

    public Car() {
    }

    public Car(String nameCar, String color, String id, String licensePlate, String type) {
        this.nameCar = nameCar;
        this.color = color;
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameCar='" + nameCar + '\'' +
                ", color='" + color + '\'' +
                ", id='" + id + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
