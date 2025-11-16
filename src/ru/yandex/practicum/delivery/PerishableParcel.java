package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private int timeToLive;
    //Integer basePrice = 4;

    public PerishableParcel(String description, Integer weight, String deliveryAddress, Integer sendDay, Integer timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }


    public boolean isExpired(int currentDay){
        if(timeToLive >= currentDay-getSendDay()){
            return false;
        } else {return true;}
    }

    @Override
    protected Integer getBasePrice(){
        return 4;
    };



}
