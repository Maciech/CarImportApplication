package com.example.demo;

public class CarProperties {
    public int transportUSA;
    public int transportEU = 790;
    public int customClearanceUSA = 150;
    public int customClearanceEU = 450;
    public double carBid;
    public boolean over2l = false;
    public double transportPL = 2000;

    //Class implementation with a lot different parameters, transport from Usa and car bid must be specified
    //rest can be set by default
    CarProperties(int transportUSA, int transportEU, int customClearanceUSA, int customClearanceEU, int carBid){
        this.transportUSA = transportUSA;
        this.transportEU = transportEU;
        this.customClearanceUSA = customClearanceUSA;
        this.customClearanceEU = customClearanceEU;
        this.carBid = carBid;
    }
    CarProperties(int transportUSA, double carBid){
        this.transportUSA = transportUSA;
        this.carBid = carBid;
    }
    CarProperties(int transportUSA,int transportEU, double carBid){
        this.transportUSA = transportUSA;
        this.transportEU = transportEU;
        this.carBid = carBid;
    }
    CarProperties(int transportUSA, double carBid, boolean over2l){
        this.transportUSA = transportUSA;
        this.carBid = carBid;
        this.over2l = over2l;
    }
    CarProperties(int transportUSA,int transportEU, double carBid, boolean over2l){
        this.transportUSA = transportUSA;
        this.transportEU = transportEU;
        this.carBid = carBid;
        this.over2l = over2l;
    }

    //Summing all transport costs with car value
    public double sumTransportFees(CarProperties carProperties){
        double result;
        result = carProperties.carBid + carProperties.customClearanceUSA + carProperties.transportUSA + carProperties.transportEU + carProperties.customClearanceEU;
        return result;
    }
}