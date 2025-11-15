package ru.yandex.practicum;
import org.junit.jupiter.api.*;
import ru.yandex.practicum.delivery.*;

public class Tests {

    private static StandardParcel standardParcel;
    private static StandardParcel standardParcelOver;
    private static StandardParcel standardParcelLight;
    public static FragileParcel fragileParcel;
    public static PerishableParcel perishableParcel;
    public static ParcelBox<StandardParcel> standardParcelParcelBox;

    @BeforeAll
    public static void setUp(){
        standardParcel = new StandardParcel("Описание", 1, "адрес", 10);
        standardParcelOver = new StandardParcel("Описание", 1, "адрес", 100000);
        standardParcelLight = new StandardParcel("Описание", 1, "адрес", 1);
        fragileParcel = new FragileParcel("Описание", 1, "адрес", 10);
        perishableParcel = new PerishableParcel("Описание", 1, "адрес", 10, 7);
        standardParcelParcelBox = new ParcelBox<>(10);

    }

    @AfterEach
    public void clearParcelBox(){
        standardParcelParcelBox.clearBox();
        standardParcelParcelBox.maxAvailableWeight = 10;
    }


    //Тесты на калькуляцию стоимости доставки
    @Test
    public void standartParcel10kgDeliveryPrice(){
        Assertions.assertEquals(20, standardParcel.calculateDeliveryCost(), "Тест провален");
    }

    @Test
    public void fragileParcel10kgDeliveryPrice(){
        Assertions.assertEquals(30, fragileParcel.calculateDeliveryCost(), "Тест провален");
    }

    @Test
    public void prishableParcel10kgDeliveryPrice(){
        Assertions.assertEquals(40, perishableParcel.calculateDeliveryCost(), "Тест провален");
    }


    //Тест на испорченость
    @Test
    public void prishableParcelIsExpiredTrue(){
        Assertions.assertTrue(perishableParcel.isExpired(9));
    }

    @Test
    public void prishableParcelIsExpiredFalse(){
        Assertions.assertFalse(perishableParcel.isExpired(5));
    }

    @Test
    public void prishableParcelIsExpiredFalseBorder(){
        Assertions.assertFalse(perishableParcel.isExpired(8));
    }

    //Тесты на вес коробки
    @Test
    public void parcelFitInTheBox(){
        standardParcelParcelBox.addParcel(standardParcelLight);
        Assertions.assertEquals(9, standardParcelParcelBox.maxAvailableWeight);

    }

    @Test
    public void parcelDontFitInTheBox(){
        standardParcelParcelBox.addParcel(standardParcelOver);
        Assertions.assertEquals(10, standardParcelParcelBox.maxAvailableWeight);
    }

    @Test
    public void parcelFitInTheBoxTightly(){
        standardParcelParcelBox.addParcel(standardParcel);
        Assertions.assertEquals(0, standardParcelParcelBox.maxAvailableWeight);
    }


}

