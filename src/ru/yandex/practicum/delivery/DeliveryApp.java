package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> trackableParsels = new ArrayList<>();
    //Коробки посслок
    private static ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox(100);
    private static ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox(70);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox(30);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    System.out.println("Введите новый адрес");
                    String newLocation = scanner.nextLine();
                    for (FragileParcel parcel : trackableParsels){
                        parcel.reportStatus(newLocation);
                    }
                case 5:
                    showParcelsBoxByType();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Поменять адрес доставки всех хрупких посылок");
        System.out.println("5 — Показать содержимое коробки по типу");
        System.out.println("0 — Завершить");
    }


    private static void addParcel() {
        System.out.println("1 - Посылка обычная, 2- Скоропортящаяся, 3- Хрупкая");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание поссылки");
        String desc = scanner.nextLine();
        System.out.println("Введите вес поссылки");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес получения");
        String adr = scanner.nextLine();

        int timeToLive=0;
        int sendDay = 0;
        if (choice == 2){
            System.out.println("Введите номер дня месяца, когда желаете осуществить отправку");
            sendDay = Integer.parseInt(scanner.nextLine());
            System.out.println("Сколько времени может храниться посылка?");
            timeToLive = Integer.parseInt(scanner.nextLine());
        }
        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(desc, weight, adr, sendDay);
                allParcels.add(standardParcel);
                standardParcelsBox.addParcel(standardParcel);
                break;
            case 2:
                PerishableParcel perishableParcel = new PerishableParcel(desc, weight, adr, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(desc, weight, adr, sendDay);
                allParcels.add(fragileParcel);
                trackableParsels.add(fragileParcel);
                fragileParcelsBox.addParcel(fragileParcel);
                break;

            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void showParcelsBoxByType(){
        System.out.println("Коробку какого типа хотите посмотреть?");
        System.out.println("1 - Посылка обычная, 2- Скоропортящаяся, 3- Хрупкая");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                for (StandardParcel p :standardParcelsBox.getAllParcels()){
                    System.out.println(p.getDescription());
                }
                break;
            case 2:
                for (PerishableParcel p :perishableParcelBox.getAllParcels()){
                    System.out.println(p.getDescription());
                }
                break;
            case 3:
                for (FragileParcel p :fragileParcelsBox.getAllParcels()){
                    System.out.println(p.getDescription());
                }
                break;
            default:
                System.out.println("Поссылок с таким типом не было добавлено");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for ( Parcel parcel : allParcels){
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum = 0;
        for (Parcel parcel : allParcels){
            sum+=parcel.calculateDeliveryCost();
        }
        System.out.println(sum);
    }

}
