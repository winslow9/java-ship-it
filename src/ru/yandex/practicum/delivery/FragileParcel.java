package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    public FragileParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
    //Integer basePrice = 3;




    @Override
    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка <<"+super.getDescription()+">> изменила местоположение на "+newLocation);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обернута в защитную пленку");
        super.packageItem();
    }

    @Override
   protected Integer getBasePrice(){
        return 3;
    };


}
