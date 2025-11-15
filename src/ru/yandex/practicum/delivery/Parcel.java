package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Parcel {

    private String description;
    private Integer weight;
    private String deliveryAddress;
    private Integer sendDay;

    //Базовая стоимость единицы отправления
    //private final static List<Integer> basePrice = new ArrayList<>(Arrays.asList(2, 3, 4));
    //private static Integer basePrice;




    public Parcel(String description, Integer sendDay, String deliveryAddress, Integer weight) {
        this.description = description;
        this.sendDay = sendDay;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
    }

    public void packageItem(){
        System.out.println("Посылка <<"+description+">> упаковна");
    }

    public void deliver(){
        System.out.println("Посылка <<"+description+">> доставлена по адресу "+deliveryAddress);
    }

    public abstract Integer calculateDeliveryCost();
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
}
