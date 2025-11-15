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

    public void getAllParcels(){
        System.out.println("В коробке находятся следующие поссылки");
        for (T parcel : parcelBox){
            System.out.println(parcel.getDescription());
        }
    }

    public void clearBox(){
        parcelBox.clear();
    }
}
