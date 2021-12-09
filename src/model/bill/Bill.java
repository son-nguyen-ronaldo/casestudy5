package model.bill;

import model.car.Car;
import model.uer.User;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Bill implements Serializable {
    private String id;
    private Car car;
    private User user;
    private LocalDate checkin;
    private LocalDate checkOut;

    public Bill() {
    }

    public Bill(String id, Car car, User user, LocalDate checkin, LocalDate checkOut) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.checkin = checkin;
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getClient() {
        return user;
    }

    public void setClient(User user) {
        this.user = user;
    }
    public long getTotalPrice(){
        long total =0;
        long daysBetween = DAYS.between(checkin, checkOut);
        total =daysBetween * 100;
        return total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", car=" + car +
                ", user=" + user +
                '}';
    }
}
