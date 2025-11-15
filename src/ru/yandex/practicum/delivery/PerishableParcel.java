package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private int timeToLive;
    private static Integer basePrice = 4;

    public PerishableParcel(String description, Integer sendDay, String deliveryAddress, Integer weight, int timeToLive) {
        super(description, sendDay, deliveryAddress, weight);
        this.timeToLive = timeToLive;
    }


    public boolean isExpired(int currentDay){
        if(timeToLive >= currentDay-getSendDay()){
            return false;
        } else {return true;}
    }

    @Override
    public Integer calculateDeliveryCost() {
        return getWeight() * basePrice;
    }


}
