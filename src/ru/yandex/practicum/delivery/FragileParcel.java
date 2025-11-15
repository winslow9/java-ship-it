package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    private static Integer basePrice = 3;

    public FragileParcel(String description, Integer sendDay, String deliveryAddress, Integer weight) {
        super(description, sendDay, deliveryAddress, weight);
    }

    @Override
    public Integer calculateDeliveryCost() {
        return getWeight() * basePrice;
    }

    @Override
    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка <<"+super.getDescription()+">> изменила местоположение на "+newLocation);
    }


}
