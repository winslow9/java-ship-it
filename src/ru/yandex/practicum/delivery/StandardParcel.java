package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{

    public StandardParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected Integer getBasePrice(){
        return 2;
    };



}
