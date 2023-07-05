package com.example.demo;

public class Calculator {
    private int id;
    private double carBid;
    private String carLocation;
    private boolean carCapacityExceeded;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCarBid() {
        return carBid;
    }

    public void setCarBid(double carBid) {
        this.carBid = carBid;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    public boolean isCarCapacityExceeded() {
        return carCapacityExceeded;
    }

    public void setCarCapacityExceeded(boolean carCapacityExceeded) {
        this.carCapacityExceeded = carCapacityExceeded;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "id=" + id +
                ", carBid=" + carBid +
                ", carLocation='" + carLocation + '\'' +
                ", carCapacityExceeded=" + carCapacityExceeded +
                '}';
    }
}
