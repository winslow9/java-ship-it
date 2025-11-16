package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Parcel {

    protected String description;
    protected Integer weight;
    protected String deliveryAddress;
    protected Integer sendDay;


    public Parcel(String description, Integer weight, String deliveryAddress,Integer sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem(){
        System.out.println("Посылка <<"+description+">> упаковна");
    }

    public void deliver(){
        System.out.println("Посылка <<"+description+">> доставлена по адресу "+deliveryAddress);
    }

    //public abstract Integer calculateDeliveryCost();
    //Getters
    public String getDescription() {
        return description;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Integer getSendDay() {
        return sendDay;
    }


    protected abstract Integer getBasePrice();

    public Integer calculateDeliveryCost() {
        //System.out.println("Weight: " + weight + ", BasePrice: " + getBasePrice());
        return weight * getBasePrice();
    }
}
