package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{

    private static Integer basePrice = 2;
    public StandardParcel(String description, Integer sendDay, String deliveryAddress, Integer weight) {
        super(description, sendDay, deliveryAddress, weight);
    }
    @Override
    public Integer calculateDeliveryCost() {
        return getWeight() * basePrice;
    }



}
