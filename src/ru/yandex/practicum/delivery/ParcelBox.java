package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox <T extends Parcel>{
    public Integer maxAvailableWeight;
    public List<T> parcelBox = new ArrayList<T>();


    public ParcelBox(Integer maxAvailableWeight) {
        this.maxAvailableWeight = maxAvailableWeight;
    }

    public void addParcel(T parcel){
        if (maxAvailableWeight>=parcel.getWeight()){
            parcelBox.add(parcel);
            maxAvailableWeight -= parcel.getWeight();
        } else {
            System.out.println("Коробка станет слишкой тяжелой. Посылка не добавлена в коробку");
        }
    }



    public List<T> getAllParcels(){
        return parcelBox;
    }

    //Используется только в тестах
    public void clearBox(){
        parcelBox.clear();
        maxAvailableWeight = 10;
    }
}
